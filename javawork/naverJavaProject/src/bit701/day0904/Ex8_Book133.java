package bit701.day0904;

import java.io.IOException;

public class Ex8_Book133 {

	
	public static void main(String[] args) throws IOException {
		
	
		
		try{
		int a = 	3/0;
		System.out.println(a);
		}catch(Exception e) {
			System.err.println("[에러색상 테스트] // 회색으로 나옵니다 ㅠ");
			System.err.println(e.toString());		//오류가 .. 회색이라 ^^;;
		
		}
		
		System.out.println("정상출력 색 테스트 : 요런색상입니다.");
		
		int keyCode = System.in.read();
		if(keyCode == 13) {
			System.out.println("엔터누름");	//다른 문자일 경우 enter를 누르기 전까지 대기상태임! 엔터 누르면 값을 읽어옴
		}else {
			System.out.println("다른거 누름");
		}

		
	
	}
}
