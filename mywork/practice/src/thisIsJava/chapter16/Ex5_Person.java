package thisIsJava.chapter16;

public class Ex5_Person {

	public void ordering(Ex5_Comparable comparable) {
		String a = "김길동";
		String b = "김길동";	
		
		int result = comparable.compare(a, b);
		
		if (result < 0) {
			System.out.println(a + "은 " + b + "보다 앞에 옵니다.");
		}else if(result==0) {
			System.out.println(a + "은 " + b + "과 같습니다.");
		}else {
			System.out.println(a + "은 " + b + "보다 뒤에 옵니다.");
		}
		
	}
}
