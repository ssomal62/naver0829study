package bit701.day0913;

import java.util.Scanner;

interface Board {

	public void process();
	
}
// 총 4개의 서브 클래스 구현

class Insert implements  Board{
	@Override
	public void process() {
		System.out.println("새 글쓰기합니다.");		
	}
	
}

class Delete implements  Board{
	@Override
	public void process() {
		System.out.println("글 삭제합니다.");		
	}
	
}

class Update implements  Board{
	@Override
	public void process() {
		System.out.println("글 수정합니다.");		
	}
	
}

class List implements  Board{
	@Override
	public void process() {
		System.out.println("목록을 불러옵니다.");		
	}
	
}



public class Ex7_InterfaceTest {

	public static void process(Board b) {
		b.process();

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		Board b = null;
		
		Exit:
		while (true) {
			System.out.println("1 글쓰기 | 2 글삭제 | 3 글수정 | 4 글목록 | 5 종료");
			System.out.printf("선택 >> ");
			
			num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			
			case 1 :
				b = new Insert();
				b.process();
				break;
			case 2 :
				b = new Delete();
				b.process();
				break;
			case 3 :
				b = new Update();
				b.process();
				break;
			case 4 :
				b = new List();
				b.process();
				break;
			case 5 :
				System.out.println("프로그램 종료 ");
				break Exit;
			}
		}

	}
}
