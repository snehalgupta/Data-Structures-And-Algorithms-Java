package segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class SegmentTree 
{
    public int st[]; 
 
    public SegmentTree(int arr[], int n)
    {
        
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
        int max_size = 2 * (int) Math.pow(2, x) - 1;
 
        st = new int[max_size]; 
 
        constructSTUtil(arr, 0, n - 1, 0);
    }
 
    
    public int getMid(int s, int e) {
        return s + (e - s) / 2;
    }
 
    public int getSumUtil(int ss, int se, int qs, int qe, int si)
    {
        
        if (qs <= ss && qe >= se)
            return st[si];
 
       
        if (se < qs || ss > qe)
            return 0;
 
       
        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }
 
   
    public void updateValueUtil(int ss, int se, int i, int diff, int si)
    {
        
        if (i < ss || i > se)
            return;
 
        st[si] = st[si] + diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
        }
    }
 
    
    public void updateValue(int arr[], int n, int i, int new_val)
    {
        
        
 
        int diff = new_val - arr[i];
 
        arr[i] = new_val;
 
        updateValueUtil(0, n - 1, i, diff, 0);
    }
 
    
    public int getSum(int n, int qs, int qe)
    {
        
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }
 

    public int constructSTUtil(int arr[], int ss, int se, int si)
    {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
                 constructSTUtil(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }
    
    public  int binarysearch(int arr,int x){
        int l=0;
        int r=arr-1;
        if(st[0] < x)
            return -1;
        while (l < r){
            int m=(l+r)>>1;
        	int res=getSum(arr,0,m);
            if (res<x)
                l=m+1;
            else{
                r=m;}}
        return r; }  
}
public class cp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int n=Reader.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				String s=Reader.next();
				int count=0;
				for(int u=0;u<s.length();u++){
					if(s.charAt(u) == '0'){
						count=count+1;
					}
				}
				arr[i]=count;
			}
			SegmentTree tree=new SegmentTree(arr,n);
			int q=Reader.nextInt();
			for(int j=0;j<q;j++){
				int er=Reader.nextInt();
				if(er == 1){
					int k=Reader.nextInt();
					int ans=tree.binarysearch(n, k);
					System.out.println(ans);
				}
				else if(er == 0){
					int I =Reader.nextInt();
					String V=Reader.next();
					int count1=0;
					for(int p=0;p<V.length();p++){
						if(V.charAt(p) == '0')
							count1=count1+1;
					}
					tree.updateValue(arr, n, I, count1);
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