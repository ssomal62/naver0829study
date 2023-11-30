package javaStudy;

public class MathExam {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		//최대값
		int Value1 = Math.max(4, 50);//스테틱한 매서드는 클랙스이름. < 이와같이 사용하면 됨
		System.out.println(Value1);
		//최소값
		int Value2 = Math.min(4, 50);
		System.out.println(Value2);
		
		//절대값
		System.out.println(Math.abs(-10));
		
		//랜덤
		System.out.println(Math.random());
		
		//제곱근(루트)
		System.out.println(Math.sqrt(25));
		
		
		//16의 1/2승
		System.out.println("pow[1] :"+Math.pow(16, 0.5));
		System.out.println("pow[2] :"+Math.pow(16, 1/2));//완전히 다른 결과.. 조심하자.
		System.out.println("pow[3] :"+Math.pow(16, (double)1/2));//double를 써줬더니 잘됐다

	}

}
