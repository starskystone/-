package com.xiaoleilei.wait_notify;

/**
 * 快递运输实例
 * 
 * @author ly-leiwang
 *
 */
public class TestWN extends Thread {
	
	private int miles;
	private String area;
	
	public TestWN(int miles,String area){
		this.miles = miles;
		this.area = area;
	}

	public synchronized void notifyMiles(){
		try {
			this.miles = 101;
			notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void notifyArea(){
		try {
			this.area = "beijing";
			notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void judgeMiles(){
		
		while(miles <= 100){
			try {
				System.out.println("this thread is waiting");
				wait();
				System.out.println("this thread is not waiting");
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("this thread has being notified");
		}
	}
	
	public synchronized void judgeArea(){
		while("shanghai".equals(area)){
			try {
				System.out.println("this thread is waiting");
				wait();
				System.out.println("this thread is not waiting");
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("this thread has being notified");
		}
	}
}
