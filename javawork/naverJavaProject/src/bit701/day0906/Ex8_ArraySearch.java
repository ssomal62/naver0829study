package bit701.day0906;

import java.util.Scanner;

public class Ex8_ArraySearch {
	public static void main(String[] args) {

		String[] arr = { "강호동", "이승기", "비", "리스테린", "제임스" };

		// 이름 검색해서 없으면 없다고 출력, 있으면 몇번째 위치에 있는지 출력

		Scanner sc = new Scanner(System.in);
		boolean isName = false;
		int add = 0;
		
		System.out.printf("찾는 이름 >> ");

		String input = sc.nextLine();

		for (String str : arr) {
			if (str.equals(input)) {
				isName = true;
				System.out.println(input + "은 " + (add + 1) + "번째로 등록되어 있습니다.");
				break;
			}
			add++;
		}
		if(!isName) {
			System.out.println("찾는 값이 없습니다.");
		}
		




	}
}
