package biginteger;

import java.util.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BigInteger b=sc.nextBigInteger();
		ArrayList<BigInteger> ans=prime(b);
		for(int i=0;i<ans.size();i++){
			System.out.print(ans.get(i)+" ");
		}
		System.out.println();
		sc.close();
	}
	public static ArrayList<BigInteger> prime(BigInteger n){
		 BigInteger two = BigInteger.valueOf(2);
		    ArrayList<BigInteger> fs = new ArrayList<BigInteger>();


		    while (n.mod(two).equals(BigInteger.ZERO))
		    {
		        fs.add(two);
		        n = n.divide(two);
		    }

		    if (n.compareTo(BigInteger.ONE) > 0)
		    {
		        BigInteger f = BigInteger.valueOf(3);
		        while (f.multiply(f).compareTo(n) <= 0)
		        {
		            if (n.mod(f).equals(BigInteger.ZERO))
		            {
		                fs.add(f);
		                n = n.divide(f);
		            }
		            else
		            {
		                f = f.add(two);
		            }
		        }
		        fs.add(n);
		    }

		    return fs;
	}
}

