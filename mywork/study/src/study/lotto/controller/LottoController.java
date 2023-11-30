package study.lotto.controller;

import study.lotto.view.LottoView;
import study.lotto.model.LottoTicket;
//Model과 View 간의 상호 작용을 처리하는 컨트롤러 클래스.


public class LottoController implements LottoView {

	
	public LottoController(){		
		
	}
	

	@Override
	public void selectNumbers(int[] selectedNumbers) {
		// 사용자가 번호를 선택한 후 호출되는 메서드입니다.
		// 선택한 번호를 받아와 게임에 추가합니다.
		
	}
	
	@Override
	public void runGame() {
		// 당첨확인
		// 게임을 실행하고 로또 번호를 생성하는 메서드입니다.
		// 사용자가 선택한 번호와 당첨 번호를 비교하여 결과를 계산합니다.
		
	}
	@Override
	public void displayResults() {
		// 게임 결과를 사용자에게 표시하는 메서드입니다.
		// 당첨 번호, 상금, 정답 여부 등을 화면에 출력합니다.
	}
	
	@Override
	public void restartGame() {
		// 게임을 재시작하는 메서드입니다.
		// 게임 초기화 및 화면 리셋을 수행합니다.
		
	}
	
	@Override
	public void exitGame() {
		// 게임을 종료하는 메서드입니다.
		// 게임 종료 전에 사용자에게 확인을 받을 수 있도록 구현할 수 있습니다.

	}

	
	@Override
	public void validateUserInput() {
		// 사용자 입력을 유효성 검사하는 메서드입니다.
		// 잘못된 입력을 방지하고 오류 처리를 수행합니다.

	}
	

	
	@Override
	public void updateView() {
		//화면을 업데이트하는 메서드입니다.
		//게임 진행 상태에 따라 화면을 갱신하고 결과를 표시합니다.

	}




}
