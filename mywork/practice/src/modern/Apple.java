package modern;

public class Apple {
	
	private Color color;
	private int weight;
	
	public Apple(Color color, int weight) {
		this.color = color;
		this.weight = weight;
		
	}
	
	public Color getColor() {
		return color;
	}
	
	private void setColor(Color color) {
		this.color = color;
	}
	
	public int getWeight() {
		return weight;
	}
	
	private void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
	
	

}
