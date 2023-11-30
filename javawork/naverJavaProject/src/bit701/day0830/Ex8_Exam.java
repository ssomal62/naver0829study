package bit701.day0830;

import java.util.stream.Stream;

public class Ex8_Exam {

	public static void main(String[] args) {
		
		/*
		 * 출력 money : 5674321원 
		 * 만원짜리 : 567장 
		 * 천원짜리 : 3장 
		 * 백원짜리 : 2개 
		 * 십원짜리 : 2개 
		 * 일원짜리 : 1개
		 */
		

		int money = 5674321;
		int a = 10000;


//		System.out.println(a +  "원 : " + money/a + "장");
//		money %= a; 
//		a /= 10;
//		System.out.println(a +  "원 : " + money/a + "장");
//		money %= a;
//		a /= 10;
//		System.out.println(a +  "원 : " + money/a + "장");
//		money %= a;
//		a /= 10;
//		System.out.println(a +  "원 : " + money/a + "장");
//		money %= a;
//		a /= 10;
//		System.out.println(a +  "원 : " + money/a + "장");		
		
//		System.out.println("만원짜리 : " + money/10000 + "장");
//		System.out.println("천원짜리 : " + (money%10000)/1000 + "장");
//		System.out.println("백원짜리 : " + (money%1000)/100 + "장");
//		System.out.println("십원짜리 : " + (money%100)/10 + "장");
//		System.out.println("일원짜리 : " + (money%10) + "장");


		for (int i = 0; i < 5; i++) {
			System.out.println(a + "원 : " + money / a + "장");
			money %= a;
			a /= 10;
		}
	}
	



}
