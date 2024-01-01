package Practice;

import java.util.Arrays;
import java.util.List;

public class ProductComp {
	public static void main(String[] args) {
		List<String> products=Arrays.asList("ram","laxman","satrughna","bharat");
		products.sort(new ProductAccComparator());
		System.out.println("accending order");
		for(String product:products) {
			System.out.println(product);
		}
		
		products.sort(new ProductDesComparator());
		System.out.println("decending order");
		for(String product:products) {
			System.out.println(product);
		}
		
		//with the help of lambda exp
		products.sort((String p1,String p2)-> p1.compareTo(p2));
		for(String product:products) {
			System.out.println(product);
		}
	}

}
