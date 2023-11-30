package thisIsJava.chapter16;

public class Ex5_MthodReferenceExample {
	public static void main(String[] args) {

		Ex5_Person person = new Ex5_Person();
		
		person.ordering(String::compareToIgnoreCase);
		//같은 코드.. 좀 이해가 안된다.. 왜 설정한 적 없는 메소드가 나오느거지?
		person.ordering((a,b) -> a.compareToIgnoreCase(b));
	
	}
}
