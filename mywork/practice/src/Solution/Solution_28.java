package Solution;

import java.util.stream.IntStream;

public class Solution_28 {

    public int solution(int n) {

        int answer = 0;
        int leng = String.valueOf(n).length()-1;

        for(int i = 1 ; i <= n;i ++){
            if(i % 3 == 0){
                answer++;
            } else {
                int temp = i;
                for (int j = leng; j >= 0 ; j--){
                    if((temp-Math.pow(10,j)) % Math.pow(10,j-1)==3){
                        temp/=10;
                    }else if (j==0 && (temp-Math.pow(10,j)) % Math.pow(10,j-1) != 3){
                        answer++;
                        break;
                    }else{

                    }
                }
            }
        }


return answer;

        //return IntStream.iterate(0, i -> i + 1).filter(i -> (i % 3) != 0 && (!String.valueOf(i).contains("3"))).limit(n).max().getAsInt();

    }

    //    IntStream
    //        .iterate(0, i -> i + 1)                           시작값 i → 0, 다음 i는  i += 1. 이 조건으로 무한스트림 선언.
    //        .filter(i -> (i % 3) != 0)                        나머지가 0이 아닌 i만 다음 함수로 이동
    //        .filter(i -> !String.valueOf(i).contains("3"))    문자 안에 "3"이 없는 i만 다음 함수로 이동
    //        .limit(n)                                         n번째 i값이 채워질 때까지 반복 수행. n번째 값이 채워지면 다음 함수로 이동.
    //        .max()                                            지금까지의 데이터 중 최댓값을 OptinalInt로 반환 (max를 쓰면 원래 그럼)
    //        .getAsInt();                                      OptinalInt → int 변환 getter. 사용하지 않으면 'OptionalInt[최댓값]' 이라고 출력됨.

    //     return IntStream.iterate(0, i -> i + 1).filter(i -> (i % 3) != 0 && (!String.valueOf(i).contains("3"))).limit(n).max().getAsInt();

    public static void main(String[] args) {
        Solution_28 sol = new Solution_28();
        int s = sol.solution(40);

        System.out.println(s);
    }
}
