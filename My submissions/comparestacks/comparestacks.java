package comparestacks;

import java.util.Scanner;

class stack{
	public int[] arr;
	public int top;
public stack(int t){
	arr=new int[t];
	top=-1;
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
}


public class comparestacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n1 = sc.nextInt();
		stack s1 = new stack(n1);
		for(int i=0; i<n1 ; i++){
			s1.push(sc.nextInt());
		}
		int n2=sc.nextInt();
		stack s2 = new stack(n2);
		for(int j=0;j<n2;j++){
			s2.push(sc.nextInt());
		}
		boolean res =compare_stacks(s1,s2);
		System.out.println(res);
		sc.close();
	}
	
    public static boolean compare_stacks(stack a,stack b){
    	int element_a;
    	int element_b;
    	if(a.isempty() != b.isempty())
    		return false;
    	if(a.isempty() && b.isempty())
    		return true;
    	element_a = a.pop();
    	element_b = b.pop();
    	if(element_a != element_b){
    		a.push(element_a);
    		b.push(element_b);
    		return false;
    	}
    	boolean result=compare_stacks(a,b);
    	a.push(element_a);
    	b.push(element_b);
    	return result;
    }
   }
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
      		
    		
  
   
