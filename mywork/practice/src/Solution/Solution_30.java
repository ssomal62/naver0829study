package Solution;


public class Solution_30 {

    public int solution2(String[] babbling) {
        int answer = 0;

        String[] words = {"aya", "ye", "woo", "ma"};

        for(String s : babbling) {
            for (String w : words){
                s = s.replaceFirst(w," ".repeat(w.length()));
            }
            if (s.trim().isEmpty()){
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution_30 sol = new Solution_30();

        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        System.out.println(" s : " + sol.solution2(babbling));

    }
}
