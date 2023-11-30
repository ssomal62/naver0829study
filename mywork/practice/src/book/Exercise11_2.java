package book;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Exercise11_2 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		HashSet set = new HashSet(list);//Set에 넣어 중복제거
		TreeSet tset = new TreeSet(set);//오름차순
		Stack stack = new Stack();// Stack . 에 넣었다 꺼내면 저장순서가 반대가 된
		stack.addAll(tset);// TreeSet의ㅏ 저장된 모든 요소를 stack에 담는다. .
		
		while(!stack.empty()) {
			System.out.println(stack.pop()); // stack . 에 저장된 값을 하나씩
		}

		
		
		
	}
}


//실행결과 적기

//3,6,2,7,
//
//7, 2, 6, 3