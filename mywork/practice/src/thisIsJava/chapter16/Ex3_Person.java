package thisIsJava.chapter16;

public class Ex3_Person {
	public void action(Ex3_Calcuable calcuable) {
		double result = calcuable.calc(10, 4);
		System.out.println("결과 : " + result);
	}
}
