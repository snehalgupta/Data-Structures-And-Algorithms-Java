package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class stack{
	public String[] arr;
	public int top;
	
	public stack(int t){
		arr=new String[t];
		top=-1;
	}
	
	public void push(String ch){
		if(top != arr.length-1){
			top++;
			arr[top]=ch;
		}
	}
	
	public String pop(){
		String ch1;
		if(top != -1){
			ch1=arr[top];
			top--;
			return ch1;
		}
		else{
			return "#";
		}
	}
	
	public String topelement(){
		String ch2;
		if(top != -1){
			ch2=arr[top];
		}
		else{
			ch2="#";
		}
		return ch2;
	}
	
	
	
}

public class InfixtoPostfix {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
		int t=Reader.nextInt();
		String popped = new String();
		String elem=new String();
		String ele=new String();
		int pre,prep;
		stack stack1=new stack(t);
		int f=0,count=0;
		String[] infix=new String[t];
		String[] postfix=new String[t];
		
		for(int i=0;i<t;i++){
			infix[i]=Reader.next();
		}
		for(int j=0;j<t;j++){
			if(infix[j].equals("(")==false && infix[j].equals(")")==false && infix[j].equals("^")==false && infix[j].equals("*")==false && infix[j].equals("/")==false && infix[j].equals("+")==false && infix[j].equals("-")==false){
				postfix[f++]=infix[j];
				//System.out.println("s2"+" "+postfix[f-1]);
				count++;
			}
			else if( infix[j].equals("(")){
				elem=infix[j];
				stack1.push(elem);
			}
			else if( infix[j].equals(")")){
				//String s1=new String();
				while((popped=stack1.pop()).equals ("(")==false){
					postfix[f++]=popped;
					//System.out.println("s3"+postfix[f-1]);
					count++;
				}
			}
			else {
				//String elem=new String();
				
				if(infix[j-1].equals("(") && infix[j].equals("/")){
					//pre=3;
					//stack1.push("~");
					elem="~";
				}
				else{
				elem=infix[j];
				}
				pre=precedence(elem);
				//System.out.println("pre is"+pre);
				//String ele=new String();
				ele=stack1.topelement();
				//System.out.println(ele);
				 prep=precedence(ele);
				 //System.out.println("prep is"+prep);
				if(pre > prep){
					stack1.push(elem);
					//System.out.println("s1"+elem);
				}
				
				else{
					while(prep >= pre){
						if(ele.equals("#"))
							break;
						
					    popped = stack1.pop();
						ele=stack1.topelement();
						postfix[f++]=popped;
						count++;
						//System.out.println("s4"+postfix[f-1]);
						prep=precedence(ele);
					}
					stack1.push(elem);
				}
				
			}
		}
		//String popped1=new String();
		while((popped=stack1.pop()).equals("#")==false){
			postfix[f++]=popped;
			count++;
		}
		for(int k=0;k<count;k++){
						
			System.out.print(postfix[k]+" ");
			
		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int precedence(String ch){
		switch(ch) { 
        case "-":return 1;
        case "+":return 2;
        case "*":return 2;
        case "/":return 1;
        case "~":return 3;
        //case "(":return 3;
     } 
     return 0;
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