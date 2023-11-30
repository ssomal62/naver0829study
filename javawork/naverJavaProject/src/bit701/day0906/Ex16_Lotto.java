package bit701.day0906;

public class Ex16_Lotto {

	public static void main(String[] args) {

		// 오름차순 정렬
		int randomNum;
		int[] lottoNumber = new int[6];

		System.out.println(" 랜덤 번호를 생성합니다.");

		for (int i = 0; i < lottoNumber.length; i++) {

			lottoNumber[i] = (int) (Math.random() * 45) + 1;

			for (int j = 0; j < i; j++) {
				if (lottoNumber[i] == lottoNumber[j]) {
					i--;
					continue;
				}
			}
		}

		for (int i = 0; i < lottoNumber.length - 1; i++) {
			for (int j = i + 1; j < lottoNumber.length; j++) {

				if (lottoNumber[i] > lottoNumber[j]) {
					int temp = lottoNumber[i];
					lottoNumber[i] = lottoNumber[j];
					lottoNumber[j] = temp;
				}
			}
		}
		
		System.out.print(" | ");
		for (int i : lottoNumber) {

			System.out.print(i + " | ");
		}
	}

}
