package bit701.day0906;

public class Ex14_ArrayStringSort {
	
	public static void main(String[] args) {
		
		String[] names = { "강호동", "강호남", "비", "리스테린", "Candy", "신민아", "이서진", "유리미", "김남길", "이소연" };
		
		
		//selection sort 문자열 비교시
		
		for (int i = 0; i < names.length-1 ; i++) {
			for (int j = i+1 ; j < names.length ; j++) {
				
				if(names[i].compareTo(names[j]) > 0) { //부등호 바꾸면 내림차순 정렬
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
				
			}
		}
		
		for(String s : names) {
			System.out.println(s);	
		}
		
	}

}
