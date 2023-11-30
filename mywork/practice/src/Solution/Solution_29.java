package Solution;

public class Solution_29 {

    public int solution(int[] common) {

        int diff  = 0;  //공차
        int ratio = 1;  //공비

        int e1 = common[0];
        int e2 = common[1];
        int e3 = common[2];
        int le = common[common.length - 1];

        if((e2 - e1) == (e3 - e2)) {    //등차 조건 성립 여부
            diff  = e2 - e1;            //여 : 공차 계산
        } else {                       
            ratio = e2 / e1;            //부 : 공비 계산
        }
        return le * ratio + diff;



    }



    public static void main(String[] args) {
        Solution_29 sol = new Solution_29();
        int[] arr = {2,4,8};
        int s = sol.solution(arr);

        System.out.println(s);
    }
}
