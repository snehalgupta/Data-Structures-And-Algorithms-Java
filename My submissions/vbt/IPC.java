package vbt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


class Node{
	long t;
	long s;
	public Node(long t1,long s1){

		t=t1;
		s=s1;
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
		while( i != 0 && harr[parent(i)].s < harr[i].s){
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
		if( l < heap_size && harr[l].s > harr[i].s){
			smallest=l;
		}
		if( r < heap_size && harr[r].s > harr[smallest].s){
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
 
 
public class IPC{
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int t=Reader.nextInt();
			for(int i=0;i<t;i++){
				int n=Reader.nextInt();
				int d=Reader.nextInt();
				heap h=new heap(n);
				HashMap<Integer,ArrayList<Node>> hm=new HashMap<Integer,ArrayList<Node>>();
				long sum=0;
				for(int j=0;j<n;j++){
					int di=Reader.nextInt();
					long ti=Reader.nextInt();
					long si=Reader.nextInt();
					sum+=ti*si;
					Node nptr=new Node(ti,si);
					if(hm.get(di) != null){
						hm.get(di).add(nptr);
					}
					else{
						hm.put(di, new ArrayList<Node>());
						hm.get(di).add(nptr);
					}
				}
				for(int fg=1;fg<=d;fg++){
					if(hm.get(fg) != null){
						for(int fh=0;fh<hm.get(fg).size();fh++){
							h.insert(hm.get(fg).get(fh));
						}
						h.harr[0].t-=1;
						sum-=h.harr[0].s;
						if(h.harr[0].t == 0)
							h.extractmin();
						
					}
					else if(h.heap_size != 0){
						h.harr[0].t-=1;
						sum-=h.harr[0].s;
						if(h.harr[0].t == 0)
							h.extractmin();
						
					}
				}
				
				System.out.println(sum);
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