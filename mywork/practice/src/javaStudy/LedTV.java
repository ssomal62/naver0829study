package javaStudy;

public class LedTV implements TV { //TV인터페이스를 구현하겠다

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("켜다");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("끄다");
	}

	@Override
	public void changeVolume(int Volume) {
		// TODO Auto-generated method stub
		System.out.println("볼륨 조절");
	}

	@Override
	public void changeChannel(int Channel) {
		// TODO Auto-generated method stub
		System.out.println("채널 변경");
	} 

}
