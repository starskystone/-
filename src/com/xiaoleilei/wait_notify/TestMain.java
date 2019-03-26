package com.xiaoleilei.wait_notify;

public class TestMain {

	static TestWN test = new TestWN(0, "shanghai");
	
	private static class CheckMiles extends Thread{
        @Override
        public void run() {
        	test.judgeMiles();
        }
    }
	
	private static class CheckArea extends Thread{
        @Override
        public void run() {
        	test.judgeArea();
        }
    }
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 3; i++){
			new CheckArea().start(); //开启三个执行wait地点的线程
		}
		
		for(int i = 0; i < 3; i++){
			new CheckMiles().start(); //开启三个执行距离的线程
		}
		
		Thread.sleep(3000);
		
		test.notifyArea();
	}

}
