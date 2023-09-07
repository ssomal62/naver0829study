package bit701.day0906;

import java.util.Random;
import java.util.stream.Collectors;

public class Ex15_DeleteDuplicationArray {

	public static void main(String[] args) {
		Random r = new Random();
		int[] data = new int[10];
		Loop:
		for (int i = 0; i < data.length; i++) {
			data[i] = r.nextInt(10) + 1;

			// 중복처리
			for (int j = 0; j < i ;  j++) {
				//i가 3일경우 j 는 i횟수 전까지 턴 	
				if (data[i] == data[j]) {
					i--;
					continue Loop;	//컨티뉴에도 적용이 되는구아요 !!!
				}
			}

		}

		for (int i = 0; i < data.length; i++) {
			System.out.printf("%4d", data[i]);
			if ((i + 1) % 5 == 0) {
				System.out.println();
			}
		}
		
		String str = r.ints(6, 1, 45).sorted().mapToObj(Integer::toString).collect(Collectors.joining(" | ","[ "," ]"));	
		//그치만 중복은 못막음 ㅠ
		System.out.println(str);
	}

}
