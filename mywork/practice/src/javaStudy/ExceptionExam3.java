package javaStudy;

public class ExceptionExam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 10;
		int j = 0;
		try {
		int k = divide(i, j);
		System.out.println(k);
		}catch(IllegalArgumentException e) {
			System.out.println("[오류] : " + e.toString());
		}
	}
	
	public static int divide(int i, int j) throws IllegalArgumentException {
		
		if ( j==0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}
		int k = i/j;
		return k;
	}

}
