package bit701.day0913;



public class Ex2_Inheri {
	
	//인자를 SubA로 하면 SubA만 보낼 수 있다.
	//이런문제를 해결하는 방법은 부모 클래스로 인자를 써주면 된다.
	public static void processPlay(SuperA sub) {
		sub.process();
	}

	public static void main(String[] args) {

		processPlay(new SubA());
		processPlay(new SubB());
		processPlay(new SubC());

	}

}
