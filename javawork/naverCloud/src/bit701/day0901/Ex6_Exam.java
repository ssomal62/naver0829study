package bit701.day0901;

import java.util.Scanner;

public class Ex6_Exam {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		System.out.println("=".repeat(20));
		System.out.printf("임의의 숫자>> ");
		int num1 = sc.nextInt();
		for(int i = 1; i <= num1 ; i++)
			sum += i;
		
		System.out.println("1부터 " + num1 +"까지의 합 : " + sum);
		
		int num2 = 0;
		
		System.out.println("=".repeat(20));
		System.out.printf("구구단 숫자>> ");
		num2 = sc.nextInt();
		
		System.out.println("<" + num2  + " 단>");
		
		for(int i = 1; i < 9 ; i++) {
			System.out.println(num2 + " x " + i + " = " + num2*i);
		}
		
		
		
	}
}
