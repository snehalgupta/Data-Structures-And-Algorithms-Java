package Lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Node
{
    int data;
    Node link;
 
    public Node(int val)
    {
        link = null;
        data = val;
    }    
    
    public void setLink(Node n)
    {
        link = n;
    }    
    
    public void setData(int d)
    {
        data = d;
    }    
    
    public Node getLink()
    {
        return link;
    }    
    
    public int getData()
    {
        return data;
    }
}

class linkedlist
{
    protected Node start;
    protected Node end ;
    public int size ;
 
  
    public linkedlist()
    {
        start = null;
        end = null;
        size = 0;
    }
    
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
    
}

class Graph1
{
	int v;
	linkedlist[] adj;
	int c;
	
	public Graph1(int v1){
		v=v1;
		adj=new linkedlist[v1];
		c=0;
		for(int j=0;j<v1;j++){
			adj[j]=new linkedlist();
		}
	}
	
	public void addlink(int a,int b){
		adj[a].insertAtEnd(b);
		adj[b].insertAtEnd(a);
	}
	
	public void depthft(int v,boolean visited[]){
		visited[v]=true;
		c=c+1;
		//System.out.print(v+" ");
		Node temp=adj[v].start;
		while(temp != null){
			if(!visited[temp.getData()])
				depthft(temp.getData(),visited);
			temp=temp.getLink();
		}
	}
	
	public void domains(){
		int count=0;
		boolean[] visited = new boolean[v];
		for(int w=0;w < v;w++){
			visited[w]=false;
		}
		for(int q=1;q< v;q++){
			if(visited[q]==false){
				depthft(q,visited);
				c=0;
				count=count+1;
				//System.out.println();
			}
			
		}
		System.out.println(count);
		
	}
	
}
 
public class graph {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int n=Reader.nextInt();
			int d=Reader.nextInt();
			int x,y;
			Graph1 g=new Graph1(n+1);
			for(int i=0;i<d;i++){
				x=Reader.nextInt();
				y=Reader.nextInt();
				g.addlink(x, y);
			}
			g.domains();
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