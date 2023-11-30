package bit701.day0911;

public class Ex11_CallBy {

	// 모든 클래스는 레퍼런스 타입 : 주소가 전달
	// 멤버값을 변경하면 main의 by 변수의 멤버값도 변경된다.

	public static void cangeCallBy(CallBy by) {
		by.addr = "서초구";
	}

	public static void writeData(CallBy by) {
		System.out.println("이름 : " + by.name);
		System.out.println("주소 : " + by.addr);
		System.out.println("핸드폰 : " + by.hp);
		System.out.println();

	}

	public static void main(String[] args) {

		CallBy by = new CallBy("김이사", "강남구", "010-2222-3333");
		System.out.println("***초기값 출력 ***");
		writeData(by);
		System.out.println("***값 변경 후 출력 ***");
		cangeCallBy(by);
		writeData(by);

	}

}

class CallBy {

	String name;
	String addr;
	String hp;

	public CallBy(String name, String addr, String hp) {
		this.name = name;
		this.addr = addr;
		this.hp = hp;

	}

}