package mintr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
	public static int sum=0;
	public static int n;
	public static int getmin(int[] arr){
		int mini=0;
		for(int i=1;i<arr.length;i++)
			if(arr[i] < arr[mini])
				mini=i;
		return mini;
	}
	
	public static int getmax(int[] arr){
		int maxi=0;
		for(int i=1;i<arr.length;i++)
			if(arr[i] > arr[maxi])
				maxi=i;
		return maxi;
	}
	
	public static void mincashflow(int[][] graph){
		int[] amount=new int[n];
		for(int p=0;p<n;p++)
			for(int i=0;i<n;i++)
				amount[p]+=graph[i][p]-graph[p][i];
		mincashflowrec(amount);
	}
	
	public static void mincashflowrec(int[] amount){
		int mxCredit = getmax(amount);
		int mxDebit = getmin(amount);
		 
	    if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
	        return;
	 
	   
	    int min = Math.min(-amount[mxDebit], amount[mxCredit]);
	    amount[mxCredit] -= min;
	    amount[mxDebit] += min;
	 
	    sum+=1;
	   
	    mincashflowrec(amount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			n=Reader.nextInt();
			int m=Reader.nextInt();
			int[][] graph=new int[n][n];
			for(int i=0;i<m;i++){
				int xi=Reader.nextInt();
				int yi=Reader.nextInt();
				int ci=Reader.nextInt();
				xi-=1;
				yi-=1;
				graph[xi][yi]=ci;
			}
			mincashflow(graph);
			System.out.println(sum);
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
