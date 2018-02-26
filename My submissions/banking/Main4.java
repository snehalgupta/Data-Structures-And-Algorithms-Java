package banking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Account{
	String csname;
	String address;
	int balance;
	int accno;
	static int count=0;
	
	public Account(){
		csname=" ";
		address=" ";
		balance=0;
		accno=Integer.MIN_VALUE;
	}
	
	public Account(String cs,String ad,int ba){
		csname=cs;
		address=ad;
		balance=ba;
		if(balance <= 500)
			balance-=5;
		count+=1;
		accno=count;
	}
	
	public String toString(){
		String s=accno+" "+csname+" "+address+" "+balance+" ";
		System.out.println(s);
		return s;
	}
	
	public void debit(int deb){
		if(deb > balance)
			System.out.println("Print Error");
		else{
			balance=balance-deb;
			if(balance <= 500)
				balance-=5;
		}
	}
	
	public void credit(int cre){
		balance=balance+cre;
	}
}

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			Account[] acc=new Account[20];
			for(int i=0;i<20;i++){
				acc[i]=new Account("blabla","abcd",1000);
			}
			int flag =0;
			System.out.println("Enter account number");
			int ac=Reader.nextInt();
			ac=ac-1;
			if(ac <= acc.length+1 && ac>0){
				System.out.println("Menu:\n1. Credit\n2. Debit\n3. Check Balance\n4. Enter another account\n5. Exit\n");
			while(flag == 0){
				
				
				System.out.println("Select option number");
				int op=Reader.nextInt();
				
				if(op == 1){
					System.out.println("Enter amount to deposit");
					int cre=Reader.nextInt();
					acc[ac].credit(cre);
				}
				else if(op == 2){
					System.out.println("Enter amount to withdraw");
					int deb=Reader.nextInt();
					acc[ac].debit(deb);
				}
				else if(op == 3){
					System.out.println("Balance: "+acc[ac].balance);
				}
				else if(op == 4){
					continue;
				}
				else{
					flag=1;
					break;
				}
					}
			}
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
    
    static long nextLong() throws IOException{
    	return Long.parseLong(next());
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}