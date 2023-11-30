package javaStudy;

public class Car {
	String name;
	int number;
	
	/*
	 * public Car(String name) { this.name = name; }
	 * 
	 * public Car() { this("이름없음", 0); }
	 * 
	 * public Car(String name, int number) { this.name = name; this.number = number;
	 * 
	 * System.out.println(this.name); System.out.println(this.number); }
	 */

	public void run() {
		System.out.println("Car의 run 메서드");
	}

}
