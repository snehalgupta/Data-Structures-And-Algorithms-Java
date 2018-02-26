package shortest_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Queue{
	protected int queue[][];
	protected int front,rear,size;
	
	public Queue(int n){
		size=n;
		queue=new int[n][3];
		front=-1;
		rear=-1;
	}
	
	public boolean isEmpty(){
		return front == -1;
	}
	
	public boolean isFull(){
		return front==0 && rear==size-1;
	}
	
	public void insert(int[] i){
		if(rear == -1){
		   front=0;
		   rear=0;
		   queue[rear]=Arrays.copyOf(i,i.length);
		}
		else if( rear + 1 < size){
			queue[++rear]=Arrays.copyOf(i,i.length);
		}
	}
	
	public int[] remove(){
		int[] ele = Arrays.copyOf(queue[front],queue[front].length);
		if(front == rear){
			front=-1;
			rear=-1;
		}
		else{
			front++;
		}
		return ele;
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Empty");
		}
		for(int v=front; v<=rear; v++){
			for(int b=0; b<2;b++){
				System.out.print(queue[v][b]);
			}
			System.out.println();
		}
	}
	
	public int[] peek(){
		return queue[front];
	}
}

public class Shortest_distance {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{ int t = Reader.nextInt();
			 int[][] arr=new int[t][t];
			 int xs= Reader.nextInt();
			 int ys= Reader.nextInt();
			 int xd= Reader.nextInt();
			 int yd= Reader.nextInt();
			 for(int i=0;i<t;i++){
				 for(int j=0;j<t;j++){
					 arr[i][j]=Reader.nextInt();
				 }
			 }
			 int[] src={ys,xs};
			 int[] des={yd,xd};
			 shortest(arr,src,des,t);
			 /*Queue que = new Queue(5);
			 int[] s={4,5};
			 que.insert(s);
			 int[] s1={2,3};
			 que.insert(s1);
			 que.remove();
			 que.display();*/
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void shortest(int[][] arr,int[] src,int[] des,int t){
		int[] rownum={-1,0,0,1};
		int[] colnum={0,-1,1,0};
		boolean[][] visited=new boolean[t][t];
		Queue q1=new Queue(t*t);
		for(int i=0;i<t;i++){
			for(int j=0;j<t;j++){
				visited[i][j]=false;
			}
		}
		visited[src[0]][src[1]]=true;
		Queue q=new Queue(t*t);
		q.insert(src);
		while(q.isEmpty()==false){
			int[] curr=Arrays.copyOf(q.queue[q.front],3);
			if(curr[0] == des[0] && curr[1]==des[1]){
				//System.out.println(curr[2]);
				break;
			}
		q.remove();
		for(int k=0;k<4;k++){
			int row=curr[0]+rownum[k];
			int col=curr[1]+colnum[k];
			if((row >= 0 && row < t) && (col >= 0 && col < t) && arr[row][col] != 0 && !visited[row][col]){
				visited[row][col]=true;
				int[] temp={row,col,curr[2]+1};
				q.insert(temp);
			}
		}
		}
		int[] curr2={des[0],des[1]};
		for(int u=0;u<2;u++){
			int row1=curr2[0]+rownum[u];
			int col1=curr2[1]+colnum[u];
			if(row1 >= 0 && row1<t && col1>=0 && col1<t && visited[row1][col1] ){
				System.out.println("hol");
				int[] temp1={col1,row1};
				q1.insert(temp1);
				curr2[0]=row1;
				curr2[1]=col1;
			}
		}
		q1.insert(des);
		q1.display();
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