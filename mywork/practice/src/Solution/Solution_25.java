package Solution;

public class Solution_25 {
    static int count = 0;
    public static int solution(String A, String B) {
        if (A.equals(B)) {
            return count;
        }
        //위 조건이 아니라면 문자열 순환 시작!
        //A = (현재 A 문자열의 마지막 요소) + (A의 첫번째 요소부터 ~ A의 마지막 '이전' 요소까지)
        A = A.charAt(A.length() - 1) + A.substring(0, A.length() - 1);
        count++;
        //삼항연산자를 이용해서 A의 문자열 길이만큼 돌지 않았을 때는 재귀 함수 호출하여 다시 반복.
        //A의 문자열 길이만큼 돌았을 때까지 A와 B값이 다르면  -1 최종 반환 후 종료.
        return A.length() == count ? -1 : solution(A, B);

        //=== 성능면에서는 재귀 호출보다 일반 반복문이 훨씬 좋습니다. (from.Aiur) ====

    }


    public static int solution2(String A, String B) {
        if (A.equals(B)) {
            return count;
        }
        //위 조건이 아니라면 문자열 순환 시작!
        //A = (현재 A 문자열의 마지막 요소) + (A의 첫번째 요소부터 ~ A의 마지막 '이전' 요소까지)
        A = A.charAt(A.length() - 1) + A.substring(0, A.length() - 1);
        count++;
        //삼항연산자를 이용해서 A의 문자열 길이만큼 돌지 않았을 때는 재귀 함수 호출하여 다시 반복.
        //A의 문자열 길이만큼 돌았을 때까지 A와 B값이 다르면  -1 최종 반환 후 종료.
        return A.length() == count ? -1 : solution(A, B);

        //=== 성능면에서는 재귀 호출보다 일반 반복문이 훨씬 좋습니다. (from.Aiur) ====

    }

    public static void main(String[] args) {

        String a = "applesdlkjflksejfisejfldsjfljdsflisejlkalkqwiuqukjdkkjdsakjdsaksaukuawiufdwu";
        String b = "pplesdlkjflksejfisejfldsjfljdsflisejlkalkqwiuqukjdkkjdsakjdsaksaukuawiufdwua";

        //재귀함수
        long startTime1 = System.nanoTime();
        int i = solution(a, b);
        long endTime1 = System.nanoTime(); // 작업 종료 후 현재 시간을 나노초로 기록
        System.out.println("재귀 함수 사용: " + i + "회, 실행 시간 : " + (endTime1 - startTime1) / 1000000 + "밀리초");

        //일반
        long startTime2 = System.nanoTime();
        int j =  (b+b).indexOf(a);
        System.out.println();
        long endTime2 = System.nanoTime(); // 작업 종료 후 현재 시간을 나노초로 기록
        System.out.println("indexOf사용: " + j + "회, 실행 시간 : " + (endTime2 - startTime2) / 1000000 + "밀리초");


/*      int i = 5;
        int j = 15;
        int start=i%2==0?-i/2+1:-i/2;
        int end=i%2==0?start-1:start;

        int[] arr= IntStream.rangeClosed(start,Math.abs(end)).map(l->(int)j/i+l).toArray();

        for(int d : arr){
            System.out.println(d);
        }*/
    }


//        public static int Solution(String a, String b) {
//        int count = 0;
//        int len = a.length() - 1;
//        while (true) {
//            return (a.equals(b)) ? count : len == count? -1: ;
//            else if () return -1;
//            else {
//                count++;
//                a = a.charAt(len) + a.substring(0, len);
//            }
//        }
//    }





/*    static int count = 0;
    public static int Solution(String a, String b) {
        if (a.equals(b)) return count;
        else if (a.length()-1 == count) return -1;
        else {
            count++;
            return Solution(a.charAt(a.length()-1) + a.substring(0, a.length()-1), b);
        }
    }*/


/*
    static int count = 0;
    public static int Solution(String a, String b) {
        int len = a.length()-1;
        if (a.equals(b)) return count;
        else if (len == count) return -1;
        else {
            count++;
            a = a.charAt(len) + a.substring(0, len);
            return Solution(a, b);
        }
    }
*/


}








