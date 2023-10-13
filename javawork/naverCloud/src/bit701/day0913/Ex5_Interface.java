package bit701.day0913;
//인터페이스는 기능구현을 할 메서드들의 목록을 나열해놓는 일을 한다.

//인터페이스는 상수와 추상메서드만 구현이 가능함
//구분할 필요가 없기 때문에 fianl, abst~를 생략 가능해
//인터페이스도 객체 생성불가

interface InterA {

	int SCORE = 100;

	public void play();

	public void study();

}

class MY implements InterA {

	int myScore = SCORE;

	@Override
	public void play() {
		System.out.println("플레이합니다. Score : " + SCORE);
	}

	@Override
	public void study() {
		System.out.println("점수변경" + (myScore - 20));
	}
	
	public void processMY() {
		System.out.println("마이의 프로세스 ");
	}

}

public class Ex5_Interface  {

	public static void main(String[] args) {
		
		InterA my = new MY();
		my.play();
		my.study();
	//	a.processMy()//Override 메서드가 아니므로 My로 선언시에만 호출 가능
		
		MY me = new MY();
		me.processMY();

	}

}
