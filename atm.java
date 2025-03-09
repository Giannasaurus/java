import java.util.Scanner;

public class atm {
	// array of account names, pins, and balances
	static String[] accList = {"a", "b", "c", "d"};
	static int[] pinList = {123456, 987654, 888888, 000000};
	static double[] balList = {5000.00, 3000.00, 10000.00, 2000.00};
	
	static Scanner s = new Scanner(System.in);
	static int accIndex = -1; // no user logged in yet

	public static void main(String[] args) {
	System.out.println("===Welcome to At The Moment ATM!===\n");

	// Show available accounts
	System.out.println("Select an account:");
	for (int i = 0; i < accList.length; i++) {
		System.out.println("(" + (i + 1) + ") " + accList[i]);
	}

	// account selection (1,2,3,4)
	while (accIndex == -1) {
		System.out.print("\nEnter account number (1-4): ");
		int choice = Integer.parseInt(s.nextLine()) - 1;

		if (choice >= 0 && choice < accList.length) {
			System.out.print("Enter 6-digit PIN: ");
			int accPin = Integer.parseInt(s.nextLine());

			// validate pin
			if (pinList[choice] == accPin) {
				accIndex = choice;
				System.out.println("\nWelcome, " + accList[accIndex] + "!\n");
				atmMenu(); // proceed to transactions
			} else {
				System.out.println("Incorrect PIN. Try again.\n");
			}
		} else {
			System.out.println("Invalid selection. Choose from 1-4.\n");
		}
	}
}

	public static void atmMenu(){
		while(true){
			System.out.println("Please select a transaction:");
			System.out.println("----------------------------");
			System.out.println("(1) Check Balance");
			System.out.println("(2) Withdraw");
			System.out.println("(3) Deposit");
			System.out.println("(4) Pay Bills");
			System.out.println("(5) Exit\n");
			int menuChoice = Integer.parseInt(s.nextLine());

		// select transaction (1,2,3,4,5)
		switch(menuChoice){
			case 1:
				checkBalance();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				deposit();
				break;
			case 4:
				payBills();
				break;
			case 5:
				System.out.println("\nThank you for using At The Moment ATM! Goodbye!");
				return;
			default:
				System.out.println("Invalid input! Please select from 1-5.");
		}
		}
	}

	public static void checkBalance(){
		System.out.println("\nYour account balance at the moment is");
		System.out.println("=====P"+balList[accIndex]+"=====\n");
	}

	public static void withdraw(){
		System.out.println("\nWithdraw funds from account");
		System.out.println("---------------------------");

	while(true){ // loop if conditions are false until true
		System.out.print("Enter amount: P");
		double amtWithdraw = Double.parseDouble(s.nextLine()); // input amount to withdraw
		if(amtWithdraw>0&&amtWithdraw<=balList[accIndex]){ // amount to withdraw > or = to current account balance
			balList[accIndex]-=amtWithdraw; // amount to withdraw deducted from current account balance, updates current balance
			System.out.println("\nTransaction success!\n");
			System.out.println("Your balance at the moment is");
			System.out.println("=====P"+balList[accIndex]+"=====\n");
			break;
		}else{
			System.out.println("\nInsufficient funds! Please enter a valid amount.\n");
		}
		}
	}

	public static void deposit(){
		System.out.println("\nDeposit funds to account");
		System.out.println("------------------------");
		System.out.print("Enter amount: P");
		double amtDeposit = Double.parseDouble(s.nextLine()); // input amount to deposit

	while(true){
		if(amtDeposit>0){
			balList[accIndex]+=amtDeposit; // amount to deposit added to current account balance, updates current balance
			System.out.println("\nTransaction success!\n");
			System.out.println("Your balance at the moment is");
			System.out.println("=====P"+balList[accIndex]+"=====\n");
			break;
		}else{
			System.out.println("Invalid amount! Please enter a valid amount.");
			deposit();
		}
	}
	}

	public static void payBills(){
		System.out.println("\nPay my bills");
		System.out.println("------------");
		System.out.println("Select utility:");
		System.out.println("(1) Meralco");
		System.out.println("(2) Maynilad");
		System.out.println("(3) Globe\n");
		int billChoice = Integer.parseInt(s.nextLine());

		// choose which bills to pay
		switch(billChoice){
			case 1:
				System.out.println("\nAng liwanag ng bukas - Welcome to Meralco!");
				System.out.println("----------------------------------------------");
				System.out.println("Amount to pay: P"+"1200");
				System.out.print("Enter amount: P");
				double amtMeralco = Double.parseDouble(s.nextLine());

				balList[accIndex]-=amtMeralco;

				System.out.println("\nTransaction success!\n");
				System.out.println("Your balance at the moment is");
				System.out.println("=====P"+balList[accIndex]+"=====\n");
				break;
			case 2:
				System.out.println("\nDumadaloy ang ginhawa - Welcome to Maynilad!");
				System.out.println("------------------------------------------------");
				System.out.println("Amount to pay: P"+"500");
				System.out.print("Enter amount: P");
				double amtMaynilad = Double.parseDouble(s.nextLine());

				balList[accIndex]-=amtMaynilad;

				System.out.println("\nTransaction success!\n");
				System.out.println("Your balance at the moment is");
				System.out.println("=====P"+balList[accIndex]+"=====\n");
				break;
			case 3:
				System.out.println("\nAbot mo ang mundo - Welcome to Globe!");
				System.out.println("-----------------------------------------");
				System.out.println("Amount to pay: P"+"2100");
				System.out.print("Enter amount: P");
				double amtGlobe = Double.parseDouble(s.nextLine());

				balList[accIndex]-=amtGlobe;

				System.out.println("\nTransaction success!\n");
				System.out.println("Your balance at the moment is");
				System.out.println("=====P"+balList[accIndex]+"=====\n");
				break;
			default:
				System.out.println("Invalid input! Please select from 1-3.");
		}
	}
}