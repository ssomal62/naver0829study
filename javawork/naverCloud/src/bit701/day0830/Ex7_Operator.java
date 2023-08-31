package bit701.day0830;

public class Ex7_Operator {
	public static void main(String[] args) {
		
		//비교 연산자와 논리연산자, 결과값은 무조건 true or false
		
		int kor = 100, eng = 90, math = 100;
		
		System.out.println(kor >= 90);
		System.out.println(kor >= 80 || kor!=math); // true, 뒤의 수식을 비교하지 않는다.
		System.out.println(kor < 80 || kor!=math);
		System.out.println(kor >= 80 && kor != math);
		System.out.println(kor >= 80 && kor != math);
		System.out.println(!(kor==math));
		System.out.println(kor >= 95 && eng >= 95 && math >=95);
		System.out.println(kor >= 95 && eng >= 95 || math >=95);
		System.out.println(kor >= 95 || eng >= 95 && math >=95);
		
		int year = 2023;
		// 위 연도가 윤년인지 확인
		
		System.out.println(year%4==0 && year%100!=0 || year%400 == 0? "윤년입니다." : "윤년이 아닙니다.");
		
		
	}
}
