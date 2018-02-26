package segment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


 class SegmentTree {

    private Node[] heap;
    private int[] array;
    private int size;
    
    public SegmentTree(int[] array) {
        this.array = array;
        size = (int) (2 * Math.pow(2.0, Math.floor((Math.log((double) array.length) / Math.log(2.0)) + 1)));
        heap = new Node[size];
        build(1, 0, array.length);
    }


    public int size() {
        return array.length;
    }

    
    private void build(int v, int from, int size) {
        heap[v] = new Node();
        heap[v].from = from;
        heap[v].to = from + size - 1;

        if (size == 1) {
            heap[v].max = array[from];
            heap[v].min = array[from];
        } else {
            build(2 * v, from, size >> 1);
            build(2 * v + 1, from + (size >> 1), size - (size >> 1));

            heap[v].max =Math.max (heap[2 * v].max ,heap[2 * v + 1].max);
            heap[v].min = Math.min(heap[2 * v].min, heap[2 * v + 1].min);
        }
    }

   
    public int rMinQ(int from, int to) {
        return rMinQ(1, from, to);
    }

    private int rMinQ(int v, int from, int to) {
        Node n = heap[v];


        if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
            return n.pendingVal;
        }

        if (contains(from, to, n.from, n.to)) {
            return heap[v].min;
        }

        if (intersects(from, to, n.from, n.to)) {
            propagate(v);
            int leftMin = rMinQ(2 * v, from, to);
            int rightMin = rMinQ(2 * v + 1, from, to);

            return Math.min(leftMin, rightMin);
        }

        return Integer.MAX_VALUE;
    }
    public int rMaxQ(int from, int to) {
        return rMaxQ(1, from, to);
    }

    private int rMaxQ(int v, int from, int to) {
        Node n = heap[v];


        
        if (n.pendingVal != null && contains(n.from, n.to, from, to)) {
            return n.pendingVal;
        }

        if (contains(from, to, n.from, n.to)) {
            return heap[v].max;
        }

        if (intersects(from, to, n.from, n.to)) {
            propagate(v);
            int leftMin = rMaxQ(2 * v, from, to);
            int rightMin = rMaxQ(2 * v + 1, from, to);

            return Math.max(leftMin, rightMin);
        }

        return Integer.MIN_VALUE;
    }

  
    public void update(int from, int to, int value) {
        update(1, from, to, value);
    }

    private void update(int v, int from, int to, int value) {

        
        Node n = heap[v];

        
        if (contains(from, to, n.from, n.to)) {
            change(n, value);
        }

        if (n.size() == 1) return;

        if (intersects(from, to, n.from, n.to)) {
            
            propagate(v);

            update(2 * v, from, to, value);
            update(2 * v + 1, from, to, value);

            n.max= Math.max(heap[2 * v].max, heap[2 * v + 1].max);
            n.min = Math.min(heap[2 * v].min, heap[2 * v + 1].min);
        }
    }

    
    private void propagate(int v) {
        Node n = heap[v];

        if (n.pendingVal != null) {
            change(heap[2 * v], n.pendingVal);
            change(heap[2 * v + 1], n.pendingVal);
            n.pendingVal = null; 
        }
    }

    
    private void change(Node n, int value) {
        n.pendingVal = value;
        n.max =  value;
        n.min = value;
        array[n.from] = value;

    }

    private boolean contains(int from1, int to1, int from2, int to2) {
        return from2 >= from1 && to2 <= to1;
    }

    
    private boolean intersects(int from1, int to1, int from2, int to2) {
        return from1 <= from2 && to1 >= from2   
                || from1 >= from2 && from1 <= to2; 
    }

   
    static class Node {
        int max;
        int min;
       
        Integer pendingVal = null;
        int from;
        int to;

        int size() {
            return to - from + 1;
        }

    }
}
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reader.init(System.in);
		try{
			int n=Reader.nextInt();
			int q=Reader.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=Reader.nextInt();
			}
			SegmentTree tr=new SegmentTree(arr);
			for(int j=0;j<q;j++){
				int er=Reader.nextInt();
				if(er == 1){
					int x1=Reader.nextInt();
					int y=Reader.nextInt();
					int m1=tr.rMaxQ(x1-1, y-1);
					int m2=tr.rMinQ(x1-1, y-1);
					int res=m1-m2;
					System.out.println(res);
				}
				else if(er == 2){
					int i=Reader.nextInt();
					int x1=Reader.nextInt();
					tr.update(i-1, i-1, x1);
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