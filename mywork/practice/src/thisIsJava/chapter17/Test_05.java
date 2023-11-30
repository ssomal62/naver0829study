package thisIsJava.chapter17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Test_05 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");
		
		IntStream.range(0, list.size()).filter(i -> i%2 == 0).mapToObj(list::get).forEach(System.out::println);
		
		
		//인트스트림으로 접근해서 중간에 리스트로 접목시킬 수 있다는 것에 굉장히 놀랐다.

	}

}
