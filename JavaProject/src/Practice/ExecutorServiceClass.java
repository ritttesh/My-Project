package Practice;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceClass {
	public static void main(String[] args) {
		ExecutorService eservice1=Executors.newSingleThreadExecutor();
		Runnable r1=()-> System.out.println("Running task one"+ Thread.currentThread().getName());
		Runnable r2=()-> System.out.println("Running task two"+ Thread.currentThread().getName());
		eservice1.execute(r1);
		//eservice.shutdown(); // shutdown all thread not accept any thread and complete existing thread task
		eservice1.execute(r2);
		
		
		ScheduledExecutorService eservice2=Executors.newSingleThreadScheduledExecutor();
		System.out.println("start time "+LocalTime.now());
		Runnable r3=()-> System.out.println("Running task three "+"time "+LocalTime.now());
		Runnable r4=()-> System.out.println("Running task four "+ "time "+LocalTime.now());
		eservice2.schedule(r3, 5, TimeUnit.SECONDS);
		eservice2.schedule(r4, 10, TimeUnit.SECONDS);
		eservice2.shutdown();
		
		
		//fixed thread pool :create thread  number
		ExecutorService eservice3=Executors.newFixedThreadPool(3); //newScheduleThreadPool(3);
		Runnable r5=()-> System.out.println("task-5 "+ Thread.currentThread().getName());
		Runnable r6=()-> System.out.println("task-6 "+ Thread.currentThread().getName());
		eservice3.execute(r5);
		eservice3.execute(r6);
		
		//cashed thread: it will create new thread for task can reused if avialble
		ExecutorService eservice4=Executors.newCachedThreadPool();
		Runnable r7=()-> System.out.println("task-7 "+ Thread.currentThread().getName());
		Runnable r8=()-> System.out.println("task-8 "+ Thread.currentThread().getName());
		eservice3.execute(r7);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eservice3.execute(r8);
		
		//newScheduledThreadPool();
		//
		
	}
}
