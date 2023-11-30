package thisIsJava.chapter16;

public class Test01 {
	
	public static void main(String[] args) {
		
		Button btnOk= new Button();
		
		btnOk.setClickListener(()-> System.out.println("OK버튼"));
		btnOk.click();
		
		Button btnCheck = new Button();
		btnCheck.setClickListener(() -> System.out.println("check 버튼"));
		btnCheck.click();
		
	}
	


}

class Button{
	
	@FunctionalInterface
	public static interface ClickListener{
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
		
	}
	
	public void click() {
		this.clickListener.onClick();
		//onClick 이 추상메서드이 이기 때문에 이렇게 getter 형식으로 받아오는 거..
	}
	
}
