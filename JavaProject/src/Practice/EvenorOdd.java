package Practice;

import java.util.Scanner;

public class EvenorOdd {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.err.println("enter a numbers:");
		int n1=sc.nextInt();
		if(n1%2==0) {
			System.out.println("the number is even");
		}
		else {
			System.out.println("the number is odd");
		}
		
	}

}
