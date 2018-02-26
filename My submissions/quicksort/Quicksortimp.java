package quicksort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 class Quicksort {
	 private int[] A;
	 private int n;
	 
	 public void sort (int[] values) {
	 this.A = values;
	 n = values.length;
	 quicksort (0, n - 1);
	 }
	 
	 private void quicksort (int low, int high) {
	 int i = low+1, j = high;
	 int pivot = A[low];

	 while (i <= j) {
	 while (A[i] < pivot && i <= j)
	 i++;
	 while (A[j] > pivot)
	 j--; 
	 
	 if (i < j) {
	 exchange (i, j);
	 i++;
	 j--;
	 }
	 
	 }
	 exchange (low, j);
	
	 if (low < j - 1)
	 quicksort (low, j-1);
	 if (j+1 < high)
	 quicksort (j+1, high);
	 }
	 
	 private void exchange (int i, int j) {
		 int temp = A[i];
		 A[i] = A[j];
		 A[j] = temp;
		 }
		}

public class Quicksortimp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{int a;
			int n=Reader.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				a=Reader.nextInt();
				arr[i]=a;
			}
			Quicksort s=new Quicksort();
			s.sort(arr);
			for(int j=0;j<n;j++){
				System.out.print(arr[j]+" ");
			}
		}catch (IOException e) {
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
