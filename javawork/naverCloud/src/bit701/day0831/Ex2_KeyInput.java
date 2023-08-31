package bit701.day0831;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex2_KeyInput {
	
	
	public static void main(String[] args) {
		
		Date date = new Date();
		int curYear = date.getYear() + 1900;
		System.out.println("현재 연도 : " + curYear);
		

	  
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("당신이 태어난 연도는?");
		int birthYear = Integer.parseInt(scanner.nextLine());
		
		System.out.println("지금 사는 곳은 어디입니까?");
		String address = scanner.nextLine();
		int age = curYear - birthYear;
		System.out.println("저는 " + address + "에 사는 " + birthYear + "년생" + "("+ age +"세) 학생입니다.");
		
		System.out.printf("저는 %s에 사는 %4d년생(%d세) 학생입니다.%n", address, birthYear, age);
		
		String msg = age > 20 ? "성인입니다." : "미성년자입니다.";
		
		System.out.println(msg);
		
		msg ="";
		
		if (age >=20) {
			msg = "성인입니다.";
		}else {
			msg = "미성년자입니다.";
		}
		
		System.out.println("당신은 " + msg);
	}
}
