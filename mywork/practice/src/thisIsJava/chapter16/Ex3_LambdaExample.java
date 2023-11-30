package thisIsJava.chapter16;

public class Ex3_LambdaExample {
	
	public static void main(String[] args) {
		Ex3_Person person = new Ex3_Person();
		
		
		//실행문이 두개 이상일 경우 (중괄호)
		person.action((x,y) -> {
			double result = x + y;
			return result;
		});
		
		//와.... 진짜 .. 어렵다
		//Person.action은 파라미터로 Calcuable 을 받음. Calcuable.clac은 단일 메서드
		//추상메서드 double x,y를 받기 때문에
		//위코드가 성립됨..
		
		//다시 !!
		//추상 인터페이스 정의 -> 객체에서 메소드 정의 후 추상클래스를 파라미터로 받기
		//메인함수 -> 객체 생성, 메소드 호출 인자에 추상 인터페이스 인자 넣기 
		
		//action함수는 void 이지만 action 파라미터인 calulable.calc가 double을 반환하므로 이에 맞게 코드 작성
		
		//리턴문이 하나만 있을 경우 (연산식)
		person.action((x,y)->(x+y));
		
		//위에 식 풀어쓰면 아래식
		person.action((x,y)->{
			return (x+y);
		});
		
		
		//리턴문이 하나만 있을 경우 (메소드 호출)
		person.action((x,y)-> sum(x,y));
		//위에 식 풀어쓰면 아래식
		person.action((x,y) -> {
			return sum(x, y);
		});
		
	}
	
	public static double sum(double x, double y) {
		return x + y;
	}

}
