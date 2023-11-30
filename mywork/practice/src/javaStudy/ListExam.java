package javaStudy;

import java.util.*;
public class ListExam {

	public static void main(String[] args) {
		
		
		// TODO 자동 생성된 메소드 스텁
		List<String> list = new ArrayList<>();
		list.add("kim");
		list.add("kang");		
		list.add("kim");	
		
		System.out.println(list.size());
		
		//1번 출력
		for(int i = 0; i <list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
			}
		
		//2번 출력
		for(String str : list) {
			System.out.println(str);
        }
		//3번 출력
		String str = list.toString();
		System.out.println(str);
			

		
	}

}
