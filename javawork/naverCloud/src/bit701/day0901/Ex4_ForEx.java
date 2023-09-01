package bit701.day0901;

public class Ex4_ForEx {

	public static void main(String[] args) {

		for (int i = 0; i <= 1; i++) {
			System.out.println("i=" + i);
		}

		System.out.println("=".repeat(30));// "="을 30번 반복
		for (int i = 0; i < 10; i++) {

			if (i == 0) {
				System.out.printf("%2d", i);
			} else {
				System.out.printf("%3d", i);
			}

		}
		System.out.println();
		System.out.println("=".repeat(30));

		for (int i = 1; i < 20; i += 3) {
			System.out.printf("%02d  ", i);
		}
		System.out.println();
		System.out.println("=".repeat(30));

		for (int i = 9; i >= 0; i--) {
			System.out.printf("%d  ", i);
		}
		System.out.println();
		System.out.println("=".repeat(30));

		//레이블 테스트 
		stop: //요렇게 달아도됨 
			for (int i = 0; i < 5; i++) {
			System.out.println("i=" + i);
			for (int j = 0; j < 5; j++) {
				if (j == 3) {
					break stop;
				} else {
					System.out.printf("%02d  ", j);
				}
			}
			System.out.println();

		}
		System.out.println();
		System.out.println("=".repeat(30));

	}

}
