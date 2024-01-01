package Practice;

import java.util.Scanner;

public class Largestnum {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.err.println("enter three numbers:");
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int n3=sc.nextInt();
		if(n1>n2 && n1>n3) {
			System.out.println(n1 + " is greater");
		}
		else if(n2>n1 && n2>n3) {
			System.out.println(n2+" is greater");
		}
		else {
			System.out.println(n3 +" is greater");
		}
	}

}
