package Practice;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class mythread implements Runnable{
//	public void mt() {
//		System.out.println("hi");
//	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() +" start");
		System.out.println("hi");
		System.out.println(Thread.currentThread().getName()+ "end");
		
	}
	
	//task method t1
	
	
}
public class Threads {
	public static void main(String[] args) {
		mythread uploadRunnable=new mythread();
		ExecutorService exServicePool= Executors.newFixedThreadPool(2);
		exServicePool.execute(uploadRunnable);
		exServicePool.execute(uploadRunnable);
		
		
		//or  without implememting runnable int
//		Runnable r=()-> obj.t1();
//		Thread th=new Thread(r);
//		ExecutorService es=Executors.newSingleThreadExecutor();
//		es.execute(r);
	}
	

}
