package Solution;

public class Solution2 {

	    public String solution(String str1, String str2) {
	        String answer = "";
	        
	        for (int i = 0; i < str1.length() ;i++) {
	        	answer += String.valueOf(str1.charAt(i)) + String.valueOf(str2.charAt(i));

	        }
	        
	        return answer;
	    }
	public static void main(String[] args) {

		Solution2 sol = new Solution2();
		System.out.println(sol.solution("12345", "abcde"));
	}

}
