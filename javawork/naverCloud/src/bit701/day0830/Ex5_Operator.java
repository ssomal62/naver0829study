package bit701.day0830;

public class Ex5_Operator {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 5;
		++a;
		System.out.println(a);
		b++;
		System.out.println(b);
		
		System.out.println(++a);
		System.out.println(b++);//선출력 후연산 
		System.out.println("a : " + a + ", b : " + b);
		
		// 증감연산자 : ++(1씩 증가), -- (1씩 감소)
		// 변수 앞에 붙일 경우 1순위 (전치) ++a
		// 변수 뒤에 붙일 경우 끝순위 (후치) a++
		// 단, 단항으로 사용할경우 상관없다.
		
		a=b=5;
		int m = ++a;
		int n = b++; // 'b++'에서 '++'은 대입연산자 '='보다 후연산 ! 그래서 n에 대입 후 b값 증가 !
		
		System.out.printf("a=%d,b=%d,m=%d,n=%d",a,b,m,n);
		

	}
}
