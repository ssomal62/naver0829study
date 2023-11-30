package modern;

public class AppleSimpleFormatter implements AppleFormatter {
	@Override
	public String accept(Apple apple) {
		// TODO 자동 생성된 메소드 스텁
		return "An apple of " + apple.getColor() + " " + apple.getWeight() + "g";
	}

}
