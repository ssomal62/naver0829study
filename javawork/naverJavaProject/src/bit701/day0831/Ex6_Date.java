package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex6_Date {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 입력한 연, 월, 일에서 요일구하기

		int year = sc.nextInt();
		int month = sc.nextInt();
		int day = sc.nextInt();

		Date date = new Date(year-1900, month-1,day);
		
		int weekint = date.getDay();
		System.out.println("요일숫자 :" + weekint);
		
		String week = weekint == 0? "일" : weekint==1?"월":weekint==2?"화":weekint==3?"수":weekint==4?"목":weekint==5?"금":"토";
		System.out.println(week + "요일입니다.");
		
		

	}

}
