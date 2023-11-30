package Solution;

public class Sol08 {
	public int solution(int a, int b, boolean flag) {

		int answer = 0;

		return Boolean.valueOf(flag) ? a + b : a - b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sol08 sol = new Sol08();
		
		System.out.println(sol.solution(4, 11, true));

	}

}
