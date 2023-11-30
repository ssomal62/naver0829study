package bit701.day0912;

class SuperC{
	
	protected String name;
	protected int age;
	
	public SuperC() {
		System.out.println("부모 디폴트 생성자 호출");
		name = "홍길동";
		age = 10;
	}

	public SuperC(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}

class SubC extends SuperC {
	
	String hp;
	
	public SubC() {
		super(); //기본으로 쓰지 않아도 내부적으로 호출된다.(생략가능, 단 디폴트일 경우만)
		System.out.println("서브클래스의 디폴트 생성자 호출");
		hp = "010-111-222";
	}
	
	public SubC(String hp) {
		//super(); 생략되어잇음.
		System.out.println("두번째 생성자 호출");
		this.hp = hp;
	}
	

	
	public SubC(String name ,int age ,String hp) {
		
		super(name, age); //부모꺼 생성자 추가하고 거기에 자식으로 받은 값을 덮어씌움. 그래서 부모꺼는 안뜬다..
		System.out.println("세번째 생성자 호출");
		
		this.hp  = hp;
		
	}
	
	public void dataShow() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		System.out.println("폰 : " + this.hp);
		System.out.println("=====================");
	}
	
}

public class Ex8_InheriConst {
	
	public static void main(String[] args) {
		
		SubC sub1 = new SubC();
		sub1.dataShow();
		
		SubC sub2 = new SubC("010-222-4444");
		sub2.dataShow();	
		
		SubC sub3 = new SubC("캔대",22,"010-333-4444");
		sub3.dataShow();	
		
	}

}
