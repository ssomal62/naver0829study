package bit701.day0904;

import java.util.Random;
import java.util.Scanner;

public class Ex5_RandomEx {

	public static void main(String[] args) {

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		int num = rd.nextInt(100) + 1;
		int count = 0;

		while (true) {
			System.out.printf(++count +  " 번째 시도 >>");
			int input = sc.nextInt();

			if (input == num) {
				System.out.println("정답!");
				
				break;
			}else if(input > num) {
				System.out.println("더 낮은 숫자를 제시하세요.");
				continue;
			}else if(input < num) {
				System.out.println("더 높은 숫자를 제시하세요.");
				continue;
			}
			
		}

	}

}
