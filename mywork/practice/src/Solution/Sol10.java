package Solution;

public class Sol10 {
	boolean[] included = { true, false, false, true, true };

	public int Solution(int a, int d, boolean[] included) {
		//int[] series = new int[included.length];
        int answer = 0;

        for(int i = 0; i < included.length; i++){

            if(included[i]){  //included가 true 이기 때문에... true 일 경우만 진입하는 거지.. ㅠㅠ 힝구
  
                answer +=  a + (d*i);

            }
        }

        return answer;
        }

	public static void main(String[] args) {

		Sol10 sol = new Sol10();
		System.out.println(sol.Solution(3, 4, sol.included));

	}

}
