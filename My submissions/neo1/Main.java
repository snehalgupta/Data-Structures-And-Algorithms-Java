package neo1;
import java.util.Scanner;

public class Main {
	int start;
	int end;
	long[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int b=0;b<t;b++){
		int n=sc.nextInt();
		Main p=new Main();
		p.arr=new long[n];
		p.start=0;
		p.end=0;
		for(int i=0;i<n;i++){
			p.arr[i]=sc.nextLong();
		}
		long max_sum=0;
		long lo=Long.parseLong("-100000000000000");
		while(max_sum != lo){
			max_sum=p.get_sum();
			long len=p.end-p.start+1;
			long res=max_sum*len;
			int d1=p.start;
			int d2=p.end;
			while(d1 > 0){
				long temp=max_sum+p.arr[d1-1];
				long hu=temp*(p.end-p.start+2);
				if(hu > res){
					max_sum=temp;
					res=hu;
					p.start=d1;
					d1=d1-1;
				}
				else{
					break;
				}
			}
			while(d2<p.arr.length-1){
				long temp=max_sum+p.arr[d2+1];
				long hu=temp*(p.end-p.start+2);
			}
		}
	}
		sc.close();
	}
	
	public long get_sum(){
		long max_sum=Long.parseLong("-100000000000000");
		long sum=0;
		int temp_start=0;
		int j;
		for(j=0;j<arr.length;j++){
			sum+=arr[j];
			if(sum > max_sum || (sum==max_sum && end-start<j-temp_start)){
				max_sum=sum;
				start=temp_start;
				end=j;
			}
			if(sum<0){
				sum=0;
				temp_start=j+1;
			}
		}
		return max_sum;
	}
}
