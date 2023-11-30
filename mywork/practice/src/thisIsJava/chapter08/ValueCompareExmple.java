package thisIsJava.chapter08;

public class ValueCompareExmple {
	public static void main(String[] args) {
		
		Integer obj1 = 300;// 127 초과값일 경우
		Integer obj2 = 300;// 127 초과값일 경우
		
		System.out.println("[1] : " +  (obj1==obj2));
		System.out.println("[2] : " +  (obj1.equals(obj2)));
		
		System.out.println(obj1);
		
		double num = -4.5645;
		
		Math.abs(num); //절대값
		System.out.println(Math.abs(num));
		
		Math.ceil(num); //올림값
		System.out.println(Math.ceil(num));
		
		Math.floor(num); //내림값
		System.out.println(Math.floor(num));
		
		Math.round(num); //반올림값
		System.out.println(Math.round(num)); //정수 반환인가요


	}

}
