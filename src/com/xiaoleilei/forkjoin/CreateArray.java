package com.xiaoleilei.forkjoin;

import java.util.Random;

/**
 * 生成一个随机整形数组
 * @author ly-leiwang
 *
 */
public class CreateArray {
	
	public static final int MAX_SIZE = 50000000;
	
	public static int[] makeArray(){
		int []array = new int[MAX_SIZE];
		Random r = new Random();
		for(int i = 0; i < MAX_SIZE; i++){
			array[i] = r.nextInt(MAX_SIZE*3);
		}
		return array;
	} 
}
