package javaStudy;

public class BoxExam {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
//		Box box = new Box();
//		box.setObj(new Object());
//		Object obj =  box.getObj();
//		
//		box.setObj("hello");
//		String str = (String)box.getObj();
//		
//		System.out.println(str);
//		
//		box.setObj(1);
//		int value = (int)box.getObj();
		
		Box<Object> box = new Box<>();
		box.setObj(new Object());
		Object obj = box.getObj();
		
		
		Box<String> box2 = new Box<>();
		box2.setObj("스트링만 들어감. 인트형 쓰면 오류남");
		String str = box2.getObj();
		
		Box<Integer> box3 = new Box<>();
		box3.setObj(4);
		int v2 = box3.getObj();
		
		
		
		
		
	}
	
	

}
