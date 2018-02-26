package twocoins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
 
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
 
class Node1{
	int src;
	int des;
	
	public Node1(int s,int d){
		src=s;
		des=d;
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
	int[] level;
	int[] in;
	int[] out;
	int[] discover;
	HashMap<Integer,ArrayList<Integer>> map;
	
	
	public Graph1(int v1){
		v=v1;
		adj=new linkedlist[v1+1];
		c=0;
		map=new HashMap<Integer,ArrayList<Integer>>();
		level=new int[v1+1];
		in=new int[v1+1];
		out=new int[v1+1];
		discover=new int[v1+1];
		for(int j=0;j<v1+1;j++){
			adj[j]=new linkedlist();
			map.put(j,new ArrayList<Integer>());
			map.get(j).add(1);
		}
	}
	
	public void addlink(int a,int b){
		adj[a].insertAtEnd(b);
		adj[b].insertAtEnd(a);
	}
	
	public void depthft(int vd,boolean visited[],int lev){
		visited[vd]=true;
		level[vd]=lev;
		in[vd]=++c;
		discover[c]=vd;
		Node temp=adj[vd].start;
		while(temp != null){
			if(!visited[temp.getData()])
				depthft(temp.getData(),visited,lev+1);
			temp=temp.getLink();
		}
		out[vd]=c;
	}
	
	public void depth(int v1){
		boolean[] visited=new boolean[v+1];
		depthft(v1,visited,0);
	}
	
	public void func(Node1 node){
		if(level[node.src] > level[node.des]){
			int i1=in[node.src];
			int i2=out[node.src];
			for(int k=i1;k<=i2;k++){
				map.get(discover[k]).add(node.src);
			}
		}
		else if(level[node.des] > level[node.src]){
			int i1=in[node.des];
			int i2=out[node.des];
			for(int k=i1;k<=i2;k++){
				map.get(discover[k]).add(node.des);
			}
		}
	}
	
	public void coins(){
		HashSet<Integer> hs=new HashSet<Integer>();
		for(int i=v;i>=1;i--){
			Node temp=adj[discover[i]].start;
			int flag=0;
			int cou=0;
			while(temp != null){
				if(hs.contains(temp.data)){
					cou=cou+1;
				}
				if(cou == 2){
					flag=1;
					break;
				}
				temp=temp.link;
			}
			if(flag == 0){
				hs.add(discover[i]);
				ArrayList<Integer> ar=map.get(discover[i]);
				if(ar.size() >= 3){
					hs.add(ar.get(ar.size()-3));
				}
				else if(ar.size() == 2){
					hs.add(ar.get(ar.size()-2));
				}
			}
		}
		System.out.println(hs.size());
	}
	
	
}
public class Depth {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int t=Reader.nextInt();
			for(int i=0;i<t;i++){
				int n=Reader.nextInt();
				Graph1 g1=new Graph1(n);
				Node1[] edge=new Node1[n-1];
				for(int j=0;j<n-1;j++){
					int u=Reader.nextInt();
					int v=Reader.nextInt();
					g1.addlink(u, v);
					edge[j]=new Node1(u,v);
				}
				g1.depth(1);
				/*for(int r=0;r<n+1;r++){
					System.out.print(g1.discover[r]);
				}
				System.out.println();
				for(int r=0;r<n+1;r++){
					System.out.print(g1.in[r]);
				}
				System.out.println();
				for(int r=0;r<n+1;r++){
					System.out.print(g1.out[r]);
				}*/
				for(int v9=0;v9<n-1;v9++){
					g1.func(edge[v9]);
				}
				if(n ==1)
					System.out.println("-1");
				/*for(int u1=0;u1<n+1;u1++){
					ArrayList<Integer> arr1=g1.map.get(u1);
					for(int v1=0;v1<arr1.size();v1++){
						System.out.print(arr1.get(v1)+" ");
						}
					System.out.println();
					}*/
				else{
				g1.coins();}
					
					
					
					
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static int binarysearch(List<Integer> arr,int x){
	        int l=0;
	       int r=arr.size()-1;
	        if(arr.get(r) <= x)
	            return arr.size();
	        while (l < r){
	            int m=(l+r)>>1;
	            if (arr.get(m)<=x)
	                l=m+1;
	            else{
	                r=m;}}
	        return r; }  
 
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
