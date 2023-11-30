package ngs.ui.menu;

import java.util.Scanner;
import ngs.ui.console.ClubConsole;

public class ClubMenu {

	private Scanner scanner ;
	private ClubConsole console;
	public ClubMenu(){
		this.scanner = new Scanner(System.in);
		this.console = new ClubConsole();
	}
	
	 
	private void displayMenu() {

		System.out.println("=====================");
		System.out.println("Club Menu");
		System.out.println("=====================");
		System.out.println("1. Register");
		System.out.println("2. Find[All]");
		System.out.println("3. Find[ID]");
		System.out.println("4. Find[name]");
		System.out.println("5. Modify");
		System.out.println("6. Remove");
		System.out.println("=====================");
		System.out.println("0. Previous");

	}

	public void show() {
		int InputNumber = 0;
		
		while(true) {		

			displayMenu();
			InputNumber = selectMenu();
			System.out.println(InputNumber);

			switch (InputNumber) {
			case 1:
				console.register();
				break;
			case 2:
				console.FindAll();
				break;
			case 3:
				console.FindbyId();
				break;
			case 4:
				console.FindbyName();
				break;
			case 5:
				console.modify();
				break;
			case 6:
				console.remove();
				break;
			case 0:
				return;
			default:
				System.out.println("Choose again!!");
			}

		}
	}

	private int selectMenu() {


		System.out.print("Select : ");
		int menuNumber = scanner.nextInt();
		
		if (0 <= menuNumber && menuNumber <=6 ) {
			scanner.nextLine();			
			return menuNumber;
			
		}else{
			System.out.println("입력한 숫자 : " + menuNumber);
			return -1;
		}	
		
		
	}

}
