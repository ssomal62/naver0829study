package Solution;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_26 {

    public static void main(String[] args) {

        Solution_26 ex = new Solution_26();

        int[] arr = ex.solution(4,30);

        Arrays.stream(arr).forEach(System.out::println);

    }
    public int[] solution(int num, int total) {

        //1. 범위 구하기 : 시작값 ~ 마지막값
        // s : start 값 구하기. 짝수일 경우와 홀수일 경우 구분해줘야하므로 삼항연산자 사용.
        int s = (num % 2) == 0 ? (-num / 2) + 1 : (-num / 2);

        //2. 스트림으로 순환 후 배열로 보내버리기.
        return IntStream
                .iterate(s, i -> i + 1)
                .map(i -> total / num + i)
                .limit(num)
                .toArray();
    }
}
