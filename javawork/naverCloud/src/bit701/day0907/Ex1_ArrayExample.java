package bit701.day0907;

import java.util.Scanner;

public class Ex1_ArrayExample {

	public static void main(String[] args) {

		System.out.println("배열 복습 예제");

		Scanner sc = new Scanner(System.in);

		int count = 0;
		System.out.printf("등록할 데이터 수 >> ");
		count = Integer.parseInt(sc.nextLine());
		
		int[] korScore = new int[count];
		int[] engScore = new int[count];
		int[] totalScore = new int[count];
		double[] average = new double[count];

		String[] names = new String[count];

		boolean run = true;



		while (run) {

			for (int i = 0; i < count; i++) {

				System.out.printf("이름 입력 >> ");
				names[i] = sc.nextLine();
				System.out.printf("국어 점수 >> ");
				korScore[i] = Integer.parseInt(sc.nextLine());
				System.out.printf("영어 점수 >> ");
				engScore[i] = Integer.parseInt(sc.nextLine());
				totalScore[i] = korScore[i] + engScore[i];
				average[i] = totalScore[i] / count;

				System.out.println("-".repeat(40));
				if ((i + 1) == count) {
					run = !run;
					break;
				}
			}

		}

		System.out.println();

		System.out.println("이름 \t국어 \t영어 \t총점 \t평균");
		System.out.println("=".repeat(40));

		for (int i = 0; i < count; i++) {

			System.out.println(
					names[i] + "\t" + korScore[i] + "\t" + engScore[i] + "\t" + totalScore[i] + "\t" + average[i]);
		}

	}

}
