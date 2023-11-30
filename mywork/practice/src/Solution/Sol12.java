//정수가 담긴 리스트 num_list가 주어질 때, 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.



package Solution;
import java.util.Arrays;

public class Sol12 {

	int[] arr = { 5, 7, 8, 3 };

	public int solution(int[] num_list) {
		int answer;
		int sum = 0, times = 1;

		for (int i : num_list) {
			sum += i;
			times *= i;
		}

		answer = times < Math.pow(sum, 2) ? 1 : 0 ;		
		
		//===========희표좌 답=============//
		sum = 0; times = 1;
		sum += Math.pow(Arrays.stream(num_list).sum(), 2);
		times =  Arrays.stream(num_list).reduce((acc,i) -> acc*i).getAsInt();
		answer = times < sum ? 1 : 0;	
		//=============================//
		
		return answer;
	}
	

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol12 sol = new Sol12();

		System.out.println(sol.solution(sol.arr));
	}

}
