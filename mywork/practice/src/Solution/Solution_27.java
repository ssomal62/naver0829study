package Solution;

import static java.lang.System.*;

public class Solution_27 {

    public static void main(String[] args) {

        String a = "aBcDeFg";
        // A == 65, a == 97, 대문자와 소문자 간의 값 차이 '32'
        a.chars()                                                                     // chars() : 문자 스트림 선언. stream<Integer>로 시작한다.
                .mapToObj(ch ->                                                       // map(변환한다) + ToObj(다른 오브젝트객체로); 이 함수 안에서 객체의 변환이 필요해서 사용.
                        (char) (('A' <= ch) && (ch <= 'Z') ? (ch + 32) : (ch - 32)))  // 형변환을 통해 stream<Character>으로 반환. 변환하지않으면 아스키숫자로 출력됨.
                .forEach(out::print);                                                 // Character로 넘어온 값을 print로 하나씩 출력.


        for (char ch : a.toCharArray()) {


            ch = (char) (Character.isUpperCase(ch) ? (ch + 32) : (ch - 32));
            out.print(ch);
        }
    }

}
