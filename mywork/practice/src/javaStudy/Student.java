package javaStudy;

import java.util.Objects;

public class Student {
	String name;
	String number;
	int birthYear;
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(number, other.number);
	}



	public static void main(String[] args) {
		Student s1 = new Student();
		
		s1.name = "홍길동";
		s1.number = "1234";
		s1.birthYear = 1995;
		
		Student s2 = new Student();
		
		s2.name = "홍길동";
		s2.number = "1234";
		s2.birthYear = 1995;
		
		if (s1.equals(s2))
			System.out.println("같아요");
		else
			System.out.println("달라요");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1.toString());
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", number=" + number + ", birthYear=" + birthYear + "]";
	}




	
}
