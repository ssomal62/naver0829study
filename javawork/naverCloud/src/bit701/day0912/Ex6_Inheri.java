package bit701.day0912;

class SuperA {

	public void ProcessA() {
		System.out.println("부모 A다");
	}

	public void ProcessB() {
		System.out.println("부모 B다");
	}

	private void ProcessC() {
		System.out.println("부모 C다");
	}

}

class SubA extends SuperA {
	public void ProcessA() {
		

		System.out.println("-".repeat(40));
		this.ProcessA(); // this로 호출시 현재 클래스에 없으면 부모로부터 찾아서 가져온다.
		System.out.println("자식 A다");
		super.ProcessA(); //부모 메서드이므로 super로도 가져올 수 있다.
		//반드시 super로만 부모 메서드를 가져와야 하는 경우는 
		//부모의 메서드를 자식이 오버라이드 한 경우
	}
}

public class Ex6_Inheri {
	public static void main(String[] args) {

		SuperA superA = new SuperA();
		SubA sub = new SubA();

		sub.ProcessA();
		
		System.out.println("-".repeat(40));
		sub.ProcessB();
		// sub.ProcessC();//private 자식객체는 상속불가.

	}
}
