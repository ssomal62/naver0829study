package thisIsJava.chapter11;

public class Ex3_Exception {
	// 이해는 잘 안되나 Exception 더 큰 클래스는 더 뒤에 오게 작성해야함
	public static void main(String[] args) {

		String[] array = { "100", "1oo" , null,"200"};

		for (int i = 0; i <= array.length; i++) {

			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array[" + i + "] " + value);
			} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
				System.out.println("데이터에 문제 있음 : " + e.getMessage());
			}

		}

	}
}
