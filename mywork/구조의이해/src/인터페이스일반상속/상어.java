package 인터페이스일반상속;

public class 상어 extends 어류 implements 물생활
{
	@Override
	public void 먹기() {
		System.out.println("상어 먹다");
	}
	@Override
	public void 울기() {
		System.out.println("상어 울음소리");
	}
	@Override
	public void 이동하기() {
		System.out.println("상어 이동");
	}
	
	public void 고래만의특징() {
		System.out.println("상어 특징");
	}
	@Override
	public void 물에서동작() {
		// TODO Auto-generated method stub
		System.out.println("상어 물생활");
	}
	
}
