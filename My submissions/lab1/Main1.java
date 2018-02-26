package lab1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

//Node representing a student
class Node{
	String name;
	String rollno;
	String program;
	int dis;
	boolean allot;
	
	public Node(String s,String rno,String pr,int d){
		name=s;
		rollno=rno;
		program=pr;
		dis=d;
		allot=false;
	}
}
// Max Heap for phds
class phd{
	Node[] harr;
	int capacity;
	int heap_size;
	
	public phd(int n){
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
		while( i != 0 && harr[parent(i)].dis < harr[i].dis){
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
		if( l < heap_size && harr[l].dis > harr[i].dis){
			smallest=l;
		}
		if( r < heap_size && harr[r].dis > harr[smallest].dis){
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
//Max heap for pgs
class pg{
	Node[] harr;
	int capacity;
	int heap_size;
	
	public pg(int n){
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
		while( i != 0 && harr[parent(i)].dis < harr[i].dis){
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
		if( l < heap_size && harr[l].dis > harr[i].dis){
			smallest=l;
		}
		if( r < heap_size && harr[r].dis > harr[smallest].dis){
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
// max heap for ugs
class ug{
	Node[] harr;
	int capacity;
	int heap_size;
	
	public ug(int n){
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
		while( i != 0 && harr[parent(i)].dis < harr[i].dis){
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
		if( l < heap_size && harr[l].dis > harr[i].dis){
			smallest=l;
		}
		if( r < heap_size && harr[r].dis > harr[smallest].dis){
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

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);    
	    try{
	    	int n=Reader.nextInt();
	    	int m=Reader.nextInt();
	    	phd h1=new phd(n);
	    	phd h0=new phd(n);
    		pg h2=new pg(n);
    		ug h3=new ug(n);
    		if(h1.getClass() == h0.getClass())
    			System.out.println("yo");
    		ArrayList<Node> arr=new ArrayList<Node>();
	    	for(int i=0;i<n;i++){
	    		String name=Reader.next();
	    		String rno=Reader.next();
	    		String pr=Reader.next();
	    		int dis=Reader.nextInt();
	    		Node nptr=new Node(name,rno,pr,dis);
	    		arr.add(nptr);
	    		if(pr.equals("PhD")){
	    			h1.insert(nptr);//Add node to heap of phds
	    		}
	    		else if(pr.equals("PG")){
	    			h2.insert(nptr);//Add node to heap of pgs
	    		}
	    		else if(pr.equals("UG")){
	    			h3.insert(nptr);//Add node to heap of ugs
	    		}
	    	}
	    	int c1=0;
	    	int c2=0;
	    	if(m % 2 == 0){
	    		int n1=m/2;
	    		for(int j=0;j<n1;j++){
	    			if(h1.heap_size != 0){
	    				Node w=h1.extractmin();//Top m/2 phds
	    				w.allot=true;
	    				c1++;
	    			}
	    			if(h2.heap_size != 0){
	    				Node w1=h2.extractmin();//Top m/2 pgs
	    				w1.allot=true;
	    				c1++;
	    			}
	    		}
	    		
	    		if(c1 != m){//Remaining ugs
	    			int e=m-c1;
	    			for(int i=0;i<e;i++){
	    				if(h3.heap_size != 0){
	    				Node w2=h3.extractmin();
	    				w2.allot=true;
	    				}
	    				else{
	    					break;
	    				}
	    			}
	    		}
	    	}
	    	else{// m is odd case
	    		int c3=0;
	    		int n1=m/2;
	    		int n2=m-n1;
	    		for(int i=0;i<n2;i++){
	    			if(h1.heap_size != 0){
	    				Node w=h1.extractmin();// top m/2+1 phds
	    				w.allot=true;
	    				c3++;
	    			}
	    			else{
	    				break;
	    			}
	    		}
	    		for(int i1=0;i1<n1;i1++){
	    			if(h2.heap_size != 0){
	    				Node w1=h2.extractmin();//top m/2 pgs
	    				w1.allot=true;
	    				c3++;
	    			}
	    			else{
	    				break;
	    			}
	    		}
	    		if(c3 != m){
	    			int e1=m-c3;
	    			for(int i=0;i<e1;i++){
	    				if(h3.heap_size != 0){
	    					Node w2=h3.extractmin();//Reamaining ugs
	    					w2.allot=true;
	    				}
	    				else{
	    					break;
	    				}
	    			}
	    		}
	    	}
	    	for(int f=0;f<arr.size();f++){//Order by allotment list
	    		Node a=arr.get(f);
	    		if(a.allot == true)
	    			System.out.println(a.name+" "+a.rollno+" "+a.program+" "+a.dis);
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


