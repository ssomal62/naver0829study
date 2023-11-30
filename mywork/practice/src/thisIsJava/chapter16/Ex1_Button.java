package thisIsJava.chapter16;

public class Ex1_Button {

	@FunctionalInterface //함수형 인터페이스
	public static interface ClickListener {
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;		
	}
	
	public void click() {
		this.clickListener.onClick();
	}
	

}
