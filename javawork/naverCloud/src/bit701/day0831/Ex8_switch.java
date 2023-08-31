package bit701.day0831;

import java.util.Scanner;

public class Ex8_switch {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//int num = sc.nextInt();

//		switch (num) {// 숫자, 문자, 문자열 다 됨. 그러나 문자열을 자주 사용하지는 않는 편
//		case 1:
//			System.out.println("one!");
//			break;
//		case 2:
//			System.out.println("two!");
//			break;
//		case 3:
//			System.out.println("three!");
//			break;
//		default:
//			System.out.println("other number!");
//		}

		System.out.println("영문 색상명을 입력하세요");
		String color = sc.nextLine();
		
		switch (color.toLowerCase()) {
		case "red":
			System.out.println("빨강");
			break;
		case "black":
			System.out.println("블랙");
			break;
		case "blue":
			System.out.println("파랑");
			break;
		case "pink":
			System.out.println("분홍");
			break;
		}

	}

}
