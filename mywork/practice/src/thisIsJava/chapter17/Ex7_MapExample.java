package thisIsJava.chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ex7_MapExample {

	public static void main(String[] args) {

		List<Ex7_Student> stuList = new ArrayList<>();

		stuList.add(new Ex7_Student("홍길동", 85));
		stuList.add(new Ex7_Student("홍길동", 92));
		stuList.add(new Ex7_Student("홍길동", 87));
		

		stuList.stream().map(Ex7_Student::getScore).forEach(System.out::println);
		stuList.stream().mapToInt(Ex7_Student::getScore).forEach(System.out::println);

		int[] intArray = { 1, 2, 3, 4, 5 };
		
		IntStream intStream = Arrays.stream(intArray);
		
		intStream.asDoubleStream().forEach(System.out::println);

		intStream = Arrays.stream(intArray);
		intStream.boxed().forEach(System.out::println);
		
		
		
		
	}

}
