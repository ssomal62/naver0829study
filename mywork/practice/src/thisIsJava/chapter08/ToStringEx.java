package thisIsJava.chapter08;

public class ToStringEx {

	public static void main(String[] args) {

		SmartPhone myPhone = new SmartPhone("삼서전자", "안드로이드");

		String str = myPhone.toString();
		System.out.println(str);

		System.out.println(myPhone);//객체 변수명을 출력 시도하면 자동으로 toString이 불러와짐 !!
		

	}

}

class SmartPhone {

	private String companu;
	private String os;

	public SmartPhone(String companu, String os) {
		this.companu = companu;
		this.os = os;
	}

	@Override
	public String toString() {
		return "SmartPhone [컴퍼니 : " + companu + ", OS :" + os + "]";
	}

}
