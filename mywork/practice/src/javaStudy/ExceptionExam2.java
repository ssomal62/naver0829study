package javaStudy;

public class ExceptionExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10;
		int j = 5;
		try {
		int k = divide(i,j);
		System.out.println(k);
		}catch(Exception e){
			System.out.println(e.toString());
		}

	}
	
	public static int divide(int i , int j) throws Exception{
		
		int k = i/j;
		return k;
	}

}
