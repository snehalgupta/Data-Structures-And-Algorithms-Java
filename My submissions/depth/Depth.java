package depth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


class Node2{
	int val;
	int index;
	
	public Node2(int v,int i){
		val=v;
		index=i;
	}
}
 
class heap1{
	Node2[] harr;
	int capacity;
	int heap_size;
	
	public heap1(int n){
		heap_size=0;
		capacity=n;
		harr=new Node2[n];
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
	
	public void insert(Node2 k){
		Node2 temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && harr[parent(i)].val > harr[i].val){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	public void decreaseKey(int i,int new_val){
		Node2 temp;
		harr[i].val=new_val;
		while(i != 0 && harr[parent(i)].val > harr[i].val){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	public 	Node2 extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		Node2 root=harr[0];
		//System.out.println("root"+root+" "+harr[0]);
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		Node2 temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && harr[l].val < harr[i].val){
			smallest=l;
		}
		if( r < heap_size && harr[r].val < harr[smallest].val){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
	public void delete(int i){
		decreaseKey(i,Integer.MIN_VALUE);
		extractmin();
	}
}




class Node
{
    int data;
    Node link;
 
    public Node(int val)
    {
        link = null;
        data = val;
    }    
    
    public void setLink(Node n)
    {
        link = n;
    }    
    
    public void setData(int d)
    {
        data = d;
    }    
    
    public Node getLink()
    {
        return link;
    }    
    
    public int getData()
    {
        return data;
    }
}

class Node1{
	int src;
	int des;
	int weight;
	
	public Node1(int s,int d,int w){
		src=s;
		des=d;
		weight=w;
	}
}
class linkedlist
{
    protected Node start;
    protected Node end ;
    public int size ;
 
  
    public linkedlist()
    {
        start = null;
        end = null;
        size = 0;
    }
    
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
    
}

class Graph1
{
	int v;
	linkedlist[] adj;
	int c;
	int[] level;
	int[] in;
	int[] out;
	int[] discover;
	HashMap<Integer,ArrayList<Integer>> map;
	
	
	public Graph1(int v1){
		v=v1;
		adj=new linkedlist[v1+1];
		c=0;
		map=new HashMap<Integer,ArrayList<Integer>>();
		level=new int[v1+1];
		in=new int[v1+1];
		out=new int[v1+1];
		discover=new int[v1+1];
		for(int j=0;j<v1+1;j++){
			adj[j]=new linkedlist();
			map.put(j,new ArrayList<Integer>());
		}
	}
	
	public void addlink(int a,int b){
		adj[a].insertAtEnd(b);
		adj[b].insertAtEnd(a);
	}
	
	public void depthft(int vd,boolean visited[],int lev){
		visited[vd]=true;
		level[vd]=lev;
		in[vd]=++c;
		discover[c]=vd;
		Node temp=adj[vd].start;
		while(temp != null){
			if(!visited[temp.getData()])
				depthft(temp.getData(),visited,lev+1);
			temp=temp.getLink();
		}
		out[vd]=c;
	}
	
	public void depth(int v1){
		boolean[] visited=new boolean[v+1];
		depthft(v1,visited,0);
	}
	
	public void func(Node1 node,heap1[] hs){
		if(level[node.src] > level[node.des]){
			int i1=in[node.src];
			int i2=out[node.src];
			for(int k=i1;k<=i2;k++){
				map.get(discover[k]).add(node.weight);
				Node2 nptr=new Node2(node.weight,map.get(discover[k]).size()-1);
				hs[discover[k]].insert(nptr);
			}
		}
		else if(level[node.des] > level[node.src]){
			int i1=in[node.des];
			int i2=out[node.des];
			for(int k=i1;k<=i2;k++){
				map.get(discover[k]).add(node.weight);
				Node2 nptr=new Node2(node.weight,map.get(discover[k]).size()-1);
				hs[discover[k]].insert(nptr);
			}
		}
		
	}
	
	
}
public class Depth {
	static final int MAX = 1000000001;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int t=Reader.nextInt();
			for(int i=0;i<t;i++){
				int n=Reader.nextInt();
				heap1[] hs=new heap1[n+1];
				Graph1 g1=new Graph1(n);
				Node1[] edge=new Node1[n-1];
				for(int j=0;j<n-1;j++){
					int u=Reader.nextInt();
					int v=Reader.nextInt();
					int w=Reader.nextInt();
					g1.addlink(u, v);
					hs[j]=new heap1(n);
					edge[j]=new Node1(u,v,w);
				}
				hs[n-1]=new heap1(n);
				hs[n]=new heap1(n);
				g1.depth(1);
				for(int r=0;r<n+1;r++){
					System.out.print(g1.discover[r]+" ");
				}
				System.out.println();
				for(int r=0;r<n+1;r++){
					System.out.print(g1.in[r]+" ");
				}
				System.out.println();
				for(int r=0;r<n+1;r++){
					System.out.print(g1.out[r]+" ");
				}
				System.out.println();
				for(int v9=0;v9<n-1;v9++){
					g1.func(edge[v9],hs);
				}
				
				int m=Reader.nextInt();
				for(int x=0;x<m;x++){
					int u1=Reader.nextInt();
					int v1=Reader.nextInt();
					int k1=Reader.nextInt();
					ArrayList<Integer> arr1=g1.map.get(u1);
					ArrayList<Integer> arr2=g1.map.get(v1);
					for(int d1=0;d1<arr1.size();d1++){
						System.out.print(arr1.get(d1)+" ");
					}
					System.out.println();
					for(int d2=0;d2<arr2.size();d2++){
						System.out.println(arr2.get(d2)+" ");
					}
					System.out.println();
					int r1=0;
					int ans=0;
					for(int ip=0;ip < arr1.size() && ip<arr2.size();ip++){
						if(arr1.get(ip) != arr2.get(ip)){
							r1=ip;
							break;
						}
					}
					int flag1=0;
					int flag=0;
					int flag2=0;
					ArrayList<Node2> tar=new ArrayList<Node2>();
					while(flag1 == 0){
						if(hs[u1].heap_size != 0){
							Node2 te=hs[u1].extractmin();
							tar.add(te);
							if(te.index >= r1 && te.val <= k1){
								if(flag == 0)
									ans=te.val;
								else{
									flag=1;
									ans=ans^te.val;
								}
							}
							else if(te.val > k1)
								break;
						}
						else{
							flag1=1;
						}
					}
					while(tar.size() != 0){
						Node2 qwt=tar.remove(tar.size()-1);
						hs[u1].insert(qwt);
					}
					while(flag2 ==0){
						if(hs[v1].heap_size != 0){
							Node2 ta=hs[v1].extractmin();
							tar.add(ta);
							if(ta.index >= r1 && ta.val <= k1){
								if(flag == 0)
									ans=ta.val;
								else{
									ans=ans^ta.val;
								}
							}
							else if(ta.val > k1)
								break;
						}
						else {
							flag2=1;
						}
					}
					while(tar.size() != 0){
						Node2 qwt=tar.remove(tar.size()-1);
						hs[v1].insert(qwt);
					}
					System.out.println(ans);
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 
    static void update(int idx, int blk, int val, int bit[][])
    {
        for (; idx<MAX; idx += (idx&-idx))
            bit[blk][idx] += val;
    }
      
    
    static int query(int l, int r, int k, int arr[], int blk_sz,
                                          int bit[][])
    {
        
        int sum = 0;
        while (l<r && l%blk_sz!=0 && l!=0)
        {
            if (arr[l] <= k)
                sum++;
            l++;
        }
      
       
        while (l + blk_sz <= r)
        {
            int idx = k;
            for (; idx > 0 ; idx -= idx&-idx)
                sum += bit[l/blk_sz][idx];
            l += blk_sz;
        }
      
        
        while (l <= r)
        {
            if (arr[l] <= k)
                sum++;
            l++;
        }
        return sum;
    }
      
    
    static void preprocess(ArrayList<Integer> arr, int blk_sz, int n, int bit[][])
    {
        for (int i=0; i<n; i++)
            update(arr.get(i), i/blk_sz, 1, bit);
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