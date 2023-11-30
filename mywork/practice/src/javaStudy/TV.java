package javaStudy;

public interface TV {
	
	public int MIN_VOLUME = 0;  //변수는 컴파일 시 자동으로 final
	public int MAX_VOLUME = 100;
	
	public void turnOn(); //자동으로 컴파일 시 추상매서드 
	public void turnOff();
	public void changeVolume(int Volume);
	public void changeChannel(int Channel);
}
