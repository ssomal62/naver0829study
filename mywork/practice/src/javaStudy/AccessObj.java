package javaStudy;

public class AccessObj {
	
	public int p = 3;
	protected int p2 = 4; //같은 패키지. 다른패키지라도 상속은 허묭
	private int i = 1;
	int k = 2; //디폴트 접근지정자.
	
	private void test() {
		System.out.println(i);
	}
	// public > protected > default > private
	

}
