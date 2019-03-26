package com.xiaoleilei.dq;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 存放到队列的元素
 * @author ly-leiwang
 * @param <T>
 *
 */
public class ItemVo<T> implements Delayed{
	private long activeTime; //到期的时间,ms
	private T data;

	
	
	public ItemVo(long activeTime, T data) {
		super();
		this.activeTime = TimeUnit.NANOSECONDS.convert(activeTime, TimeUnit.MILLISECONDS) + System.nanoTime();
		this.data = data;
	}
	
	

	public long getActiveTime() {
		return activeTime;
	}


	public T getData() {
		return data;
	}


	@Override
	public int compareTo(Delayed o) {
		long d = getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS);
		return (d==0)?0:((d>0)?1:-1);
	}

	
	//返回元素剩余的时间
	@Override
	public long getDelay(TimeUnit unit) {
		long d = unit.convert(this.activeTime-System.nanoTime(), TimeUnit.NANOSECONDS);
		return d;
	}
	

}
