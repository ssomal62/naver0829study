package thisIsJava.chapter16;

public class Ex6_Person {

	public Ex6_Member getMemeber1(Ex6_Creatable1 creatable){
		String id = "winter";
		Ex6_Member member = creatable.creator(id );
		
		return member;
	}
	
	public Ex6_Member getMemeber2(Ex6_Creatable2 creatable){
		String id = "winter";
		String name = "한겨울";
		Ex6_Member member = creatable.creator(id, name);
		return member;
	}
	
	
	
}
