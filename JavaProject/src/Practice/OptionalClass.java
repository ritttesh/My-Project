package Practice;

import java.util.Optional;

public class OptionalClass {
	public static void main(String[] args) {
        // uncomment the below code to understand the way to create the optional object
		String s=null;
		String s1="Java";
		//Empty
		Optional<String >obj=Optional.empty();
		System.out.println(obj);
		
		//Of
		Optional<String >obj1=Optional.of(s1);
		System.out.println(obj1);
		//Uncomment the below line and see the output
//		Optional<String >obj2=Optional.of(s);
//		System.out.println(obj2);
		
		
		//OfNullable
		Optional<String >obj3=Optional.ofNullable(null);
		System.out.println(obj3);
		Optional<String >obj4=Optional.ofNullable(s1);
		System.out.println(obj4);
		Optional<String >obj5=Optional.ofNullable(s);
		//Uncomment the below line and see the output
//		System.out.println(obj5.get());
		
		
		//isPresent
		if(obj5.isPresent())
			System.out.println(obj5.get());
		
		
		// OrElse 
		System.out.println(obj5.orElse("Default value"));
    }
}
