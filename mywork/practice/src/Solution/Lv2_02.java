package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lv2_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int price = 1230;
		final int payment = 5000;

		List<Integer> coins = new ArrayList<>(Arrays.asList(500, 100, 50, 10));



		coins.stream().sorted(Comparator.reverseOrder()).forEach(coin -> {

			int change = price - payment;
			int count = change / coin;
			change %= coin;
			if (count > 0) {
				System.out.println(coin + "원 동전: " + count + "개");
			}
		});
	}

}
