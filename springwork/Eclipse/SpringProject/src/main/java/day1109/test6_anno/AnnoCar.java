package day1109.test6_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

//@Component  //id : annoCar
//public class AnnoCar {
	
	@Component  //id : mycarAnnoCar.java
	public class AnnoCar {	
	
//	@Autowired //�ڵ� ���� - ���� �߻� : ��Ī ������ Ŭ������ koreaTire, canadaTire 2���̹Ƿ� ������ �߻�.
//	AnnoTire annoTire;
	
	// �������̽��� ������ Ŭ������ �������� ��� ��Ȯ�ϰ� Ŭ���������� �����ϸ� �ǵ��.
	// �����ϰ� �������ָ� �ڵ����Եȴ�.
	
	@Autowired
	//@Resource(name = "annoKoreaTire")
	AnnoCanadaTire annoTire;
	public void myCarInfo() {
		System.out.println("�� ���� Ÿ�̾�� " + annoTire.getTireName() + "�Դϴ�.");
	}


//	@Re(name ="annoCanadaTire")
//	AnnoCanadaTire annoTire;
//	public void myCarInfo() {
//		System.out.println("�� ���� Ÿ�̾�� " + annoTire.getTireName() + "�Դϴ�.");
//	}


}