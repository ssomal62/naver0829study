package bit701.day0913;

abstract class SuperColor {

//	public void draw() {
//		//부모클래스가 하는 일이 없으므로 안에 내용도 없음
//		//오버라이드를 위해 있는 것
//		
//	}
	//추상클래스의 특징.
	//1. 일반 메서드와 미완성의 abstract 메서드 둘다 구현 가능하다.
	//2. abstract(추상) 클래스는  new로 객체 생성을 할 수 없다.
	//3. 추상 클래스를 상속받는 클래스는 반드시 추상 메서드를 오버라이드해서 기능을 구현해야만한다.
	//4. 만약 추상 메소드를 오버라이드 안할 경우 서브클래스도 역시 추상화시켜야한다.
	
	abstract public  void draw();
	public void parentSkill() {
		System.out.println("부모가 자식이 해낸 것을 보고 웃습니다.");
	}
}

class Red extends SuperColor {
	@Override
	public void draw() {
		System.out.println("사과를 그린다.");
	}
}

class Blue extends SuperColor {
	@Override
	public void draw() {
		System.out.println("바다를 그린다.");
	}
}

class Green extends SuperColor {
	@Override
	public void draw() {
		System.out.println("나무를 그린다.");
	}
}

public class Ex3_Inheri {
	public static void draw(SuperColor color) {
		color.draw();
		color.parentSkill();
	}
	public static void main(String[] args) {
		draw(new Red());
		draw(new Blue());
		draw(new Green());
	}
}
