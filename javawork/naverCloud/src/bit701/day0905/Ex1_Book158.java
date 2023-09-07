package bit701.day0905;

import java.util.Scanner;

public class Ex1_Book158 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String ssn;
		String str;

		boolean run = true;
		while (run) {
			System.out.printf("주민등록번호 입력 >> ");

			ssn = sc.nextLine();

			if ("q".equalsIgnoreCase(ssn)) {
				System.out.println("프로그램 종료");
				run = !run;
				break;
			}
			
			String match = "[^0-9]";
			ssn = ssn.replaceAll(match, "");
			str = ssn.substring(0, 2) + "년 " + ssn.substring(2, 4) + "월 " + ssn.substring(4, 6) + "일생";
			switch (ssn.charAt(6)) {
			case '1':
			case '2':
			case '3':
			case '4':
				System.out.println("[내국인] " + str);
				System.out.println();
				break;
			case '5':
			case '6':
				System.out.println("[외국인] " + str);
				System.out.println();
				break;

			}
		}

	}
}
