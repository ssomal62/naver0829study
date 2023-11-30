package bit701.day0914;

//<T>는 T가 타입 파라미터임을 뜻하는 기호로, 타입이 필요한 자리에 T를 사용한다.
class GenericsType<T> {
	T[] v;

	public void set(T[] n) {
		v = n;
	}

	public void print() {
		for (T s : v) {
			System.out.println(s + " ");

		}
		System.out.println();
	}
}

public class Ex1_Generic<T> {

	public static void main(String[] args) {

		String[] flower = { "장미꽃", "안개꽃", "다알리아" };

		// T에 대체되는 타입은 클래스(객체) 타입이나 인터페이스면 가능하다 !!
		GenericsType<String> t1 = new GenericsType<>();
		t1.set(flower);
		t1.print();

		GenericsType<Integer> t2 = new GenericsType<>();
		Integer[] arr = { 5, 7, 29, 48, 59 };
		t2.set(arr);
		t2.print();

	}

}
