package thisIsJava.chapter12;

public interface RemoteControl {
	
	/*
	 * 인터페이스가 가질 수 있는 멤버 
	 * public 상수 필드 
	 * public 추상 메소드 
	 * public 디폴트 메소드 
	 * public 정적 메소드
	 * private 메소드 
	 * private 정적 메소드
	 */
	
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	public void turnOn();
	public void turnOff();
	void setVolume(int volume);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	
	static void changeBattery() {
		//상수 필드를 제외한 추상메소드, 디폴트 메소드, private 메소드 호출 불가.
		System.out.println("리모콘 건전지를 교환합니다.");
	}

}
