package javaStudy;

public class LedTVExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TV tv = new LedTV();//TV인터페이스는 타입이 될 수 있으나 TV가 가지고 있는 기능만 이용할 수 있다.
		
		tv.turnOff();
		tv.turnOn();
		tv.changeChannel(80);
		tv.changeVolume(100);
	}

}
