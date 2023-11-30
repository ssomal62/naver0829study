package bit701.day0911;

import java.util.Scanner;

public class Ex7_MysStudentExample {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int count;

		System.out.printf("등록할 학생 인원수 >>");
		count = Integer.parseInt(sc.nextLine());
		System.out.println("-".repeat(30));
		
		MyStudent[] stu = new MyStudent[count];
		boolean run = true;
		while (run) {
			for (int i = 0; i < count; i++) {

				System.out.printf("[" + (i + 1) + "] 이름>>");
				String name = sc.nextLine();

				System.out.printf("[" + (i + 1) + "] 국어>>");
				int kor = Integer.parseInt(sc.nextLine());

				System.out.printf("[" + (i + 1) + "] 영어>>");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.println("-".repeat(30));

				stu[i] = new MyStudent(name, kor, eng);
				
				if (count-1 == i) {
					run = !run;
					break;
				}
			}

		}
		
		
		System.out.println();
		System.out.println("<결과>");
		System.out.println("=".repeat(30));
		
		for (MyStudent s : stu) {
			System.out.println(s);
		}
		
		
	}

}
