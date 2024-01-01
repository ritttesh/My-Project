package Junit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.openqa.selenium.grid.Main;

public class dem {
	public static void main(String[] args) {
		Date date =new Date();
		System.out.println(date);
		DateFormat dt=new SimpleDateFormat("E, MMMM dd,yyyy");
		System.out.println(date.getDay());
		//System.out.println(
		//date.setDate(13);
		System.out.println(date);
		String dat=dt.format(date);
		System.out.println(dat);
//		String prs="4035.00";
//		System.out.println("*");
//		System.out.println(Integer.valueOf(prs.substring(0,prs.length()-3)));
//		if(Math.round(Integer.valueOf(prs))==4035) {
//			System.out.println("converted");
//			System.out.println(Integer.valueOf(prs));
//		}
		System.out.println(date.getMonth());
		boolean res=Pattern.matches("^[a-z_]{6}[_0-9]{7}[.]{1}[a-z]{3}$","order_1317694.pdf");
		System.out.println(res);
	}

}
