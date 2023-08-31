package bit701.day0831;

import java.util.Scanner;

public class Ex9_SwtichWeek {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 연도와 월을 입력하면 몇일까지 있는지 출력해보자.
		// 일단 해당 연도가 윤년인지 아닌지부터 판단해보자.

		System.out.printf("연도 4자리 숫자 입력 >> ");
		int year = sc.nextInt();

		System.out.printf("월 입력 >> ");
		int month = sc.nextInt();

		if (month < 1 || month > 12) {
			System.out.println("월을 잘못입력했어요!!");
			return;
		}

		System.out.printf("입력한 연도와 월 : %d년 %d월 %n%n", year, month);
		int days = 0;

		boolean b = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

//		if (b) {
//			System.out.println("윤년");
//		} else {
//			System.out.println("평년");
//		}
		System.out.println();

		switch (month) {
		case 2:
			days = b ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 31;
			break;
		}
		
		
		System.out.printf("%d년 %d월은 %d일까지 있어요!! %n", year, month, days);
		
		
	}
}
