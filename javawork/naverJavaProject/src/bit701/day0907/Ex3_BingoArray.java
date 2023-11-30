package bit701.day0907;

import java.util.Scanner;

public class Ex3_BingoArray {
	public static void main(String[] args) {

		// 3*3 배열 선언 후 난수 채우기
		// 가로, 세로 , 대각선으로 비교하여 같은 숫자가 나온 갯수를 구한다.

		Scanner sc = new Scanner(System.in);

		int[][] data = new int[3][3];
		int binggo;

		while (true) {

			binggo = 0;
			// 3행 3열에 난수 넣기

			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					data[i][j] = (int) (Math.random() * 3) + 1;

				}
			}

			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					System.out.printf("%3d", data[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			for (int i = 0; i < data.length; i++) {
				if (data[i][0] == data[i][1] && data[i][1] == data[i][2]) {
					binggo++;
				}
				if (data[0][i] == data[1][i] && data[1][i] == data[2][i]) {
					binggo++;
				}
			}

			if (data[0][0] == data[1][1] && data[1][1] == data[2][2]) {
				binggo++;
			}
			if (data[2][0] == data[1][1] && data[1][1] == data[0][2]) {
				binggo++;
			}

			System.out.println();

			// 빙고계산 0 이면 꽝, 아닐경우 빙고 2개

			if (binggo >= 2) {
				System.out.println("빙고 : " + binggo + "개");
			} else {
				System.out.println("꽝!");
			}

			System.out.printf("종료(Q) >>");
			String ans = sc.nextLine();
			if (ans.equalsIgnoreCase("Q"))
				break;

			System.out.println("-".repeat(30));
		}

		System.out.println("빙고 게임 끗!🤗");
	}

}
