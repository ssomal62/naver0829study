package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader  {

	static final String FILE_NAME = "C:/Temp/memo1.txt";

	public static void main(String[] args) throws IOException{
		FileReader fr = null;

		BufferedReader br = null;

		try {

			fr = new FileReader(FILE_NAME); // 줄단위로 읽는 멤버 메서드가 없다. 그래서 2차 생성을 하겠다.
			br = new BufferedReader(fr);
			// br.readLine()이 한줄씩 읽는다. 그런데 더이상 읽을 것이 없을 경우 null 을 반환
			// 몇줄이 저장되어있는지 모르므로 while문으로 처리한다.

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				// 파일의 내용을 한줄씩 읽기
				System.out.println(line);
			}		

			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없어여~~");
			e.printStackTrace();

		}
//			catch (IOException e) {
//			System.out.println("입출력 오류에여~~");
//			e.printStackTrace();
//		}
			
		br.close();
		fr.close();
	

	}

}
