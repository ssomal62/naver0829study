//정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
//각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 k보다 크면서 가장 작은 arr[i]를 찾습니다.
//각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
//단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.

package Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Sol19 {


	public int[] solution(int[] arr, int[][] queries){
		return IntStream.range(0,queries.length).map(i -> 
		IntStream.rangeClosed(queries[i][0], queries[i][1])
				.filter( j -> arr[j]> queries[i][2])
				.map(j -> arr[j])
				.min()
				.orElse(-1))
			.toArray();

	}
				


	public static void main(String[] args) {

		Sol19 sol = new Sol19();

		int[] arr = { 0, 1, 2, 4, 3 };
		int[][] queries = { { 0, 4, 2 }, { 0, 3, 2 }, { 0, 2, 2 } };
		int[] result = sol.solution(arr, queries);
		System.out.println(Arrays.toString(result));

	}

}


/*
		return IntStream.range(0, queries.length).mapToObj(i-> 
		IntStream.rangeClosed(queries[i][0], queries[i][1])
				.filter(j -> arr[j] > queries[i][2])
				.map(j -> arr[j])
				.min()
				.orElse(-1)
				)
				.collect(Collectors.toList());
*/