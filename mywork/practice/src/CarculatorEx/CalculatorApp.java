package CarculatorEx;

import java.util.Scanner;

public class CalculatorApp {
	private static Calculator calculator;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("첫번째 숫자 입력 >> ");
		int num1 = scanner.nextInt();
		
		System.out.printf("두번째 숫자 입력 >> ");
		int num2 = scanner.nextInt();
		
		System.out.printf("덧셈(1)/뺼셈(2) ");
		int operator = scanner.nextInt();
		
	
		
		if(operator ==1) {
			calculator = new AdditionCalculator();
			
		}else if(operator ==2) {
			calculator = new SubtractionCalculator();
		}else {
			System.out.println("올바른 연산자를 입력하세요.");
		}
		
		Runnable claculationTask = ()->{
			int result = calculator.calculate(num1, num2);
			System.out.println("계산 결과 : " + result);
		};
		
		Thread calculationThread = new Thread(claculationTask);
		calculationThread.start();
			
	}

}
