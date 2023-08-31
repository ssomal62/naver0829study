package bit701.day0831;

import java.util.Scanner;

public class Ex4_Exam {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		// 점수 90이상 A, 80이상 B, 70이상 C, 60이상은 D, 나머지 F
		// 출력 "score"는 "grade"학점입니다.
		// 조건 : if문, 조건연산자
		System.out.println("점수를 입력하세요.");	
		System.out.printf("입력 >");	
		int score = sc.nextInt();		
		sc.nextLine();
		
		if(1 > score || score > 100) {
			System.out.println("범위 벗어남.");
			return; //해당 메서드만 종료하는 명령어. 해당 메서드가 main 일 경우 main 메서드 종료됨.
		}

		String grade = "";
			
		
		if (score >= 90) {
			grade = "A";
		}else if(score >= 80){
			grade = "B";
		}else if(score >= 70){
			grade = "C";
		}else if(score >= 60){
			grade = "D";
		}else{
			grade = "F";
		}
		
		System.out.println(score + "점은 " + grade +"학점입니다.");

		
	}
}
