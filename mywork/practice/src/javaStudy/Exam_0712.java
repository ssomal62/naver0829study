package javaStudy;

import java.util.Scanner;

public class Exam_0712 {

	public static void main(String[] args) {
		Exam_0712 result = new Exam_0712();
		
		result.Result("a");
		
		
	}

	public void Result(String name) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 2; i++) {
			int a = sc.nextInt();

			if (-100000 <= a && 100000 <= a) {
				System.out.println(name + "=" + a);
			}

		}

	}

}
