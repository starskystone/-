package com.xiaoleilei.join;

public class TestJoin {

	public static void main(String[] args) throws InterruptedException{
		
		Thread previous = Thread.currentThread();		//现在是主线程
		
		for(int i = 0; i <10; i++){
			Thread thread = new Thread(new MyThread(previous),String.valueOf(i));
			System.out.println(previous.getName() +"插队在" + thread.getName());
			
			thread.start();
			
			previous = thread;
			
		}
		
		Thread.sleep(2000);
		
	}
	
}

class MyThread implements Runnable{
	Thread thread = new Thread();
	 public MyThread(Thread thread) {
		this.thread = thread;
	}
	
	
	@Override
	public void run() {
		try {
			System.out.println(thread.getName() + "将要插队到" +Thread.currentThread().getName());
			thread.join();			//此线程进行插队
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
