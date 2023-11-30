package thisIsJava.chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex8_FlatMappingExample {

	public static void main(String[] args) {

		List<String> list1 = new ArrayList<>();

		list1.add("this is java");
		list1.add("i am a best developer");

		list1.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(word -> System.out.println(word));
		System.out.println();

		List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");

		// flatMap은 내부반환이 아니라 평면화이다.
		// 항시 반환되는 타입이 잘 맞아야 함.. 이것이 어렵도다 ㅠㅠ
		
		list2.stream().flatMapToInt(data -> //Stream<String> 으로 시작 
		{ 
			String[] strArr = data.split(", ");
			
			int[] intArr = new int[strArr.length];
			
			for (int i = 0; i < strArr.length; i++) 
				intArr[i] = Integer.parseInt(strArr[i].trim());
				
			return Arrays.stream(intArr);  //Stream<Integer> 반환
		})
		.forEach(System.out::println);
		
		

	}

}
