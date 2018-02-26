package pr2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Reader.init(System.in);    
		    try{
		    	int t=Reader.nextInt();
		    	for(int i=0;i<t;i++){
		    		int n=Reader.nextInt();
		    		int k=Reader.nextInt();
		    		int sum=(k*(k+1) )/2;
		    		int flag=0;
		    		int flag1=0;
		    		int[] visited=new int[k+1];
		    		int count1=0;
		    		for(int j=0;j<n;j++){
		    			int n1=Reader.nextInt();
		    			if(n1 == k){
		    				flag=1;
		    			}
		    			flag1=0;
		    				for(int f=0;f<n1;f++){
		    					int c=Reader.nextInt();
		    					if(visited[c] == 0){
		    						visited[c]=1;
		    						sum-=c;
		    						flag1=1;
		    					}
		    				}
		    				if(flag1 == 1){
		    					count1+=1;
		    				}
		    			
		    		}
		    		if (flag==1){
		    			System.out.println("some");
		    		}
		    		else if(flag == 0){
		    			if(sum != 0){
		    				System.out.println("sad");
		    			}
		    			else if(sum ==0 && count1==n){
		    				System.out.println("all");
		    			}
		    			else{
		    				System.out.println("some");
		    			}
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