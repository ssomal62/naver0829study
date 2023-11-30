package bit701.day0911;

public class Memeber3Example {
	
	public static void main(String[] args) {
				
		Member3[] mem1 = 
			{
				new Member3("김이나",10000,5000,4),
				new Member3("김나나",30000,6000,1),
				new Member3("홍길동",45000,8000,3)
			};
		
		
		System.out.println("이름\t기본급\t수당\t가족수\t가족수당\t세금\t|  총액");
		System.out.println("=".repeat(90));
		
		
		for(Member3 m : mem1) {
			System.out.println(m);
		}
		
		

					
	}
}
