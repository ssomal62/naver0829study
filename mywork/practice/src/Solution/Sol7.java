package Solution;


public class Sol7 {
	public int solution(String ineq, String eq, int n, int m) {
        //chatGPT 도움 받은 문제 ㅠㅠ... 진짜.. 대단행..
		
		  switch (ineq) {
          case "<":
              return eq.equals("=") ? (n <= m ? 1 : 0) : (n < m ? 1 : 0);
          case ">":
              return eq.equals("=") ? (n >= m ? 1 : 0) : (n > m ? 1 : 0);
          default: 
        	  return -1;
		  }

	}
        

    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol7 sol = new Sol7();
		System.out.println(sol.solution("<","!",40,30));
	}

}
