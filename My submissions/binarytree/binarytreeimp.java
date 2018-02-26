package binarytree;

import java.util.Scanner;
import java.util.*;

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
	public void setdata(int d){
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
	
	public binarytree(){
		root = null;
	}
	
	public boolean isempty(){
		return root == null ;
	}
	
	public void insert(int data){
		root = insert(root,data);
	}
	private Node insert(Node node,int data){
		if(node == null){
			node = new Node(data);
		}
		else{
			if(node.getright() == null)
				node.right = insert(node.right,data);
			else
				node.left=insert(node.left,data);
		}
		return node;
	}
	
	public int countnodes(){
		return countnodes(root);
	}
	private int countnodes(Node r){
		if(r == null){
			return 0;
		}
		else{
			return 1+countnodes(r.left)+countnodes(r.right);
		}
	}
	
	public int height(){
		return height(root);
	}
	private int height(Node r){
		if(r == null){
			return 0;
		}
		else{
			return (1 + Math.max( height(r.left),height(r.right) ) );
		}
	}
	
	public boolean search(int val){
		return search(root,val);
	}
	private boolean search(Node r,int val){
		if(r.getdata()==val)
			return true;
		if(r.getleft()!= null)
			if(search(r.getleft(),val)){
				return true;
			}
		if(r.getright() != null)
			if(search(r.getright(),val)){
				return true;
			}
		return false;
	}
	
	public void inorder(){
		inorder(root);
	}
	private void inorder(Node r){
		if(r!=null){
		inorder(r.getleft());
		r.setdata(r.getdata()+5);
		System.out.print(r.getdata()+" ");
		inorder(r.getright());
		}
	}
	
	public void preorder(){
		preorder(root);
	}
	private void preorder(Node r){
		if(r != null){
			System.out.print(r.getdata());
			preorder(r.getleft());
			preorder(r.getright());
		}
	}
	
	public void postorder(){
		postorder(root);
	}
	private void postorder(Node r){
		if(r != null){
			postorder(r.getleft());
			postorder(r.getright());
			System.out.print(r.getdata());
		}
	}
	
	public Node copy(){
		return copy(root);
	}
	private Node copy(Node r){
		if(root == null)
			return null;
		Node copy = new Node(r.getdata());
		copy.setleft(r.getleft());
		copy.setright(r.getright());
		return copy;
	}
	
	public int rightmost(){
		return rightmost(root);
	}
	private int rightmost(Node r){
		if(r == null){
			return 0;
		}
		while(r.getright() != null){
			r = r.getright();
		}
		return r.getdata();
		
	}
	
	public int deepestnode(){
		return deepestnode(root);
	}
	private int deepestnode(Node r){
		Queue<Node> q=new LinkedList<>();
		q.add(r);
		Node t = null;
		while(q.isEmpty() ==false){
			t = q.remove();
			if(t.getleft() != null)
				q.add(t.getleft());
			if(t.getright() != null)
				q.add(t.getright());
		}
		System.out.println(t.getdata());
		return t.getdata();
	}
	
	public void deepest(){
		int h=height(root);
		finddeepest(root,h,0);
	}
	private void finddeepest(Node root,int h,int depth){
		if(root == null)
			return;
		if( root.getleft() == null && root.getright() == null){
			if(depth+1 == h)
				System.out.println(root.data);
		}
		finddeepest(root.getleft(),h,depth+1);
		finddeepest(root.getright(),h,depth+1);
	}
	
	/*static void reverseTree(final TreeNode root) {
	    if (root == null) {
	        return;
	    }

	    final TreeNode temp = root.right;
	    root.right = root.left;
	    root.left = temp;

	    reverseTree(root.left);

	    reverseTree(root.right);
	}*/
}

public class binarytreeimp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		binarytree bt = new binarytree();
		char ch='y';
		do{
			int choice = sc.nextInt();
			switch(choice){
			case 1: 
				bt.insert(sc.nextInt());
				break;
			case 2:
				System.out.println(bt.search(sc.nextInt()));
				break;
			case 3:
				System.out.println(bt.countnodes());
				break;
			case 4:
				System.out.println(bt.height());
				break;
			case 5:
				System.out.println(bt.copy().getdata());
				break;
			case 6:
				System.out.print(bt.rightmost());
				break;
			default:
				bt.inorder();
				bt.preorder();
				bt.postorder();
				
			
			
			}
			ch = sc.next().charAt(0);
		}while(ch == 'y');
			sc.close();
	}

}
