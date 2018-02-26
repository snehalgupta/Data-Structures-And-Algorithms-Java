package bintodec;

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

public class dectobin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
     stack s1 = new stack(100);
     int q;
     int t=sc.nextInt();
     if( t == 0)
    	 System.out.println("0");
     while(t != 0){
    	 q = t / 2 ;
    	 s1.push(t % 2);
    	 t = q;
     }
     while(s1.isempty()==false){
    	 System.out.print(s1.pop());
     }
     sc.close();
	}

}
