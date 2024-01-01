package Practice;

import java.awt.Component.BaselineResizeBehavior;

class Balance{
	int availablebal=1000;
	public synchronized void  getBalance(int b) {
		System.out.println("initial bal " + availablebal);
		availablebal=b+availablebal;
		
		System.out.println("final bal " + availablebal);
		
	}
}
public class Syncronized {
	public static void main(String[] args) {
		Balance bal=new Balance();
		
		Runnable r1= () -> bal.getBalance(2000);
		Runnable r2= () -> bal.getBalance(2000);
		
		Thread th1=new Thread(r1);
		Thread th2=new Thread(r1);
		
		th1.start();
		th2.start();
	}
	
	
	
}
