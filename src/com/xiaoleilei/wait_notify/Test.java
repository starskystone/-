package com.xiaoleilei.wait_notify;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {

	public static void main(String[] args) {
		long timeInterval =1000*10;// 24 * 60 * 60 * 1000;//一天的间隔
		Date date = Test.getTime();
		Timer timer = new Timer();
		
			timer.schedule(new TimerTask() {
		        public void run() {
		            System.out.println("11232");
		            System.out.println("指定时间为："+date);
		            //TODO 业务代码
		        }
		}, date,timeInterval);
		
		
	}
	
	public static Date getTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),14,10,0);
        Date time = calendar.getTime();
        
        return time;
    }

}
