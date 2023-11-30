package thisIsJava.chapter08;

import java.util.HashSet;

public class HashCodeExample {

	public static void main(String[] args) {

		HashSet hashSet = new HashSet();

		Student s1 = new Student(1, "홍길동");
		hashSet.add(s1);
		System.out.println("저장된 객체 수 : " + hashSet.size());

		Student s2 = new Student(1, "홍길동");
		hashSet.add(s2);
		System.out.println("저장된 객체 수 : " + hashSet.size()); // 동등 객체는 중복저장되지 않음

		Student s3 = new Student(1, "이소연");
		hashSet.add(s3);
		System.out.println("저장된 객체 수 : " + hashSet.size()); // 동등 객체는 중복저장되지 않음



		if (s1.hashCode() == s2.hashCode()) {
			if (s1.equals(s2)) {
				System.out.println("동등 객체 입니다.");
			} else {
				System.out.println(" 데이터가 다르므로 동등객체가 아닙니다.");
			}

		} else {
			System.out.println("해시코드가 다르므로 동등 객체가 아닙니다.");
		}
	}

}

class Student {

	private int no;
	private String name;

	public void setNo(int no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		int hashCode = no + name.hashCode();
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student target) {
			if (no == target.getNo() && name.equals(target.getName())) {
				return true;
			}
		}
		return false;
	}
}

//@Override
//public boolean equals(Object obj) {
//	if(obj instanceof Student target) {
//		if (no == target.getNo() && name.equals(target.getName())) {
//		return true;
//		}
//	}
//	return false;
//}
