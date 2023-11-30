package thisIsJava.chapter12;

public class RemoteControlEx {
	public static void main(String[] args) {
		
		System.out.println("리모콘 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최소 볼륨 : " + RemoteControl.MIN_VOLUME);
		
		RemoteControl rc = new Television();	
		rc.turnOn();
		rc.setVolume(11);
		rc.setMute(true);
		rc.setMute(false);
		rc.turnOff();

		
		rc = new Audio();	
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute(true);
		rc.setMute(false);
		rc.turnOff();
		
		//정적 메소드 호출은 구현 객체 필요없음.. 바로 인터페이스로 접근 가능..
		RemoteControl.changeBattery();
		
	}

}
