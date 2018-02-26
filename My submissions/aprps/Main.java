package aprps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			N=Reader.nextInt();
			int k=Reader.nextInt();
			int[][] arr=new int[N][N];
			int con=1;
			for(int i=0;i<N-1;i++){
				int u=Reader.nextInt();
				int v=Reader.nextInt();
				u=u-1;
				v=v-1;
				arr[u][v]=con;
				arr[v][u]=con;
			}
			
			long sum=0;
			for(int f=0;f<N;f++){
				for(int g=f+1;g<N;g++){
					sum+=countwalks(arr,f,g,k);
				}
			}
			System.out.println(sum);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public static int countwalks(int graph[][], int u, int v, int k)
    {
        
        int count[][][] = new int[N][N][k+1];
 
        
        for (int e = 0; e <= k; e++)
        {
            for (int i = 0; i < N; i++) 
            {
                for (int j = 0; j < N; j++) 
                {
                   
                    count[i][j][e] = 0;
 
                    
                    if (e == 0 && i == j)
                        count[i][j][e] = 1;
                    if (e == 1 && graph[i][j]!=0)
                        count[i][j][e] = 1;
 
                    
                    if (e > 1)
                    {
                        for (int a = 0; a < N; a++) 
                            if (graph[i][a]!=0)
                                count[i][j][e] += count[a][j][e-1];
                    }
               }
            }
        }
        return count[u][v][k];
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