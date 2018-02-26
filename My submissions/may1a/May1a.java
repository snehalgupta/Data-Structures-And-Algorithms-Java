package may1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class May1a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{ int t=Reader.nextInt();
		     for(int i=0;i<t;i++){
		    	 String s=Reader.next();
		    	 int[] arr =new int[3];
		    	 int res=0;
		    	 for(int j=0;j<s.length();j++){
		    		 if(s.charAt(j) == 'C'){
		    			 arr[0]=1;
		    			 if(arr[1] == 1 || arr[2] == 1){
		    				 res=1;
		    				 break;
		    			 }
		    		 }
		    		 else if(s.charAt(j) == 'E'){
		    			 arr[1]=1;
		    			 if(arr[2] == 1){
		    				 res=1;
		    				 break;
		    			 }
		    		 }
		    		 else if(s.charAt(j) == 'S'){
		    			 arr[2]=1;
		    		 }
		    	 }
		    	 if(res == 0){
		    		 System.out.println("yes");
		    	 }
		    	 else{
		    		 System.out.println("no");
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