package selfStudy;

public class SingletonEx {
	
	private static SingletonEx singleton = new SingletonEx();
	
	private SingletonEx() {}
	
	static SingletonEx getInstance() {
		return singleton;
	}

	public static void main(String[] args) {
		
		SingletonEx obj1 = SingletonEx.getInstance();
		SingletonEx obj2 = SingletonEx.getInstance();
		
		String checkSingleton = obj1== obj2 ? "같음" : "틀림";
		
		System.out.println(checkSingleton);
		
	}
}
