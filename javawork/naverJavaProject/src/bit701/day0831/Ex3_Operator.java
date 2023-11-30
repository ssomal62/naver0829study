package bit701.day0831;

import java.util.Scanner;

public class Ex3_Operator {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요");
		
		int score = sc.nextInt();
		sc.nextLine();
		
		if(1 > score || score > 100) {
			System.out.println("범위 벗어남.");
			return; //해당 메서드만 종료하는 명령어. 해당 메서드가 main 일 경우 main 메서드 종료됨.
		}else {
			System.out.println("입력된 점수 : " + score + "점");
		}
		
		String msg = "";
		
		if(score >= 90) {
			msg = "합격";
		}else if(score >=80 ) {
			msg = "재시험";
		}else {
			msg = "불합격";
		}
		
			
		System.out.println("합격 여부 : " + msg);
		
		String msg1 = score >= 90 ?  "합격" : score >=80? "재시험" : "불합격" ;
		
		System.out.println("합격 여부 : " + msg1);
		
		

		
		
		
	}   
}
