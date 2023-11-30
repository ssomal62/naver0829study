package thisIsJava.chapter17;

import java.util.ArrayList;
import java.util.List;

public class Ex6_ {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("홍길동");
		list.add("신용권");
		list.add("김자바");
		list.add("신용권");
		list.add("신민철");
		
		
		//1
		list.stream().forEach(System.out::println);
		System.out.println();
		
		//2
		list.stream().filter(i-> i.startsWith("신")).forEach(System.out::println);
		System.out.println();
		
		//3
		list.stream().distinct().filter(i -> i.startsWith("신")).forEach(System.out::println);
		
		
		
	}

}
