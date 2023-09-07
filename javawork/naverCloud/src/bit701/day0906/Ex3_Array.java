package bit701.day0906;

public class Ex3_Array {
	public static void main(String[] args) {

		Character[] arr1 = { 'a', 'p', 'p', 'l', 'e' };
		Double[] arr2 = { 1.1, 2.2, 3.3, 4.4 };
		String[] arr3 = { "딸기", "사과", "오렌지" };
		
		PrintText pf = new PrintText();		

		//반복하기 귀찮아서 지네릭을 활용했다!
		
		pf.setPrintText1(arr1);
		pf.setPrintText1(arr2);
		pf.setPrintText1(arr3);
		
		pf.setPrintText2(arr1);
		pf.setPrintText2(arr2);
		pf.setPrintText2(arr3);
		
		

	}
}

class PrintText<E> {
	public void setPrintText1(E[] ex) {
		for (E i : ex) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public void setPrintText2(E[] ex) {
		for (int i = 0 ; i < ex.length; i++) {
			System.out.print(ex[i] + " ");
		}
		System.out.println();
	}	
}
