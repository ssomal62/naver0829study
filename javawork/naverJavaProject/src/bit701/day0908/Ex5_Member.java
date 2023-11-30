package bit701.day0908;

public class Ex5_Member {
	
	private int age;
	private String name;
	private int number;
	private String ageFormat;

	
	
	public String getName() {
		return name + "";
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAge() {
		return ageFormat;
	}
	public void setAge(int age) {		
		//if(2024년 이라면) age++:
		ageFormat = age + "세";
	}
	
	
}
