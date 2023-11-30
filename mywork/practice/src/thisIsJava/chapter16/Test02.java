package thisIsJava.chapter16;

public class Test02 {

	public static double calc(FunctionEx1 fun) {
		double x = 10;
		double y = 4;
		return fun.apply(x, y);
	}

	public static void main(String[] args) {

		double result = calc((x, y) -> (x / y));
		System.out.println(result);

	}
}
//와아아아아 내가 작성해따아아ㅏ
interface FunctionEx1 {
	double apply(double x, double y);
}
