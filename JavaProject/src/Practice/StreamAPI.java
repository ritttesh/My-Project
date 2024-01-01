package Practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
	public static void main(String[] args) {
		//stream from values
		Stream<String> stream=Stream.of("ram","sita","bharat","laxman");
		
		//stream of collection
		List<String> list=List.of("ram","sita","bharat","laxman");
		Stream<String> liststream=list.stream();
	
		//stream from array
		String[] arr={"ram","sita","bharat","laxman"};
		Stream<String> arraystream=Arrays.stream(arr);
		
		
		int[] arr1= {10,20,30,40,50,60,70,80,90};
		List<Integer> list1=Arrays.asList(77,13,76,20,55,30,40,43,98);
		Arrays.stream(arr1).filter(e-> e>30).sorted().map(n1 -> n1+1).forEach(a1-> System.out.println(a1));
		
		int res=Arrays.stream(arr1).filter(e-> e>30 ).sorted().reduce(0,(n1,n2)-> n1+n2);
	}

}
