package bit701.day0831;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateEx {
	
	public static void main(String[] args) {
		
		LocalDate date0 = LocalDate.of(2023, 12, 11);
		System.out.println("date0 :" + date0);
		
		LocalDate date1 = LocalDate.now();
		System.out.println("date1 :" + date1);
		
		LocalDate date2 = LocalDate.now();
		System.out.println("date2 :" + date2);
		
		LocalDateTime date3 = LocalDateTime.now();
		System.out.println("date3 :" + date3);
		
		int money = 456789;
		
		
		//회계단위로 숫자 출력
		NumberFormat numberFormat = NumberFormat.getInstance();	//단순 콤마만 추가해서 출력
		System.out.println(numberFormat.format(money));
		
		NumberFormat numberFormat1 = NumberFormat.getCurrencyInstance(); //지역설정된 화폐단위 붙여서 출력
		System.out.println(numberFormat1.format(money));
		
		double num = 456.12345;
		
		System.out.println(numberFormat1.format(num));//정수만 나옴
		numberFormat1.setMaximumFractionDigits(1); // 소수점 한자리로 출력.
		System.out.println(numberFormat1.format(num));
		
	}

}
