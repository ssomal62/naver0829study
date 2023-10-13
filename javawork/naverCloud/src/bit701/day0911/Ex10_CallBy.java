package bit701.day0911;

public class Ex10_CallBy {
	
	//Call by value : 값만 전달. 주소가 전달되지 않는다.
	//모든 기본형과 String 타입은 값만 전달된다.
	public static int changeInt(int a) {
		System.out.println("전달 받은 a값 : " + a);
		a = 20;		
		System.out.println("변경 된 훈 a값 : " + a);
		return a;
	}
	
	//Call by Reference 
	//모든 배열은 주소가 전달(배열은 무조건 객체 타입으로 인식)
	public static void changeArray(int[] arr) {
		System.out.println("전달 받은 배열값 확인");
		for(int a : arr) {
			System.out.print(a + "\t");
		}
		System.out.println("\nd1번지 값 변경");
		arr[1] = 100;
	};
	
	public static void main(String[] args) {		
		//배열은 객체형
		//
		int a = 10;
		changeInt(a);//배열은 주소가 전달됨. 
		System.out.println("main a : " + a);
		
		int[] arr = {3, 4, 5};
		changeArray(arr);
		System.out.println("main에서 arr 배열 확인");
		
		for(int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();

		
	}

}
