package multiply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static int B;
	public static int x;
	public static int y;
	public static int z;
	public static int ux;
	public static int uy;
	public static int aux=(int)Math.pow(10,5)-2;
	public static int aux0=(int)Math.pow(10,5)-1;
	public static ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
		B=Reader.nextInt();
		x=B;
		y=B+2;
		z=B+4;
		ux=B+8;
		uy=ux+B*B-1;
		prog();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void instr(int a,int b,int c){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(a);
		arr.add(b);
		arr.add(c);
		l.add(arr);
	}
	public static void non_zero(int a,int c){
		instr(a,0,c);
	}
	public static void copy(int a,int c){
		instr(0,a,c);
	}
	public static void incr(int a,int c){
		instr(1,a,c);
	}
	public static void decr(int a,int c){
		incr(a,c);
		if (B == 3)
			instr(2,c,c);
		else{
			incr(c,c);
			instr(c,B-3,c);
		}
	}
	public static void both(int a,int b,int c){
		instr(a,b,c);
		decr(c,c);
	}
	public static void ret(int x,int i,int c){
		instr(2,x,aux0);
		both(i,aux0,c);
	}
	public static void add(int x,int i,int c){
		instr(i,x,c);
	}
	public static void gen(){
		for(int i=0;i<B-1;i++){
			non_zero(x+1,ux+i);
			decr(x+1,x+1);
		}
		for(int i=0;i<B-1;i++){
			for(int j=0;j<B;j++){
				non_zero(x,ux+B-1+B*i+j);
			}
			decr(x,x);
		}
		for(int i=0;i<B-1;i++){
			non_zero(y+1,uy+i);
			decr(y+1,y+1);
		}
		for(int i=0;i<B-1;i++){
			for(int j=0;j<B;j++){
				non_zero(y,uy+B-1+B*i+j);
			}
			decr(y,y);
		}
		for(int i=0;i<B*B-1;i++){
			for(int j=0;j<B*B-1;j++){
				both(ux+i,uy+j,aux);
				for(int k=3;k>-1;k--){
					add(z+k,aux,z+k);
					ret(z+k,aux,aux);
				}
			}
		}
	}
	public static void prog(){
		if( B==3){
			System.out.println("0 1 2");
			System.out.println("1 2 0");
			System.out.println("1 0 0");
		}
		else if(B == 5){
			System.out.println("0 1 2 3 4");
			System.out.println("1 2 3 4 0");
			System.out.println("1 0 0 0 0");
			System.out.println("1 0 0 0 0");
			System.out.println("1 0 1 0 0");
		}
		else{
			System.out.println("0 1 2 3 4 5 6");
			System.out.println("1 2 3 4 5 6 0");
			System.out.println("1 0 0 0 0 0 0");
			System.out.println("1 0 0 0 0 0 0");
			System.out.println("1 0 0 0 1 0 0");
			System.out.println("1 0 0 0 2 0 0");
			System.out.println("1 0 0 0 3 0 0");
		}
		gen();
		System.out.println(l.size());
		for(int i=0;i<l.size();i++){
			System.out.println(l.get(i).get(0)+" "+l.get(i).get(1)+" "+l.get(i).get(2));
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