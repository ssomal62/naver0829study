package javaStudy;

public class MyCalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new MyCal();
		cal.plus(4, 5);
		cal.multiple(4, 5);
		int i = cal.exec(3, 4);
		System.out.println(i);
		
		
		//cal.exec2 >> 스테틱메서드는 이러한 참조변수형으로 불러올 수 없음
		int j = Calculator.exec2(3, 4);//인터페이스의 스테틱 메소드는 인터페이스명으로 호출해야함.
		System.out.println(j);

	}

}
