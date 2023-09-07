package bit701.day0906;

import java.util.Scanner;

public class Ex7_ArrayString {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] names;
		
		int count;
		
		System.out.printf("등록할 인원수를 입력하세요! >> ");

		count = Integer.parseInt(sc.nextLine());
		
		names = new String[count];
		
		for(int i = 0; i < names.length ; i++) {
			System.out.println(i +1 + "번 이름은?");		
			names[i] =sc.nextLine();
		}
		
		System.out.println("번호 \t 이름");
		
		for(int i = 0; i < names.length; i++) {
			
			System.out.println(i +1  + "\t" + names[i]);
		}
		
		
		
	}

}
