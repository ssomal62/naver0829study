package bit701.day0906;

import java.util.stream.Stream;
import static  java.util.Comparator.comparing;

import java.util.Arrays;

public class Ex5_ArrayMax {

	
	public static void main(String[] args) {
		
		int[] data;
		
		data = new int[] {5, -100, 67, 89, 45, -9, 123, 58, 110, 200};
		
		Stream str = Stream.of(data);
		
		int min = Arrays.stream(data).min().orElse(0);
		int max = Arrays.stream(data).max().orElse(min);
		
		//반드시 orElse를 붙여야함.
		
		System.out.println(min);
		System.out.println(max);
		
		
		
		
		
		
	}
}
