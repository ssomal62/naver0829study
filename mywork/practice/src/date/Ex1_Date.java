package date;

import java.util.Calendar;
import java.util.Date;

public class Ex1_Date {
	
	public static void main(String[] args) {
				
		Calendar cal = Calendar.getInstance();
		System.out.println("현재 연도 : " + cal.get(Calendar.YEAR));
		
		cal.set(Calendar.YEAR, 2002);
		

		System.out.println("변경된 연도 : " + cal.get(Calendar.YEAR));
		
		
		Date date = new Date();
        System.out.println("현재 날짜: " + date);
        date.setTime(0);
        System.out.println("변경된 날짜: " + date);
	        
	        
	}

}
