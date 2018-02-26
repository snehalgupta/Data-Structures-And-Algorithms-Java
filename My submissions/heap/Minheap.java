package heap;

class heap{
	int[] harr;
	int capacity;
	int heap_size;
	
	public heap(int n){
		heap_size=0;
		capacity=n;
		harr=new int[n];
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
	
	public void insert(int k){
		int temp;
		if(heap_size == capacity){
			System.out.println("Overflow");
			return;
		}
		heap_size++;
		int i=heap_size-1;
		harr[i]=k;
		while( i != 0 && harr[parent(i)] > harr[i]){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	public void decreaseKey(int i,int new_val){
		int temp;
		harr[i]=new_val;
		while(i != 0 && harr[parent(i)] > harr[i]){
			temp=harr[i];
			harr[i]=harr[parent(i)];
			harr[parent(i)]=temp;
			i=parent(i);
		}
	}
	
	public int extractmin(){
		if(heap_size <= 0){
			return Integer.MAX_VALUE;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		int root=harr[0];
		//System.out.println("root"+root+" "+harr[0]);
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.MinHeapify(0);
		return root;
	}
	
	private void MinHeapify(int i){
		int temp;
		int l = left(i);
		int r= right(i);
		int smallest = i;
		if( l < heap_size && harr[l] < harr[i]){
			smallest=l;
		}
		if( r < heap_size && harr[r] < harr[smallest]){
			smallest=r;
		}
		if( smallest != i){
			temp=harr[i];
			harr[i]=harr[smallest];
			harr[smallest]=temp;
			MinHeapify(smallest);
		}
	}
	
	public void delete(int i){
		decreaseKey(i,Integer.MIN_VALUE);
		extractmin();
	}
}

public class Minheap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		heap h=new heap(11);
		h.insert(3);
		h.insert(2);
		h.delete(1);
		h.insert(15);
		h.insert(5);
		h.insert(4);
		h.insert(45);
		System.out.println(h.extractmin());
		System.out.println(h.harr[0]);
		h.decreaseKey(2,1);
		System.out.println(h.harr[0]);
	}

}
