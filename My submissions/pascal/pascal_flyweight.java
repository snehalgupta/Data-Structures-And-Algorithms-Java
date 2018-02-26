package pascal;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
public class pascal_flyweight extends RecursiveTask<Integer> {
	
	private static volatile Map<String, pascal_flyweight> instances=new HashMap<String,pascal_flyweight>();

	public static synchronized pascal_flyweight getInstance(int n,int k){
		String key=n+","+k;
		if(!instances.containsKey(key)){
			instances.put(key, new pascal_flyweight(n,k));
		}
		return instances.get(key);
	}
	
	private final int n,k;
	
	private pascal_flyweight(int n,int k){
		this.n=n;
		this.k=k;
	}
	
	public Integer compute() {
		if(n==0||k==0||n==k){
			return 1;
		}
		pascal_flyweight left=getInstance(this.n-1,this.k-1);
		pascal_flyweight right=getInstance(this.n-1,this.k);
		left.fork();
		return right.compute()+left.join();
	}
	
	int recurse(int n,int k){
		if(n==0||k==0||n==k){
			return 1;
		}
		
		int left=recurse(n-1,k-1);
		int right=recurse(n-1,k);
		
		return (left+right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool pool_w=new ForkJoinPool(1);
		pascal_flyweight task3=new pascal_flyweight(50,7);
		long startTime3 = System.currentTimeMillis();
		int result3 =pool_w.invoke(task3);
		long endTime3   = System.currentTimeMillis();
		long totalTime3 = endTime3 - startTime3;
		System.out.println(result3);
		System.out.println(totalTime3);
		
		ForkJoinPool pool=new ForkJoinPool(1);
		pascal_flyweight task=getInstance(50,7);
		long startTime = System.currentTimeMillis();
		int result=pool.invoke(task);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(result);
		System.out.println(totalTime);
		
		ForkJoinPool pool1=new ForkJoinPool(2);
		pascal_flyweight task1=getInstance(50,7);
		long startTime1 = System.currentTimeMillis();
		int result1=pool1.invoke(task1);
		long endTime1   = System.currentTimeMillis();
		long totalTime1 = endTime1 - startTime1;
		System.out.println(result1);
		System.out.println(totalTime1);
		
		ForkJoinPool pool2=new ForkJoinPool(3);
		pascal_flyweight task2=getInstance(50,7);
		long startTime2 = System.currentTimeMillis();
		int result2=pool2.invoke(task2);
		long endTime2   = System.currentTimeMillis();
		long totalTime2 = endTime2 - startTime2;
		System.out.println(result2);
		System.out.println(totalTime2);
	}

}