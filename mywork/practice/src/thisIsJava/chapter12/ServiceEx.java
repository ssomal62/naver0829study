package thisIsJava.chapter12;

public class ServiceEx {
	public static void main(String[] args) {
		
		Service service = new ServiceImpl();
		
		//디폴트 메소드 호출
		service.defaultMethod1();
		System.out.println();
		service.defaultMethod2();
		System.out.println();
		
		//정적 메소드 호출
		Service.staticMethod1();
		System.out.println();
		Service.staticMethod2();
		System.out.println();
		
	}
}
