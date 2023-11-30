package javaStudy;

public class CarExam {

	public static void main(String[] args) { // TODO Auto-generated method stub
		Car car1 = new Car();
		Car car2 = new Car();
		
		car1.name = "소방차";
		car1.number = 6778;
		
		car2.name = "구급차";
		car2.number = 1234;
		
		System.out.println(car1.name);
		System.out.println(car1.number);
		System.out.println(car2.name);
		System.out.println(car2.number);
	}

}
