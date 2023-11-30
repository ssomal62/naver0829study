package thisIsJava.chapter12;

public class MultuInterfaceImpEx  {
	public static void main(String[] args) {
		
		
		RemoteControl rc = new SmartTelevision();
		
		rc.turnOn();
		rc.turnOff();
		
		Searchable serchable = new SmartTelevision();
		
		serchable.search("http://naver.com");
	}

}
