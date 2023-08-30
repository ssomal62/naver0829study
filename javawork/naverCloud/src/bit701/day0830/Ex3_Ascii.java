package bit701.day0830;

public class Ex3_Ascii {

	public static void main(String[] args) {

		//char과 int는 같은 타입이라고 봐도 된다.
		
		char a1 = 65;
		int a2 = 'B';
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println((int)a1);
		System.out.println((char)a2);
		
		System.out.printf("%d 의 아스키문자는 %c이다.%n", a2,a2);
		                                                 // ^ a1,a1이 안되는 이유 : char-> int로 넣을 수 없기 때문. int를 char로는 가능.
		
		char b1 = 'C';
		int b2 = 68;
		System.out.println((char)(b1+3)); //묵시적 형변환 > byte 단위가 더 큰 타입으로 자동변환됨.
 
		
	    /* 묵시적 형변환
	     * 
	     * char + int = int
	     * int + int = int
	     * long + int = long
	     * double + int = double
	     * String + int = String
	     * String + double = String
	     * 
	     * 묵시적 형변환 외 강제 형변환 가능
	     */
		
		
		
		System.out.println(5/2); //2
		System.out.println(5.0/2); //2.5
		System.out.println((double)5/2); //2.5
		System.out.println((double)(5/2)); //2.0
		
	}

}
