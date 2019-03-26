package com.xiaoleilei.forkjoin;

public class SumArray {
	
	public static void main(String []args) throws InterruptedException{
		int []array = CreateArray.makeArray();
		int result = 0;
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < array.length; i++){
			result += array[i];
		//	Thread.sleep(1);
		}
		
		System.out.println("普通循环相加总共花费了"+(System.currentTimeMillis()-start)+"ms");
	}
}
