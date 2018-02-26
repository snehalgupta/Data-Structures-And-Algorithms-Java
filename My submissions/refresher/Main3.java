package refresher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


class Triangle{
	int l1;
	int l2;
	int l3;
	public Triangle(){
		l1=0;
		l2=0;
		l3=0;
	}
	public Triangle(int y1,int y2,int y3){
		l1=y1;
		l2=y2;
		l3=y3;
	}
	public int getSide1(){
		return l1;
	}
	public void setSide1(int y1){
		l1=y1;
	}
	public int getSide2(){
		return l2;
	}
	public void setSide2(int y2){
		l2=y2;
	}
	public int getSide3(){
		return l3;
	}
	public void setSide3(int y3){
		l3=y3;
	}
	public void type(){
		if((l1*l1)+(l2*l2) ==(l3*l3) || (l3*l3)+(l2*l2) ==(l1*l1) || (l1*l1)+(l3*l3) ==(l2*l2)){
			System.out.println("Right angled triangle");
		}
		else if(l1 == l2 && l2 == l3){
			System.out.println("Equilateral Triangle");
		}
		else if(l1 != l2 && l2 != l3 && l3 != l1){
			System.out.println("Scalene Triangle");
		}
		else if((l1 == l2 && l2!= l3)|| l2 == l3 && l3!= l1 || l1 == l3 && l1!= l2 ){
			System.out.println("Isosceles Triangle");
		}
	}
}
public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int l1=Reader.nextInt();
			int l2=Reader.nextInt();
			int l3=Reader.nextInt();
			Triangle t=new Triangle(l1,l2,l3);
			t.type();
			t.setSide1(3);
			t.setSide2(5);
			t.setSide3(4);
			System.out.println(t.getSide1());
			System.out.println(t.getSide2());
			System.out.println(t.getSide3());
			t.type();
			
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