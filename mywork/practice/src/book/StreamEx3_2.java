package book;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx3_2 {
	public static void main(String[] args) {
		
		String[] lineArr = {
				"Belive of not It os true",
				"Do ro do not There is no try"
		};
		
		Stream<String> lineStream = Arrays.stream(lineArr);
		Stream<String> strStream = lineStream.flatMap(line -> Stream.of(line.split(" +")));
		strStream.map(String::toUpperCase)
		.distinct()
		.sorted()
		.forEach(System.out::println);
		
		
		
		//스트림 합치기 -- flatMap 이용
		Stream<String> strStrm1 = Stream.of("abc","def","jklmn");
		Stream<String> strStrm2 = Stream.of("ABC","GHI","JKLMN");
		
		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1,strStrm2);
		
		Stream<String> strStream1 = strStrmStrm.map(s->s.toArray(String[]::new))
				.flatMap(Arrays::stream);
		
		strStream1.map(String::toLowerCase).distinct().forEach(System.out::println);
		
		
		
	}
}