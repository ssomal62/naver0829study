package bit701.day0907;

public class Ex2_ArrayTwo {

	public static void main(String[] args) {

		int[][] arr = new int[2][3];

		arr[0][1] = 3;
		arr[1][1] = 5;

		System.out.println("첫번째 배열 출력");
		//ArrayWrite(arr);
		System.out.println();

		System.out.println("두번째 배열 출력");
		int[][] arr2 = { { 1, 2 ,3 }, { 3, 4, 5 }, { 10, 20, 30 } };

		ArrayWrite(arr2);

		System.out.println();

		System.out.println("세번째 배열 출력");
		
		String[][] arr3;
		arr3 = new String [][] { { "가","나" }, { "다","라","마" }, { "바","사","아","자"} };
		//ArrayWrite2(arr3);

	}

	public static void ArrayWrite(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("[%2d][%2d]=%d  ", i, j, arr[i][j]);
			}
			System.out.println();
		}
	}


}

class WritePrint {

}
