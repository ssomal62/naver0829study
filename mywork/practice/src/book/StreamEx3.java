package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) {

		ArrayList<StudentEx1> stu = new ArrayList<>();
		stu.add(new StudentEx1("이자바", 3, 300));
		stu.add(new StudentEx1("김자바", 1, 200));
		stu.add(new StudentEx1("안자바", 2, 100));
		stu.add(new StudentEx1("박자바", 2, 150));
		stu.add(new StudentEx1("소자바", 1, 200));
		stu.add(new StudentEx1("나자바", 3, 290));
		stu.add(new StudentEx1("감자바", 3, 180));

		Stream<StudentEx1> stuStream = stu.stream();

		stuStream.sorted(Comparator.comparing(StudentEx1::getBan).thenComparing(Comparator.naturalOrder()))
				.forEach(System.out::println);

		stuStream = stu.stream();

		IntStream stuScoreStream = stuStream.mapToInt(StudentEx1::getTotalScore);

		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println("count : " + stat.getCount());
		System.out.println("sum : " + stat.getSum());
		System.out.println("avereage : " + (int) stat.getAverage());
		System.out.println("min : " + stat.getMin());
		System.out.println("max : " + stat.getMax());

		System.out.println("==========================");
		// 스트림 문자열 합
		IntStream charstream = "12345".chars();
		int charSum = charstream.map(ch -> ch - '0').sum();
		System.out.println("합계 : " + charSum);

		System.out.println("==========================");
		// 로또 만들기
		IntStream intStream = new Random().ints(1, 46);
			//1번방법
		String lottoNum = intStream.distinct().limit(6).sorted().mapToObj(i -> i+ ", ").collect(Collectors.joining());
		System.out.println(lottoNum);
		
		intStream = new Random().ints(1, 46);
		Stream<String> lottoNum2 = intStream.distinct().limit(6).mapToObj(i -> i + ", ");
		lottoNum2.forEach(System.out::print);
	}

}
