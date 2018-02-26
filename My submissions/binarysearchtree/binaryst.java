package binarysearchtree;


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
	
	public binarytree(){
		root = null;
	}
	
	public boolean search(int val){
		return search(root,val);
	}
	private boolean search(Node r,int val){
		Node current = r;
		while( current != null){
			if(current.getdata() == val){
				return true;
			}
			else if(current.getdata() > val){
				return search(current.getleft(),val);
			}
			else{
				return search(current.getright(),val);
			}
		}
		return false;
	}
	
	public int smallest(){
		return smallest(root);
	}
	private int smallest(Node root){
		if(root.getleft() == null){
			return root.getdata();
		}
		else
			return smallest(root.getleft());
	}
	
	public Node insert(int value){
		return insert(root,value);
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
	
	public boolean bst(int min,int max){
		return bst(root,min,max);
	}
	private boolean bst(Node r,int min,int max){
		if(r == null){
			return true;
		}
		return( (r.getdata() > min) && (r.getdata() < max) && (bst(r.getleft(),min,r.getdata())) && bst(r.getright(),r.getdata(),max));
	}
	
	public Node findmaxi(){
		return findmaxi(root);
	}
	private Node findmaxi(Node r){
		if(r == null)
			return null;
		while(r.getright() != null){
			r=r.getright();
		}
		return r;
	}
	
	public Node findmaxr(){
		return findmaxr(root);
	}
	private Node findmaxr(Node r){
		if(r == null)
			return null;
		if(r.getright() == null){
			return r;
		}
		return findmaxr(r.getright());
	}
	
	public int noofleaves(){
		return noofleaves(root);
	}
	private int noofleaves(Node r){
		if(r == null)
			return 0;
		if(r.getleft() == null && r.getright() == null){
			return 1;
		}
		return noofleaves(r.getleft()) + noofleaves(r.getright());
	}
	
	public int sumofnodes(){
		return sumofnodes(root);
	}
	private int sumofnodes(Node r){
		if(r == null)
			return 0;
		if(r.getleft() == null && r.getright() == null)
			return r.getdata();
		return r.getdata() + sumofnodes(r.getleft()) + sumofnodes(r.getright());
	}
	
	public int noofsinglechild(){
		return noofsinglechild(root);
	}
	private int noofsinglechild(Node r){
		if(r == null)
			return 0;
		else if(r.getleft() == null && r.getright() != null){
			return 1 + noofsinglechild(r.getright());
		}
		else if(r.getright() == null && r.getleft()!=null){
			return 1 + noofsinglechild(r.getleft());
		}
		else{
			return noofsinglechild(r.getleft()) + noofsinglechild(r.getright());
		}
	}
	
	public int nooftwochild(){
		return nooftwochild(root);
	}
	private int nooftwochild(Node r){
		if(r == null)
			return 0;
		else if(r.getleft() == null && r.getright() == null){
			return 0;
		}
		else if(r.getleft() != null && r.getright() != null){
			return 1 + nooftwochild(r.getleft()) + nooftwochild(r.getright());
		}
		else if(r.getleft() == null && r.getright() != null){
			return nooftwochild(r.getright());
		}
		else{
			return nooftwochild(r.getleft());
		}
	}
	
	public boolean identicaltrees(Node r1,Node r2){
		if(r1 == null && r2 == null)
			return true;
		if( r1 != null && r2 != null)
			return (r1.getdata() == r2.getdata() && identicaltrees(r1.getleft(),r2.getright()) && identicaltrees(r1.getright(),r2.getright()));
		return false;
	}
}
public class binaryst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
