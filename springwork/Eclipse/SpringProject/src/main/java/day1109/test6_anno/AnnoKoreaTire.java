package day1109.test6_anno;

import org.springframework.stereotype.Component;

@Component  
public class AnnoKoreaTire implements AnnoTire {
	
	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "������̼� �ѱ� Ÿ�̾�";
	}

}