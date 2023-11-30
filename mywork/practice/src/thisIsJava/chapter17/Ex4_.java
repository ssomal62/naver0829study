package thisIsJava.chapter17;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex4_ {
	public static void main(String[] args) {
		
		String[] strArray = {"홍길동","신용권","김미나"};
		
		int[] intArray = { 1, 2, 3, 4, 5};
		
		Arrays.stream(strArray).forEach(System.out::print);
		System.out.println();
		String arr = Arrays.stream(strArray).collect(Collectors.joining(", "));
		System.out.println(arr);
		
		Arrays.stream(intArray).forEach(i -> System.out.print(i + ", "));
		
		System.out.println();
		
	}
}
