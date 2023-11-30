package Solution;

public class Sol5 {

	
    public int solution(int a, int b) {
        //int answer = 0;
        
//        String sum1 = String.valueOf(a+""+b);
//        String sum2 = String.valueOf(b+""+a);
//        
//        if (Integer.valueOf(sum1) >= Integer.valueOf(sum2))
//        	return Integer.valueOf(sum1);
//       
//        else
//        	return Integer.valueOf(sum2);
    	
    	//희표님 답
    	return Math.max(Integer.valueOf(a+""+b), Integer.valueOf(b+""+a));
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sol5 sol = new Sol5();
		System.out.println(sol.solution(79, 87));
		
	}

}
