package thisIsJava.chapter12;

public interface Service {
	
	
	//디폴트 메소드
	default void defaultMethod1() {
		System.out.println("defaultMethod1 종속 코드");
		defaultCommon();
	}
	
	default void defaultMethod2() {
		System.out.println("defaultMethod2 종속 코드");
		defaultCommon();
	}
	
	default void defaultCommon() {
		System.out.println("defaultMethod 중복 코드A");
		System.out.println("defaultMethod 중복 코드B");
	}
	
	//정적 메소드
	
	static void staticMethod1() {
		System.out.println("static1 종속 코드");
		staticCommon();
	}
	
	static void staticMethod2() {
		System.out.println("static2 종속 코드");
		staticCommon();
	}
	
	static void staticCommon() {
		System.out.println("staticMethod 중복 코드C");
		System.out.println("staticMethod 중복 코드D");
	}

}
