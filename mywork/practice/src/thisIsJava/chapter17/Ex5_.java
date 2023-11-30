package thisIsJava.chapter17;

import java.util.stream.IntStream;

public class Ex5_ {
	
	public static int sum1;
	
	public static void main(String[] args) {
		
		IntStream stream = IntStream.rangeClosed(1, 100);
		int sum = stream.sum();
		System.out.println(sum);	
		
		
		stream = IntStream.rangeClosed(1, 100);
		stream.forEach(i -> sum1 += i );
		
		
		System.out.println(sum1);
	}

}
