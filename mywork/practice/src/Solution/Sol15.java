//정수 n과 문자열 control이 주어집니다. control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며, control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.
//"w" : n이 1 커집니다.
//"s" : n이 1 작아집니다.
//"d" : n이 10 커집니다.
//"a" : n이 10 작아집니다.
//위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.


package Solution;
import java.util.*;
public class Sol15 {
    public int solution(int n, String control) {
//        for (char ch : control.toCharArray()){
//        	switch(ch) {
//        	case('w'): n += 1; break;
//        	case('s'): n -= 1; break;
//        	case('d'): n += 10; break;        	
//        	case('a'): n -= 10; break;
//        	}      	
//        }      
//        return n;
    	
//== 희표 좌의 답 따라하기 =====
    	
    	return control.chars().reduce(n, (acc,c) -> acc + (c =='w'? 1 : c == 's'?  -1 : c == 'd' ? 10 : -10));

//== 희표 좌의 답 따라하기 =====
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol15 sol = new Sol15();
		System.out.println(sol.solution(0, "wsdawsdassw"));
	}

}
