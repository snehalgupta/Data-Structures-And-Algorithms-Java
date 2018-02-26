package circularlinkedlist;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Node
{
    public int data;
    public Node link;
 
   
    public Node()
    {
        link = null;
        data = 0;
    }    
    
    public Node(int s,Node n)
    {
        data = s;
        link = n;
    }    
    
    public void setLink(Node n)
    {
        link = n;
    }    
    
    public void setData(int s)
    {
        data = s;
    }    
   
    public Node getLink()
    {
        return link;
    }    
    
    public int getData()
    {
        return data;
    }
}

class circularlist{
	public Node rear;
	
	public circularlist(){
		rear = null;
	}
	
	public void insert(int num){
		Node nptr = new Node(num,null);
		if(rear == null){
			rear=nptr;
			rear.setLink(rear);
		}
		else{
			Node cur = rear.getLink();
			nptr.setLink(cur);
			rear.setLink(nptr);
			rear=nptr;
		}
	}
	public void disp(int num){
		int i;
		Node it=rear;
		for (i=0;i<num*2+3;i++){
			System.out.print(it.data+" ");
			it=it.getLink();
		}
	}
	public void delete(int num){
		if (rear == null) 
	          return;
		else{
	       Node prev = rear.getLink();
	       Node now = rear.getLink().getLink();
	       //System.out.println(prev.getData());
	       //System.out.println(now.getData());
	       while (prev.getLink()!= prev && num!=1) 
	       {   prev.setLink(now.getLink());
	           now = null;
	           prev = prev.getLink();
	           if (prev != null) 
	              now = prev.getLink();
	           num--;
	             //disp(13);
	       }
	       System.out.println(prev.getData());
	       return;
	}
		}
}

public class CircularLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 {   Reader.init(System.in);    
		    try{
		    	
		    	int t = Reader.nextInt();
		    	for(int i=0;i<t;i++){
		    		circularlist c1 = new circularlist();
		    		int num = Reader.nextInt();
		    		for(int j=1;j<num+1;j++){
		    			c1.insert(j);
		    		}
		    		//c1.disp(num);
		    		c1.delete(num);
		    		
		    		
		    	}
		    
		        
		                  
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}