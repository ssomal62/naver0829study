package selfStudy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BankingSystemEx {

	static int deposit;
	static String name;

	public BankingSystemEx() {
		this(deposit, name);
	}

	public BankingSystemEx(int deposit, String name) {
		this.deposit = deposit;
		this.name = name;
	}

	public static void main(String[] args) {

		boolean run = true;
		int balance = 0;
		String str;
		String str1;
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###");
		
		while (run) {

			System.out.println("=".repeat(40));
			System.out.println("  1.예금 | 2. 출금 | 3.잔고 | 4.종료");
			System.out.println("=".repeat(40));
			System.out.println("메뉴 선택 > ");

			int menuNum = Integer.parseInt(scanner.nextLine());

			////
			switch (menuNum) {
			case 1:
				System.out.println("1.예금 > ");
				balance += Integer.parseInt(scanner.nextLine());
				str = df.format(balance);
				System.out.println(str + "원 입금 완료");
				continue;
			case 2:
				System.out.println("2.출금 > ");

				int checkNum = Integer.parseInt(scanner.nextLine());

				if (checkNum > balance) {
					Exception e = new Exception();
					System.out.println("예금 잔액이 부족합니다. 다시 입력해주세요." + e.toString());
					continue;
				} else {
					balance -= Math.abs(checkNum);
					str = df.format(Math.abs(checkNum));
					str1 = df.format(balance);

					System.out.println(str + "원 출금 완료 (잔액 : " + str1 + "원)");
					continue;
				}

			case 3:
				str = df.format(balance);
				System.out.println("3.잔액 > " + str + "원");
				continue;
				
			case 4:
				run = !run;
				break;
			}
		}
		System.out.println("프로그램 종료");

	}

}
