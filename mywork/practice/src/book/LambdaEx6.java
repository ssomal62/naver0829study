package book;

import java.util.Arrays;
import java.util.function.*;

public class LambdaEx6 {

	public static void main(String[] args) {

		IntSupplier s = ()-> (int)(Math.random()*100)+1;
		IntConsumer c = i -> System.out.print(i +", ");
		IntPredicate p = i -> i%2 == 0;
		IntUnaryOperator op = i -> i/10*10;
		
		
		int[] arr = new int[10];
		makeRandomNum(s, arr);
		System.out.println(Arrays.toString(arr));
		printEvenNum(c, p, arr);
		
		int[] newArr = dosomeThing(op, arr);
		System.out.println(Arrays.toString(newArr));
		
	}
	
	
	static void makeRandomNum(IntSupplier s, int[] arr) {
		for(int i = 0; i<arr.length;i++) arr[i] = s.getAsInt();
		//for(int i : arr) i = s.getAsInt(); 왜 안돼???ㅠㅠ
	}
	
	static void printEvenNum(IntConsumer c, IntPredicate p, int[] arr) {
		System.out.print("[");
		for (int i : arr) {
			if(p.test(i)) {
				c.accept(i);
			}
		}

		System.out.println("]");
		
	}
	
	static int[] dosomeThing(IntUnaryOperator op, int[] arr) {
		int[] newArr = new int[arr.length];
		for(int i = 0; i<newArr.length;i++)
		{
			newArr[i] = op.applyAsInt(arr[i]);
		}
		return newArr; 
	}
	
}
