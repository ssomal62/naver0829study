package thisIsJava.chapter16;

public class Ex1_ButtinExample {
	
	public static void main(String[] args) {
		
		Ex1_Button btnOk = new Ex1_Button();
		
		btnOk.setClickListener(()-> {
			System.out.println("Ok 버튼을 클릭했습니다.");
			});
		
		btnOk.click();
		
		Ex1_Button btnCheck = new Ex1_Button();
		
		btnCheck.setClickListener(()-> {
			System.out.println("Check 버튼을 클릭했씁니다.");
		});
		
		btnCheck.click();
		
	}

}
