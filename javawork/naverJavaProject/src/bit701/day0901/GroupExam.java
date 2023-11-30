package bit701.day0901;

import java.util.stream.IntStream;

public class GroupExam {
	public static void main(String[] args) {

		int max = 6;
		int min = 1;
		int step = 2;
		String star = "*";
		boolean checkMax = true;

		/*
		 * for (int i = 0; i < 2; i++) { if (checkMax) { for (int j = min; j < max; j +=
		 * step) { System.out.println(star.repeat(j)); } checkMax = !checkMax; } else
		 * if(!checkMax) { if(max% 2 == 0) max+=1; for (int j = max; j >= min; j -=
		 * step) { System.out.println(star.repeat(j)); } }
		 * 
		 * }
		 */

		/*
		 * IntStream.rangeClosed(0, 4) .mapToObj(i -> "*".repeat(2 * i + 1))
		 * .forEach(System.out::println);
		 * 
		 * IntStream.rangeClosed(-3, 0) .mapToObj(i -> Math.abs(i)) //절대값 함수 .map(i ->
		 * "*".repeat(2 * i + 1)) .forEach(System.out::println);
		 */
		
		IntStream.rangeClosed(0, 4)
		.mapToObj(i -> Math.abs(i)) //절대값 함수
        .map(i -> "*".repeat(2 * i + 1))
        .forEach(System.out::println);

	}

}
