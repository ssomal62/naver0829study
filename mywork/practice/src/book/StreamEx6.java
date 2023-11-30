package book;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx6 {
	public static void main(String[] args) {

		StudentEx1[] stuArr = { new StudentEx1("이자바", 3, 300), new StudentEx1("김자바", 1, 200),
				new StudentEx1("안자바", 2, 100), new StudentEx1("박자바", 2, 150), new StudentEx1("소자바", 1, 200),
				new StudentEx1("나자바", 3, 290), new StudentEx1("감자바", 3, 180), };
		
		//==============================================

		Stream<StudentEx1> stuStream = Stream.of(stuArr);
		// List<String> names = stuStream.map(StudentEx1::getName).collect(Collectors.toList());
		// List<String> names = stuStream.map(s -> s.getName()).toList();

		List<String> names = stuStream.map(StudentEx1::getName).toList();
		System.out.println(names);

		//==============================================

		StudentEx1[] stulist = Stream.of(stuArr).toArray(StudentEx1[]::new);

		for (StudentEx1 s : stulist)
			System.out.println(s);
		//==============================================

		stuStream = Stream.of(stuArr);
		Map<String,StudentEx1> stuMap = stuStream.collect(Collectors.toMap(n -> n.getName(), s -> s));

		for(String name : stuMap.keySet()) {
			System.out.println(name + "-" + stuMap.get(name));
		}
		//==============================================
		
		//long count = Stream.of(stuArr).map(StudentEx1::getName).count();
		long count = Stream.of(stuArr).collect(Collectors.counting());//그냥 counting() 만 써도 된다고 책에 나오는데 나는 안됨 ..		
		System.out.println("count : " + count);
		
		//==============================================
		
		//long totalScore = Stream.of(stuArr).map(StudentEx1::getTotalScore).reduce(0, (a,b) -> a + b);
		
		//1
		long totalScore = Stream.of(stuArr).collect(Collectors.summingInt(StudentEx1::getTotalScore));
		System.out.println("totalScore : " + totalScore);
		
		//2
		totalScore = Stream.of(stuArr).map(StudentEx1::getTotalScore).reduce(0, Integer::sum);
		System.out.println("totalScore1 : " + totalScore);
		
		//==============================================
		//1 어찌어찌구현한 내 답.. ㅠ
		Optional<StudentEx1> topStudent = Stream.of(stuArr).sorted((o1, o2) -> o2.totalScore - o1.getTotalScore()).findFirst();
		System.out.println("topStudent : " + topStudent.get());
		//2 
		topStudent = Stream.of(stuArr).sorted(Comparator.comparingInt(StudentEx1::getTotalScore).reversed()).findFirst();
		System.out.println("topStudent : " + topStudent.get());
		//3
		topStudent = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparingInt(StudentEx1::getTotalScore)));
		System.out.println("topStudent : " + topStudent.get());
		
		//==============================================
		IntSummaryStatistics stuStat = Stream.of(stuArr).collect(Collectors.summarizingInt(StudentEx1::getTotalScore));
		System.out.println(stuStat);
		
		//==============================================	
		String names2 = Stream.of(stuArr).map(StudentEx1::getName).collect(Collectors.joining(", ","{","}"));
		System.out.println(names2);
	}


}
