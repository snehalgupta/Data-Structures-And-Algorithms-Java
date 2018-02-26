package prob2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	Node left,right,link;
	int data;
	
	public Node(int d){
		left=null;
		right=null;
		link=null;
		data=d;
	}
}

class Queue{
	protected Node start;
	protected Node end;
	public int size;
	
	public Queue(){
		start=null;
		end=null;
		size=0;
	}
	
	public void enqueue(Node nptr){
		
		if(start == null){
			start=nptr;
			end=start;
		}
		else{
			end.link=nptr;
			end=nptr;
		}
		size++;
	}
	
	public Node dequeue(){
		Node temp=start;
		start=start.link;
		size--;
		return temp;
	}
}

class binarytree{
	Node root;
	
	public binarytree(Node r){
		root=r;
	}
	
	public void preorder(){
		preorder(root);
	}
	private void preorder(Node r){
		if(r != null){
			System.out.print(r.data+" ");
			preorder(r.left);
			preorder(r.right);
		}
	}
}

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int N=Reader.nextInt();
			int[] data=new int[N];
			for(int i=0;i <N;i++){
				data[i]=Reader.nextInt();
			}
			int count=0;
			Queue q=new Queue();
			Node root=new Node(data[0]);
			q.enqueue(root);
			Node cur=null;
			for(int i=1;i<N;i++){
				Node node=new Node(data[i]);
				if(count ==0){
					cur=q.dequeue();
				}
				if(count ==0){
					count++;
					cur.left=node;
				}
				else{
					count=0;
					cur.right=node;
				}
				q.enqueue(node);
			}
			binarytree b=new binarytree(root);
			b.preorder();
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