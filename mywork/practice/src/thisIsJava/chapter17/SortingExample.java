package thisIsJava.chapter17;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

	public static void main(String[] args) {
		
		List<Student> stuList = new ArrayList<>();
		
		stuList.add(new Student("홍길동",30));
		stuList.add(new Student("신용권",10));
		stuList.add(new Student("유미선",20));
		stuList.add(new Student("유미르",40));
		stuList.add(new Student("보우니",50));
		
		stuList.stream().sorted(comparing(Student::getScore)).forEach(System.out::println);
		System.out.println();
		
		int a = stuList.stream().mapToInt(Student::getScore).sorted().sum();
		System.out.println(a);
		
		System.out.println();
		stuList.stream().map(Student::getScore).sorted((o1, o2) -> o2-o1).forEach(System.out::println);
		System.out.println();
		
		stuList.stream().sorted((o1, o2) -> Integer.compare(o1.getScore(), o2.getScore())).forEach(System.out::println);//오름차순
		System.out.println();
		
		stuList.stream().sorted((o1, o2) -> Integer.compare(o2.getScore(), o1.getScore())).forEach(System.out::println);//내림차순
		System.out.println();
		
		
		stuList.stream().map(Student::getName)
		.peek(i -> System.out.println("Peek1 : " +i))
		.sorted()
		.peek(i -> System.out.println("Peek2 : " +i))
		.forEach(System.out::println);

		
	}
}
