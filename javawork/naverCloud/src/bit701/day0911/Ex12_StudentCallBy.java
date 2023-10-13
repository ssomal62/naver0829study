package bit701.day0911;


public class Ex12_StudentCallBy {
	
	
	//주소가 넘어오므로 여기서 준 초기값은 main의 stu로 값이 전달된다.
	
	public static void dataInput(Student99[] stu) {
		stu[0] = new Student99("김씨",1000,10);
		stu[1] = new Student99("이씨",2000,90);
		stu[2] = new Student99("박씨",1989,89);
	};
	
	public static void dataWrite(Student99[] stu) {
		for(Student99 s : stu) {
		System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		
		Student99[] stu= new Student99[3];
		
		dataInput(stu);
		dataWrite(stu);
		
		int a = 100;
		int b = changeInt(a);
		System.out.println(a + "을 " + b + "로 변경했어요.");		
	}

	
	private static int changeInt(int a) {
		return a = 200;
	}

	
}
