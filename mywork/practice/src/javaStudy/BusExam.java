package javaStudy;

public class BusExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Bus bus = new Bus();
		
		//bus.run();

		Car car = new Bus(); //부모타입으로 자식을 가리킬 수는 있지만 부모가 가지고 있는 내용만 사용 가능
		car.run();  
		
		Bus bus = (Bus)car;
		
		bus.run();
		bus.ppang();

	}

}
