package tools;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.xiaoleilei.SleepTools;

public class UseFuture {
	
	public static class UseCallable implements Callable<Integer>{

		@Override
		public Integer call() throws InterruptedException {
			System.out.println("子线程开始运行");
			Thread.sleep(2000);
			int result = 0;
			for(int i = 0; i < 5000;i++){
				result += i;
			}
			System.out.println("子线程运行结束，结果为:"+result);
			return result;
		}
		
	}
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO 自动生成的方法存根
		UseCallable useCallable = new UseCallable();
		FutureTask<Integer> futureTask = new FutureTask<>(useCallable);
		new Thread(futureTask).start();
		Random r = new Random();
		SleepTools.second(1);
		if(r.nextBoolean()){
			System.out.println("子线程执行结果为"+futureTask.get());
		}else{
			System.out.println("中断");
			futureTask.cancel(true);
		}

	}

}


