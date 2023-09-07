package bit701.day0906;

import java.util.Arrays;
import java.util.Scanner;

public class Ex12_ArraySearchMain {
	static String searchFirstName;

	public static void main(String[] args) {
		String[] names = { "강호동", "이승기", "비", "리스테린", "제임스", "신민아", "이서진", "유리미", "김남길", "이소연" };

		// 검색할 성은? 이 4번째
		// {요소 번호 : 이름} 모두 가져오기
		// 성이 없을 경우 알림
		// 종료 커맨드 만들기

		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {
			boolean bFind = false;
			System.out.printf("찾을 성 입력 (종료 : Q) >> ");
			searchFirstName = sc.nextLine();



			System.out.println("=".repeat(30));
			Arrays.stream(names).filter(i -> i.startsWith(searchFirstName)).forEach(System.out::println);
			System.out.println("=".repeat(30));

			for (int i = 0; i < names.length; i++) {
				if (names[i].startsWith(searchFirstName)) {
					bFind = true;
					System.out.println(i + 1 + " :" + names[i]);
					continue;
				}
			}
			
			if (searchFirstName.equalsIgnoreCase("Q")) {
				System.out.println("종료");
				run = !run;
				break;
			}

			if (bFind) {
				System.out.println();
			} else {
				System.out.println("\"" + searchFirstName + "\" 씨성은 없습니다.");
			}
			

			System.out.println();

		}

	}

}
