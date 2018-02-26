package uniandint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Node{
	public int data;
	public Node link;
	
	public Node(int d){
		data=d;
		link=null;
	}
	public void setlink(Node n){
		link=n;
	}
	public void setdata(int d){
		data=d;
	}
	public Node getlink(){
		return link;
	}
	public int getdata(){
		return data;
	}
}

class linkedlist{
	public Node start;
	public Node rear;
	public int size;
	
	public linkedlist(){
		start=null;
		rear=null;
		size=0;
	}
	
	public void insertatbegin(int val){
		Node nptr=new Node(val);
		size++;
		if(start == null){
			start=nptr;
			rear=start;
		}
		else{
			nptr.setlink(start);
			start=nptr;
		}
		
	}
	 public void insertatend(int val){
		 Node nptr=new Node(val);
		 size++;
		 if(start == null){
			 start=nptr;
			 rear=start;
		 }
		 else{
			 rear.setlink(nptr);
			 rear=nptr;
		 }
	 }
	 public void insertatpos(int pos,int val){
		 Node nptr=new Node(val);
		 pos=pos-1;
		 Node ptr=start;
		 for(int i=1 ; i < size;i++){
			 if(i == pos){
				 Node temp=ptr.getlink();
				 ptr.setlink(nptr);
				 nptr.setlink(temp);
				 break;
			 }
			 ptr=ptr.getlink();
		 }
		 size++;
	 }
	 public void deleteatpos(int pos){
		 if(pos == 1){
			 start=start.getlink();
			 size--;
			 return;
		 }
		 if(pos == size){
			 Node s=start;
			 Node t=start;
			 while(s != rear){
				 t=s;
				 s=s.getlink();
			 }
			 rear=t;
			 rear.setlink(null);
			 size--;
			 return;
		 }
		 Node ptr=start;
		 pos=pos-1;
		 for(int v=1;v<size-1;v++){
			 if(v==pos){
				 Node tmp=ptr.getlink();
				 tmp=tmp.getlink();
				 ptr.setlink(tmp);
				 break;
			 }
			 ptr=ptr.getlink();
		 }
		 size--;
	 }
	 public void display(){
		 Node ptr=start;
		 if(start == null){
			 System.out.println();
			 return;
		 }
		 while(ptr != null ){
			 System.out.print(ptr.data+" ");
			 ptr=ptr.getlink();
		 }
		 System.out.println();
	 }
	 public void getunion(Node head1,Node head2){
		 Node t1=head1;
		 Node t2=head2;
		 while( t1 != null){
			 insertatend(t1.getdata());
			 t1=t1.getlink();
		 }
		 while(t2 != null){
			 if( !ispresent(head1,t2.getdata()))
				 insertatend(t2.getdata());
			 t2=t2.getlink();		 
		 }
	 }
	 public void getinter(Node head1,Node head2){
		 Node t1=head1;
		 while(t1 != null){
			 if(ispresent(head2,t1.getdata()))
				 insertatend(t1.getdata());
			 t1=t1.getlink();
		 }
	 }
	 public boolean ispresent(Node head,int val){
		 Node t=head;
		 while(t != null){
			 if(t.getdata()==val){
				 return true;
			 }
			 t=t.getlink();
		 }
		 return false;
	 }
}

public class Uniandint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			linkedlist l1=new linkedlist();
			linkedlist l2=new linkedlist();
			linkedlist unin=new linkedlist();
			linkedlist inter=new linkedlist();
			int y=Reader.nextInt();
			int n=Reader.nextInt();
			for(int i=0;i<y;i++){
				int k=Reader.nextInt();
				l1.insertatend(k);
			}
			for(int j=0;j<n;j++){
				int m=Reader.nextInt();
				l2.insertatend(m);
			}
			unin.getunion(l1.start,l2.start);
			inter.getinter(l1.start, l2.start);
			unin.display();
			inter.display();
			
		}catch (IOException e) {
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
