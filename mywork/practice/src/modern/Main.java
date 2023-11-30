package modern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Apple> inventory = new ArrayList<>(Arrays.asList(
				
				new Apple(Color.GREEN, 150),
				new Apple(Color.GREEN, 90),
				new Apple(Color.RED, 180),
				new Apple(Color.GREEN, 180),
				new Apple(Color.RED, 90),
				new Apple(Color.RED, 150)
				));
		inventory.sort((o1, o2) -> o1.getColor().compareTo(o2.getColor()));
		prettyPrintApple(inventory, new AppleFancyFormatter());
		List<Apple> apples = filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
		
		apples.sort((o1, o2) -> o1.getWeight()-o2.getWeight());
		prettyPrintApple(apples, new AppleSimpleFormatter());
		
		
	}

	
	

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredication p) {
		
		List<Apple> result = new ArrayList<>();
		
		for(Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		
		return result;
	}
	
	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter f) {
		for (Apple apple : inventory) {
			
			String output = f.accept(apple);
			System.out.println(output);
		}
			
	}
	
	
}
