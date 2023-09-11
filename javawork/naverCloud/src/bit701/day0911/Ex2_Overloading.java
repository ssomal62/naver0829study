package bit701.day0911;

public class Ex2_Overloading {

	
	public static void main(String[] args) {
		
		
		Sum s = new Sum();
		System.out.println(s.sum(1,3));
		
		

		
	}
	

	
	
}



class Sum{
	
//	public static int sum(int a, int b) {
//		return a+b;
//	}
	
	public static int sum(int a, int b, int c) {
		return a+b+c;
	}
	
//	public static double sum(double a, double b) {
//		return a+b;
//	}
	
	public static String sum(String a, String b) {
		return a+b;
	}
	
	public static String sum(String a, int b) {
		return a+b;
	}
	
	public static int sum(int ...n) { //개수 상관없이 받을 수 있음. 근데 명시적으로 선언된 생성자가 우선 호출
		System.out.println(2);
		System.out.println("총 " + n.length);
		return 0;
		
	}
	
	
}
