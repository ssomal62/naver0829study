package bit701.day0831;

import java.util.Scanner;

public class Ex01_KeyInput {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("당신의 나이를 입력하세요");
		
		String age = scanner.nextLine();
		System.out.println("당신의 나이는 " + Integer.parseInt(age) + "세 이군요");
		
		String name = scanner.nextLine();
		System.out.println("너의 이름은.." + name);
	}

}
