package may1c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class heap{
	int[] harr;
	int heap_size;
	
	public heap(int[] n){
		heap_size=n.length;
		harr=n;
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
	
	public int extractmin(){
		if(heap_size <= 0){
			return Integer.MAX_VALUE;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		int root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.minheapify(0);
		return root;
	}
	
	public void minheapify(int i){
		int temp;
		int smallest=i;
		int l=left(i);
		int r=right(i);
		if(l < heap_size && harr[l] < harr[smallest])
			smallest=l;
		if(r < heap_size && harr[r] < harr[smallest])
			smallest=r;
		if(smallest != i){
			temp=harr[smallest];
			harr[smallest]=harr[i];
			harr[i]=temp;
			minheapify(smallest);
		}
	}
	
	public int[] heapsort(){
		int e;
		int[] ans=new int[heap_size];
		int p=0;
		for(int i=heap_size/2 - 1;i >=0;i--){
			minheapify(i);
		}
		while(heap_size != 0){
			e=extractmin();
			ans[p]=e;
			p++;
			//System.out.print(e);
		}
		return ans;
	}
}

public class May1c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int t=Reader.nextInt();
			for(int i=0;i<t;i++){
				int n=Reader.nextInt();
				int s=1;
				int[] arr = new int[2*n];
				for(int j=0;j< 2*n;j++){
					int e=Reader.nextInt();
					arr[j]=e;
				}
				int[] use=new int[2*n];
				heap h=new heap(arr);
				use=h.heapsort();
				//int[] gye =new int[n];
				int[] fin = new int[2*n];
				for(int k=n; k<2*n ; k++ ){
					if(s< 2*n){
					fin[s]=use[k];
					fin[s-1]=use[k-n];
					s=s+2;}
				}
				int med= use[n+ (n+1)/2 - 1];
				System.out.println(med);
				for(int x=0;x<2*n;x++){
					System.out.print(fin[x]+" ");
				}
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