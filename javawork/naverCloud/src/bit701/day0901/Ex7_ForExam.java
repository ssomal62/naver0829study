package bit701.day0901;

import java.util.Scanner;

public class Ex7_ForExam {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1;
		int num2;
		int temp;


		System.out.println("첫번째 숫자 >> ");
		num1 = sc.nextInt();

		System.out.println("두번째 숫자 >> ");
		num2 = sc.nextInt();

		
		if (num1 > num2) {
			temp = num2;
			num2= num1;
			num1 = temp;
		}
		
		
		System.out.println("=".repeat(40));

		for (int i = num1; i <= num2; i++) {
			System.out.printf("\t<" + i + "단>");
		}

		System.out.println();
		System.out.println("=".repeat(40));

		for (int i = 1; i <= 9; i++) {
			for (int j = num1; j <= num2; j++) {
				System.out.printf("\t" + j + "x" + i + "=" + i * j);
			}
			System.out.println();
		}

	}
}
