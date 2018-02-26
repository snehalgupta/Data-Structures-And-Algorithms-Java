package kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class Graph1
{
    int V;   
    adjlist[] arr; 
 
    

 
    public Graph1(int v1){
		V=v1;
		arr=new adjlist[v1];
		for(int i=0;i<V;i++){
			arr[i]=new adjlist();
			arr[i].head=null;
		}
	}
	
	public void addedge(int src,int dest){
		adjnode nptr=new adjnode(dest);
		nptr.next=arr[src].head;
		arr[src].head=nptr;
		nptr=new adjnode(src);
		nptr.next=arr[dest].head;
		arr[dest].head=nptr;
	}
    
 
    Boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {
        
        visited[v] = true;
 
        adjnode df=arr[v].head;
        while (df != null)
        {
 
            if (!visited[df.dest])
            {
                if (isCyclicUtil(df.dest, visited, v))
                    return true;
            }
 
            else if (df.dest != parent)
                return true;
            df=df.next;
        }
        return false;
    }
 
    
    Boolean isCyclic()
    {
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        for (int u = 0; u < V; u++)
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;
 
        return false;
    }
}
class adjnode{
	int dest;
	adjnode next;
	
	public adjnode(int dest1){
		dest=dest1;
		next=null;
	}
}

class adjlist{
	adjnode head;
}


class Graph
{
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };
 
 
    int V, E;    
    Edge edge[]; 
 
    
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
 
   
 
    void KruskalMST()
    {	int count=0;
        Arrays.sort(edge);
        for(int i=1;i<E;i++){
        	if(edge[i].weight != edge[i-1].weight){
        		Graph1 g1=new Graph1(V);
        		for(int j=0;j<i;j++){
        			g1.addedge(edge[j].src, edge[j].dest);
        		}
        		if(!g1.isCyclic()){
        			count=count+1;
        		}
        	}
        }
       System.out.println(count); 
    }
}
public class cp6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);    
	    try{
	    	int n=Reader.nextInt();
	    	int m=Reader.nextInt();
	    	Graph g3=new Graph(n,m);
	    	for(int i1=0;i1<m;i1++){
	    		g3.edge[i1].src=Reader.nextInt();
	    		g3.edge[i1].src-=1;
	    		g3.edge[i1]. dest=Reader.nextInt();
	    		g3.edge[i1].dest-=1;
	    		g3.edge[i1].weight=Reader.nextInt();
	    	}
	    	g3.KruskalMST();
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