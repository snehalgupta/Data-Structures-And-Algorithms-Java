package prob1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node
{
	int data;
	Node link;
	
	public Node(int d){
		data=d;
		link=null;
	}
	
	public void setlink(Node l){
		link=l;
	}
	
	public void setdata(int d){
		data=d;
	}
	
	public Node getlink(){
		return link;
	}
	
	public int getdata(){
		return data;
	}
}

class linkedlist
{
	protected Node start;
	protected Node end;
	public int size;
	
	public linkedlist(){
		start=null;
		end=null;
		size=0;
	}
	
	public void insertatend(int val){
		Node nptr=new Node(val);
		if(start == null){
			start=nptr;
			end=start;
		}
		else{
			end.setlink(nptr);
			end=nptr;
		}
		size++;
	}
	
	public int deletebeg(){
		int y=start.getdata();
		start=start.getlink();
		size--;
		return y;
	}
}

class Graph{
	int v;
	linkedlist[] adj;
	
	public Graph(int v1){
		v=v1;
		adj=new linkedlist[v1+1];
		for(int i=0;i<v1+1;i++){
			adj[i]=new linkedlist();
		}
	}
	
	public void addlink(int a,int b){
		adj[a].insertatend(b);
	}
	
	public boolean isreachable(int s,int d){
		boolean[] visited=new boolean[v+1];
		linkedlist queue=new linkedlist();
		visited[s]=true;
		queue.insertatend(s);
		while(queue.size != 0){
			s=queue.deletebeg();
			Node temp=adj[s].start;
			while(temp != null){
				if(temp.data == d){
					return true;
				}
				if(!visited[temp.data]){
					visited[temp.data]=true;
					queue.insertatend(temp.data);
				}
				temp=temp.getlink();
			}
		}
		return false;
	}
}
public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int V=Reader.nextInt();
			int E=Reader.nextInt();
			int v1=Reader.nextInt();
			int v2=Reader.nextInt();
			Graph G=new Graph(V);
			for(int i=0;i<E;i++){
				int a=Reader.nextInt();
				int b=Reader.nextInt();
				G.addlink(a, b);
			}
			boolean ans=G.isreachable(v1,v2);
			if(ans == true){
				System.out.println("1");
			}
			else{
				System.out.println("0");
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