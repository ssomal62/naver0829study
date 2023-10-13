package bit701.day0912;

import java.io.FileWriter;
import java.io.IOException;

public class Ex1_FileWriter {
	
	static final String FILE_NAME = "C:/Temp/memo1.txt";
	
	public static void main(String[] args) {
		
		try {
			FileWriter fw  =  null;
			fw = new FileWriter(FILE_NAME,true); //파일이 없으면 새로 생성하고 있으면 덮어쓴다.
													//true 기존파일에 내용을 추가한다는 의미 
			
			fw.write("유재석\n");
			fw.write("sksksk\n");
			fw.write("sksksk\n");
			
			fw.close();
			
			fw.write("탐색기를 열고 memo1.txt 파일을 확인하세요");
			
		} catch (IOException e) {
			System.out.println("오류에여~~");
			e.printStackTrace();
		}
		

		
		
		
	}

}
