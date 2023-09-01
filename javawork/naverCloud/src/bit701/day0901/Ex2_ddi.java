package bit701.day0901;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex2_ddi {

	public static void main(String[] args) {
	
		//닭띠가 1
		Scanner sc = new Scanner(System.in);
		LocalDate carrentDate = LocalDate.now();
		System.out.printf("연도 입력 >> ");
		
		int year = sc.nextInt();
		int m = year % 12;
		
		String ddi = m == 1 ? "닭" : m == 2 ? "개" : m == 3 ? "돼지" : m == 4 ? 
				"쥐" : m == 5 ? "소" : m == 6 ? "호랑이" : m == 7 ? "토끼" : m == 8 ? 
				"용" : m == 9 ? "뱀" : m == 10 ? "말" : m == 11 ? "양" :"원숭이" ;

		System.out.println(year + "년은 " +ddi + "의 해입니다.");
		
		
	}

}
