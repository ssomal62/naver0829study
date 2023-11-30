package bit701.day0904;

import java.util.Scanner;

public class Ex2_while {
	
	public static void main(String[] args) {
		
		
		//정수를 입력 받아 총점과 평균을 구해보자
		//0이 입력되면 정수 입력을 종료한다.
		
		Scanner sc = new Scanner(System.in);
		
		double score;
		double average;
		double sum = 0, count = 0;
		
		while(true) {
			System.out.println("점수를 입력하세요.");
			score = sc.nextDouble();
			
			if(score==0) {
				System.out.println("입력된 점수 평균을 구합니다.");
				break;
			}
			
			if(!(1<= score && score <= 100)){
				System.out.println("다시 입력해수세요");
				continue;
			}
			count++;
			sum += score;
		}
		
		
		average = sum/count;
		
		String str = String.format("%.2f", average);
		System.out.println("평균 :" + str);
	
		
	}

}
