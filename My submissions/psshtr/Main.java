package psshtr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Graph
{
 private int V;   
 private LinkedList<Integer> adj[];
 int[] parent;
 int[] can1;
 int[] can2;
 int[] coin;
 ArrayList<Integer> arr=new ArrayList<Integer>();


 Graph(int v)
 {
     V = v;
     adj = new LinkedList[v];
     can1=new int[v];
     can2=new int[v];
     coin=new int[v];
     parent=new int[v];
     arr=new ArrayList<Integer>();
     for (int i=0; i<v; ++i){
         adj[i] = new LinkedList();
     		parent[i]=-1;}
 }


 void addEdge(int v,int w)
 {
     adj[v].add(w);
     adj[w].add(v);
 }

 
 void BFS(int s)
 {	if(adj.length <= 2){
	 System.out.println("2");
	 return;
 }
     LinkedList<Integer> queue = new LinkedList<Integer>();
     queue.add(s);
     int need,count;

     while (queue.size() != 0)
     {
         s = queue.poll();
         arr.add(s);
         Iterator<Integer> i = adj[s].listIterator();
         while (i.hasNext())
         {
             int n = i.next();
             if (n!=parent[s]){
            	 queue.add(n);
            	 parent[n]=s;
             }
         }
     }
     for(int i=arr.size()-1;i>=0;i--){
    	 int x=arr.get(i);
    	 if(parent[x] != -1){
    		 if(adj[x].size() == 1){
    			 coin[x]=1;
    			 can2[x]=0;
    			 can1[x]=1;
    		 }
    		 else{
    			 need=0;
    			 count=0;
    			 Iterator<Integer> i1 = adj[x].listIterator();
    			 while (i1.hasNext())
    	         {
    	             int y = i1.next();
    	             if(need == 1)
    	            	 break;
    	             if(y != parent[x]){
    	            	 if(coin[y] == 0){
    	            		 if(can2[y] == 0){
    	            			 need=1;
    	            			 break;
    	            		 }
    	            		 else{
    	            			 Iterator<Integer> i2 = adj[y].listIterator();
    	            			 while (i2.hasNext())
    	            	         {
    	            				 int z=i2.next();
    	            				 if(z!= parent[y])
    	            					 if(coin[z] == 1)
    	            						 if(can2[z] == 0){
    	            							 need=1;
    	            							 break;
    	            						 }
    	            	         }
    	            		 }
    	            	 }	 
    	             }
    	         }
    	             if(need == 1){
    	            	 coin[x]=1;
    	            	 count=0;
    	            	 Iterator<Integer> i3 = adj[x].listIterator();
            			 while (i3.hasNext())
            	         {
            				 int y1=i3.next();
            				 if(y1 != parent[x]){
            					 if(coin[y1] == 1){
            						 count+=1;
            						 break;}
            				 }
            	         }
            			 can2[x]=1;}
            			 else{
            				count=0;
        	            	 Iterator<Integer> i8 = adj[x].listIterator();
                			 while (i8.hasNext())
                	         {
                				int y8=i8.next();
                				if(y8 != parent[x]){
                					if(coin[y8] == 1)
                						count+=1;
                				}
                	         }
            			 
            			 if(count == 1){
            				 coin[x]=0;
            				 can1[x]=1;
            				 can2[x]=0;
            			 }
            			 else if(count >= 2){
            				 coin[x]=0;
            				 can2[x]=1;
            				 can1[x]=1;
            			 }
            			 else{
            				 coin[x]=1;
            				 can2[x]=1;
            				 can1[x]=1;
            			 }
            			 }
    		 }
    	 }
            			 else{
            				 if(adj[x].size()==1){
            					 coin[x]=1;
            					 can2[x]=0;
            					 can1[x]=1;
            				 }
            				 else{
            					 need=0;
            					 count=0;
            					 Iterator<Integer> i4 = adj[x].listIterator();
                    			 while (i4.hasNext())
                    	         {
                    				 int y5=i4.next();
                    				 if(need == 1)
                    					 break;
                    				 if (y5 != parent[x]){
                    					 if(coin[y5] == 0){
                    						 if(can2[y5] == 0){
                    							 need=1;
                    							 break;
                    						 }
                    						 else{
                    							 Iterator<Integer> i5 = adj[y5].listIterator();
                                    			 while (i5.hasNext())
                                    	         { 
                                    				 int z5=i5.next();
                                    				 if(z5 != parent[y5]){
                                    					 if(coin[z5] == 1) {
                                    						 if(can2[z5] == 0){
                                    							 need=1;
                                    							 break;
                                    						 }
                                    					 }
                                    				 }
                                    	         }
                    						 }
                    					 }
                    					 else if(can2[y5] == 0){
                    						 need=1;
                    					 }
                    				 }
                    	         }
                    				 if(need == 1)
                    					 coin[x]=1;
                    				 else{
                    					 count=0;
                    					 Iterator<Integer> i6 = adj[x].listIterator();
                            			 while (i6.hasNext())
                            	         { 
                            				 int y6=i6.next();
                            				 if(coin[y6]==1){
                            					 count+=1;
                            				 }
                            	         }
                            			 if(count > 1)
                            				 coin[x]=0;
                            			 else
                            				 coin[x]=1;
                    				 }
                    	         
                    	         }
            				 }
            			 }
    	             
    	         
    		 
    	 
     int sum1=0;
     for(int gh=0;gh<coin.length;gh++){
    	 sum1+=coin[gh];
     }
     System.out.println(sum1);
     
     
 }

}
public class Main{
	
	
	public static void main(String[] args) {
		
		Reader.init(System.in);
		try{
		int t = Reader.nextInt();
		
		for(int cv=0;cv<t;cv++)
		{
				int n = Reader.nextInt();
				Graph g=new Graph(n);
				for(int i=1; i<n; i++)
				{
					int u = Reader.nextInt();
					int v = Reader.nextInt();
					u=u-1;
					v=v-1;
					g.addEdge(u,v);
				}
				if(n>1)
				g.BFS(0); 
				else{
					System.out.println("-1");
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