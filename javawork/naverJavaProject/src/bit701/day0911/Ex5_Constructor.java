package bit701.day0911;

public class Ex5_Constructor {

	public static void main(String[] args) {
		
		//Car2 car = Car2.getInstance(); // 오류 발생. private 이라 같은 멤버만 호출이 가능하다.

		//System.out.println(car.toString());

	}

}

class Car2 {

	String carName;
	String carColor;

	private Car2() {
		carName = "아우디";
		carColor = "블랙";
	}

	public static Car2 getInstance() {
		return new Car2();
	}

	@Override
	public String toString() {
		return "carName=" + carName + ", carColor=" + carColor;
	}

}
