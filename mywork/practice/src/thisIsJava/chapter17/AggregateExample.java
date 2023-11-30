package thisIsJava.chapter17;

import java.util.Arrays;

public class AggregateExample {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		
		long count = Arrays.stream(arr).filter(i -> !(i%2==0) ).count(); //요소 개수 카운트
		
		System.out.println(count);
		
		double avg = Arrays.stream(arr).average().getAsDouble();//optinal 타입으로 반환되기 때문에 getAs 추가해줘야함. min, max 도 마찬가지
		System.out.println(avg);
		
		int max = Arrays.stream(arr).max().getAsInt();
		System.out.println(max);
		
		int first = Arrays.stream(arr).filter(i -> i%2==0).findAny().getAsInt();
		System.out.println(first);

	}

}
