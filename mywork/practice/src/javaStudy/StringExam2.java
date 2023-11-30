package javaStudy;

public class StringExam2 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		String str1 = "hello world";
		String str2 = str1.substring(5);
		
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = str1 + str2;
		System.out.println(str3);
		
		String str4 = new StringBuffer().append(str1).append(str2).toString(); //str3의 결과는 이렇게 내부적으로 좌측과 같은 방식으로 돌려 나오는거..
		System.out.println(str4);
		
		String str5 = "";
		
		for(int i = 0; i < 100 ; i++) {
			str5 += "*";
		}
			System.out.println(str5);// 반복문 한번돌떄마다 스트링버퍼를(new StringBuffer) 한번씩 만들어 냄. 자바는 new연산자가 많이 사용될 수록 프로그램이 느려짐. 좌측은 비효율적은 코드; 아래가 나음.
			
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i<100; i++) {
				sb.append("*");
				//이 코드가 훨씬 효과적임..
			}
			
			String str6 = sb.toString();
			System.out.println(str6);
			
			
	//문자열 반복문을 사용 시에는 이점을 유의할 것

	}

}
