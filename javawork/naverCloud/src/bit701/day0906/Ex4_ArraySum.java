package bit701.day0906;

public class Ex4_ArraySum {
	public static void main(String[] args) {
		
		int[] score = {78, 100, 90, 89, 69};
		int sum = 0;
		double avg = 0;
		
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		
		avg = (double) sum/score.length;
		
		System.err.println("총 점수 개수 : " + score.length);
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
		for(int i : score) {
			i+= i;
		}
		
		System.out.println(sum);

	}
}
