package StreamPractice;

import java.util.stream.IntStream;

public class Practice_01 {

	public static void main(String[] args) {

		// 구구단.. 만들어볼까?

		IntStream.rangeClosed(2, 9).forEach(i -> 
			IntStream.rangeClosed(1, 9)
			.forEach(j -> System.out.printf("%d x %d = %d\n", i, j ,i*j))
		);

	}

}
