package day1109.test6_anno;

import org.springframework.stereotype.Component;

@Component    //xml �� �ڵ����� bean ���-id�� Ŭ�������� ���̵� �ȴ�(ù���� �ҹ���:annoCanadaTire)
public class AnnoCanadaTire implements AnnoTire{
	

	@Override
	public String getTireName() {
		// TODO Auto-generated method stub
		return "������̼� ĳ���� Ÿ�̾�";
	}
	

}
