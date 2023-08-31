package bit701.day0831;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		
	
		System.out.println("[1] : " + cal.getTime());
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int weekint = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("요일" + weekint);
		
		String weekday = weekint==5? "목요일":"";
		
		System.out.println("Year :" + year);	
		System.out.println("[2] : " + year + "/"+ month +"/" + weekday + "입니다.");
		
		Date date = new Date();
		int year1 = date.getYear() + 1900;
		int month1 = date.getMonth() + 1;
		int day = date.getDate();
		
		System.out.printf("오늘은 %d년 %02d월 %02d일 입니다.", year1, month1, day);
		//알고보니 Calendar도 불안정하다고 쓰지 말라고함.
		//앞으로는 LocalDate, LocalDateTime 에 대해서 공부하고 쓰도록하자 !
		
	}
}
