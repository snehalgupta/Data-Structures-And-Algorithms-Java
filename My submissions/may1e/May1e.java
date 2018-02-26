package may1e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class node{
	node[] children;
	int freq;
	boolean isleaf;
	int flag;
	public static int f=0;
	public static int s=0;
	public static int e=0;
	
	public node(int f){
		freq=1;
		isleaf=false;
		children=new node[26];
		for(int i=0;i<26;i++){
			children[i]=null;
		}
		flag=f;
	}
	
	public int chartoindex(char c){
		return ((int)c - (int)'a');
	}
	
	public void insert(String key,int a){
		int len=key.length();
		node p = this;
		for(int j=0;j<len;j++){
			int index=chartoindex(key.charAt(j));
			if(p.children[index] == null)
				p.children[index]=new node(a);
			else{
				if(a == 0 || (a == 1 && p.children[index] .flag == 0) )
				p.children[index].freq++;
				if(p.children[index].flag != 1)
					p.children[index].flag=a;
			}
			p=p.children[index];
		}
		if(a!=0)
		p.isleaf=true;
	}
	
	public void result(char[] prefix,int ind,int flag,char[] ans){
		
		if(this == null || (this.isleaf == true && freq != 1 )){
			//System.out.println("-1");
			s=1;
			return;
		}
		if(this.freq == 1){
			//prefix[ind]=' ';
			if(this.flag == 1){
					f++;
				for(int j=0;j<ind;j++){
					//System.out.print(prefix[j]);
					ans[e]=prefix[j];
					e++;
				}
				ans[e]='\n';
				e++;
				//System.out.println();
				
			}
			return;	
		}
		for(int b=0;b<26;b++){
			
			if(this.children[b] != null ){
				prefix[ind]=(char)(b+(int)'a');
				this.children[b].result(prefix,ind+1,flag,ans);
			}
		}
		if(ind == 0)
		{ if(s == 1){
			System.out.println("-1");
		}
		else{
			System.out.println(f);
			for(int k=0;k<e;k++){
				System.out.print(ans[k]);
			}
			System.out.println();
		}
		}
	}
	
}

public class May1e {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Reader.init(System.in);
			int n=Reader.nextInt();
			String[] x=new String[n];
			int[] y=new int[n];
			node root=new node(0);
			root.freq=0;
			for(int i=0;i<n;i++){
				String s=Reader.next();
				String s1=Reader.next();
				if(s.equals("-")){
					y[i]=1;
					}
				else
					y[i]=0;
				x[i]=s1;
				root.insert(x[i], y[i]);
			}
			char[] prefix=new char[200000];
			char[] ans=new char[200000];
			//System.out.println(count);
			root.result( prefix,0,0,ans);
			
			
		}catch (IOException e) {
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