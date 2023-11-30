package thisIsJava.chapter18;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args)  {



		try {			
			OutputStream os = new FileOutputStream("C:/Temp/test3.db");

			byte[] array = { 10, 20, 30, 50, 70, 99, 120 };
			
			byte a = 10;
			byte b = 127;

			os.write(a);
			os.write(b);
			
			System.out.println();

			os.write(array);
			os.write(array, 2, 4);
			
			os.flush();
			os.close();

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
