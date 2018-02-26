package problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;



public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			String s1=Reader.next();
			String s2=Reader.next();
			if(s1.length() != s2.length()){
				System.out.println("FALSE");
			}
			else{
				HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
				HashMap<Character,Integer> hv=new HashMap<Character,Integer>();
				int flag=0;
				for(int i=0;i<s1.length();i++){
					if(hm.containsKey(s1.charAt(i))){
						int a=hm.get(s1.charAt(i));
						a=a+1;
						hm.remove(s1.charAt(i));
						hm.put(s1.charAt(i), a);
					}
					else{
						hm.put(s1.charAt(i),1);
					}
				
				
				if(hv.containsKey(s2.charAt(i))){
					int a=hv.get(s2.charAt(i));
					a=a+1;
					hv.remove(s2.charAt(i));
					hv.put(s2.charAt(i), a);
				}
				else{
					hv.put(s2.charAt(i),1);
				}
				}
				for(char j:hv.keySet()){
					if(hm.containsKey(j)){
						if(hm.get(j) != hv.get(j)){
							flag=1;
							break;
						}
					}
					else{
						flag=1;
						break;
					}
				}
				if(flag == 0){
					System.out.println("TRUE");
				}
				else{
					System.out.println("FALSE");
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
    
    static long nextLong() throws IOException{
    	return Long.parseLong(next());
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}