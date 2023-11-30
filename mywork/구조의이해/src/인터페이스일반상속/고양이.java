package 인터페이스일반상속;

public class 고양이 extends 포유류{
	@Override
	public void 먹기() {
		System.out.println("고양이 먹다");
	}
	@Override
	public void 울기() {
		System.out.println("고양이 울음소리");
	}
	@Override
	public void 이동하기() {
		System.out.println("고양이 이동");
	}
	
	public void 고양이만의특징() {
		System.out.println("고양이 특징");
	}
	
}
