package com.xiaoleilei.threadpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 
 * @author ly-leiwang
 *
 */
public class ThreadPoolTest {
	int size;
	
	
	LinkedList<Connection> pool = new LinkedList<>();
	
	//数据库连接池初始化
	public ThreadPoolTest(int size){
		for(int i = 0; i < size ; i++){
			pool.addLast(ThreadPoolImp.fetchConnection());
		}
	}
	
	//从数据库链接池中获取数据库链接
	public Connection fetchConn(long time) throws InterruptedException{
		synchronized (pool) {
			if(time <= 0){
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			}
			
			else {
				long overtime = System.currentTimeMillis() + time;
				long remain = time;
				while(pool.isEmpty() && remain > 0){
					pool.wait(remain);
					remain = overtime - System.currentTimeMillis();
				}
				Connection connection = null;
				if(!pool.isEmpty()){
					connection = pool.removeFirst();
				}
				return connection;
			}
		}
	}
	
	public void releaseConn(Connection conn){
		if(conn != null){
			synchronized (pool){
				pool.addLast(conn);
				pool.notifyAll();
			}
		}
	}
	
}
