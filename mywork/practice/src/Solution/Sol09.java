package Solution;

import javax.sound.sampled.BooleanControl;

public class Sol09 {

    public String solution(String code) {

        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int idx = 0; idx < code.length(); idx++) {
            char c = code.charAt(idx);

            if (c == '1') {
                mode = 1 - mode; //토글로 사용하기 좋음 .. 미쳤다..
            } else {
            	//if ((mode == 0 && idx % 2 == 0) || (mode == 1 && idx % 2 != 0)){  //이거 축약한게 바로아래꺼
                if (mode == idx % 2) { //이걸 생각해낸 애도 미쳤따... 문제에 대해 완벽하게 겹치는 항목들을 파악하면 좋은 예..
                    answer.append(c); 
                }
            }
        }

        if (answer.length() == 0)
            return "EMPTY";
        else
            return answer.toString();
    }



	public static void main(String[] args) {

		Sol09 sol = new Sol09();

		System.out.println(sol.solution("AbF1dbc1abc"));
	}
}
