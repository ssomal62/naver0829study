package bit701.day0904;

public class Ex9_String {
	public static void main(String[] args) {

		String str1 = "apple";
		String str2 = "APPLE";
		String str3 = "Have a nice day!";
		String str4 = "          HAPPY       !";
	
		
		System.out.println(str3.length());
		System.out.println(str1.toLowerCase());
		System.out.println(str2.toUpperCase());
		System.out.println(str3.substring(5));
		System.out.println(str3.substring(7,11)); //7번부터 10번까지 추출해서 출력
		System.out.println(str3.charAt(0));
		System.out.println(str1.charAt(3));
		System.out.println(str1.indexOf('a'));
		System.out.println(str3.lastIndexOf('a'));
		System.out.println(str4.length());
		System.out.println("트림 : " + str4.trim().length());//중간 공백 제거 못함..
		System.out.println("sw" + str3.startsWith("Have"));
		System.out.println(str3.endsWith("day"));//대소문자 안맞아서 flase 나옴
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println(str1.compareTo(str2));
		System.out.println(str1.compareTo("apple"));// 두 값이 완전히 같을 경우 '0'출력됨 !!
		
		long time1 = System.nanoTime();
		int sum = 0;
		
		for (int i = 0; i < 10000 ; i++) {
			sum+=i;
		}
		long time2 = System.nanoTime();
		
		System.out.println(sum);
		System.out.println(time2 - time1 + " 나노초가 소요됨");
	

	}
}
