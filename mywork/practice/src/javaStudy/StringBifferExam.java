package javaStudy;


public class StringBifferExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		sb.append("hello");
		sb.append(" world");
		
		String str = sb.toString();
		System.out.println(str);
		
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = sb2.append("hello");
		if (sb2 == sb3)
			System.out.println("sb==sb3");
		
		//스트링 버퍼 클래스 : 메소드 체이닝 : 자기자신을 리턴하여 계속해서 자신의 메소드를 호출하는 방식.
		
		
		String str2 = new StringBuffer().append("Hello").append(" ").append("world").toString();
		System.out.println();
	}

}
