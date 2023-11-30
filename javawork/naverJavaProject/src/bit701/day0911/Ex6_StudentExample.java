package bit701.day0911;

public class Ex6_StudentExample {

	public static void main(String[] args) {

		Student99[] stu = { 
				new Student99("홍길동", 3000, 20), 
				new Student99("김이나", 999, 20),
				new Student99("슬라임", 4567, 55),

		};

		printStudent(stu);

	}

	
	public static void printStudent(Student99[] s) {

		for(Student99 stu :s) {
			System.out.println(stu);
		}

	}

}
