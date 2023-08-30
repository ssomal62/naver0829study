package bit701.day0830;

public class Ex2_Data {
	
	public static void main(String[] args) {
		
		//args 불러오기
		//Run Configuration에서 args 입력
		System.out.println("내이름은 " + args[0] + "입니다.");
		System.out.println("내사랑 " + args[1] + "!");
		System.out.println("내 혈액형은 " + args[2] + "형 입니다.");
		
		float pi1 = 0.123456789123456789f; //정밀도 : 소수점 이하 8자리까지 (마지막 반올림 있음)
		double pi2 = 0.123456789123456789; //정밀도 : 소수점 이하 15자리까지 (마지막 반올림 원래 없음?!)
		System.out.println(pi1 + " " + pi2 );
		
		char ch1 = 'A';
		char ch2 = '귤';
		
		System.out.println(ch1 + " " + ch2);
		
	}

}
