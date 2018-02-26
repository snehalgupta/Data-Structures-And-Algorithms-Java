package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Node
{
    public char data;
    public Node link;
 
   
    public Node()
    {
        link = null;
        data = ' ';
    }    
    
    public Node(char s,Node n)
    {
        data = s;
        link = n;
    }    
    
    public void setLink(Node n)
    {
        link = n;
    }    
    
    public void setData(char s)
    {
        data = s;
    }    
   
    public Node getLink()
    {
        return link;
    }    
    
    public char getData()
    {
        return data;
    }
}
 
class queue{
	public Node front;
	public Node rear;
	public int size;
	
	public queue(){
		front=null;
		rear=null;
		size=0;
	}
	
	public void enqueue (char val) {
		 Node nptr = new Node(val, null);
		 if (rear == null) {
		 front = nptr;
		 rear=nptr;
		 }
		 else{
		 rear.setLink(nptr);
		 rear = nptr;
		 size++;
		 }
	}
	
	public char dequeue () {
		if(isempty()==true){
			return '#';
		}
		 char d = front.getData();
		 front = front.getLink();
		 if (front == null)
		 rear = null;
		 size--;
		 return d;

		 }
	
	public char peek () {
		 char d = front.getData();
		 return d;
		 }
	
	public boolean isempty(){
		return front == null;
	}
	

}
public class queue_imp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str2=new String();
	    str2 = Reader.next();
		queue queue1 = new queue();
		for(int i=str2.length()-1; i>=0;i--){
			queue1.enqueue(str2.charAt(i));
		}
		String reverse = new String("");
		while(queue1.isempty()==false){
			reverse=reverse + queue1.dequeue();
		}
		int flag=0;
		for(int i=0; i< str2.length();i++){
			if(str2.charAt(i)==reverse.charAt(i)){
				flag=0;
			}
			else{
				flag=1;
				break;
			}
		}
		
		System.out.println(reverse);
		
		if(flag == 0){
			System.out.println("pALINDROME");
		}
		else{
			System.out.println("not palindrome");
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
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
