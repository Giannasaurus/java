import java.io.*;
import java.util.Scanner;

public class atm {
    // Array of account names, pins, and balances
    static String[] accList = {"a", "b", "c", "d"};
    static int[] pinList = {123456, 987654, 888888, 000000};
    static double[] balList = {5000.00, 3000.00, 10000.00, 2000.00};
    
    static Scanner s = new Scanner(System.in);
    static int accIndex = -1; // No user logged in yet

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to At The Moment ATM!");

        // Account login loop
        while (accIndex == -1) {
            System.out.print("Enter account name: ");
            String accName = s.nextLine();
            System.out.print("Enter 6-digit PIN: ");
            int accPin = Integer.parseInt(s.nextLine());

            boolean validLogin = false;
            for (int i = 0; i < accList.length; i++) {
                if (accList[i].equals(accName) && pinList[i] == accPin) {
                    accIndex = i; // User logged in
                    System.out.println("Welcome, " + accName + "!");
                    validLogin = true;
                    break;
                }
            }
            if (!validLogin) {
                System.out.println("Invalid account name or PIN. Please try again!");
            }
        }
        
        atmMenu(); // Proceed to transaction selection
    }

    public static void atmMenu() {
        while (true) {
            System.out.println("\nPlease select a transaction:");
            System.out.println("(1) Check Balance");
            System.out.println("(2) Withdraw");
            System.out.println("(3) Deposit");
            System.out.println("(4) Pay Bills");
            System.out.println("(5) Exit");
            System.out.print("Your choice: ");
            
            int menuChoice = Integer.parseInt(s.nextLine());

            switch (menuChoice) {
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
                    System.out.println("Thank you for using At The Moment ATM! Goodbye!");
                    return; // Exits the program properly
                default:
                    System.out.println("Invalid input! Please select from 1-5.");
            }
        }
    }

    public static void checkBalance() {
        System.out.println("Your account balance at the moment: P" + balList[accIndex]);
    }

    public static void withdraw() {
        System.out.println("\nWithdraw funds from account");
        System.out.println("---------------------------");

        while (true) {
            System.out.print("Enter amount: ");
            double amtWithdraw = Double.parseDouble(s.nextLine());

            if (amtWithdraw > 0 && amtWithdraw <= balList[accIndex]) {
                balList[accIndex] -= amtWithdraw;
                System.out.println("Transaction success!");
                System.out.println("Your balance at the moment is P" + balList[accIndex]);
                break;
            } else {
                System.out.println("Insufficient funds or invalid amount! Please enter a valid amount.");
            }
        }
    }

    public static void deposit() {
        System.out.println("\nDeposit funds to account");
        System.out.println("------------------------");

        while (true) {
            System.out.print("Enter amount: ");
            double amtDeposit = Double.parseDouble(s.nextLine());

            if (amtDeposit > 0) {
                balList[accIndex] += amtDeposit;
                System.out.println("Transaction success!");
                System.out.println("Your balance at the moment is P" + balList[accIndex]);
                break;
            } else {
                System.out.println("Invalid amount! Please enter a valid amount.");
            }
        }
    }

    public static void payBills() {
        System.out.println("\nPay my bills");
        System.out.println("------------");
        System.out.println("(1) Meralco - P1200");
        System.out.println("(2) Maynilad - P500");
        System.out.println("(3) Globe - P2100");
        System.out.print("Select utility: ");

        int billChoice = Integer.parseInt(s.nextLine());
        double billAmount = 0;

        switch (billChoice) {
            case 1:
                billAmount = 1200;
                System.out.println("Ang liwanag ng bukas - Welcome to Meralco!");
                break;
            case 2:
                billAmount = 500;
                System.out.println("Dumadaloy ang ginhawa - Welcome to Maynilad!");
                break;
            case 3:
                billAmount = 2100;
                System.out.println("Abot mo ang mundo - Welcome to Globe!");
                break;
            default:
                System.out.println("Invalid input! Please select from 1-3.");
                return;
        }

        while (true) {
            System.out.print("Enter amount: ");
            double payment = Double.parseDouble(s.nextLine());

            if (payment >= billAmount && balList[accIndex] >= billAmount) {
                balList[accIndex] -= billAmount;
                System.out.println("Transaction success!");
                System.out.println("Your balance at the moment is P" + balList[accIndex]);
                break;
            } else {
                System.out.println("Insufficient funds or incorrect amount! Please try again.");
            }
        }
    }
}
