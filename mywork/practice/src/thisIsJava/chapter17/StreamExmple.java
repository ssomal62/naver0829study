package thisIsJava.chapter17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExmple {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		set.add("홍길동");
		set.add("홍길동");
		set.add("신용권");
		set.add("김자바");
		
		Stream<String> stream = set.stream();
		stream.forEach(System.out::println);

		
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		// Stream.of(list) 방식
		Stream<List<Integer>> stream1 = Stream.of(integerList);
		
		// list.stream() 방식
		Stream<Integer> stream2 = integerList.stream();
		
		
		
		
		/*
		 * Stream.of(list)와 list.stream()은 두 가지 다른 방식으로 리스트를 스트림으로 변환하는 것을 나타냅니다. 
		 * 여기에는 두가지 주요 차이점이 있습니다:
		 * 
		 * <메소드 호출 방식>	 
		 * 
		 * Stream.of(list): Stream.of() 메소드는 주어진 인수를 사용하여 스트림을 생성합니다. 여기서 list는 스트림의 요소로
		 * 포함됩니다. list.stream(): stream() 메소드는 리스트 객체 자체에서 직접 호출됩니다. 이것은 리스트 객체의 메소드로
		 * 스트림을 생성하는 것이므로 객체 지향적인 방식입니다. 
		 * 
		 * <타입 추론>	 
		 * 
		 * Stream.of(list)을 사용하면 스트림의 요소 타입을 추론하기 어렵습니다. 스트림의 요소 타입은 주어진 인수의 타입에 따라
		 * 결정됩니다. list.stream()을 사용하면 리스트의 요소 타입이 명확하게 알려져 있으므로 자동으로 타입이 추론됩니다. 이렇게 하면
		 * 코드가 더 명확하고 유지보수가 쉬워집니다.
		 * 
		 */
	}

}
