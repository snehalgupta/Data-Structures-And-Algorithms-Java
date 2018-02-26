package integerlinkedlist;
 import java.util.Scanner;

class Node
{
   protected int data;
   protected Node link;

  
   public Node()
   {
       link = null;
       data = 0;
   }    
   
   public Node(int d,Node n)
   {
       data = d;
       link = n;
   }    
   
   public void setLink(Node n)
   {
       link = n;
   }    
   
   public void setData(int d)
   {
       data = d;
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


class linkedList
{
   public Node start;
   public int size ;

   
   public linkedList()
   {
       start = null;
       size = 0;
   }
   
   
   public void insertAtPos(int num , int pos)
   {
	   Node nptr = new Node(num, null); 
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
       if (pos == size) 
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
       size-- ;
   }    
   
   public void display()
   {
       Node ptr = start;
       System.out.print(start.getData()+" ");
       ptr=start.getLink();
       
       while (ptr.getLink() != null)
       {
       	System.out.print(ptr.getData()+ " ");
           ptr = ptr.getLink();
       }
      System.out.println(ptr.getData());
   } 
   public void count(){
	   int count=0;
	   Node ptr=start;
	   while(ptr != null){
		   if(ptr.getData() >= 45){
			   count++;
		   }
		   ptr=ptr.getLink();
	   }
	   System.out.println(count);
   }
   public void print_alternate(){
	   Node ptr=start;
	   while(ptr != null){
		   System.out.print(ptr.getData());
		   ptr=ptr.getLink();
		   if(ptr != null){
			   ptr=ptr.getLink();
		   }
	   }
   }
   public void print_last(){
	   Node ptr1=start;
	   while(ptr1.getLink() != null){
		   ptr1=ptr1.getLink();
	   }
	   System.out.print(ptr1.getData());
   }
   public linkedList copy(){
	   linkedList list1 = new linkedList();
	   Node ptr = start;
	   while(ptr != null){
		   int d=ptr.getData();
		   Node nptr = new Node(d,null);
		   if(list1.start == null){
			   start=nptr;
		   }
		   else{
			   Node ptr1 = list1.start;
			   while(ptr1.getLink() != null){
				   ptr1=ptr1.getLink();
			   }
			   ptr.setLink(nptr);
		   }
	   }
	   return list1;
   }
   public linkedList reverse_copy(){
	   Node ptr2 = start;
	   linkedList l1 = new linkedList();
	   while(ptr2 != null){
		   int d=ptr2.getData();
		   Node nptr = new Node(d,null);
		   nptr.setLink(l1.start);
		   l1.start=nptr;
		   ptr2 = ptr2.getLink();
	   }
	   return l1;
   }
   public linkedList alternate_copy(){
	   Node ptr3 = start;
	   linkedList list = new linkedList();
	   while(ptr3 != null){
		   int d = ptr3.getData();
		   Node n1 = new Node(d,null);
		   if(list.start == null){
			   list.start = n1;
		   }
		   else{
			   Node n2 = list.start;
			   while(n2.getLink() != null){
				   n2 = n2.getLink();
			   }
			   n2.setLink(n1);
		   }
		   ptr3=ptr3.getLink();
		   if(ptr3 != null){
			   ptr3=ptr3.getLink();
		   }
	   }
	   return list;
   }
   public void delete_fl(){
	   start=start.getLink();
	   Node ptr1 = start;
	   Node ptr2 = start.getLink();
	   while(ptr2 != null){
		 ptr1 = ptr2;
		 ptr2 = ptr2.getLink();
	   }
	   ptr1.setLink(null);
   }
   public int getk(int pos){
	   Node ptr2 = start;
	   for(int i=1; i < pos; i++){
		   ptr2=ptr2.getLink();
	   }
	   return ptr2.getData();
   }
   public void join(linkedList l2){
	   Node ptr3 = start;
	   while (ptr3.getLink() != null){
		   ptr3=ptr3.getLink();
	   }
	   ptr3.setLink(l2.start);
   }
   public void remove(){
	   Node ptr1 = start;
	   Node ptr2 = start.getLink();
	   while(ptr1 != null && ptr2 != null){
		   ptr1.setLink(ptr2.getLink());
		   ptr2=null;
		   ptr1=ptr1.getLink();
		   if(ptr1 != null){
			   ptr2=ptr1.getLink();
		   }
	   }
   }
   public void split(){
	   Node head = start;
	   Node head1 = head;
	   Node head2 = head.getLink();
	   while(head != null && head.getLink() != null){
		   Node t = head.getLink();
		   head.setLink(t.getLink());
		   if(head.getLink() != null && head.getLink().getLink() != null){
			   t.setLink(head.getLink().getLink());
		   }
		   else{
			   t.setLink(null);
			   return;
		   }
		   head=head.getLink();
	   }
	  
	   }
   public void replace_sum(){
	   Node temp1=start;
	   while(temp1 != null && temp1.getLink() != null){
		   temp1.setData(temp1.getData()+temp1.getLink().getData());
			   temp1.setLink(temp1.getLink().getLink());
		   temp1=temp1.getLink();
	   }
   }
   /*public linkedList merge(linkedList l1){
	   linkedList lnew = new linkedList();
	   Node head1 = start;
	   Node head2 = l1.start;
	   while(head1=)*/
   }




public class IntegerLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scan = new Scanner(System.in);
	     linkedList list = new linkedList(); 
		int M=scan.nextInt();
		 for(int y=1;y<=M;y++){
		        int num = scan.nextInt() ;
		        list.insertAtPos(num, y);
		        }
		 int q=scan.nextInt();
		 for(int j=0;j<q;j++){
			 int qno = scan.nextInt();
			 if(qno == 1){
				 int num2 = scan.nextInt();
				 int pos = scan.nextInt();
				 list.insertAtPos(num2, pos);
				 list.display();
			 }
			 else if(qno == 2){
				 int pos2 = scan.nextInt();
				 list.deleteAtPos(pos2);
				 list.display();
			 }
			 else if(qno == 3){
				 list.display();
			 }
			 else if(qno ==4){
				 list.delete_fl();
				 list.display();
			 }
			 else if(qno == 5){
				 list.count();
			 }
			 else if(qno == 6){
				 list.remove();
				 list.display();
			 }
			 else if(qno == 7){
				 list.replace_sum();
				 list.display();
			 }
			 
		 }
		 scan.close();
	}

}
