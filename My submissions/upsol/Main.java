package upsol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
public class Main{
 
	public static int MAXN = 1000000;
	public static int[] spf = new int[MAXN + 1];
	public static int[] arr;
	public static List<List<Integer>> factors = new ArrayList<>();
	public static List<List<Integer>> tree = new ArrayList<>();
 
	
	
	public static void build(int node, int start, int end){
		if(start == end){
			
			tree.get(node).addAll(factors.get(start));
		}else{
			int mid = (start + end)>>1;
			build(2*node, start, mid);
			build(2*node+1, mid+1, end);
			List<Integer> fact = new ArrayList<>(tree.get(2*node));
			fact.addAll(tree.get(2*node+1));
			Collections.sort(fact);
			tree.get(node).clear();
			tree.get(node).addAll(fact);
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

	public static int query(int node, int start, int end, int l, int r, int X, int Y){
		if(start > r || end < l || start > end){
			return 0;
		}
		if(l <= start && end <= r){
			return (binarysearch(tree.get(node),Y)-binarysearch(tree.get(node),X-1));
		}else{
			int mid = (start + end)>>1;
			int a = query(2*node, start, mid, l, r, X, Y);
			int b = query(2*node+1, mid+1, end, l, r, X, Y);
			return (a + b);
		}
	}
	
	public static void sieve() {
		spf[1] = 1;
		for (int i = 2; i <= MAXN; i++){
			spf[i] = i;
			tree.add(new ArrayList<Integer>());}
		for (int i = 4; i <= MAXN; i += 2)
			spf[i] = 2;
		for (int i = 3; i * i <= MAXN; i += 2) {
			if (spf[i] == i) {
				for (int j = i * i; j <= MAXN; j += i) {
					if (spf[j] == j)
						spf[j] = i;
				}
			}
		}
	}
 
	public static List<Integer> getFactors(int n) {
		List<Integer> factors = new ArrayList<>();
		while (n != 1) {
			factors.add(spf[n]);
			n /= spf[n];
		}
		return factors;
	}
 
	
 
	public static void main(String[] args) throws Exception {
		 Reader.init(System.in);    
		    try{
		    	int n=Reader.nextInt();
		    	
		    	arr = new int[n];
		    	sieve();
		    	for(int i=0;i<n;i++){
		    		
		    		int input=Reader.nextInt();
		    		arr[i]=input;
		    		factors.add(getFactors(arr[i]));
		    	}
		    	build(1,0,n-1);
		    	int q=Reader.nextInt();
		    	for(int j=0;j<q;j++){
		    		int l=Reader.nextInt();
		    		int r=Reader.nextInt();
		    		int x=Reader.nextInt();
		    		int y=Reader.nextInt();
		    		l=l-1;
		    		r=r-1;
		    		int a=query(1, 0, n-1, l, r, x, y);
		    		System.out.println(a);
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