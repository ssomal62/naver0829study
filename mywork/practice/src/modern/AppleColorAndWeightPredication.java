package modern;

import java.util.List;

public class AppleColorAndWeightPredication implements ApplePredication {

	@Override
	public boolean test(Apple apple) {
		
		return Color.GREEN.equals(apple.getColor()) && apple.getWeight() >= 150;
	}

}
