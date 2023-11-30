package day1109.test6_anno;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component("mycar2")
@AllArgsConstructor
public class AnnoCar2 {
	
	AnnoKoreaTire koreaTire;
	AnnoKoreaTire canadaTire;
	
	public void myCarInfo() {
		System.out.println("�� ���� Ÿ�̾�� " + koreaTire.getTireName() + "�Դϴ�.");
		System.out.println("�� ���� Ÿ�̾�� " + canadaTire.getTireName() + "�Դϴ�.");
	}

}
