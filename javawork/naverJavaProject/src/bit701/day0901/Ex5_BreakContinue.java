package bit701.day0901;

public class Ex5_BreakContinue {
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			if (i == 5)
				break;
			System.out.println("넘나 졸리구ㅠ");
		}

		System.out.println();
		System.out.println("-".repeat(20));

		// 레이블 테스트
		allExit:           // 요렇게 달아도됨
		for (int i = 0; i < 5; i++) {
			System.out.println("i=" + i);
			for (int j = 0; j < 5; j++) {
				if (j == 3) {
					break allExit;
				} else {
					System.out.printf("%02d  ", j);
				}
			}
			System.out.println();

		}

	}
}
