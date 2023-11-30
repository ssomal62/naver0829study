package thisIsJava.chapter08;


public class RecordEx{
	
	public static void main(String[] args) {
		
		//lombok 사용해보기
		Member m = new Member();
//		m.setAge(99);
//		m.setId("wxy890");
//		m.setName("이소연");
		
		System.out.println(m);
		///////////////
		
		
		Person s = new Person("홍길동",25);
		Person s2 = new Person("홍길동",25);
		System.out.println(s.age());
		System.out.println(s.name());
		System.out.println(s.toString());
		
		boolean check = s.hashCode()==s2.hashCode();
		
		System.out.println(check);
	
	}
	
}
record Person(String name, int age) {
	
	//인수는 private final로 자동 생성됨. 
	// private final String name 
	//getter setter가 자동생성되지만 getX setX 메소드 명이 아니라 X로 표현됨.

}


