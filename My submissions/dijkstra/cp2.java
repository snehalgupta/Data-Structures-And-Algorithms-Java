package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class adjnode{
	int dest;
	int weight;
	adjnode next;
	
	public adjnode(int dest1,int weight1){
		dest=dest1;
		weight=weight1;
		next=null;
	}
}

class adjlist{
	adjnode head;
}

class graph{
	int v;
	adjlist[] arr;
	
	public graph(int v1){
		v=v1;
		arr=new adjlist[v1];
		for(int i=0;i<v;i++){
			arr[i]=new adjlist();
			arr[i].head=null;
		}
	}
	
	public void addedge(int src,int dest,int weight){
		adjnode nptr=new adjnode(dest,weight);
		nptr.next=arr[src].head;
		arr[src].head=nptr;
		nptr=new adjnode(src,weight);
		nptr.next=arr[dest].head;
		arr[dest].head=nptr;
	}
}
class minheapnode{
	int v;
	int dist;
	
	public minheapnode(int v1,int dist1){
		v=v1;
		dist=dist1;
	}
}

class minheap{
	int size;
	int capacity;
	int[] pos;
	minheapnode[] array;
	
	public minheap(int c){
		pos=new int[c];
		size=0;
		capacity=c;
		array=new minheapnode[c];
	}
	
	
	public void minheapify(int idx){
		int smallest,left,right;
		smallest=idx;
		left=2*idx+1;
		right=2*idx+2;
		if(left < size && array[left].dist < array[smallest].dist){
			smallest=left;
		}
		if(right < size && array[right].dist < array[smallest].dist){
			smallest=right;
		}
		if(smallest != idx)	{
			minheapnode smallestnode=array[smallest];
			minheapnode idxnode=array[idx];
			pos[smallestnode.v]=idx;
			pos[idxnode.v]=smallest;
			minheapnode temp=array[smallest];
			array[smallest]=array[idx];
			array[idx]=temp;
			minheapify(smallest);
		}
	}
	
	public boolean isempty(){
		return size == 0;
	}
	
	public minheapnode extractmin(){
		if(isempty()==true){
			return null;
		}
		minheapnode root=array[0];
		minheapnode lastnode=array[size-1];
		array[0]=lastnode;
		pos[root.v]=size-1;
		pos[lastnode.v]=0;
		--size;
		minheapify(0);
		return root;
	}
	
	public void decreaseKey(int v,int dist){
		int i=pos[v];
		array[i].dist=dist;
		while(i != 0 && array[i].dist < array[(i-1)/2].dist){
			pos[array[i].v]=(i-1)/2;
			pos[array[(i-1)/2].v]=i;
			minheapnode temp=array[i];
			array[i]=array[(i-1)/2];
			array[(i-1)/2]=temp;
			i=(i-1)/2;
		}
	}
	
	public boolean isinminheap(int v1){
		if(pos[v1] < size)
			return true;
		return false;
	}
	
	public void printarr(int dist[],int n){
		for(int i=0;i<n;i++)
			System.out.println(i+" "+dist[i]);
	}
	
	public int[] dijkstra(graph g,int src){
		int v=g.v;
		int[] dist=new int[v];
		for(int i=0;i<v;i++){
			dist[i]=Integer.MAX_VALUE;
			array[i]=new minheapnode(i,dist[i]);
			pos[i]=i;
		}
		array[src]=new minheapnode(src,dist[src]);
		pos[src]=src;
		dist[src]=0;
		decreaseKey(src,dist[src]);
		size=v;
		while(! this.isempty()){
			minheapnode we=extractmin();
			int u=we.v;
			adjnode pcrawl=g.arr[u].head;
			while(pcrawl != null){
				int v1=pcrawl.dest;
				if (isinminheap( v1) && dist[u] != Integer.MAX_VALUE && 
                        pcrawl.weight + dist[u] < dist[v1])
				{
					dist[v1] = dist[u] + pcrawl.weight;
					decreaseKey(v1, dist[v1]);
				}
				pcrawl = pcrawl.next;
			}
		}
	return dist;	
	}
}
public class cp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int t=Reader.nextInt();
			for(int i=0;i<t;i++){
				int n=Reader.nextInt();
				int m=Reader.nextInt();
				int v=Reader.nextInt();
				int b=Reader.nextInt();
				int g=Reader.nextInt();
				int h=Reader.nextInt();
				int dist=0;
				int[] des=new int[v];
				graph graph=new graph(n);
				for(int j=0;j<m;j++){
					int x=Reader.nextInt();
					int y=Reader.nextInt();
					int l=Reader.nextInt();
					graph.addedge(x-1,y-1,l);
					if((x == g && y==h) || (x==h && y==g)){
						dist=l;
					}
				}
				for(int k=0;k<v;k++){
					des[k]=Reader.nextInt();
				}
				ArrayList<Integer> arre=new ArrayList<Integer>();
				minheap heap=new minheap(n);
				int[] err1=heap.dijkstra(graph, b-1);
				minheap heap2=new minheap(n);
				int[] err2=heap2.dijkstra(graph,h-1);
				/*for(int y1=0;y1<n;y1++){
					System.out.print(err1[y1]+" ");
				}
				System.out.println();
				for(int y1=0;y1<n;y1++){
					System.out.print(err2[y1]+" ");
				}*/
				for(int k1=0;k1<v;k1++){
					int ans1=err1[des[k1]-1];
					//System.out.println("ans1 "+ans1);
					int ans2=err1[g-1];
					ans2=ans2+dist;
					ans2=ans2+err2[des[k1]-1];
					//System.out.println("ans2 "+ans2);
					if(ans1 == ans2){
						arre.add(des[k1]);

					}
					else{
						ans2=err1[h-1];
						ans2=ans2+dist;
						minheap heap3=new minheap(n);
						int[] err3=heap3.dijkstra(graph,g-1);
						ans2=ans2+err3[des[k1]-1];
						//System.out.println("ans2 "+ans2);
						if(ans1 == ans2){
							arre.add(des[k1]);
						}
					}
				}
				//System.out.println();
				Collections.sort(arre);
				for(int fg=0;fg<arre.size();fg++){
					System.out.print(arre.get(fg)+" ");
				}
				System.out.println();
			}
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