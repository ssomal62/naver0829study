//정수가 담긴 리스트 num_list가 주어집니다. num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.

package Solution;
import java.util.Arrays;
public class Sol13 {
	
	int[] arr = {3, 4, 5, 2, 1 };
	
	
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = new String("");   //int로 놓고 10씩 곱해주는 방식도 있음.
        String even = new String("");
        // ============== 111..   
        for(int i : num_list) {    	
        	if (i%2 == 0) even += i;
        	if (i%2 != 0) odd +=  i;
        }
        return answer = Integer.valueOf(even)+ Integer.valueOf(odd);
        // ============== 스트림이용..
     // ============== 스트림이용.. 변수 int 로 놓고 해야함.
//        even = Integer.parseInt(Arrays.stream(num_list).filter( i -> i % 2 == 0).mapToObj(String::valueOf).reduce("",String::concat));  //1번 솔류션
        //     = Integer.parseInt(Arrays.stream(num_List).filter( i -> i % 2 != 0).mapToObj(String::valueOf).collect(Collectors.joining())); //2번 솔류션
//        odd = Integer.parseInt(Arrays.stream(num_list).filter( i -> i % 2 != 0).mapToObj(String::valueOf).reduce("",String::concat));
//        return answer = even+odd;
        // ============== 스트림이용..

    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol13 sol = new Sol13();
		System.out.println(sol.solution(sol.arr));

	}


}
