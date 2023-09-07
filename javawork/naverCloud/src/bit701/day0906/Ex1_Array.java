package bit701.day0906;

public class Ex1_Array {

	public static void main(String[] args) {

		// <배열> : 배열은 기본형이라고 하더라도 객체로 인식하기 떄문에 변수를 프린트하면 주소값이 반환됨.

		int[] arr1 = { 1, 2, 3, 4, 5 };
		System.out.println(arr1);// [I@372f7a8d >>주소값나옴

		int[] arr2 = new int[5]; // 5개는 0으로 초기화됨. 그럼 스트링은?
		System.out.println(arr2[0]);

		String[] arr3 = new String[5];
		System.out.println(arr3[0]);// 객체타입은 null로 초기화됨.

		// 배열은 스택에 쌓임.
		arr1[1] = 0;
		arr1[4] = 99;
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();

		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
