package study.lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
	LottoTicket t;

	public LottoGame() {
		t= new LottoTicket();
	}

	public List<Integer> setRandomNum() {
		List<Integer> randomStream = IntStream.iterate(0, n -> n).map(i -> (int) (Math.random() * 45) + 1).distinct()
				.limit(6).sorted().boxed().collect(Collectors.toList());
		return randomStream;
	}
	
	public void setLottoTicket() {
		
		//List<LottoTicket> ticket
		
	}

	// 당첨 번호 : 난수 생성 1~45 + 정렬 + 보너스 번호
	// 티켓과 비교하기

}
