package javaStudy;

public class StringMethodExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello";
		System.out.println(str.length());
		System.out.println(str.concat(" world")); 
		System.out.println(str);
		str = str.concat(" world");
		
		System.out.println(str);
		System.out.println(str.substring(5));
		System.out.println(str.substring(1, 4));
	}

}
