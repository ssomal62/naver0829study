package thisIsJava.chapter16;

public class Ex6_ConstructorReferenceExample {
	
	public static void main(String[] args) {
		
		Ex6_Person person = new Ex6_Person();
		
		Ex6_Member m1 = person.getMemeber1(Ex6_Member::new);
		
		Ex6_Member m2 = person.getMemeber2(Ex6_Member::new);
		
		System.out.println(m1);
		System.out.println(m2);
		
		// Ex6_Member에서 new를 하지 않을 경우 주소값으로 나옴. 
		
		//정리해보자. 개어려유...
		
		//
		

	}

}
