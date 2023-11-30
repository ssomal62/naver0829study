package javaStudy;

public class StringExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "hello";

		String str3 = new String("hello");
		String str4 = new String("hello");

		if (str3 ==str4) {
			System.out.println("3과 4 같음");
		}
		else
			System.out.println("3과 4 같지 않음");
		
		System.out.println(str1);
			

	}

}
