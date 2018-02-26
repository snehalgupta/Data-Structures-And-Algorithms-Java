package ipc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
 
 
class Node{
	int d;
	int t;
	int s;
	public Node(int d1,int t1,int s1){
		d=d1;
		t=t1;
		s=s1;
	}
}
 
class heap{
	Node[] harr;
	int capacity;
	int heap_size;
	
	public heap(int n){
		heap_size=0;
		capacity=n;
		harr=new Node[n];
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i +2;
	}
	
	public void insert(Node k){
		Node temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && harr[parent(i)].s < harr[i].s){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	
	public Node extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		Node root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		Node temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && harr[l].s > harr[i].s){
			smallest=l;
		}
		if( r < heap_size && harr[r].s > harr[smallest].s){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
}
 
class Segnode{
	int val;
	int index;
	
	public Segnode(int v,int i){
		val=v;
		index=i;
	}
}
public class IPC {
	
	 static Segnode[] tree;
	 static int[] al;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int t=Reader.nextInt();
			for(int i=0;i<t;i++){
				int n=Reader.nextInt();
				int d=Reader.nextInt();
				heap h=new heap(n);
				long sum=0;
				for(int j=0;j<n;j++){
					int di=Reader.nextInt();
					int ti=Reader.nextInt();
					int si=Reader.nextInt();
					sum+=ti*si;
					Node nptr=new Node(di,ti,si);
					h.insert(nptr);
				}
				//System.out.println("sum"+sum);
				al=new int[d];
				//build(1,0,d);
				int x = (int) (Math.ceil(Math.log(d) / Math.log(2)));
		       int max_size = 2 * (int) Math.pow(2, x) - 1;
		        tree = new Segnode[max_size]; 
		        /*for(int i5=0;i5<max_size;i5++)
		        	tree[i5]=new Segnode(Integer.MAX_VALUE,1000);*/
		        for(int u=0;u<d;u++)
		        	al[u]=u;
				build(1,0,d-1);
				int flag=0;
				int count=0;
				while(flag == 0){
					Node temp=h.extractmin();
					int yw=d-temp.d+1;
					if(temp.t > yw)
						temp.t=yw;
					for(int gh=0;gh<temp.t;gh++){
						Segnode tr=minquery(1,0,d-1,temp.d-1,d-1);
						if(tr.val != Integer.MAX_VALUE){
							//System.out.println(tr.index);
							update(1,0,d-1,tr.index,Integer.MAX_VALUE);
							sum-=temp.s;
							count++;
						}
						else{
							break;
						}	
					}
					if(count == d || h.heap_size == 0)
						flag=1;
				}
				System.out.println(sum);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 
	 
	 public static void build(int node,int l,int r){
		 if(l==r){
			tree[node]=new Segnode(al[l],l);
			 //tree[node].val=al[l];
			 //tree[node].index=l;
		 }
		 else{
			 int mid=(l+r)>>1;
	         build(2*node,l,mid);
	         build(2*node+1,mid+1,r);
	         Segnode tem;
	        
	          tem=tree[2*node].val < tree[2*node+1].val ? tree[2*node]:tree[2*node+1];
	          tree[node]=new Segnode(tem.val,tem.index);
	         //tree[node].val=tem.val;
	         //tree[node].index=tem.index;
		 }
	 }
	 
	 public static void update(int node,int l,int r,int index,int val){
		 if(l==r){
			 al[index]=val;
			 tree[node].val=val;
			 tree[node].index=index;
		 }
		 else{
			 int mid=(l+r)>>1;
	         if(l<=index && index<=mid){
	        	 update(2*node,l,mid,index,val);
	         }
	         else{
	        	 update(2*node+1,mid+1,r,index,val);
	         }
	         Segnode tem;
	         
	        
	          tem=tree[2*node].val < tree[2*node+1].val ? tree[2*node]:tree[2*node+1];
	         tree[node].val=tem.val;
	         tree[node].index=tem.index;
		 }
	 }
	 
	 public static Segnode minquery(int node,int l,int r,int ql,int qr){
		 if(qr<l || r<ql){
			 //System.out.print(qr+" "+l+" "+r+" "+ql);
			 Segnode tu=new Segnode(Integer.MAX_VALUE,-1);
			 return tu;}
		 if(ql <= l && r<=qr)
			 return tree[node];
		 int mid=(l+r)>>1;
		 Segnode a1=minquery(2*node,l,mid,ql,qr);
		 Segnode a2=minquery(2*node+1,mid+1,r,ql,qr);
		
		return a1.val < a2.val ? a1:a2;
		 
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