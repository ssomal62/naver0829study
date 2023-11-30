package thisIsJava.chapter17;

public class Student {

	private String name;
	private int score;
	private String sex;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public Student(String name,String sex,  int score) {
		this.name = name;
		this.score = score;
		this.sex = sex;
	}
	
	public String getName() {return name;}
	public String getSex() {return sex;}
	public int getScore() {return score;}
	
	public int compareTo(Student stu) {
		return Integer.compare(score, stu.score);
	}

	@Override
	public String toString() {
		return "Student [name : " + name + ", score:" + score + ", sex :" + sex + "]";
	}
	
	
	
}
