package pr1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Node{
	int val;
	int id;
	public Node(int v1,int n1){
		val=v1;
		id=n1;
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
		while( i != 0 && harr[parent(i)].val < harr[i].val){
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
		//System.out.println("root"+root+" "+harr[0]);
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
		if( l < heap_size && harr[l].val > harr[i].val){
			smallest=l;
		}
		if( r < heap_size && harr[r].val > harr[smallest].val){
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

public class Problem_a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int n=Reader.nextInt();
			int m=Reader.nextInt();
			if (n == 1){
				int cv=Reader.nextInt();
				int res=findmax(cv,m);
				System.out.println(res);
			}
			else{
			int[] arr=new int[n];
			int[] arr1=new int[n];
			heap h=new heap(100000);
			for(int i=0;i<n;i++){
				int vgh=Reader.nextInt();
				Node n5=new Node(vgh,i);
				h.insert(n5);
				arr[i]=1;
				arr1[i]=vgh;
			}
			int c=m-n;
			for(int j=1;j<=c;j++){
				Node b=h.extractmin();
				arr[b.id]+=1;
				System.out.println("b "+b.val);
				System.out.println("count "+arr[b.id]);
				int cvb=findmax(arr1[b.id],arr[b.id]);
				System.out.println("inserted "+cvb);
				Node ce=new Node(cvb,b.id);
				h.insert(ce);
			}
			Node res=h.extractmin();
			System.out.println(res.val);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int findmax(int max,int bn){
		int lo=0;
		int hi=max;
		int[] arr=new int[max];
		for(int j=0;j<max;j++){
			arr[j]=1;
		}
		while(lo < hi){
			int x=lo+(hi-lo)/2;
			
			int required = 1,current=0;
			for(int i=0;i<max;i++){
				if(current+arr[i] <= x){
					current+=arr[i];
				}
				else{
					required++;
					current=arr[i];
				}
			}

			if(required <= bn){
				hi=x;
			}
			else{
				lo=x+1;
			}
		}
		return lo;
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