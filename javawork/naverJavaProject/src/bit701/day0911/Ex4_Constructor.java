package bit701.day0911;

public class Ex4_Constructor {
	
	public static void main(String[] args) {
		
		Car car1 = new Car();
		System.out.println(car1);
		Car.setCarName("그랑죠");
		Car.setCarPrice(30000);
		
		System.out.println(car1);
		
		Car car2 = new Car();
		System.out.println(car2);
		
	}
	
}

class Car{
	
	private static String carName;
	private static int carPrice;
	
	public Car() {
		this(carName,carPrice);
	}

	
	public Car(String carName, int carPrice) {
		this.carName = "자동차";
		this.carPrice = 10000;
	}
	
	

	
	public static String getCarName() {
		return carName;
	}


	public static void setCarName(String carName) {
		Car.carName = carName;
	}


	public static int getCarPrice() {
		return carPrice;
	}


	public static void setCarPrice(int carPrice) {
		Car.carPrice = carPrice;
	}


	@Override
	public String toString() {
		return "carName ; " + carName + ", carPrice :" + carPrice ;
	}
	

	
}
