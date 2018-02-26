package sandwich;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++){
			long n=sc.nextLong();
			long k=sc.nextLong();
			long m=sc.nextLong();
			if(n%k == 0){
				System.out.println(n/k+" "+1);
				
			}
			else{
				long p=n/k;
				p=p+1;
				long ma;
				long mi;
				if(p-1>p*k-n){
				 ma=p-1;
					 mi=p*k-n;
				}
				else{
					 ma=p*k-n;
					 mi=p-1;
				}
				long num=1;
				long den=1;
				for(int g=1;g<=mi;g++){
					num=num*(g+ma);
					den=den*g;
				}
				long res=num/den;
				long res1=res%m;
				System.out.println(p+" "+res1);
			}
			
		}
		sc.close();
	}
	
	
	
	
	
	
	
	
	
	
}
