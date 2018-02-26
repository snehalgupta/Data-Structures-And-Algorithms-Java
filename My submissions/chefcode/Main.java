package chefcode;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			long k=sc.nextLong();
			ArrayList<Long> war=new ArrayList<Long>();
			ArrayList<Long> product=new ArrayList<Long>();
			long count=0;
			
			for(int i=0;i<n;i++){
				long gh=sc.nextLong();
				if(gh == 1){
					count+=1;
				}
				else if(gh <= k){
					war.add(gh);
				}
			}
			long VC=1;
			product.add(VC);
			
			Collections.sort(war);
			for(int j=0;j<war.size();j++){
				Collections.sort(product);
				int cur=product.size();
				for(int h=0;h<cur;h++){
					long vbo=product.get(h);
					long yu=war.get(j)*vbo;
					if (yu <= k){
						product.add(yu);
	
					}
					else{
						break;
					}
				}
			}
			
			long wo=(long)Math.pow(2,count )-1;
			long fgh=wo*(product.size()-1);
			long result=product.size()-1+wo+fgh;
			System.out.println(result);
			sc.close();
	}
}

