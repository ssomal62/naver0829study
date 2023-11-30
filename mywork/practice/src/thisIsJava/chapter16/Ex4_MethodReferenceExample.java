package thisIsJava.chapter16;

public class Ex4_MethodReferenceExample {
	public static void main(String[] args) {
		
		Ex4_Person person = new Ex4_Person();
		
		person.adtion(Ex4_Computer::staticMethod);
		
		Ex4_Computer com = new Ex4_Computer();
		person.adtion(com::instanceMethod);
		
		//static이 아닌경우 객체 생성후 메소드 참조 사용한다.
	}
}
