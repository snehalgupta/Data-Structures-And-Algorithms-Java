package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class maxint{
	int max;
	public maxint(){
		max=0;
	}
}
class Node{
	Node left,right;
	int data;
	
	public Node(){
		left = null;
		right = null;
		data = 0;
	}
	public Node(int n){
		left=null;
		right=null;
		data=n;
	}
	public void setleft(Node y){
		left=y;
	}
	public void setright(Node y){
		right=y;
	}
	public void data(int d){
		data=d;
	}
	public Node getleft(){
		return left;
	}
	public Node getright(){
		return right;
	}
	public int getdata(){
		return data;
	}
}

class binarytree{
	
	Node root;
	maxint m;
	
	public binarytree(){
		root = null;
		m=new maxint();
	}
	
	public void insert(int value){
		root = insert(root,value);
	}
	private Node insert(Node r,int val){
		if(r == null){
			r=new Node(val);
		}
		else{
			if(val < r.getdata())
				r.setleft(insert(r.getleft(),val));
			else
				r.setright(insert(r.getright(),val));
		}
		return r;
	}
	
	private Node smallest(Node root){
		if(root.getleft() == null){
			return root;
		}
		else
			return smallest(root.getleft());
	}
	
	public Node search(int val){
		return search(root,val);
	}
	private Node search(Node r,int val){
		Node current = r;
		while( current != null){
			if(current.getdata() == val){
				return current;
			}
			else if(current.getdata() > val){
				return search(current.getleft(),val);
			}
			else{
				return search(current.getright(),val);
			}
		}
		return null;
	}
	
	public void delete(int value){
		root = delete(root,value);
	}
	private Node delete(Node r,int value){
		if(r == null){
			return null;}
		if(r.getdata() > value)
			{
			r.setleft(delete(r.getleft(),value));}
		else if(r.getdata() < value)
			{
			r.setright(delete(r.getright(),value));}
		else{
		 if(r.getleft() != null && r.getright() != null){
			
			Node temp=r;
			Node minr=smallest(temp.getright());
			r.data=minr.getdata();
			/*if(minr.getleft()==null && minr.getright()==null && (minr==temp.getright())){
				temp.setright(null);
			}
			else delete(r.getright(),minr.getdata());*/
			r.setright(delete(r.getright(), minr.getdata()));
		}
		else if(r.getleft() != null ){
			
			r=r.getleft();
		}
		else if(r.getright() != null){
			
			r=r.getright();
		}
		else{
			
			r=null;
		}}
		return r;
	}
	
	public void display(Node root){
		if(root != null){
			display(root.getleft());
			System.out.println(root.getdata()+" ");
			display(root.getright());
		}
	}
	
	public void rightview(){
		rightview(root);
	}
	private void rightview(Node r){
		m.max=0;
		rightview(r,1,m);
	}
	private void rightview(Node r,int level,maxint max){
		Node temp=r;
		
		if(temp == null){
			return;
		}
		else if(max.max < level){
			System.out.print(temp.data + " ");
			max.max=level;
		}
		
		rightview(temp.getright(),level+1,max);
		rightview(temp.getleft(),level+1,max);
	}
	
}
public class Binarysearchtree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int n=Reader.nextInt();
			int q=Reader.nextInt();
			int r,q1;
			binarytree b1=new binarytree();
			for(int i=0;i<n;i++){
				r=Reader.nextInt();
				b1.insert(r);
			}
			for(int j=0;j<q;j++){
				q1=Reader.nextInt();
				if(q1 == 1){
					int e=Reader.nextInt();
					b1.delete(e);
					//b1.display(b1.root);
				}
				else if(q1 == 2 ){
					b1.rightview();
					System.out.println();
				}
			}
		}catch (IOException e) {
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
