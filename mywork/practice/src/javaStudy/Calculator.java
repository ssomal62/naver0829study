package javaStudy;

public interface Calculator {

	
		public int plus(int i, int j);
		public int multiple(int i, int j);
		
		default int exec(int i , int j) {//디폴드를 붙이면 메서드 형태로 가능
			return i + j;
		}
		
		public static int exec2(int i , int j) {
			return i *j;
		}
}
