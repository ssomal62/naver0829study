package bit701.day0906;

public class Ex2_Array {
	
	public static void main(String[] args) {
		
		int[] arr = new int[5];
		
		for(int i : arr) {
			i = (int)(Math.random()*100 + 1);
			System.out.print(i + " ");
		}
		
		System.out.println("=".repeat(30));
		
		int[] arr2;	
		arr2 = new int[]{3,6,8,10,30};//나중에 값을 한꺼번에 지정할 경우
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.printf("[%d]:%-3d%n",i , arr2[i]);
		}
		
		
		
	}
}
