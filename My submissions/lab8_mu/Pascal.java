package lab8_mu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.*;

class Pascal_1 extends RecursiveAction{
	int n;
	int k;
	long result;
	public Pascal_1(int n1,int n2){
		n=n1;
		k=n2;
	}
	public void compute(){
		if (n == 0 || k == 0 || n == k) {
		this.result = 1;
		return;
			}
			Pascal_1 left = new Pascal_1(n - 1, k - 1);
			Pascal_1 right = new Pascal_1(n - 1, k);
			left.fork();
			right.compute(); 
			left.join();
			this.result=left.result+right.result;
	}
	
}


public class Pascal extends RecursiveAction {
	private final int n;
	private final int k;
	long result;
	private	static volatile Map<String,Pascal> instances=new HashMap<String,Pascal>();	
	
	private Pascal(int n1,int n2){
		n=n1;
		k=n2;
		result=0;
	}
	public static synchronized Pascal getInstance(int x,int y)		
	{	
		String	key	=x+","+y;	
		if	(instances.get(key) == null)	{
			//System.out.println("obj created"+x+" "+y);
			instances.put(key,new Pascal(x,y));	
			}
		/*if(instances.get(key)== null){
			System.out.println("lol");
		}*/
		return	instances.get(key);	
	}	
	public void compute(){
		if (n == 0 || k == 0 || n == k) {
		this.result = 1;
		return;
			}
			//Pascal left = new Pascal(n - 1, k - 1);
			//Pascal right = new Pascal(n - 1, k);
			
			Pascal left=getInstance(n-1,k-1);
			Pascal right=getInstance(n-1,k);
			//System.out.println(right);
			if(right == null ){
				System.out.println(n-1+" "+k);
			}
			left.fork();
			right.compute(); 
			left.join();
			this.result=left.result+right.result;
	}
	
	public	int getn()	{	return	n;	}	
	public	int getk()	{	return	k;	}	
	public	String	toString()	{	 								
		return	n+","+k;	
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int n1=Reader.nextInt();
			int n2=Reader.nextInt();
			
			ForkJoinPool pool1 = new ForkJoinPool(1);
			ForkJoinPool pool2 = new ForkJoinPool(2);
			ForkJoinPool pool3 = new ForkJoinPool(3);
			
			Pascal task1=getInstance(n1,n2);
			long start = System.currentTimeMillis();
			pool1.invoke(task1);
			long end = System.currentTimeMillis()-start;
			System.out.println("Thread Pool Size : 1");
			System.out.println("Result with flyweight "+task1.result+" "+end);
			
			Pascal task3=getInstance(n1,n2);
			start = System.currentTimeMillis();
			pool2.invoke(task3);
			end = System.currentTimeMillis()-start;
			System.out.println("Thread Pool Size : 2");
			System.out.println("Result with flyweight "+task3.result+" "+end);
			
			Pascal task5=getInstance(n1,n2);
			start = System.currentTimeMillis();
			pool3.invoke(task5);
			end = System.currentTimeMillis()-start;
			System.out.println("Thread Pool Size : 3");
			System.out.println("Result with flyweight "+task5.result+" "+end);
			
			Pascal_1 task2=new Pascal_1(n1,n2);
			start = System.currentTimeMillis();
			pool1.invoke(task2);
			end = System.currentTimeMillis()-start;
			System.out.println("Thread Pool Size : 1");
			System.out.println("Result without flyweight "+task2.result+" "+end);

			Pascal_1 task4=new Pascal_1(n1,n2);
			start = System.currentTimeMillis();
			pool2.invoke(task4);
			end = System.currentTimeMillis()-start;
			System.out.println("Thread Pool Size : 2");
			System.out.println("Result without flyweight "+task4.result+" "+end);
			
			Pascal_1 task6=new Pascal_1(n1,n2);
			start = System.currentTimeMillis();
			pool3.invoke(task6);
			end = System.currentTimeMillis()-start;
			System.out.println("Thread Pool Size : 3");
			System.out.println("Result without flyweight "+task6.result+" "+end);
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