package bit701.day0904;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Ex99_Calendar {
	public static void main(String[] args) {
		
		LocalDate date1 = LocalDate.of(2023, 4, 19);
		System.out.println(date1);
		
		Month date2 = LocalDate.from(date1).getMonth();
		System.out.println(date2);
		
		DayOfWeek date3 = LocalDate.from(date1).getDayOfWeek();
		System.out.println(date3);
		
		int date4 = LocalDate.from(date1).getDayOfMonth();
		System.out.println(date4);
		
		int date5 = LocalDate.from(date1).lengthOfMonth();
		System.out.println(date5);

			

	}
}
