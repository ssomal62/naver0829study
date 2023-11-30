package javaStudy;

public class InnerExam1 {
	class Cal{
		int value = 0;
		public void plus() {
			value++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InnerExam1 t = new InnerExam1();  //1
		InnerExam1.Cal cal = t.new Cal();  //2
		cal.plus();
		System.out.println(cal.value);
		
		
		
		
	}

}
