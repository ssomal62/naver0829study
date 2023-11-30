package study.lotto.main;
//프로그램을 시작하는 메인클래스 

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import study.lotto.view.ConsoleLottoView;

public class LottoMain {

	static ConsoleLottoView view = new ConsoleLottoView();

	public static void main(String[] args) {

		view.showMenu();
		view.menu1();
		
		
		


	}

}
