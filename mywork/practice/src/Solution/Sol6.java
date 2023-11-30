package Solution;

public class Sol6 {
	public int solution(int n) {
		int answer = 0;
		if (n % 2 == 0)
			for (int i = 0; i <= n; i += 2)
				answer += Math.pow(i, 2);

			else
				for (int i = 1; i <= n; i += 2)
				answer += i;
		// 와 한줄쓰기.. 이게 되네?

		return answer;
	}

	public static void main(String[] args) {

		Sol6 sol = new Sol6();
		System.out.println(sol.solution(10));

		// TODO Auto-generated method stub

	}

}
