package bit701.day0911;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BankkApplication {

	public static void main(String[] args) throws IOException {

		Service service = new Service();

		service.bankAccountFileRead();

		System.out.println("[계좌생성 실행 결과]");

		boolean run = true;
		while (run) {

			service.showMenu();

			switch (service.menuNum) {

			case 1:
				service.createAccount();
				break;

			case 2:
				service.printAccountList();
				break;

			case 3:
				service.printAccountList();
				service.makeDeposit();
				break;

			case 4:
				service.makeWithdraw();
				break;

			case 5:
				service.saveFileAndClose();
				run = !run;
				break;

			}
		}
	}
}

class Service {

	// 디스플레이
	Scanner sc = new Scanner(System.in);
	public final static String BANK_FILE = "C:/Temp/memo1.txt";
	final static int MAX_ACCOUNT = 10;
	int countingAccount = 0;
	int choicAccountNum;
	int deposit;
	int menuNum;
	String number;
	String holder;
	int amount;

	Account[] accountList = new Account[MAX_ACCOUNT];

	public void showMenu() {
		System.out.println("-".repeat(50));
		System.out.println("1 계좌생성 | 2 계좌목록 | 3 예금 | 4 출금 | 5 종료");
		System.out.println("-".repeat(50));
		System.out.printf("선택 >> ");
		menuNum = Integer.parseInt(sc.nextLine());

	}

	// 계좌 생성
	public void createAccount() {

		if (MAX_ACCOUNT == countingAccount) {
			System.out.println("더이상 계좌를 생성할 수 없습니다.");
			System.out.println();
			return;
		}

		System.out.printf("계좌 번호 >> ");
		number = sc.nextLine();
		System.out.printf("예금주 >> ");
		holder = sc.nextLine();
		System.out.printf("초기 입금액 >> ");
		amount = Integer.parseInt(sc.nextLine());

		accountList[countingAccount] = new Account(number, holder, amount);
		countingAccount++;
	}

	public void bankAccountFileRead() throws IOException {

		FileReader fr = null;
		BufferedReader br = null;
		boolean run = true;

		try {

			fr = new FileReader(BANK_FILE);
			br = new BufferedReader(fr);

			while (run) {

				for (int i = 0; i < 3; i++) {

					String line = br.readLine();

					if (line == null) {
						run = !run;
						countingAccount--;
						break;
					} else if (i == 0) {
						number = line;
					} else if (i == 1) {
						holder = line;
					} else if (i == 2) {
						amount = Integer.parseInt(line);
					}

				}
				accountList[countingAccount] = new Account(number, holder, amount);
				countingAccount++;

			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 읽을 수 없습니다.");
			run = !run;
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("넘버포맷 오류");
			run = !run;
			e.printStackTrace();
		}

		br.close();
		fr.close();

	}

	// 계좌 목록 호출
	public void printAccountList() {

		for (int i = 0; i < countingAccount; i++) {
			System.out.println("[" + (i + 1) + "] " + accountList[i].getAccountNumber() + "\t"
					+ accountList[i].getAccountHolder() + "\t" + accountList[i].getInitiaAmount());
		}

	}

	// 예금하기
	public void makeDeposit() {
		accountList[choiceAccoutNumber() - 1].initiaAmount += inputDeposit();
	}

	// 출금하기
	public void makeWithdraw() {
		accountList[choiceAccoutNumber() - 1].initiaAmount -= inputDeposit();
	}

	public int choiceAccoutNumber() {
		System.out.printf("계좌번호 선택 >> ");
		choicAccountNum = Integer.parseInt(sc.nextLine());
		return choicAccountNum;
	}

	public int inputDeposit() {
		System.out.printf("예금액 입력 >> ");
		deposit = Integer.parseInt(sc.nextLine());
		return deposit;
	}

	// 파일 저장 및 종료
	public void saveFileAndClose() throws IOException {

		FileWriter fw = null;
		fw = new FileWriter(BANK_FILE);
		try {
			for (int i = 0; i < countingAccount; i++) {
				fw.write(accountList[i].getAccountNumber() + "\n");
				fw.write(accountList[i].getAccountHolder() + "\n");
				fw.write(accountList[i].getInitiaAmount() + "\n");
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일 저장에서 파일 못찾음");
		}

		fw.close();
		System.out.println("종료합니다.");
	}

}

class Account {

	// 계좌번호, 계좌주, 초기 입금액

	String accountNumber;
	String accountHolder;
	int initiaAmount;

	public Account(String accountNumber, String accountHolder, int initiaAmount) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.initiaAmount = initiaAmount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public int getInitiaAmount() {
		return initiaAmount;
	}

	public void setInitiaAmount(int initiaAmount) {
		this.initiaAmount = initiaAmount;
	}

}