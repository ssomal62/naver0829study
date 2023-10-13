package bit701.day0911;

public class Ex13_ConstThis {
	
	
	
	public static void main(String[] args) {
		
		Kiwi[] k = {
				
				new Kiwi(),
				new Kiwi("키위"),
				new Kiwi("사과",99)
		};
		
		for(Kiwi arr : k) {
			System.out.println(arr);
		}
		
	}

}

class Kiwi{
	
	String name;
	int age;
	
	public Kiwi() {
		//this는 반드시 첫줄에 나와야함.
		this("홍길동",20); //3번째 생성자 호출됨.
	}
	
	public Kiwi(String name) {
		this(name,30) ;  //3번째 생성자 호출됨.
		
	}
	
	public Kiwi(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Kiwi [name=" + name + ", age=" + age + "]";
	}	
	
	
}

