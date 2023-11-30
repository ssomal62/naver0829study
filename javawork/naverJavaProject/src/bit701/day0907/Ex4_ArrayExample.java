package bit701.day0907;

import java.util.Scanner;

public class Ex4_ArrayExample {

	public static void main(String[] args) {
		// 베이스볼 게임
		Scanner sc = new Scanner(System.in);

		int[] com = new int[3];
		int[] user = new int[3];
		String strNum;
		int ball = 0;
		int strike = 0;

		for (int i = 0; i < com.length; i++) {

			com[i] = (int) (Math.random() * 9) + 1;
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--;
					continue;
				}
			}
		}

		// System.out.printf(" %d %d %d", com[0], com[1], com[2]);
		System.out.println();
		System.out.println("=".repeat(30));

		while (true) {
			System.out.println();
			System.out.printf("숫자 입력>> ");

			strNum = sc.nextLine();

			user[0] = strNum.charAt(0) - 48;
			user[1] = strNum.charAt(1) - 48;
			user[2] = strNum.charAt(2) - 48;

			// System.out.printf(" %d %d %d", user[0], user[1], user[2]);

			ball = 0;
			strike = 0;

			for (int i = 0; i < com.length; i++) {
				
				for (int j = 0; j < user.length; j++) {
					if (com[i] == user[j]) {
						if (i == j)
							strike++;
						else
							ball++;
					}

				}
				System.out.println();
			}

			System.out.println("스트라이크 : " + strike + ", 볼 :" + ball);

			if (strike == 3) {
				System.out.println("추카추카");
				break;
			}

			if (strNum.equalsIgnoreCase("Q")) {
				System.out.println("게임을 종료합니다.");
				break;
			}

		}

	}

}
