package bit701.day0908;

public class Ex6_MemberExample {
	
	public static void main(String[] args) {
		
		Ex5_Member member = new Ex5_Member();
		
		System.out.println();
		
		member.setNumber(1);
		member.setName("bit123");
		member.setAge(12);
		
		System.out.println("=".repeat(30));		
		
		printMember(member);
		
		//같은 클래스 내의 메서드는 클래스명 생략 가능.

		Ex5_Member member2 = new Ex5_Member();
		
		System.out.println();
		
		member2.setNumber(1);
		member2.setName("bit123");
		member2.setAge(45);
		
		System.out.println("=".repeat(30));		
		
		printMember(member2);
	}
	
	public static void printMember(Ex5_Member member) {
		System.out.println("사원번호 : " + member.getNumber());
		System.out.println("사원나이 : " + member.getAge());
		System.out.println("사원이름 : " + member.getName());
	}

}
