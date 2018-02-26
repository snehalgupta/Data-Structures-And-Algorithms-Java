package maxp;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int n=Reader.nextInt();
			int[] arr=new int[n+2];
			int sum=0;
			for(int i=1;i<n+1;i++){
				arr[i]=Reader.nextInt();
				sum+=arr[i];
			}
			int count=0;
			int flag=0;
			int prev=0;
			while(flag == 0){
			
			for(int j=1;j<n+1;j++){
				
				if(arr[j] != 0){
				int min=Math.min(prev,arr[j+1]);
				if(min < arr[j]){
					int diff=arr[j]-min;
					prev=arr[j];
					arr[j]=min;
					sum-=diff;
				}
				else{
					prev=arr[j];
					arr[j]=arr[j]-1;
					sum-=1;
				}
				
			
			}
				else{
					prev=arr[j];
				}
				}
			count++;
			if(sum == 0){
				flag=1;
				break;
			}
				
			}
			System.out.println(count);
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
    
    static long nextLong() throws IOException{
    	return Long.parseLong(next());
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}