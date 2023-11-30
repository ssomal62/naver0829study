package javaStudy;

public class TestExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		int[] arr = new int[50];
		try {
			test.get50thItem(arr);
			System.out.println("이거로구나");
		}catch(Exception e){
			System.out.println("[오류문구] : " + e.toString());
		}
		
		
	}

}
