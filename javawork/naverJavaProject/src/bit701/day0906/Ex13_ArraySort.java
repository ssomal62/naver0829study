package bit701.day0906;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex13_ArraySort {
	public static void main(String[] args) {

		int[] data = { 5, 3, 2, 4, 1 };

		for (int i = 0; i < data.length - 1; i++) {

			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {   //부등호 반대로하면 정렬 반대로 됨.
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}

		}


		for (int i : data) {
			System.out.print(i);
		}
		System.out.println();
		
		Arrays.stream(data).sorted().forEach(System.out::print);
		IntStream arr = Arrays.stream(data);
		arr.sorted().forEach(System.out::print);

	}
}
