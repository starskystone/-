package com.xiaoleilei.dq;

import java.util.concurrent.DelayQueue;

public class PutOrder implements Runnable{

	public DelayQueue<ItemVo<Order>> queue = new DelayQueue<>();
	
	public PutOrder(DelayQueue<ItemVo<Order>> queue) {
		super();
		this.queue = queue;
	}



	@Override
	public void run() {
		Order orderTb = new Order("tb123",100);
		ItemVo<Order> itemVoTb = new ItemVo<Order>(5000, orderTb);
		queue.offer(itemVoTb);
		System.out.println("订单5秒后到期："+orderTb.getOrderNumber());
		
		Order orderJd = new Order("jd321",200);
		ItemVo<Order> itemVoJd = new ItemVo<Order>(8000,orderJd);
		queue.offer(itemVoJd);
		System.out.println("订单8秒后到期："+orderJd.getOrderNumber());
	}

}
 