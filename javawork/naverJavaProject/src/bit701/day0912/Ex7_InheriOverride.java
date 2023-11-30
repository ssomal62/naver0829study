package bit701.day0912;

public class Ex7_InheriOverride {

	public static void main(String[] args) {

	}

}

class SuperB {
	public void processA() {

	}
}

class SubB extends SuperB {

	@Override
	public void processA() {
		super.processA();

	}

}
