package com.xiaoleilei.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumArray  extends RecursiveTask<Integer>{
	
	private static final  int LIMIT_SIZE = CreateArray.MAX_SIZE/10;
	private int firstNumber;
	private int lastNumber;
	private int[] arr; 
	
	public ForkJoinSumArray(int[] arr, int firstNumber, int lastNumber){
		this.arr = arr;
		this.firstNumber = firstNumber;
		this.lastNumber = lastNumber;
	}
	
	public static void main(String[] args){
		ForkJoinPool pool = new ForkJoinPool();
		int arr[] = CreateArray.makeArray();
		long start = System.currentTimeMillis();
		ForkJoinSumArray forkJoinSumArray = new ForkJoinSumArray(arr, 0, arr.length-1);
		pool.invoke(forkJoinSumArray);
		
		System.out.println("总共花费的时间为" + (System.currentTimeMillis()-start) + "ms");
		
	}

	@Override
	protected Integer compute() {
		if(lastNumber - firstNumber < LIMIT_SIZE){
			int count = 0;
			for(int i = firstNumber; i < lastNumber; i++ ){
				count+= arr[i];
//				try{
//				Thread.sleep(1);}catch(Exception e){}
			}
			
			return count;
		}else{
			int middle = (firstNumber + lastNumber)/2;
			ForkJoinSumArray left = new ForkJoinSumArray(arr, firstNumber, middle);
			ForkJoinSumArray right = new ForkJoinSumArray(arr, middle+1, lastNumber);
			
			invokeAll(left, right);
			return left.join()+right.join();
		}
	}
	
	
	
}
