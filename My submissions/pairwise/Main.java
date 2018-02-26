package pairwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Reader.init(System.in);    
		    try{
		    	int t=Reader.nextInt();
		    	for(int i=0;i<t;i++){
		    		int count=0;
		    		ArrayList<HashSet<Integer>> arr = new ArrayList<HashSet<Integer>>();
		    		int n=Reader.nextInt();
		    		int k=Reader.nextInt();
		    		for(int j=0;j<n;j++){
		    			HashSet<Integer> set=new HashSet<Integer>();
		    			int x=Reader.nextInt();
		    			for(int c=0;c<x;c++){
		    				set.add(Reader.nextInt());
		    			}
		    			arr.add(set);
		    		}
		    		for(int j=0;j<arr.size();j++){
		    			for(int k1=j+1;k1<arr.size();k1++){
		    				int flag=0;
		    				if(arr.get(j).size()+arr.get(k1).size() < k){
		    					continue;
		    				}
		    				else if(arr.get(j).size()+arr.get(k1).size() == k){
		    					flag=0;
		    					if(arr.get(j).size() < arr.get(k1).size()){
		    						for(int hj:arr.get(j)){
		    							if(arr.get(k1).contains(hj)==false){
		    								flag=1;
		    								break;
		    							}
		    						}
		    						if(flag==0){
		    							count=count+1;
		    						}
		    					}
		    					else{
		    						for(int hj:arr.get(k1)){
		    							if(arr.get(j).contains(hj)==false){
		    								flag=1;
		    								break;
		    							}
		    						}
		    						if(flag==0){
		    							count=count+1;
		    						}
		    					}
		    				}
		    				else{
		    					flag=0;
		    				for(int k2=1;k2<=k;k2++){
		    					if(arr.get(j).contains(k2) == false && arr.get(k1).contains(k2)==false){
		    						flag=1;
		    						break;
		    					}
		    				}
		    				if(flag == 0){
		    					count=count+1;
		    				}
		    			}
		    			}
		    		}
		    		
		    		System.out.println(count);
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