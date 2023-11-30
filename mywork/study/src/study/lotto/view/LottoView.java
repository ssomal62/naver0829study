package study.lotto.view;
//로또 게임의 UI를 정의하는 인터페이스

public interface LottoView {


// 내 로또넘버 보기
	public void selectNumbers(int[] selectedNumbers);

	public void runGame();

	public void displayResults();

	public void restartGame();

	public void exitGame();

	public void validateUserInput();

	public void updateView();



}
