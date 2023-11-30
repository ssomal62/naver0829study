package bit701.day0904;

public class Ex1_while {
	public static void main(String[] args) {

		int a = 'A';
		while (a <= 'Z') {
			System.out.print((char) a++ + " ");// 오오 이렇게도 되는구나..

		}
		System.out.println();

		a = 'A';
		while (true) {
			System.out.print((char) a++ + " ");
			if (a > 'Z') {
				break;
			}
		}
		System.out.println();

		a = 'A';
		do {
			System.out.print((char) a++ + " ");
		} while (a <= 90);// 조건 뒤에 반드시 ;
		System.out.println();

//		int b = 4;
//		Integer c = 4;
//		System.out.println(b+c);

		int n = 10;

		while (n < 10) {
			System.out.println(n--);
		}

		do {
			System.out.print(n-- + " ");
			if (n == 0) {
				break;
			}
		} while (n < 10);

		/*
		 * Ex1_while test1 = new Ex1_while(); Ex1_while test2 = new Ex1_while();
		 * 
		 * test1.Test();
		 * 
		 * boolean check = test1.equals(test2); System.out.println(check);
		 */

	}


	public void Test() {
		System.out.println("객체 테스트용입니다.");
	}

}
