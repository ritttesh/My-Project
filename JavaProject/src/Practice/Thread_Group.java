package Practice;

public class Thread_Group {
	public static void main(String[] args) {
		 ThreadGroup tg=new  ThreadGroup("thrdgrp");
		   Runnable r=()-> System.out.println(Thread.currentThread().getName());
		   var tg1=new Thread(tg, r,"one" );
		   var tg2=new Thread(tg, r,"two" );
		   var tg3=new Thread(tg, r,"three" );
		   
		   tg1.start();
		   tg2.start();
		   tg3.start();
		   tg.list();
	}
}
