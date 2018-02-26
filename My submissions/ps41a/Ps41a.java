package ps41a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Ps41a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
		int sum=0,p=0;
		int n=Reader.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<2;i++){
			arr[p]=Reader.nextInt();
			sum=sum+arr[i];
			p++;
		}
		int max=sum;
		for(int j=2;j<n;j++){
			arr[p]=Reader.nextInt();
			sum=sum+arr[j]-arr[j-2];
			if(sum > max)
				max=sum;
			p++;
		}
		System.out.println(max);
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