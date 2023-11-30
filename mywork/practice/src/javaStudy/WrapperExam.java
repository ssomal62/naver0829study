package javaStudy;

public class WrapperExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5; //기본형타임, 객체아님, 참조형 아님
		Integer i2 = new Integer(5);//없어졌나봄. 이렇게 안쓰고 아래처러씀
		Integer i3 = 5;//(오토박싱)
		
		
		
		int i4 = i3.intValue();// 이제 이렇게 안쓰고 아래처럼 씀
		int i5 = i3;//오토언박싱
		
	}

}
