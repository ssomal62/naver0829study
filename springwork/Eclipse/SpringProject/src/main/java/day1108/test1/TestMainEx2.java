package day1108.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx2 {
	public static void main(String[] args) {
		System.out.println("1. 기본 자바 방식으로 MessageInter 생성");
		MessageImpl m1 = new Message1();
		m1.sayHello("이영자");
		MessageImpl m2 = new Message2();
		m2.sayHello("gngn");
		
		System.out.println("2. 스프링의 xml 설정 방식으로 객세 생성하기");
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext1.xml");
		
		MessageImpl m3 = (Message1)context.getBean("mes1");//반환타입이 Object이므로 타입을 지정하거나 형변환을 해서 타입을 맞춘다.
		MessageImpl m3_1 = (Message1)context.getBean("mes1"); 
		m3.sayHello("마이클");
		
		MessageImpl m4 = context.getBean("mes2", Message2.class);
		MessageImpl m4_1 = context.getBean("mes2", Message2.class);
		m4.sayHello("캐서린");
		
		System.out.println("주소비교하기");
		
		System.out.println(m3.hashCode() + ", " + m3_1.hashCode()); //singletom은 여러밴 생성해도 주소가같다. 
		System.out.println(m4.hashCode() + ", " + m4_1.hashCode());
		
		
	}
}
