package javaStudy;

public class MyClass {
	//public 리턴타입 메소드명(매개변수 등) {구현}
	
	public void method1() {
		System.out.println("m1 값");
	}
	
	public void method2(int x) {
		System.out.println("m2 :" + x );
		
	}
	
	public int method3() {
		System.out.println("m3");
		return 10;
	}
	
	public void method4(int x, int y) {
		System.out.println("m4 :" + x + y);
		System.out.println("m4 :" + (x + y));
	}
	
	public int method5(int x){
		System.out.println("m5 : " + x);
		return x*2;
	}
	
	public void method6(int x, int y) {
		System.out.println((int)Math.pow(x, y));
	}
	
	
}
