package stack1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class stack{
	public long[] arr;
	public int top;
public stack(int t){
	arr=new long[t];
	top=-1;
}

public void push(long ch){
	if(top != arr.length-1){
		top++;
		arr[top]=ch;
	}
}

public long pop(){
	long ch1;
	if(top != -1){
		ch1=arr[top];
		top--;
		return ch1;
	}
	else{
		return -1;
	}
}

public long topelement(){
	long ch2;
	if(top != -1){
		ch2=arr[top];
	}
	else{
		ch2=-1;
	}
	return ch2;
}

public boolean isempty(){
	return top == -1;
}

public void display()
{
    
    if (this.arr.length == 0)
    {
        System.out.print("Empty\n");
        return ;
    }
    for (int i = top; i >= 0; i--)
        System.out.print(arr[i]+" ");
    System.out.println();
}    
}

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int t=Reader.nextInt();
			stack s1 = new stack(3000);
			//int count=1;
			s1.push(1);
			for(int i=2;i<=t;i++){
				multiply(i,s1);
			}
			long popped;
			stack res1 = new stack(3000);
			while(s1.isempty()==false){
				res1.push(s1.pop());
			}
			while((popped=res1.pop()) != -1){
				System.out.print(popped);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void multiply(int j,stack s1){
		long carry=0;
		long prod;
		stack res=new stack(3000);
		while(s1.isempty() == false){
			prod=(s1.topelement()*j)+carry;
			//System.out.println("prod"+prod);
			s1.pop();
			res.push(prod % 10);
			//System.out.println("push"+res.topelement());
			carry=prod/10;
		}
		while(carry != 0){
			res.push(carry % 10);
			//System.out.println("push"+res.topelement());
			carry=carry/10;
		}
		stack duplicate=new stack(3000);
		while(res.isempty()==false){
			duplicate.push(res.pop());
		}
		
		if(s1.isempty()){
			s1.arr=duplicate.arr;
			s1.top=duplicate.top;
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
