package day1108.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx2 {
	public static void main(String[] args) {
		System.out.println("1. �⺻ �ڹ� ������� MessageInter ����");
		MessageImpl m1 = new Message1();
		m1.sayHello("�̿���");
		MessageImpl m2 = new Message2();
		m2.sayHello("gngn");
		
		System.out.println("2. �������� xml ���� ������� ���� �����ϱ�");
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext1.xml");
		
		MessageImpl m3 = (Message1)context.getBean("mes1");//��ȯŸ���� Object�̹Ƿ� Ÿ���� �����ϰų� ����ȯ�� �ؼ� Ÿ���� �����.
		MessageImpl m3_1 = (Message1)context.getBean("mes1"); 
		m3.sayHello("����Ŭ");
		
		MessageImpl m4 = context.getBean("mes2", Message2.class);
		MessageImpl m4_1 = context.getBean("mes2", Message2.class);
		m4.sayHello("ĳ����");
		
		System.out.println("�ּҺ��ϱ�");
		
		System.out.println(m3.hashCode() + ", " + m3_1.hashCode()); //singletom�� ������ �����ص� �ּҰ�����. 
		System.out.println(m4.hashCode() + ", " + m4_1.hashCode());
		
		
	}
}
