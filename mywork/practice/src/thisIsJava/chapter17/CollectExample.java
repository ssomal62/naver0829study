package thisIsJava.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {

	public static void main(String[] args) {

		List<Student> stu = new ArrayList<>();

		stu.add(new Student("홍길동", "남", 92));
		stu.add(new Student("김갑수", "남", 87));
		stu.add(new Student("김현미", "여", 85));
		stu.add(new Student("고은비", "여", 77));
		stu.add(new Student("홍길동", "남", 94));
		
		Map<String,List<Student>> map = stu.stream().collect(Collectors.groupingBy(Student::getSex));
		
		List<Student> mailList = map.get("남").stream().collect(Collectors.toList());
		
		for(Student s : mailList) {
			System.out.println(s);
		}
		
		Map<String,Double> avg = stu.stream()
				.collect(Collectors.groupingBy(
						Student::getSex,// key영역이라 고정된 값
						Collectors.averagingDouble(Student::getScore) //value 영역이라 집계 가능한 메소드 
						));
		
		System.out.println(avg);
		
		System.out.println();
		
		Map<String,Double> avg2 = stu.stream()
				.collect(Collectors.groupingBy(
						Student::getSex,// key영역이라 고정된 값
						Collectors.averagingDouble(Student::getScore) //value 영역이라 집계 가능한 메소드 
						));
		
		//맵 키, 밸류 설정 > list.collect(Collectors.groupingBy(list에서 키값으로 줄 메서드참조, Collectors.averagingDouble(list에서 value값으로 줄 메서드참조)));
		
		

		

	}
	


}
