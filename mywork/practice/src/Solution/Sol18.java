//수열과 구간 쿼리 3
//정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. queries의 원소는 각각 하나의 query를 나타내며, [i, j] 꼴입니다.
//각 query마다 순서대로 arr[i]의 값과 arr[j]의 값을 서로 바꿉니다.
//위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.

package Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sol18 {
	//희표좌 답
	 public List<Integer> solution(int[] arr, int[][] queries) {
		 List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		 
		 for (int[] query : queries) {
			 Collections.swap(list,query[0] , query[1]);
		 }
		 return list;
		 
	 }
	 
	public static void main(String[] args) {	
		Sol18 sol = new Sol18();

		int[][] queries = {{0,3},{1,2},{1,4}};
    	int[] arr = {0,1,2,3,4};
    	//희표좌 답 구현
    	List<Integer> list = sol.solution(arr, queries);
    	System.out.println(list.toString());
    	
    	
//		for(int[] query : queries) {
//			int temp = arr[query[0]];
//			arr[query[0]] = arr[query[1]];
//			arr[query[1]] = temp;
//		}
//		
//		System.out.println(Arrays.toString(arr));
		
		
		
		
	}
}
