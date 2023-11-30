package modern;

public class AppleFancyFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		String characteristic =  apple.getWeight() >= 150 ? "Heavy" : "light";
		return "A " + characteristic + " " + apple.getColor() + " apple.";
 	}
	
	

}
