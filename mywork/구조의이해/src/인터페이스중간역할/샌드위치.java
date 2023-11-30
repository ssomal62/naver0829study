package 인터페이스중간역할;

public class 샌드위치 {

	String 빵;
	int 최소빵개수 = 1;
	int 빵개수 = 최소빵개수;

	String 햄;
	String 치즈;

	public 샌드위치(String ppang) {
		this.빵 = ppang;

	}

	public 샌드위치(String ppang, int ea) {
		this.빵 = ppang;
		this.빵개수 = ea;
	}

	@Override
	public String toString() {
		return "[기본] " + 빵 + " " + 빵개수 + "개 / [그 외] " + 햄 + ", " + 치즈;
	}
}
