package thisIsJava.chapter17;

import java.util.ArrayList;
import java.util.List;

public class Ex3_StreamExample {
	
	public static void main(String[] args) {
		
		List<Ex3_Product> list = new ArrayList<>();
		
		for(int i = 1; i <=5; i++) {
			Ex3_Product product = new Ex3_Product(i, "상품" + i, "멋진회사", (int)(10000*Math.random()));
			list.add(product);
		}
		
		//Stream<Product> stream =
		list.stream().forEach(System.out::println);
		
		
		
	}

}
