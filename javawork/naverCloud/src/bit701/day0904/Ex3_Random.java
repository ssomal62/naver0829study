package bit701.day0904;

import java.util.Random;

public class Ex3_Random {
	
	public static void main(String[] args) {
		
		int num = (int)(Math.random() * 10)+1;  // 범위 0.0 <= x < 1.0
		System.out.println(num);
	
		for (int i = 0; i < 5 ; i++) {
			int ch = (int)(Math.random() * 26) + 65;  
			System.out.print((char)ch + "  ");
		}
		
		
		System.out.println();
		
		
		for (int i = 0; i < 5 ; i++) {
			
			int ch = (int)(Math.random() * 26) + 97;  
			System.out.print((char)ch + "  ");
		}
		
		

		
	}

}
