package bit701.day0911;

public class Ex1_Method {

	public static void main(String[] args) {

		Hello hello = new Hello("김이나",25);
		
		
		System.out.println(hello);
		System.out.println(hello.MESSAGE);
		
	}
}


class Hello{
	
	public static final  String MESSAGE = "오늘은 월요일";
	
	private String name;
	private int age;
	
	
	
	
	public Hello(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

	public String toString() {
		return "이름 : " + name + ", 나이 : " + age;
	}
	

	
	
}