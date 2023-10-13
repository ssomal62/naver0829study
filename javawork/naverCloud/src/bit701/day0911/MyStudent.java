package bit701.day0911;

public class MyStudent {
	
	String name;
	int korScore;
	int engScore;
	
	
	public MyStudent() { //public 이 아니면  생성자 기능을 할 수 없음
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
	}


	public MyStudent(String name, int korScore, int engScore) {
		this.name = name;
		this.korScore = korScore;
		this.engScore = engScore;
	}
	
	//두과목의 합계를 구해서 리턴
	
	public int getTotal() {
		return korScore+engScore;
	}
	
	public double getAverage() {
		return getTotal()/2.0;
	}
	
	public String getGrade() {
		if (getAverage() > 90) return "A";
		else if(getAverage() > 80) return "B";
		else  return "탈락";		
	}


	@Override
	public String toString() {
		return "[ 이름 : " + name + ", 국어 : " + korScore + ", 영어 : " + engScore + ", 등급 : " + getGrade() + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
