package bit701.day0904;

public class Ex7_Book051 {

	public static void main(String[] args) {

		// json 데이터 형식 {"키" : "값 }
		String jdata = "{ \"name\" : \"이진\" }"; // 따옴표붙일때 .....
		System.out.println(jdata);
		
		// jdk에서 추가된 텍스트 블록 문법
//		String jdata1 = """
//				{ "name"" : "캔디", "address", "역삼동" }
//						""";
		
		
		String name ="캔디";
		int age = 25;
		
		String jdata4 = """
				{"name":"%s, "age" : %d}			
				""".formatted(name,age);
		
		System.out.println(jdata4);
		
		String  str2 = """
				red
				blue
				green
				""";
		
		System.out.println(str2);

	}

}
