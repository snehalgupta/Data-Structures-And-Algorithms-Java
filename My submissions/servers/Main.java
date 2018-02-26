package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class KDNode
{
    int axis;
    double[] x;
    int id;
    boolean checked;
    boolean orientation;
    int c;
    int id2;
    KDNode Parent;
    KDNode Left;
    KDNode Right;
 
    public KDNode(double[] x0, int axis0,int c1,int h1)
    {
        x = new double[2];
        axis = axis0;
        for (int k = 0; k < 2; k++)
            x[k] = x0[k];
 
        Left = Right = Parent = null;
        checked = false;
        id = 0;
        c=c1;
        id2=h1;
    }
 
    public KDNode FindParent(double[] x0)
    {
        KDNode parent = null;
        KDNode next = this;
        int split;
        while (next != null)
        {
            split = next.axis;
            parent = next;
            if (x0[split] > next.x[split])
                next = next.Right;
            else
                next = next.Left;
        }
        return parent;
    }
 
    public KDNode Insert(double[] p,int c1,int h1)
    {
        //x = new double[2];
        KDNode parent = FindParent(p);
        if (equal(p, parent.x, 2) == true)
            return null;
 
        KDNode newNode = new KDNode(p, parent.axis + 1 < 2 ? parent.axis + 1
                : 0,c1,h1);
        newNode.Parent = parent;
 
        if (p[parent.axis] > parent.x[parent.axis])
        {
            parent.Right = newNode;
            newNode.orientation = true; //
        } else
        {
            parent.Left = newNode;
            newNode.orientation = false; //
        }
 
        return newNode;
    }
 
    boolean equal(double[] x1, double[] x2, int dim)
    {
        for (int k = 0; k < dim; k++)
        {
            if (x1[k] != x2[k])
                return false;
        }
 
        return true;
    }
 
    double distance2(double[] x1, double[] x2, int dim)
    {
        double S = 0;
        for (int k = 0; k < dim; k++)
            S += (x1[k] - x2[k]) * (x1[k] - x2[k]);
        return S;
    }
}
 
class KDTree
{
    KDNode Root;
 
    int TimeStart, TimeFinish;
    int CounterFreq;
 
    double d_min;
    KDNode nearest_neighbour;
 
    int KD_id;
 
    int nList;
 
    KDNode CheckedNodes[];
    int checked_nodes;
    KDNode List[];
 
    double x_min[], x_max[];
    boolean max_boundary[], min_boundary[];
    int n_boundary;
 
    public KDTree(int i)
    {
        Root = null;
        KD_id = 1;
        nList = 0;
        List = new KDNode[i];
        CheckedNodes = new KDNode[i];
        max_boundary = new boolean[2];
        min_boundary = new boolean[2];
        x_min = new double[2];
        x_max = new double[2];
    }
 
    public boolean add(double[] x,int c1,int h1)
    {
        if (nList >= 2000000 - 1)
            return false; // can't add more points
 
        if (Root == null)
        {
            Root = new KDNode(x, 0,c1,h1);
            Root.id = KD_id++;
            List[nList++] = Root;
        } else
        {
            KDNode pNode;
            if ((pNode = Root.Insert(x,c1,h1)) != null)
            {
                pNode.id = KD_id++;
                List[nList++] = pNode;
            }
        }
 
        return true;
    }
 
    public KDNode find_nearest(double[] x)
    {
        if (Root == null)
            return null;
 
        checked_nodes = 0;
        KDNode parent = Root.FindParent(x);
        nearest_neighbour = parent;
        d_min = Root.distance2(x, parent.x, 2);
        ;
 
        if (parent.equal(x, parent.x, 2) == true)
            return nearest_neighbour;
 
        search_parent(parent, x);
        uncheck();
 
        return nearest_neighbour;
    }
 
    public void check_subtree(KDNode node, double[] x)
    {
        if ((node == null) || node.checked)
            return;
 
        CheckedNodes[checked_nodes++] = node;
        node.checked = true;
        set_bounding_cube(node, x);
 
        int dim = node.axis;
        double d = node.x[dim] - x[dim];
 
        if (d * d > d_min)
        {
            if (node.x[dim] > x[dim])
                check_subtree(node.Left, x);
            else
                check_subtree(node.Right, x);
        } else
        {
            check_subtree(node.Left, x);
            check_subtree(node.Right, x);
        }
    }
 
    public void set_bounding_cube(KDNode node, double[] x)
    {
        if (node == null)
            return;
        int d = 0;
        double dx;
        for (int k = 0; k < 2; k++)
        {
            dx = node.x[k] - x[k];
            if (dx > 0)
            {
                dx *= dx;
                if (!max_boundary[k])
                {
                    if (dx > x_max[k])
                        x_max[k] = dx;
                    if (x_max[k] > d_min)
                    {
                        max_boundary[k] = true;
                        n_boundary++;
                    }
                }
            } else
            {
                dx *= dx;
                if (!min_boundary[k])
                {
                    if (dx > x_min[k])
                        x_min[k] = dx;
                    if (x_min[k] > d_min)
                    {
                        min_boundary[k] = true;
                        n_boundary++;
                    }
                }
            }
            d += dx;
            if (d > d_min)
                return;
 
        }
 
        if (d < d_min)
        {
            d_min = d;
            nearest_neighbour = node;
        }
    }
 
    public KDNode search_parent(KDNode parent, double[] x)
    {
        for (int k = 0; k < 2; k++)
        {
            x_min[k] = x_max[k] = 0;
            max_boundary[k] = min_boundary[k] = false; //
        }
        n_boundary = 0;
 
        KDNode search_root = parent;
        while (parent != null && (n_boundary != 2 * 2))
        {
            check_subtree(parent, x);
            search_root = parent;
            parent = parent.Parent;
        }
 
        return search_root;
    }
 
    public void uncheck()
    {
        for (int n = 0; n < checked_nodes; n++)
            CheckedNodes[n].checked = false;
    }
 
}
 

class Node{
	int ids;
	int idp;
	int x;
	int y;
	int p;
	
	public Node(int i1,int i2,int t1,int s1,int p1){
		ids=i1;
		x=t1;
		y=s1;
		p=p1;
		idp=i2;
	}
}
 
class heap{
	Node[] harr;
	int capacity;
	int heap_size;
	
	public heap(int n){
		heap_size=0;
		capacity=n;
		harr=new Node[n];
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i +2;
	}
	
	public void insert(Node k){
		Node temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && harr[parent(i)].p > harr[i].p){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	
	public Node extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		Node root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		Node temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && harr[l].p < harr[i].p){
			smallest=l;
		}
		if( r < heap_size && harr[r].p < harr[smallest].p){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
}
 

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{heap h=new heap(500000);
			HashMap<Integer,ArrayList<Node>> hs=new HashMap<Integer,ArrayList<Node>>();
			int n=Reader.nextInt();
			int q=Reader.nextInt();
			KDTree kdt=new KDTree(n);
			for(int i=1;i<=n;i++){
				double we[] = new double[2];
				int x=Reader.nextInt();
				we[0]=(double)x;
				int y=Reader.nextInt();
				we[1]=(double)y;
				int k=Reader.nextInt();
				kdt.add(we,k,i);
				for(int j=1;j<=k;j++){
					int p=Reader.nextInt();
					Node nptr=new Node(i,j,x,y,p);
					h.insert(nptr);
				}
			}
			for(int w=0;w<q;w++){
				System.out.println("?");
				if(hs.get(w) != null){
					ArrayList<Node> arr=hs.get(w);
					for(int ty=0;ty<arr.size();ty++){
						h.insert(arr.get(ty));
					}
					hs.remove(w);
				}
				int x1=Reader.nextInt();
				int y1=Reader.nextInt();
				double[] sau=new double[2] ;
				sau[0]=(double)x1;
				sau[1]=(double)y1;
				KDNode kdn=kdt.find_nearest(sau);
				int flag=0;
				ArrayList<Node> sdf=new ArrayList<Node>();
				while(h.heap_size != 0){
					Node an=h.extractmin();
					if( (double)an.x == kdn.x[0] && (double)an.y == kdn.x[1]){
						int p1=w+an.p;
						if(hs.get(p1) != null){
							hs.get(p1).add(an);
						}
						else{
							hs.put(p1, new ArrayList<Node>());
							hs.get(p1).add(an);
						}
						flag=1;
						System.out.println("! "+an.ids+" "+an.idp);
						break;
					}
					else{
						sdf.add(an);
					}
				}
				while(sdf.size() != 0){
					h.insert(sdf.remove(sdf.size()-1));
				}
				if(flag == 0){
					
					Node an=h.extractmin();
					int p1=w+an.p;
					if(hs.get(p1) != null){
						hs.get(p1).add(an);
					}
					else{
						hs.put(p1, new ArrayList<Node>());
						hs.get(p1).add(an);
					}
					System.out.println("! "+an.ids+" "+an.idp);
				}
			}
			System.out.println("end");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
 
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
} 