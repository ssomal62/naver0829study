package bit701.day0906;

public class Ex10_ArrayRank {
	
	public static void main(String[] args) {
		
		int[] score = {89, 96, 100, 77, 100, 80};
		int[] rank = new int[6];
		
		//등수를 어떻게 구할까?
		//모든 학생의 총점이 다 나와야
		//다중 for문 등수 구한 다음에 출력
		//출력 번호 - 점수 - 등수
		
		
		//등수 구하는 대표 코드라고 함!
		for(int i = 0 ; i < score.length ; i ++) {
			//각 i번지 등수는 1로 초기화
			rank[i] = 1;
			for(int j = 0 ; j < score.length; j++) {				
				//i번지 점수보다 j번지 점수가 더 크면 i번지 등수를 1증가		
				if(score[i] <score[j]) {
					rank[i]++;
				}
			}
		}
		
		System.out.println("번호 \t 점수 \t 등수");
		
		System.out.println("=".repeat(30));
		
		for(int i = 0; i < score.length; i++) {
			
			System.out.println(i+1 + "\t" + score[i] + "\t" + rank[i]);
		}
		
		
		
		
	}

}
