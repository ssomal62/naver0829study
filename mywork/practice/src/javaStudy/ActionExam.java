package javaStudy;

public class ActionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Action ac = new MyAction();
//		ac.exec();
		
		Action ac = new Action() {//익명클래스. Action 클래스를 해당클래스에서만 사용될 때 . 다른 클래서에서 전혀 사용될 필요가 없을 떄 구현 
			                      // 한번만 쓸거라 MyAction을 생성을 건너뛰고 하기 위한 방법.
			
			@Override
			public void exec() {
				// TODO Auto-generated method stub
				System.out.println("exec2");
			}
		};
		ac.exec();
	}
	

}
