package bit701.day0913;

abstract class AbsEx1 {
	int a = 100;
	final String str = "abstract test";

	public String getStr() {
		return str;
	}
	
	abstract public int getA();
	public static void main(String[] args) {
	}
}

abstract class AbsEx2 extends AbsEx1 {

	@Override
	public int getA() {
		return a;  //상속 받았으므로?
	}
	
	abstract public void show();
}

class AbsEx3 extends AbsEx2{
	@Override
	public void show() {
		System.out.println("마지막 구현 클래스");		
	}
	
}

public class Ex4_Abstruct {

	public static void main(String[] args) {
		
//		AbsEx1 ex1 = new AbsEx2();
//		System.out.println("a=" + ex1.getA());
//		System.out.println("str=" + ex1.getStr());
		
		AbsEx3 ex = new AbsEx3();
		System.out.println(ex.getA());
		System.out.println(ex.getStr());
		ex.show();
		
		
		System.out.println("=".repeat(40));
		AbsEx1 ex1 = new AbsEx3();
		
		System.out.println("a = " + ex1.getA());
		System.out.println("str = " + ex1.getStr());
		// ex.show() 오류 발생 
		
	}

}


