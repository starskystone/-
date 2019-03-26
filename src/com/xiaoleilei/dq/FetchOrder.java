package com.xiaoleilei.dq;

import java.util.concurrent.DelayQueue;

public class FetchOrder implements Runnable{
	
	DelayQueue<ItemVo<Order>> queue = new DelayQueue<>();
	
	
			
	public FetchOrder(DelayQueue<ItemVo<Order>> queue) {
		super();
		this.queue = queue;
	}



	@Override
	public void run(){
		while(true){
			try {
				ItemVo<Order> item = queue.take();
				Order order = item.getData();
				System.out.println("从队列里面拿到的数据为" + order.getOrderNumber());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
