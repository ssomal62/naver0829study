package bit701.day0831;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex7_Format {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		Date date = new Date();
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
		System.out.println(dateFormat1.format(date));
		
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss EEEE");
		System.out.println(dateFormat2.format(date));
		
	}

}
