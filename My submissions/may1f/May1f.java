package may1f;


import java.util.Scanner;

 
class heap{
	long[] harr;
	int heap_size;
	
	public heap(long[] n){
		heap_size=n.length;
		harr=n;
	}
	
	public int parent(int i){
		return (i-1)/2;
	}
	
	public int left(int i){
		return 2*i + 1;
	}
	
	public int right(int i){
		return 2*i +2;
	}
	
	public long extractmin(){
		if(heap_size <= 0){
			return Integer.MAX_VALUE;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		long root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.minheapify(0);
		return root;
	}
	
	public void minheapify(int i){
		long temp;
		int smallest=i;
		int l=left(i);
		int r=right(i);
		if(l < heap_size && harr[l] < harr[smallest])
			smallest=l;
		if(r < heap_size && harr[r] < harr[smallest])
			smallest=r;
		if(smallest != i){
			temp=harr[smallest];
			harr[smallest]=harr[i];
			harr[i]=temp;
			minheapify(smallest);
		}
	}
	
	public long[] heapsort(){
		long e;
		int p=0;
		long[] arr=new long[heap_size];
		for(int i=heap_size/2 - 1;i >=0;i--){
			minheapify(i);
		}
		while(heap_size != 0){
			e=extractmin();
			//System.out.print(e);
			arr[p]=e;
			p++;
		}
		return arr;
	}
}
 
class Node
{
    long data;
    Node link;
 
  
   public Node(long d)
   {
       link = null;
       data = d;
   }    
}
 
class stack
{
    protected Node top ;
    protected int size ;
 
    public stack()
    {
        top = null;
        size = 0;
    } 
    
    public stack(stack s){
    	top=s.top;
    	size=s.size;
    }
    
    public boolean isempty()
    {
        return top == null;
    }    
    
    public int getSize()
    {
        return size;
    }    
    
    public void push(long data)
    {
        Node nptr = new Node (data);
        if (top == null)
            top = nptr;
        else
        {
            nptr.link=top;
            top = nptr;
        }
        size++ ;
    }    
    
    public long pop()
    { if(top == null)
    	return -1;
        
        Node ptr = top;
        top = ptr.link;
        size-- ;
        return ptr.data;
    }    
    
    public long topelement()
    {
        return top.data;
    }    
    
    public void display()
    {
       // System.out.print("\nStack = ");
        if (size == 0) 
        {
            System.out.print("Empty\n");
            return ;
        }
        Node ptr = top;
        while (ptr != null)
        {
            System.out.print(ptr.data+" ");
            ptr = ptr.link;
        }
        System.out.println();        
    }
}
public class May1f {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner sc=new Scanner(System.in);  
			//Reader.init(System.in);
			int n=sc.nextInt();
			long k=sc.nextLong();
			long[] arr1=new long[n];
			long[] arr=new long[n];
			int flag=0,flag1=0;
			long temp;
			for(int i=0;i<n;i++){
				arr1[i]=sc.nextLong();
			}
			heap h=new heap(arr1);
			arr=h.heapsort();
			int count=0;
			int subsets, start, end,  j, cur_len,  k3;
			long ele_max;
			subsets=(int)Math.pow(2, n)	;					
			//int queue[subsets][n+1];	
			long[][] queue = new long[subsets][n+1];
			for(j=0; j<n; j++)							
			{											
				queue[j][0]=1;							
				queue[j][1]=arr[j];						
			}
			start=0;
			end=n-1;									
			while(start<=end)
			{
				cur_len=(int)queue[start][0];                
				ele_max=queue[start][cur_len];			
				for(j=0; j<n; j++)
				{
					if(arr[j]>ele_max)					
					{									
						end++;
						queue[end][0]=cur_len+1;		
						for(k3=1; k3<=queue[start][0]; k3++)
						{
							queue[end][k3]=queue[start][k3]; 
						}
						queue[end][k3]=arr[j];				
					}	
				}
				start++;							
			}
											//Print the answer
			for(j=0; j<=end; j++)
			{   stack s1=new stack();
				s1.push(1);
				flag=0;
				for(k3=1; k3<=queue[j][0]; k3++){
					//System.out.print(queue[j][k3]+" ");
					flag=1;
					multiply(queue[j][k3],s1);
				}
				if(flag == 1)	{
					long popped1,popped2;
					stack res1=new stack();
					while(s1.isempty() == false){
						res1.push(s1.pop());
					}
					/*System.out.println("res1 :");
					res1.display();*/
					long x=k;
					stack res2=new stack();
					while(x != 0){
						temp=x%10;
						res2.push(temp);
						x=x/10;
					}
					if(res1.size == res2.size){
						while((popped1=res1.pop()) != -1 && (popped2=res2.pop()) != -1){
							if(popped1 > popped2){
								flag1=1;
								break;
							}
						}
						if(flag1 == 0){
							//System.out.println("bye");
							count++;
						}
						
						
					}
					else if(res1.size < res2.size)
						count++;
					
					
			}
			}
			System.out.println(count);
			sc.close();
		}
			/*for (int width = 1; width <= n; width++) {
				
				for (int i = 0; i <= n - width; i++) {
					stack s1=new stack();
					s1.push(1);
					flag=0;
					for (int j = 0; (j < width) && (i + j < n); j++) {
						//System.out.print( arr[i + j]+" " );
						flag=1;
						multiply(arr[i+j],s1);
					}
					//System.out.println("end of loop 1");
					if(flag == 1)	{
						long popped1,popped2;
						stack res1=new stack();
						while(s1.isempty() == false){
							res1.push(s1.pop());
						}
						System.out.println("res1 :");
						res1.display();
						long x=k;
						stack res2=new stack();
						while(x != 0){
							temp=x%10;
							res2.push(temp);
							x=x/10;
						}
						if(res1.size == res2.size){
							while((popped1=res1.pop()) != -1 && (popped2=res2.pop()) != -1){
								if(popped1 > popped2){
									flag1=1;
									break;
								}
							}
							if(flag1 == 0){
								System.out.println("bye");
								count++;
							}
							
						}
						else if(res1.size < res2.size)
							count++;
						
						
				}
				}
				//System.out.println("end of loop 2");
			}*/
			//System.out.println("end of loop 3");
			//System.out.println(count);
			//sc.close();
	
	
	public static void multiply(long j,stack s1){
		long carry=0;
		long prod;
		stack res=new stack();
		while(s1.isempty() == false){
			prod=(s1.topelement()*j)+carry;
			//System.out.println("prod"+prod);
			s1.pop();
			res.push(prod % 10);
			//System.out.println("push"+res.topelement());
			carry=prod/10;
		}
		while(carry != 0){
			res.push(carry % 10);
			//System.out.println("push"+res.topelement());
			carry=carry/10;
		}
		stack duplicate=new stack();
		while(res.isempty()==false){
			duplicate.push(res.pop());
		}
		
		if(s1.isempty()){
			s1.size=duplicate.size;
			s1.top=duplicate.top;
		}
	}
 
}
 
 
