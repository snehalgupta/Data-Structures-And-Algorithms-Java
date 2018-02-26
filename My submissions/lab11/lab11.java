package lab11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class heap{
	edge[] harr;
	int heap_size;
	
	public heap(edge[] n){
		heap_size=n.length;
		harr=new edge[n.length];
		harr=n;
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
	
	public edge extractmin(){
		if(heap_size <= 0){
			return null;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		edge root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.minheapify(0);
		return root;
	}
	
	public void minheapify(int i){
		edge temp=new edge();
		int smallest=i;
		int l=left(i);
		int r=right(i);
		if(l < heap_size && harr[l] != null && harr[smallest] != null && harr[l].weight < harr[smallest].weight)
			smallest=l;
		if(r < heap_size && harr[r] != null && harr[smallest] != null && harr[r].weight < harr[smallest].weight)
			smallest=r;
		if(smallest != i){
			temp=harr[smallest];
			harr[smallest]=harr[i];
			harr[i]=temp;
			minheapify(smallest);
		}
	}
	
	public edge[] heapsort(){
		edge e;int p=0;
		edge[] ans=new edge[heap_size];
		for(int i=heap_size/2 - 1;i >=0;i--){
			minheapify(i);
		}
		//System.out.println("heapsize: "+heap_size);
		while(heap_size != 0){
			e=extractmin();
			if(e != null)
			{ans[p]=new edge();
			ans[p]=e;
			p++;
			//System.out.print(e.weight+" ");}
		}
		//System.out.println();
	}
		return ans;
}
}
class edge{
	int v1;
	int v2;
	int weight;
}

class subset{
	int parent;
	int rank;
}

class graph{
	int v,e;
	edge arr[];
	
	graph(int v1,int e1){
		v=v1;
		e=e1;
		arr=new edge[e];
		for(int i=0;i<e;i++){
			arr[i]=new edge();
		}
	}
	
	public int findparent(subset[] s,int x ){
		if(s[x].parent != x){
			s[x].parent=findparent(s,s[x].parent);
		}
		return s[x].parent;
	}
	
	public void union(subset[] s,int a,int b){
		int x=findparent(s,a);
		int y=findparent(s,b);
		if(s[x].rank < s[y].rank){
			s[x].parent=y;
		}
		else if(s[x].rank > s[y].rank){
			s[y].parent=x;
		}
		else{
			s[y].parent=x;
			s[x].rank++;
		}
	}
	
	public edge[] kmst(){
		edge[] mst=new edge[v];
		int x=0,q=0,sum1=0;
		/*for(int y=0;y<v-1;y++){
			mst[y] = new edge();
		}*/
		heap h=new heap(arr);
		arr=h.heapsort();
		subset[] s=new subset[v+1];
		/*for(int k=0;k<v+1;k++){
			s[k]=new subset();
		}*/
		for(int z=0;z<v+1;z++){
			s[z]=new subset();
			s[z].parent=z;
			s[z].rank=0;
		}
		while( x<v-1 && arr[q]!=null){
			edge n=new edge();
			n=arr[q];
			int a=findparent(s,n.v1);
			int b=findparent(s,n.v2);
			if(a != b){
				mst[x]=new edge();
				mst[x]=n;
				sum1=sum1+mst[x].weight;
				union(s,a,b);
				x++;
			}
			q++;
		}
		/*edge[] ans1=new edge[x+1];
		for(int a=0;a<x;a++){
			if(mst[a].v1 != 0 && mst[a].v2 !=0)
			{ans1[a]=mst[a];
			sum1=sum1+ans1[a].weight;}
			else{
				System.out.println("ki");
			}
		}*/
		mst[v-1]=new edge();
		mst[v-1].weight=sum1;
		return mst;
	}
}
	


public class lab11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{int sum1=0;
			int V=Reader.nextInt();
			int E=Reader.nextInt();
			graph g=new graph(V,E);
			for(int i=0;i <E;i++){
				g.arr[i].v1 = Reader.nextInt();
				g.arr[i].v2 = Reader.nextInt();
				g.arr[i].weight = Reader.nextInt();
			}
			edge[] ans=new edge[E];
			ans=g.kmst();
			sum1=ans[ans.length-1].weight;
			/*for(int j=0;j<ans.length;j++){
				sum1=sum1+ans[j].weight;
			}*/
			/*for(int e=0;e < E;e++){
				System.out.println(ans[e].v1+" "+ans[e].v2);
			}*/
			//int p=0;
			/*edge[] ans1=new edge[ans.length];
			for(int y=0;y<ans.length;y++){
				if(ans[y].v1 != 0 && ans[y].v2 != 0){
					ans1[p]=ans[y];
					p++;
				}
			}*/
			heap h1=new heap(ans);
			ans=h1.heapsort();
			int ru=1;
			if(ans.length-1 == E){
				for(int a=0;a<ans.length-1;a++){
					if(ans[a].v1 == g.arr[a].v1 && ans[a].v2 == g.arr[a].v2){
						ru=0;
					}
					else{
						ru=1;
						break;
					}
				}
			}
			if(ru==0){
				System.out.println("-1");
			}
			else{
			int second=Integer.MAX_VALUE;
			int flag2=0;
			for(int q=0;q<ans.length-1;q++){
				int flag=0;
				int s=0;
				edge[] t=new edge[E];
				for(int a=0;a<g.arr.length;a++){
					if(g.arr[a].weight != ans[q].weight){
						t[s]=g.arr[a];
						//System.out.println(t[s].v1+" "+t[s].v2);
						s++;
					}
				}
				if(s < V-1){
					flag=1;
				}
				if(flag == 0){
					flag2=1;
				graph g1=new graph(V,E-1);
				g1.arr=t;
				edge[] c=new edge[E-1];
				c=g1.kmst();
				int qw=c[c.length-1].weight;
				
				/*for(int r=0;r<c.length;r++){
					qw=qw+c[r].weight;
				}*/
				//System.out.println("qw :"+qw);
				//System.out.println();
				if(qw < second && qw > sum1){
					second=qw;
				}
				
				}
			}
			if(flag2 == 0){
				System.out.println("-1");
			}
			else{
				System.out.println(second);
			}
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