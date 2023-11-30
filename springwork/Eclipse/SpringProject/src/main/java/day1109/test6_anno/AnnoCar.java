package day1109.test6_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

//@Component  //id : annoCar
//public class AnnoCar {
	
	@Component  //id : mycarAnnoCar.java
	public class AnnoCar {	
	
//	@Autowired //자동 주입 - 에러 발생 : 매칭 가능한 클래스가 koreaTire, canadaTire 2개이므로 오류가 발생.
//	AnnoTire annoTire;
	
	// 인터페이스를 구현한 클래스가 여러개인 경우 정확하게 클래스명으로 선언하면 ㅗ딘다.
	// 유일하게 설정해주면 자동주입된다.
	
	@Autowired
	//@Resource(name = "annoKoreaTire")
	AnnoCanadaTire annoTire;
	public void myCarInfo() {
		System.out.println("내 차의 타이어는 " + annoTire.getTireName() + "입니다.");
	}


//	@Re(name ="annoCanadaTire")
//	AnnoCanadaTire annoTire;
//	public void myCarInfo() {
//		System.out.println("내 차의 타이어는 " + annoTire.getTireName() + "입니다.");
//	}


}
