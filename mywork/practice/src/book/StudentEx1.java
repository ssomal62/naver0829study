package book;

public class StudentEx1 implements Comparable<StudentEx1> {

	String name;
	int ban;
	int totalScore;
	
	public StudentEx1(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]",name,ban,totalScore).toString();
	}
	
	String getName() {return this.name;}
	int getBan() {return this.ban;}
	int getTotalScore() {return this.totalScore;}
	
	@Override
	public int compareTo(StudentEx1 s) {
		return s.totalScore - this.totalScore;
	}
	

}
