package day1108.test1;

public class TestMainEx1 {
	public static void main(String[] args) {
		
		TestDto dto = new TestDto();
		dto.setName("�̼ҿ�");
		dto.setAddr("����");
		dto.setAge(34);
		
		System.out.println("�̸� : " + dto.getName());
		System.out.println("�ּ� : " + dto.getAddr());
		System.out.println("���� : " + dto.getAge());
		
		System.out.println("toString() ȣ��");
		System.out.println(dto);
		
		TestDto dto2 = new TestDto("������", "���ֵ�", 34);
		System.out.println(dto2);
		
		TestDto dto3 = new TestDto("����");
	}
}