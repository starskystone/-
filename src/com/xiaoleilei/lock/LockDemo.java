package com.xiaoleilei.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	 private Lock lock = new ReentrantLock();
	
	 class Increment implements Runnable{

		@Override
		public void run() {
			// TODO 自动生成的方法存根
			
		}
		 
	 }
	
}
