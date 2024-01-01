package Rough;

import java.util.Scanner;

public class Doublets {
	public static void main(String[] args) {
		//		Scanner s = new Scanner(System.in);
		//        String inputString = s.nextLine();
		String inputString="toaster boaster boastel coaster postal";
		//String inputString="boxstar boaster boestel coalter postal";
		String[] arr=inputString.split(" ");
		int c=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				System.out.print(arr[i] + " "+ arr[j]);
				if(arr[i].length()== arr[j].length()){
					
					int k=0,f=0;
					while(k<arr[i].length()){
						if(arr[i].charAt(k) == arr[j].charAt(k)){
							continue;
						}
						else {
							f++;
						}
						if(f==1 ){
							if(arr[i].substring(k+1,arr[i].length()).equals(arr[j].substring(k+1,arr[j].length()))){
								System.out.print(arr[i]+":"+arr[j]+",");
								c++;
								//break;
							}     
						}
//						if(f==1) {
//							System.out.print(arr[i]+":"+arr[j]+",");
//						}
						k++;
					}
				}           
			}
		}
		if(c==0){
			System.out.println(-1);
		}
	}
}


