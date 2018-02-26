package heapsort;

class heap{
	int[] harr;
	int heap_size;
	
	public heap(int[] n){
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
	
	public int extractmin(){
		if(heap_size <= 0){
			return Integer.MAX_VALUE;
		}
		if(heap_size == 1){
			heap_size--;
			return harr[0];
		}
		int root=harr[0];
		harr[0]=harr[heap_size - 1];
		heap_size--;
		this.minheapify(0);
		return root;
	}
	
	public void minheapify(int i){
		int temp;
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
	
	public void heapsort(){
		int e;
		for(int i=heap_size/2 - 1;i >=0;i--){
			minheapify(i);
		}
		while(heap_size != 0){
			e=extractmin();
			System.out.print(e);
		}
	}
}
public class HeapSort {
	
	public static void main(String[] args) {
		int[] arr={1,0,2,9,3,8,4,7,5,6};
		heap h=new heap(arr);
		h.heapsort();
	}
}
