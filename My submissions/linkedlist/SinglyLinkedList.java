package linkedlist;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node
{
    public String data;
    public Node link;
 
   
    public Node()
    {
        link = null;
        data = "";
    }    
    
    public Node(String s,Node n)
    {
        data = s;
        link = n;
    }    
    
    public void setLink(Node n)
    {
        link = n;
    }    
    
    public void setData(String s)
    {
        data = s;
    }    
   
    public Node getLink()
    {
        return link;
    }    
    
    public String getData()
    {
        return data;
    }
}
 

class linkedList
{
    public Node start;
    public int size ;
 
    
    public linkedList()
    {
        start = null;
        size = 0;
    }
    
       
    public void insertAtPos(String str1 , int pos)
    {
        Node nptr = new Node(str1, null); 
        if(start == null) 
        {
            start = nptr;
        }
        else if(pos == 1){
        	nptr.setLink(start);
        	start=nptr;
        }
       else if(pos == size+1){
        	Node ptr1=start;
        	while(ptr1.getLink() != null){
        		ptr1=ptr1.getLink();
        	}
        	ptr1.setLink(nptr);
        }
        
        else{
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i <= size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        }
        size++ ;
    }
   
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getLink();
            size--; 
            return ;
        }
        else if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s.getLink() != null)
            {
                t = s;
                s = s.getLink();
            }
            
            t.setLink(null);
            size --;
            return;
        }
        else{
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size--;
        }
    }    

    
    public void display()
    {   if(start == null){
    	System.out.println();
    }
    else{
        Node ptr = start;
        while (ptr != null)
        {
        	System.out.print(ptr.getData()+ " ");
            ptr = ptr.getLink();
        }
       System.out.println();
    }
    }
    
    public void compare(linkedList list1){
    	Node ptr=start;
    	int flag=1;
    	Node ptr2=list1.start;
    	if(size != list1.size){
    		System.out.println("0");
    		return;
    	}
    	else{
    	while(ptr!=null && ptr2!=null){
    		if( ptr.getData().equals(ptr2.getData())){
    			ptr=ptr.getLink();
        		ptr2=ptr2.getLink();}
    		else
    		{
    			flag =0;
    			System.out.println("0");
    			return;
    		}
    		
    	}
    	if(flag == 1 ){
    		System.out.println("1");
    		return;
    	}
    	}
    }
}
 

public class SinglyLinkedList
{   
    public static void main(String[] args)
    {   Reader.init(System.in);    
    try{
        linkedList list = new linkedList(); 
        int M=Reader.nextInt();
        int Q=Reader.nextInt();
        for(int y=1;y<=M;y++){
        String str = Reader.next() ;
        list.insertAtPos(str, y);
        }
        for(int u=0;u<Q;u++){
        	int n=Reader.nextInt();
        	if(n==1){
        		String str2=Reader.next();
        		int pos2=Reader.nextInt();
        		list.insertAtPos(str2, pos2);
        	}
        	else if(n==2){
        		int pos3=Reader.nextInt();
        		list.deleteAtPos(pos3);
        	}
        	else if(n==3){
        		list.display();
        	}
        	else if(n==4){
        		String str3;
        		linkedList list1 = new linkedList();
        		int size1=Reader.nextInt();
        		for(int j=1;j<=size1;j++){
        			str3=Reader.next();
        			list1.insertAtPos(str3, j);
        		}
        		list.compare(list1);
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
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}