package lab5;
import java.io.*;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;

class Node<T> implements Comparable<T>{
	Node<T> left,right;
	T data;
	int leftnodes,rightnodes;
	
	public Node(T d){
		left = null;
		right = null;
		data = d;
	}
	
	public int compareTo(T node){
		int ans=0;
		if(this.compareTo(node) < 0)
			ans= -1;
		else if(this.compareTo(node) > 0)
			ans=1;
		return ans;
	}

	public void setleft(Node<T> y){
		left=y;
	}
	public void setright(Node<T> y){
		right=y;
	}
	public void data(T d){
		data=d;
	}
	public Node<T> getleft(){
		return left;
	}
	public Node<T> getright(){
		return right;
	}
	public T getdata(){
		return data;
	}
}

class bst<T extends Comparable<T>>{
	
	Node<T> rq;
	Node<T> root;
	ArrayList<Node<T>> inor;
	T ans;
	
	
	public bst(T val){
		root = null;
		inor=new ArrayList<Node<T>>();
	}
	public void inorder(){
		inorder(root);
	}
	private void inorder(Node<T> r){
		if(r!=null){
		inorder(r.getleft());
		inor.add(r);
		inorder(r.getright());
		}
	}
	public Node<T> insert(T value){
		return insert(root,value);
	}
	private Node<T> insert(Node<T> r,T val){
		if(r == null){
			r=new Node<T>(val);
		}
		else{
			if(val.compareTo(r.getdata()) <= 0)
				r.setleft(insert(r.getleft(),val));
			else
				r.setright(insert(r.getright(),val));
		}
		return r;
	}
	
	public int numleftnodes(){
		if(root.left == null)
			return 0;
		int count=numnodes(root.left);
		return count;
		
	}
	private int numnodes(Node<T> r){
		if(r == null)
		return 0;
		int left=numnodes(r.left);
		int right=numnodes(r.right);
		return left+right+1;
	}
}
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int n=sc.nextInt();
		HashMap<Integer,ArrayList<String>> hash=new HashMap<Integer,ArrayList<String>>();
		for(int yy=0;yy<n;yy++){
			hash.put(yy+1,new ArrayList<String>());
		}
		createBSTFiles(n,x);
		ArrayList<bst<?>> bsw=new ArrayList<bst<?>>();
		PrintWriter w = new PrintWriter("./src/" + "answer" + ".txt", "UTF-8");
		for(int i=1;i<=x;i++){
			String s1=Integer.toString(i).concat(".txt");
			File file=new File("./input/"+s1);
			FileReader in=new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			String type=br.readLine();
			if(type.equals("String")){
				
				String n1=br.readLine();
				int n2=Integer.parseInt(n1);
				if(n2 != n)
					break;
				String[] values=br.readLine().split(" ");
				bst<String> strbst=new bst<String>(values[0]);
				for(int j=0;j<values.length;j++){
					//System.out.println(values[j]);
					strbst.root=strbst.insert(values[j]);
					//System.out.println("fg");
					if(strbst.ans == null)
						strbst.ans="";
				}
				Arrays.sort(values);
				for(int jl=0;jl<values.length;jl++){
					strbst.ans+=values[jl];
				}
				bsw.add(strbst);
			}
			else if(type.equals("Integer")){
				
				String n1=br.readLine();
				int n2=Integer.parseInt(n1);
				if(n2 != n)
					break;
				String[] values=br.readLine().split(" ");
				int edf=Integer.parseInt(values[0]);
				bst<Integer> intbst=new bst<Integer>(edf);
				for(int j=0;j<values.length;j++){
					int de=Integer.parseInt(values[j]);
					//System.out.println(de);
					intbst.root=intbst.insert(de);
					if(intbst.ans == null)
						intbst.ans=0;
					intbst.ans+=de;
				}
				bsw.add(intbst);
			}
			else if(type.equals("Float")){
				
				String n1=br.readLine();
				int n2=Integer.parseInt(n1);
				if(n2 != n)
					break;
				String[] values=br.readLine().split(" ");
				float rew=Float.parseFloat(values[0]);
				bst<Float> fbst=new bst<Float>(rew);
				for(int j=0;j<values.length;j++){
					float de=Float.parseFloat(values[j]);
					//System.out.println(de);
					fbst.root=fbst.insert(de);
					if(fbst.ans==null)
						fbst.ans=(float)0;
					fbst.ans+=de;
				}
				bsw.add(fbst);
			}
		}
		for(int k=0;k<bsw.size();k++){
			bst<?> cv=bsw.get(k);
			if(cv.root == null)
				continue;
			int zss=cv.numleftnodes()+1;
			String bvc=cv.ans.toString();
			//System.out.println(bvc);
			hash.get(zss).add(bvc);
			
		}
		int klo=0;
		for(int a=1;a<=n;a++){
			if(hash.get(a).size()>0){
			w.print(a+" ");
			for(int b=0;b<hash.get(a).size();b++){
				w.print(hash.get(a).get(b)+" ");
			}
			w.println();}
			else{
				klo+=1;
			}
		}
		w.println(klo);
		w.close();
		sc.close();
	}
	
	public static void createBSTFiles(int numStudents, int numTrees) {
		Random rand = new Random();
		for (int i = 1; i <= numTrees; i++) {
		    try {
				PrintWriter w = new PrintWriter("./src/" + i + ".txt", "UTF-8");
				int type = rand.nextInt(3) + 1;
				if(type == 1) {
					w.println("Integer");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) {
						w.print(rand.nextInt(1000));
						w.print(" ");
					}
				}
				else if(type == 2) {
					w.println("Float");
					w.println(numStudents);
					for (int j = 1; j <= numStudents; j++) {
						w.print(rand.nextFloat()*1000);
						w.print(" ");
					}
				}
				else {
					w.println("String");
					w.println(numStudents);
					String alphabet = "abcdefghijklmnopqrstuvwxyz";
					for (int j = 1; j <= numStudents; j++) {
						int len = rand.nextInt(10)+1;
						for (int k = 0; k < len; k++)
							w.print(alphabet.charAt(rand.nextInt(alphabet.length())));
						w.print(" ");
					}
				}
				w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
