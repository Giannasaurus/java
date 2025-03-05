import java.io.*;
import java.util.Scanner;

public class atm {
    // array of account names, pins, and balances
    static String[] accList = {"a", "b", "c", "d"};
    static int[] pinList = {123456, 987654, 888888, 000000};
    static double[] balList = {5000.00, 3000.00, 10000.00, 2000.00};
    
    static Scanner s = new Scanner(System.in);
    static int accIndex = -1; // no user logged in yet

    public static void main(String[] args)
    throws IOException {
    System.out.println("Welcome to At The Moment ATM!");

    // account login
    while(accIndex==-1){
        System.out.println("Enter account name:");
        String accName = s.nextLine();
        System.out.println("Enter 6-digit PIN:");
        int accPin = Integer.parseInt(s.nextLine());

    // validate login
    for(int i=0; i<accList.length; i++){
        if(accList[i].equals(accName)&&pinList[i]==accPin){
            accIndex = i; // user logged in >:)
            System.out.println("Welcome, "+accName+"!");
            atmMenu(); // proceed to transaction selection
            break;
        }else{
            System.out.println("Invalid account name or PIN. Please try again!");
        }
    }
    }
    }

    public static void atmMenu(){
        while(true){
            System.out.println("Please select a transaction:");
            System.out.println("(1) Check Balance");
            System.out.println("(2) Withdraw");
            System.out.println("(3) Deposit");
            System.out.println("(4) Pay Bills");
            System.out.println("(5) Exit");
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
                System.out.println("Thank you for using At The Moment ATM! Goodbye!");
                atmMenu();
            default:
                System.out.println("Invalid input! Please select from 1-5.");
        }
        }
    }

    public static void checkBalance(){
        System.out.println("Your account balance at the moment: P"+balList[accIndex]);
        System.out.println(balList[accIndex]);
    }

    public static void withdraw(){
        System.out.println("Withdraw funds from account");
        System.out.println("---------------------------");
        System.out.println("Enter amount:");
        double amtWithdraw = Double.parseDouble(s.nextLine()); // input amount to withdraw

    while(true){ // loop if conditions are false until true
        if(amtWithdraw>0&&amtWithdraw<=balList[accIndex]){ // amount to withdraw > or = to current account balance
            balList[accIndex]-=amtWithdraw; // amount to withdraw deducted from current account balance, updates current balance
            System.out.println("Transaction success!");
            System.out.println("Your balance at the moment is P"+balList[accIndex]);
            break;
        }else{
            System.out.println("Insufficient funds! Please enter a valid amount.");
            withdraw();
        }
    }
    }

    public static void deposit(){
        System.out.println("Deposit funds to account");
        System.out.println("------------------------");
        System.out.println("Enter amount:");
        double amtDeposit = Double.parseDouble(s.nextLine()); // input amount to deposit

    while(true){
        if(amtDeposit>0){
            balList[accIndex]+=amtDeposit; // amount to deposit added to current account balance, updates current balance
            System.out.println("Transaction success!");
            System.out.println("Your balance at the moment is P"+balList[accIndex]);
            break;
        }else{
            System.out.println("Invalid amount! Please enter a valid amount.");
            deposit();
        }
    }
    }

    public static void payBills(){
        System.out.println("Pay my bills");
        System.out.println("------------");
        System.out.println("Select utility:");
        System.out.println("(1) Meralco");
        System.out.println("(2) Maynilad");
        System.out.println("(3) Globe");
        int billChoice = Integer.parseInt(s.nextLine());

        // choose which bills to pay
        switch(billChoice){
            case 1:
                System.out.println("Ang liwanag ng bukas - Welcome to Meralco!\n");
                System.out.println("Amount to pay: P"+"1200");
                System.out.println("Enter amount: ");
                double amtMeralco = Double.parseDouble(s.nextLine());

                System.out.println("Transaction success!");
                System.out.println("Your balance at the moment is P"+balList[accIndex]);
                break;
            case 2:
                System.out.println("Dumadaloy ang ginhawa - Welcome to Maynilad!\n");
                System.out.println("Amount to pay: P"+"500");
                System.out.println("Enter amount: ");
                double amtMaynilad = Double.parseDouble(s.nextLine());

                System.out.println("Transaction success!");
                System.out.println("Your balance at the moment is P"+balList[accIndex]);
                break;
            case 3:
                System.out.println("Abot mo ang mundo - Welcome to Globe!\n");
                System.out.println("Amount to pay: P"+"2100");
                System.out.println("Enter amount: ");
                double amtGlobe = Double.parseDouble(s.nextLine());

                System.out.println("Transaction success!");
                System.out.println("Your balance at the moment is P"+balList[accIndex]);
                break;
            default:
                System.out.println("Invalid input! Please select from 1-3.");
    }
}
}
