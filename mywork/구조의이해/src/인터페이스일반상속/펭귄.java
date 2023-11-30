package 인터페이스일반상속;

public class 펭귄 extends 조류 implements 물생활{
	@Override
	public void 먹기() {
		System.out.println("펭귄 먹다");
	}
	@Override
	public void 울기() {
		System.out.println("펭귄 울음소리");
	}
	@Override
	public void 이동하기() {
		System.out.println("펭귄 이동");
	}
	
	public void 고래만의특징() {
		System.out.println("펭귄 특징");
	}
	@Override
	public void 물에서동작() {
		System.out.println("펭귄 물생활");
		
	}
	
}
