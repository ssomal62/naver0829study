package 인터페이스일반상속;

public class 독수리 extends 조류{
	@Override
	public void 먹기() {
		System.out.println("독수리 먹다");
	}
	@Override
	public void 울기() {
		System.out.println("독수리 울음소리");
	}
	@Override
	public void 이동하기() {
		System.out.println("독수리 이동");
	}
	
	public void 독수리만의특징() {
		System.out.println("독수리 특징");
	}
	
}
