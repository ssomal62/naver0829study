package javaStudy;

public class InnerExam2 {
	static class Cal{  //정적 내부 클래스
		int value = 7;
		public void plus() {
			value++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//InnerExam2.Cal cal = new InnerExam2.Cal(); 이렇게 써도됨.
		Cal cal = new Cal();
		
		cal.plus();
		System.out.println(cal.value);
	}

}
