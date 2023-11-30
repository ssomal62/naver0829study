package javaStudy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExam {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Set<String> set1 = new HashSet<>();// set은 인터페이스라 new로 구현 못함
		boolean flag1 = set1.add("kang");
		boolean flag2 = set1.add("kim");
		boolean flag3 = set1.add("kang");
		
		System.out.println(set1.size());//자료구조 사이즈.. flag로 3개를 저장했지만 같은값이 있기 때문에 2만 나옴
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);
		
		Iterator<String> iter = set1.iterator();
		while(iter.hasNext()) { //hasNext >> 데이터가 있는 동안만..  반복하는 구조
			String str = iter.next();//하나를 꺼내주고 자동으로 다음값을 참조함
			System.out.println(str);
		}
		
		

	}

}
