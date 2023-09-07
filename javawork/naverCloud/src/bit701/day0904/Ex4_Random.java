package bit701.day0904;

import java.util.Random;

public class Ex4_Random {
	public static void main(String[] args) {
		
		Random rd = new Random();
		
		for(int i = 0; i < 5; i++) {
			
			int n = rd.nextInt(10); //0~9까지 발생		
			System.out.printf(n + " ");
		}
		System.out.println();
		
		for(int i = 0; i < 5; i++) {
			
			int n = rd.nextInt(100)+1; 
			System.out.printf(n + " ");
		}
		System.out.println();
		
		for(int i = 0; i < 5; i++) {
			
			int n = rd.nextInt(26) + 65; 
			System.out.printf((char)n + " ");
		}
		System.out.println();
		
	}

}
