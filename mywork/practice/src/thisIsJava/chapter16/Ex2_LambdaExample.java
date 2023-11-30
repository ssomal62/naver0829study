package thisIsJava.chapter16;

public class Ex2_LambdaExample {
	
	public static void main(String[] args) {
		Ex2_Person person = new Ex2_Person();
		
		
		person.action1((name,job) -> {
			System.out.println(name + "이");
			System.out.println(job + "을 합니다.");
		});
		
		person.action2(word-> System.out.println("\"" + word+ "\""  + "라고 말합니다."));
		
		//추상클래스 람다 사용
		//인터페이스를 만든다 (메서드는 1개만)
		//각 인터페이스를 모아 객체에 담는다.
		//메인에서 객체를 인스턴스화 하여 추상클래스를 불러 람다식 작성한다.
		
		
	}

}
