package simplebankingsystem;

import java.util.Scanner;
import java.util.Random;

public class Main {
	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();
	static Account account = new Account(1,"","",0);
	static SavingsAcct savingsAcct = new SavingsAcct(0, 0.0, 0.0);
	
	static int option;

	public static void main(String[] args) {
	    showRegistrationScreen();
	    getUserChoice();
	}

	public static void showRegistrationScreen() {
	    System.out.println("Enter 1 to register or 0 for other options");
	    option = input.nextInt();
	    while (option!= 0){
	        System.out.println("Welcome to the client registration system");
	        
	        enterData();
	        openSavingsAccount();
	        showCreatedCheckingAccountAndAgency();
	        instantiateNewClient();
	                    
	        System.out.println("\nEnter 1 to register a new one or 0 for the next step!");
	        option = input.nextInt();
	    }
	}

	public static void instantiateNewClient() {
	    account.setId(rand.nextInt(99));
	    System.out.println("ID: " + account.getId());
	}

	public static void enterData() {
	    System.out.println("Enter your name");
	    String newName = input.next();
	    account.setName(newName);
	    
	    System.out.println("Enter your CPF");
	    String newCpf= input.next();
	    account.setCpf(newCpf);
	}
	    
	public static void showCreatedCheckingAccountAndAgency() {
		account.setAgency(rand.nextInt(99999));
		account.checkingAcct.setNumber(rand.nextInt(999999));
	    
	    System.out.println("AGENCY: "
	            + account.getAgency()
	            + "\nCHECKING ACCOUNT: "
	            + account.checkingAcct.getNumber());
	}
	public static void openSavingsAccount() {
	    System.out.println("Open savings account? [y/n]: ");
	    String resp = input.next();
	    resp = resp.toLowerCase();
	    if (resp.equals("y")) {
	    	savingsAcct.createSavingsAcct();
	        System.out.println("SAVINGS ACCOUNT SUCCESSFULLY OPENED! \nSAVINGS ACCOUNT: " + savingsAcct.getNumber());
	    } else if (resp.equals("n")){
	        System.out.println("SAVINGS ACCOUNT NOT CREATED.");
	    } else {
	        System.out.println("Invalid answer!");
	    }
	}

	//options
    public static void handleCheckingAccountDeposit() {
    	System.out.println("DEPOSIT AMOUNT: \n");
        double op1 = input.nextDouble();
        account.checkingAcct.deposit(op1);
        System.out.println("\n");
    }
    public static void handleSavingsAccountDeposit() {
    	System.out.println("DEPOSIT AMOUNT: \n");
        double op2 = input.nextDouble();
        savingsAcct.deposit(op2);
        System.out.println("\n");
    }
    public static void handleCheckingAccountWithdrawal() {
        System.out.println("AMOUNT TO WITHDRAW: \n");
        double op3 = input.nextDouble();
        account.checkingAcct.withdraw(op3);    
        System.out.println("\n");
    }
    public static void handleSavingsAccountWithdrawal() {
        System.out.println("AMOUNT TO WITHDRAW: \n");
        double op4 = input.nextDouble();
        savingsAcct.withdraw(op4);
        System.out.println("\n");
    }
    public static void checkCheckingAccountBalance() {
        System.out.println("CURRENT ACCOUNT BALANCE: "+ account.checkingAcct.getBalance()+ "\n");
    }
    public static void checkSavingsAccountBalance() {
        System.out.println("SAVINGS ACCOUNT BALANCE: "+ savingsAcct.getBalance()+ "\n");
    }
    public static void checkCheckingAccountCreditLimit () {
        System.out.println("CURRENT ACCOUNT CREDIT: " + account.checkingAcct.getCreditLimit()+ "\n");
    }
    public static void checkSavingsAccountInterest () {
    	savingsAcct.setInterest(7.50); //it would be nice to use the SELIC API
        System.out.println("SAVINGS ACCOUNT INTEREST: " + savingsAcct.getInterest()+ "\n");
    }
    public static void handleInvalidInput() {
        System.out.println("Invalid input! Please enter a number between 1 and 8."+ "\n");
    }
    
    
	public static void getUserChoice() {
	            System.out.println("Select an option from 1 to 8 to consult:\n"
	            + "(1) DEPOSIT > CHECKING ACCOUNT\n"
	            + "(2) DEPOSIT > SAVINGS ACCOUNT\n"
	            + "(3) WITHDRAWAL > CHECKING ACCOUNT\n"
	            + "(4) WITHDRAWAL > SAVINGS ACCOUNT\n"
	            + "(5) CHECK BALANCE > CHECKING ACCOUNT\n"
	            + "(6) CHECK BALANCE > SAVINGS ACCOUNT\n"
	            + "(7) CHECK CREDIT > CHECKING ACCOUNT\n"
	            + "(8) CHECK INTEREST> SAVINGS ACCOUNT\n");
        
	            int choice = input.nextInt();

        while (choice != 0){
        	switch (choice) {
            case 1:
                handleCheckingAccountDeposit();
                choice = input.nextInt();
                break;
            case 2:
                handleSavingsAccountDeposit();
                choice = input.nextInt();
                break;
            case 3:
                handleCheckingAccountWithdrawal();
                choice = input.nextInt();
                break;
            case 4:
                handleSavingsAccountWithdrawal();
                choice = input.nextInt();
                break;
            case 5:
                checkCheckingAccountBalance();
                choice = input.nextInt();
                break;
            case 6:
                checkSavingsAccountBalance();
                choice = input.nextInt();
                break;
            case 7:
                checkCheckingAccountCreditLimit();
                choice = input.nextInt();
                break;
            case 8:
                checkSavingsAccountInterest();
                choice = input.nextInt();
                break;
            default:
                handleInvalidInput();
                choice = input.nextInt();
                break;
        	}
        }
        System.out.println("\nEnter 1 to register a new client or 0 for the next step!");
        option = input.nextInt();
  	}
}
