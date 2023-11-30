package thisIsJava.chapter17;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParalleExample {
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		
		List<Integer> scores = new ArrayList<>();
		
		for(int i = 0; i < 100000000; i++) {
			scores.add(random.nextInt(101));	
		}
		
		double avg = 0.0;
		long startTime = 0;
		long endTime = 0;
		long time = 0;
		
		
		//일반스트림
		Stream<Integer> stream = scores.stream();
		startTime = System.nanoTime();		
		avg = stream.mapToInt(Integer::intValue).average().getAsDouble();		
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("avg : " + avg + ", 일반 스트림 처리 시간 : " + time + " ns");
		
		
		
		
		//병렬 스트림
		//요소가 적으면 일반을 쓰자. 병렬은 포크 및 조인 단계와 스레드풀? 뭔말인지를 모르겠지만 이러한 것들이 생성되는 추가적인 비용이 발생
		//ArrayList는 요소에 직접접근하니까 병렬로 했을 때 시간 절약이 있음.
		//단, HashMap, TreeSet LinkedList 들은 요소 분리 및 링크를 따라가고 이런 것들 때문에 병렬처리가 늦은편.
		//CPU 코어 수가 많으면 많을 수록 병렬 스트림 성능이 좋아짐. 코어 수가 적을 수록 일반스트림이 나을 수도 있음.
		
		Stream<Integer> paralleStream = scores.parallelStream();
		startTime = System.nanoTime();
		avg = paralleStream.mapToInt(Integer::intValue).average().getAsDouble();		
		endTime = System.nanoTime();
		time = endTime - startTime;
		System.out.println("avg : " + avg + ", 병렬 스트림 처리 시간 : " + time + " ns");
	}

}
