package bit701.day0911;


public class Student99{
	

	String name;
	int birthYear;
	int score;
	
	
	Student99() {
		this("이리리",2000,50);//아하.. 기본으로 출력하고자하는 값을 전달해야함.
	}
	
	
	Student99(String name, int birthYear, int score) {
		this.name = name;
		this.birthYear = birthYear;
		this.score = score;
	}



	@Override
	public String toString() {
		return "[name=" + name + ", birthYear=" + birthYear + "세 , score=" + score + "점]";
	}
	


	
	
}
