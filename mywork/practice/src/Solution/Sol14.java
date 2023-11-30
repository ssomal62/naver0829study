//정수 리스트 num_list가 주어질 때, 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 마지막 원소가 그전 원소보다 크지 않다면 
//마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.

package Solution;

import java.util.*;

public class Sol14 {
	
	int[] arr = {5, 2, 1, 7, 5};

    public int[] solution(int[] num_list) {
        int dis = num_list.length;
        int[] answer = Arrays.copyOf(num_list, dis+1);


        answer[dis] = num_list[dis-1] > num_list[dis-2] ? num_list[dis-1] - num_list[dis-2] : num_list[dis-1]*2;
        return answer;
    }

	public static void main(String[] args) {

		Sol14 sol = new Sol14();
		System.out.println(sol.solution(sol.arr));

	}

}
//스트림으로 할까 했지만.. 각 요소마다 반복되므로 비효율적임... 	