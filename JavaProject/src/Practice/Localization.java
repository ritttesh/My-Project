package Practice;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Localization {
	public static void main(String[] args) throws ParseException {
		Locale locale = Locale.getDefault(); //en_US : language(L)_country(U)
		System.out.println(locale);
//		System.out.println(new Locale("fr")); // fr
//		System.out.println(new Locale("hi", "IN")); // hi_IN
		
		
		//builder
		Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
		Locale l2 = new Locale.Builder().setRegion("IN").setLanguage("hi").build();
		System.out.println(l2);
		
		
		Locale.setDefault(new Locale("in")); // change the default
		System.out.println(Locale.getDefault()); // fr
		
		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;
		var us = NumberFormat.getInstance(Locale.US);
		System.out.println(us.format(attendeesPerMonth));
		var gr = NumberFormat.getInstance(Locale.GERMANY);
		System.out.println(gr.format(attendeesPerMonth));
		var ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		System.out.println(ca.format(attendeesPerMonth));
		
		
		String s = "40.45";
		var en = NumberFormat.getInstance(Locale.US);
		System.out.println(en.parse(s)); // 40.45
		var fr = NumberFormat.getInstance(Locale.FRANCE);
		System.out.println(fr.parse(s)); // 40

		
		double d = 1234567.467;
		NumberFormat f1 = new DecimalFormat("###,###,###.0");  //#->omit if digit not exist 0-> add zero if digit not exist
		System.out.println(f1.format(d)); // 1,234,567.5
		NumberFormat f2 = new DecimalFormat("000,000,000.00000");
		System.out.println(f2.format(d)); //001,234,567.46700
		NumberFormat f3 = new DecimalFormat("$#,###,###.##");
		System.out.println(f3.format(d)); // $1,234,567.47
	}
}
