package bit701.day0831;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam {
	
	public static void main(String[] args) {
		
		/*
		 * 상품명과 수량, 단가를 각각 입력받은 후 총금액을 출력하시오
		 * 그리고 수량이 5개 이상일경우 10프로 할인된 최종금액도 출력해주세요
		 * 
		 * (예)
		 * 상품명  : 딸기
		 * 수량 : 6
		 * 단가 : 1000
		 * 
		 * 
		 * 총금액 : 6000원
		 * 5개 이상 10프로 할인된 금액 : 5400원
		 */
		
		
		Scanner scanner = new Scanner(System.in);
		
		String productName = "";
		int price = 0;
		int discountprice = 0;
		int quantity = 0;
 
		
		System.out.println("구매할 상품을 선택해주세요.");
		System.out.println("==========================");	
		System.out.println("1. 딸기");
		System.out.println("2. 사과");
		System.out.println("3. 메론");
		System.out.println("==========================");
		System.out.printf("상품 이름 >> ");
		productName = scanner.nextLine();
		System.out.println();
		
		switch(productName) {
		case "딸기":
			price = 1000;
			break;
		default :
			System.out.println("상품 준비중입니다.");
			return;
		}
		
		System.out.println("구매 수량을 입력해주세요.");
		System.out.println("==========================");	
		System.out.printf("구매 수량 >> ");
		quantity = scanner.nextInt();

		System.out.println();
		System.out.println("구매 영수증");
		System.out.println("==========================");
		
		price *= quantity;
		NumberFormat numberFormat = NumberFormat.getInstance();	//단순 콤마만 추가해서 출력

		if(quantity >= 5) {
			discountprice = (int)(price*0.9);
			System.out.println("[" + price + "]" + "x" + quantity + "개 (단가 :" + numberFormat.format(price/quantity) + "원)");
			System.out.println("총 금액 " + numberFormat.format(discountprice) + "원 (10% 할인)");
			System.out.println("==========================");
		}else {
			System.out.println("[" + price + "]" + "x" + quantity + "개 (단가 :" + numberFormat.format(price/quantity) + "원)");
			System.out.println("총 금액" + numberFormat.format(price) + "원");
			System.out.println("==========================");
		}
		
		
		
		
	}

}
