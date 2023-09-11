package bit701.day0911;

public class Ex3_VarArg {
	
	public static int sum(int ...n) {
		System.out.println("총 " + n.length + "개");
		int s = 0;
		for(int i = 0; i< n.length; i++) {
			System.out.println(i + ":" + n[i]);
			s+=n[i];
		}
		return s;
	}
	
	public static String Str(String ...s) {
		String str = "";
		for(int i = 0; i < s.length ; i++){
		
			 str += s[i];
		}
		return str;
	}

public static void main(String[] args) {
	
	int s1 = sum(4,6,8);	
	System.out.println(s1);
	
	String str1 = Str("안녕","하세요! ","너무나 ","반갑","습니다.");
System.out.println(str1);	
}
}
