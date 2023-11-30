/*
모든 자연수 x에 대해서 현재 값이 x이면 x가 짝수일 때는 2로 나누고, x가 홀수일 때는 3 * x + 1로 바꾸는 계산을 계속해서 반복하면 언젠가는 반드시 x가 1이 되는지 묻는 문제를 콜라츠 문제라고 부릅니다.
그리고 위 과정에서 거쳐간 모든 수를 기록한 수열을 콜라츠 수열이라고 부릅니다.
계산 결과 1,000 보다 작거나 같은 수에 대해서는 전부 언젠가 1에 도달한다는 것이 알려져 있습니다.
임의의 1,000 보다 작거나 같은 양의 정수 n이 주어질 때 초기값이 n인 콜라츠 수열을 return 하는 solution 함수를 완성해 주세요.
 */

package Solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Sol22 {
	

	public int[] solution(int n) {
		//1
//		return IntStream.concat(IntStream.iterate(n, i -> i>1,i ->
//       	 i%2 == 0 ? i/2 : 3*i+1), IntStream.of(1)).toArray();
		
		
		return IntStream.iterate(n, i -> i == 1 ? -1 : i%2==0 ? i/2 : i*3+1).takeWhile(j -> j != -1).toArray();
		

    }

	public static void main(String[] args) {
		Sol22 sol = new Sol22();

		int[] result = sol.solution(10);
		System.out.println(Arrays.toString(result));

	}

}
