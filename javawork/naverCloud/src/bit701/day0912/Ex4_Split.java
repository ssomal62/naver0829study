package bit701.day0912;

import java.util.StringTokenizer;

public class Ex4_Split {
	
	public static void main(String[] args) {
		
		
		
		String str1 = "rea, blue, green, orange, gray";
		
		String[] strArray = str1.split(", ");
		
		for(String s : strArray) {
			System.out.println(s);
		}
		
		System.out.println("=".repeat(30));
		
		String str2 = "sea.jpg";
		
		String[] str2Array = str2.split("\\."); //"\\." 이나  "[.]"으로 입력
		
		for(String s : str2Array) {
			System.out.println(s);
		}
		
		String str3 = "red|green|yellow";
		String[] str3Array = str3.split("\\|");//   "\\|"  이나 "[.]"으로 입력
		
		for(String s : str3Array) {
			System.out.println(s);
		}
		
		StringTokenizer st = new StringTokenizer(str1,",");
		System.out.println("총" + st.countTokens()+ "개로 분리");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}

}
