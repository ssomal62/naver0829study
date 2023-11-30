/*
정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 i가 k의 배수이면 arr[i]에 1을 더합니다.
위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.
 */

package Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Sol20 {
	
	public int[] solution(int[] arr, int[][] queries) {
		IntStream.range(0, queries.length).forEach(i-> 
		IntStream.rangeClosed(queries[i][0], queries[i][1])
		.filter(j-> j % queries[i][2]==0)
		.forEach(j-> arr[j]+=1));
		
		return arr;
    }
	public static void main(String[] args) {
		Sol20 sol = new Sol20();
		
		int[] arr = { 0, 1, 2, 4, 3 };
		int[][] queries = { { 0, 4, 1 }, { 0, 3, 2 }, { 0, 3, 3 } };
		
		int[] result = sol.solution(arr, queries);
		System.out.println(Arrays.toString(result));
		
	}

}





/*
    public int[] solution(int[] arr, int[][] queries) {
    	IntStream.range(0, queries.length)
    	.forEach(i -> IntStream.rangeClosed(queries[i][0], queries[i][1])
    			.filter(j -> j % queries[i][2] == 0)
    			.forEach(j -> arr[j] += 1));

    	return arr;
*/