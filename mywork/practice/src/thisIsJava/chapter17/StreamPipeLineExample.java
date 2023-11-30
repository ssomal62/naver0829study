package thisIsJava.chapter17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamPipeLineExample {
	
	public static void main(String[] args) {
		
		List<Student> list = Arrays.asList(
				new Student("김길남", 10),
				new Student("김길남", 20),
				new Student("유미선", 25),
				new Student("신용권", 11),
				new Student("이재홍", 30)
				
				);
		
		double avg = list.stream().mapToInt(Student::getScore).average().getAsDouble();
		
		// Stream<Student> a = list.stream();
		// IntStream b = a.mapToInt(Student::getScore);
		// double c = b.average().getAsDouble();
		
		System.out.println(avg);
		
		System.out.println("=".repeat(40));
		
		
		Map<Integer,String> map = list.stream()
				.sorted(Comparator.comparing(Student::getName))
				.peek(a -> System.out.println("a : " + a))
				.collect(Collectors.toMap(Student::getScore,Student::getName));
		
		
		
		for(Map.Entry<Integer,String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Map<String,List<Student>> map2 = list.stream().collect(Collectors.groupingBy(s-> s.getName()));

		
		List<Student> kim = map2.get("김길남").stream().collect(Collectors.toList());
		
		System.out.println(kim);
		
		for(Student s : kim) {
			System.out.println(s.getName() + " : "+ s.getScore());
		}
		
		
		
	
		
	}


}
