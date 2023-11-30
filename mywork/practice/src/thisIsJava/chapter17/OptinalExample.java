package thisIsJava.chapter17;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public class OptinalExample {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		
		
		OptionalDouble optional = list.stream().mapToInt(Integer::intValue).average();
		
		if(optional.isPresent()) {
			System.out.println("방법 1 평균 : " + optional.getAsDouble());
		}else {
			System.out.println("방법 1 평균 : 0.0");
		}
		
		
		double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		System.out.println(avg);
		
	list.stream().mapToInt(Integer::intValue).average().ifPresent(a-> System.out.println("? :"  + a));
		
	
	System.out.println("=".repeat(40));
		
		Map<Integer,String> testMap = new HashMap<>();
		
		testMap.put(1,"사과");
		testMap.put(2,"딸기");
		testMap.put(3,"메론");
		
		for(Map.Entry<Integer,String> entry : testMap.entrySet()) {			
			System.out.println(entry.getKey()  + ":" +entry.getValue());
		}
		
		
		


		

		
	}

}
