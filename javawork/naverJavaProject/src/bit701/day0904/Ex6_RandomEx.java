package bit701.day0904;

import java.util.Scanner;

public class Ex6_RandomEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int rnd, count, input;

		Exit:
		while (true) {
			rnd = (int)(Math.random()*100) + 1;
			count = 0;
			
			while (true) {
				
				System.out.printf(++count +  " 번째 시도 >>");
				input = sc.nextInt();
				sc.nextLine();
				if (input == rnd) {
					System.out.printf("계속하시겠습니까? (y/n) >> ");
					String  str = sc.nextLine();
					
					if(str.equalsIgnoreCase("y")){ //equalsIgnoreCase (대소문자 관련없이 스펠링만 맞으면 됨).
						System.out.println("다시 시작합니다.");
						continue Exit;
					}else{
						System.out.println("종료");
						break Exit;
						}
					
				}else if(input > rnd) {
					System.out.println("더 낮은 숫자를 제시하세요.");
					continue;
				}else if(input < rnd) {
					System.out.println("더 높은 숫자를 제시하세요.");
					continue;
				}
				
				break Exit;
			}

		}
		
		
		
		

	}

}
