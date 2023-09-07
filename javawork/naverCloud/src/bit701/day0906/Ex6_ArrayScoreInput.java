package bit701.day0906;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex6_ArrayScoreInput {

	public static void main(String[] args) {
		
		// Score에 5개의 배열 할당 총점과 평균을 구하세요.
		int[] arr = new int[5];
		
		
		System.out.printf("입력 점수 : " );
		for(int i = 0; i < arr.length ; i++) {
			arr[i] = (int)(Math.random()*80)+21;
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	
		
	
		int sum = Arrays.stream(arr).sum();
		double avg = Arrays.stream(arr).average().getAsDouble();
		
		System.out.println("총점 : " + sum + ", 평균 : " + avg);
		
		///유용팁!
		for(int i = 0; i < 5 ; i++) {
			if(!(0 < i && i < 100)) {
				i--;
				System.out.println("범위값을 벗어나면 다시 입력 할 수 있도록 i 값 유지.");
				
			}
		}
		
		
	}
	

}
