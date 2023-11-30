package bit701.day0906;

import java.io.Serial;
import java.util.Scanner;

public class Ex9_ArraySearch2 {
	public static void main(String[] args) {

		String[] names = { "강호동", "이승기", "비", "리스테린", "제임스" };

		// 이름 검색해서 없으면 없다고 출력, 있으면 몇번째 위치에 있는지 출력

		Scanner sc = new Scanner(System.in);
		String searchName = "";
		int find = 1;
		
		System.out.printf("찾는 이름 >> ");

		searchName = sc.nextLine();
		

		for (int i = 0; i < names.length; i++) {
				if (searchName.equals(names[i])) {
					find = i;
					break;
				}
		}

		if(find ==1) {
			System.out.println("데이터 없음");
		}else {
			System.out.println(searchName + "는 " + (find+1) + "번째 있습니다.");
		}
		




	}
}
