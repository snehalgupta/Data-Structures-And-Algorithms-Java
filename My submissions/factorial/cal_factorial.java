package factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class stack{
	public int[] arr;
	public int top;
public stack(int t){
	arr=new int[t];
	top=-1;
}

public stack(stack t){
	this.arr=new int[t.arr.length];
	this.arr=t.arr;
	this.top=t.top;
}

public void push(int ch){
	if(top != arr.length-1){
		top++;
		arr[top]=ch;
	}
}
 

public int pop(){
	int ch1;
	if(top != -1){
		ch1=arr[top];
		top--;
		return ch1;
	}
	else{
		return -1;
	}
}

public int topelement(){
	int ch2;
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

public class cal_factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{int temp,y;
			int t=Reader.nextInt();
			stack s1= new stack(3000);
			s1.push(1);
			for(int i=2;i<=t;i++){
				stack temp1=new stack(3000);
				y = i;
				while( y != 0){
					temp=y % 10;
					temp1.push(temp);
					y=y/10;
				}
				stack s2 = new stack(3000);
				while(temp1.isempty()==false){
					s2.push(temp1.pop());
				}
				s1=new stack(multiply(s2,s1));
			}
			int popped;
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
	
	public static stack multiply(stack s2,stack s1){
		stack[] store=new stack[s2.top+1];
		int u=0;
		while(s2.isempty() == false){
			int carry = 0;
			int result = 0;
			int rem = 0;
			store[u]=new stack(3000);
			stack temp=new stack(s1);
			while(s1.isempty() == false){
				result = (s2.topelement() * s1.topelement())+carry;
				s1.pop();
				carry=result/10;
				rem=result % 10;
				store[u].push(rem);
			}
			while(carry != 0){
				store[u].push(carry % 10);
				carry=carry/10;
			}
			u=u+1;
			s1=new stack(temp);
			s2.pop();
		}
		 return arrange(store);
		 
	}
	
	public static stack arrange(stack[] s4){
		int r;
		for(int f=0;f<s4.length;f++){
		 r=0;
		 stack temp1=new stack(3000);
		 while(s4[f].isempty()==false){
			 temp1.push(s4[f].pop());
		 }
			while(r<f){
				s4[f].push(0);
				r++;
			}
			while(temp1.isempty()==false){
				s4[f].push(temp1.pop());
			}
		}
		stack[] s5=new stack[s4.length];
		for(int x=0;x<s4.length;++x){
			s5[x]=new stack(s4[x]);
		}
		
		stack sum=new stack(3000);
		sum.push(0);
		for(int z=0;z<s5.length;z++){
			sum=new stack(add(sum,s5[z]));
		}
		stack b2=new stack(3000);
		while(sum.isempty()==false){
			b2.push(sum.pop());
		}
		return b2;
	}
	
	
	
	public static stack add(stack a,stack b){
		stack a1=new stack(3000);
		while(a.isempty()==false){
			a1.push(a.pop());
		}
		stack b1=new stack(3000);
		while(b.isempty()==false){
			b1.push(b.pop());
		}
		int sum=0;
		int carry=0;
		int rem=0;
		stack n1=new stack(3000);
		if(a1.top > b1.top){
			while(b1.isempty() ==false){
				sum=a1.topelement()+b1.topelement()+carry;
				carry=sum/10;
				rem=sum%10;
				n1.push(rem);
				b1.pop();
				a1.pop();
			}
			while(a1.isempty() == false){
				sum=a1.topelement()+carry;
				carry=sum/10;
				rem=sum%10;
				n1.push(rem);
				a1.pop();
			}
			if(carry != 0){
				n1.push(carry);
			}
		}
		else{
			while(a1.isempty() ==false){
				sum=b1.topelement()+a1.topelement()+carry;
				carry=sum/10;
				rem=sum%10;
				n1.push(rem);
				a1.pop();
				b1.pop();
			}
			while(b1.isempty() == false){
				sum=b1.topelement()+carry;
				carry=sum/10;
				rem=sum%10;
				n1.push(rem);
				b1.pop();
			}
			if(carry != 0){
				n1.push(carry);
			}
		}
		//n1.display();
		return n1;
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

