package ngs.util;
import java.util.Scanner;

public class ConsoleUtil {
	private Scanner scanner;
	
	public ConsoleUtil() {
		this.scanner = new Scanner(System.in);
		
	}
	
	public String getValueOf(String label) {

		System.out.print(label + " : ");
		String InputStr = scanner.nextLine();
		InputStr = InputStr.trim();
		return InputStr;
		
	}
	
}
