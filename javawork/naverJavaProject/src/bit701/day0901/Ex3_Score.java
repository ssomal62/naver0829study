package bit701.day0901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex3_Score {
	static SubjectScore score;
	static Subject sub;
	static double average = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 이름 3과목 점수 를 입력받은 후 총점과 평균(소수점1자리 출력)
		// 등급 출력 (grade), 평균 90이상이면 "Excellent!"
		// 80이상이면 "Good!", 나머지는 "Try"
		// if문 사용하기
		
		averageScore();
	}

	public static void averageScore() {

		Scanner sc = new Scanner(System.in);

		String name = "";
		double average = 0;

		List<SubjectScore> list = new ArrayList<>(
				Arrays.asList(new SubjectScore(sub.국어, 0), new SubjectScore(sub.영어, 0), new SubjectScore(sub.수학, 0)));

		//System.out.println(list.get(0).sub); 눈물의 ㅠㅠㅠ 결과다 .. 국어값 얻기!!

		System.out.printf("이름 >> ");
		name = sc.nextLine();
		
		for (int i =0; i < list.size(); i++){
			System.out.printf(list.get(i).sub + " 점수 입력 >> ");
			list.get(i).subScore = sc.nextInt();
		}

		average  = (list.stream().mapToInt(SubjectScore::getSubScore).sum())/3.0;
				
		String str = String.format("%.2f", average);

		System.out.println("=".repeat(20));
		System.out.printf(name + "의 결과" + "(평균:" + str + ") : ");

		if (average >= 90)
			System.out.println("Excellent!");
		else if (average >= 80)
			System.out.println("Good!");
		else
			System.out.println("Try!");
	}

}

enum Subject {
	국어, 영어, 수학
}

class SubjectScore {
	Subject sub;
	int subScore = 0;

	public SubjectScore(Subject sub, int subScore) {
		this.sub = sub;
		this.subScore = subScore;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public int getSubScore() {
		return subScore;
	}

	public void setSubScore(int subScore) {
		this.subScore = subScore;
	}

}

class ScoreLogic {
	static SubjectScore score;

	public ScoreLogic(int subScore) {
		subScore = score.subScore;
	}

}