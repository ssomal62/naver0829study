package bit701.day0905;

public class Ex0_starEx {
	
	public static void main(String[] args) {
		
//		for(int i = 0 ; i <=5 ; i++) {
//			for( int j = 0 ; j <= i ; j++) {
//				System.out.printf("*");
//			}
//			System.out.println();
//		}
		
//		for(int i = 0 ; i <=5 ; i++) {
//			for( int j = i ; j <= 5 ; j++) {
//				System.out.printf("*");
//			}
//			System.out.println();
//		}
		
		
		for(int i = 1 ; i <=5 ; i++) {
			for( int j = 1 ; j <= 5 ; j++) {
				if(i==j) {
					System.out.print(i);
				}else {
				System.out.printf("*");
				}
			}
			System.out.println();
		}
		
	}

}
