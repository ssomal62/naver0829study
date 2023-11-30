package Solution;

public class Sol4 {
	
	public void test() {
	String str = "반복합니다.";
	//String Stringrepeated = new String(new char[5]).replace("\0", str);
	//System.out.println(Stringrepeated);
	
	System.out.println(str.repeat(5));
	
	}
	
	public static void main(String[] args) {
		Sol4 sol = new Sol4();
		
		sol.test();
		
	}
}
