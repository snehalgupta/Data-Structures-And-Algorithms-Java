package DEQUE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;




 
class Bipartite
{	int V;
	int[] arr1;
	int[] arr2;
	int n1;
	int n2;
	int[] colorArr;
    public Bipartite(int n){
    	V=n;
    	arr1=new int[n];
    	arr2=new int[n];
    	colorArr=new int[n];
    	n1=0;
    	n2=0;
    }
 
    boolean isBipartite(int G[][],int src)
    {
        
        colorArr[src] = 1;
        LinkedList<Integer>q = new LinkedList<Integer>();
        q.add(src);
 
        while (q.size() != 0)
        {
 
            int u = q.poll();
 
            for (int v=0; v<V; ++v)
            {
                if (G[u][v]==1 && colorArr[v]==-1)
                {
                    colorArr[v] = 1-colorArr[u];
                    q.add(v);
                }
 
                else if (G[u][v]==1 && colorArr[v]==colorArr[u]){
                	 return false;
                }
                     
            }
            
        }
        return true;
    }
    
    void isBipartite(int G[][])
    {	int flag=0;
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;
     
        for (int i = 0; i < V; i++){
          if (colorArr[i] == -1)
            if (isBipartite(G, i) == false){
            	flag=1;
            	break;
            }}
     if(flag ==0) {
    	 for(int k=0;k<V;k++){
     		if (colorArr[k]==1 && n2<V){
     			arr2[n2]=k+1;
     			n2=n2+1;
     		}
     		else if(colorArr[k]==0 && n1<V){
     			arr1[n1]=k+1;
     			n1=n1+1;
     		}
     	}
    	 System.out.println(n1);
    	 for(int i=0;i<n1;i++){
    		 System.out.print(arr1[i]+" ");
    	 }
    	 System.out.println();
    	 System.out.println(n2);
    	 for(int j=0;j<n2;j++){
    		 System.out.print(arr2[j]+" ");
    	 }
     }
     else{
    	 System.out.println("-1");
     }
    }
}
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
	    	int n=Reader.nextInt();
	    	int m=Reader.nextInt();
	    	
	    	Bipartite gr=new Bipartite(n);
	    	int[][] ge=new int[n][n];
	    	for(int i=0;i<m;i++){
	    		int x=Reader.nextInt();
	    		int y=Reader.nextInt();
	    		ge[x-1][y-1]=1;
	    		ge[y-1][x-1]=1;		
	    	}
	    	gr.isBipartite(ge);
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