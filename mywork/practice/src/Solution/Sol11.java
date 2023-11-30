//1부터 6까지 숫자가 적힌 주사위가 세 개 있습니다. 세 주사위를 굴렸을 때 나온 숫자를 각각 a, b, c라고 했을 때 얻는 점수는 다음과 같습니다.
//세 숫자가 모두 다르다면 a + b + c 점을 얻습니다.
//세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다르다면 (a + b + c) × (a^2 + b^2 + c^2 )점을 얻습니다.
//세 숫자가 모두 같다면 (a + b + c) × (a^2 + b^2 + c^2 ) × (a^3 + b^3 + c^3 )점을 얻습니다.
//세 정수 a, b, c가 매개변수로 주어질 때, 얻는 점수를 return 하는 solution 함수를 작성해 주세요.

package Solution;

public class Sol11 {
	public int solution(int a, int b, int c) {
		int answer = 1;
		int count = 1;
		
		if ( a==b || b==c || a ==c )
			count++;
			
		if ( a==b && b==c )
			count++;
		

		for (int i = 1; i <= count; i++) 
			answer *= pow(a,i) + pow(b,i) + pow(c,i);
		
		
		return answer;
	}

	
	// pow 설정 1
	private int pow (int x, int y) {
		int result = 1;
		for (int i = 1; i <= y; i++)
			result *= x;
		return result;
	}
	// pow 설정 2	// 내 머리로는 어렵다아..
//	private int pow (int x, int y) {
//		if (y==0) return 1;
//		return  x * pow(x, y-1); //재귀함수인가??
//	}
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol11 sol = new Sol11();
		System.out.println(sol.solution(4, 4, 4));
	}

}
