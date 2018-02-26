package ps41b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ps41b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
        int a=Reader.nextInt();
        int b=Reader.nextInt();
        int l=Reader.nextInt();
        int r=Reader.nextInt();
        int gcd=1,lcm;
        for(int i=1; i<=a && i<=b;i++){
        	if(a%i == 0 && b%i == 0){
        		gcd=i;
        	}
        }
        lcm=(a*b)/gcd;
        int s=0;
        if(lcm > r){
        	System.out.println("0");
        }
        else{
        for(int j=lcm;j<=r;j=j+lcm){
        	if(j >=l){
        		s=j;
        		break;
        	}
        }
        int r1=r%lcm;
        int e=r-r1;
        int n1=((e-s)/lcm)+1;
        int ans;
        if(r-e+1 >= l){
        	;
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