package simplebankingsystem.controller;

import simplebankingsystem.util.*;

import java.util.Random;

import simplebankingsystem.model.*;
import simplebankingsystem.ui.BankUI;

public class BankController implements BankUI {
	Random rand = new Random();
	public  Account [] account = new Account[100];
	private SavingsAcct savingsAcct;
	
	@Override
	public void initializeWithMsg() {
	    boolean exitProgram = false;

	    while (!exitProgram) {
	        System.out.println("Welcome to your Bank!\nIf you wish to become a new client, please press ENTER.");
	        String enterKey = CommonUtils.getLineInput();

	        if (enterKey.isEmpty()) {
	            askOpenSavingsAcct();
	            instantiateNewClient();
	            System.out.println("Congratulations! You have a checking account now and Your ID is "
	                    + account[emptyPosition].getId()
	                    + "\nNow you can go to the next steps...");
	            enterData();
	            showRegistrationScreen();
	            exitProgram = true;
	        } else {
	            System.out.println("You did not press ENTER. Are you sure you want to close the program?\nIf yes, press Q.\nOr press any key to return.");
	            enterKey = CommonUtils.getLineInput();

	            if (enterKey.equalsIgnoreCase("Q")) {
	                System.out.println("Oh, so sad! :("
	                        + "\nBut we are waiting for you in the future!"
	                        + "\nThank you for your visit! ;)");
	                System.exit(0);
	            }
	        }
	    }
	}
		
	int findFirstEmptyPosition() {
	    for (int counter = 0; counter < account.length; counter++) {
	        if (account[counter] == null) {
	            return counter;
	        }
	    } return -1;
	}

	int emptyPosition =  findFirstEmptyPosition();

	public void instantiateNewClient() {
	    if (emptyPosition >= 0) {
	        account[emptyPosition] = new Account();
	        account[emptyPosition].setId(emptyPosition);
	        account[emptyPosition].setAgency(rand.nextInt(9999));
	        account[emptyPosition].checkingAcct.setNumber(rand.nextInt(999999));
	    } else {
	        System.out.println("We have many clients for now. We'll contact you soon");
	    }
	}
	
    @Override
	public void enterData() {
	    System.out.println("Enter your name:");
		setAndShowName();

	    System.out.println("Enter your CPF (format: XXX.XXX.XXX-XX):");
		setAndShowCpf();
	}
	public void setAndShowName() { 
        String name = CommonUtils.getValidName();
        account[emptyPosition].setName(name);
    }
    public void setAndShowCpf() {
    	String cpf = CommonUtils.getValidCpf();
        account[emptyPosition].setCpf(cpf);
    }
    
    @Override
    public void showRegistrationScreen() {
        int option;
        do {
            System.out.println("Enter 1 to see your infos or 0 for other options");
            option = CommonUtils.getIntInput();

            if (option == 1) {
                System.out.println("Welcome to your account!");
                showCreatedCheckingAcctAndAgency();
            } else if (option == 0) {
                break; // Exit the loop if option is 0
            } else {
                System.out.println("Invalid input! Please enter either 0 or 1.");
            }
        } while (true);
        menuOptions();
    }

    @Override
	public void showCreatedCheckingAcctAndAgency() {
	    System.out.println("NAME: "
		        + account[emptyPosition].getName()
		        + "\nCPF: "
		        + account[emptyPosition].getCpf()
		        + "\nAGENCY: "
		        + account[emptyPosition].getAgency()
		        + "\nCHECKING ACCOUNT: "
	            + account[emptyPosition].checkingAcct.getNumber());
	    
			    if (isSavingsAcctOpened()) {
			        System.out.println("SAVINGS ACCOUNT: "
			            + this.savingsAcct.getNumber());
			    } else {
			        System.out.println("SAVINGS ACCOUNT: No account created");
			    }
	}
    
    @Override
    public void askOpenSavingsAcct() {
        boolean validInput = false;
        String answer = "";

        while (!validInput) {
            System.out.println("Do you want to open a savings account? (y/n)");
            answer = CommonUtils.getLineInput();

            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n")) {
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter 'y' or 'n'.\n");
            }
        }

        if (answer.equalsIgnoreCase("y")) {
            savingsAcct = new SavingsAcct();
            savingsAcct.createSavingsAcct();
        } else {
            System.out.println("Saving account not created.");
        }
    }

    public boolean isSavingsAcctOpened() {
        return this.savingsAcct != null;
    }
    public void checkSavingsAcct() {
        if (!isSavingsAcctOpened()) {
            askOpenSavingsAcct();
            menuOptions();
        }
    }
		
    @Override
	public void menuOptions() {
	    int option;
	    do {
	        System.out.println("Select an option from 1 to 10 to consult:\n"
	                + "(1) DEPOSIT > CHECKING ACCOUNT\n"
	                + "(2) DEPOSIT > SAVINGS ACCOUNT\n"
	                + "(3) WITHDRAWAL > CHECKING ACCOUNT\n"
	                + "(4) WITHDRAWAL > SAVINGS ACCOUNT\n"
	                + "(5) CHECK BALANCE > CHECKING ACCOUNT\n"
	                + "(6) CHECK BALANCE > SAVINGS ACCOUNT\n"
	                + "(7) CHECK CREDIT > CHECKING ACCOUNT\n"
	                + "(8) CHECK INTEREST> SAVINGS ACCOUNT\n"
	                + "(9) RETURN TO HOME\n"
	                + "(10) EXIT OF ACCOUNT\n");
	        option = CommonUtils.getIntInput();

	        switch (option) {
	            case 1:
	            	handleCheckingAcctDeposit();
	                break;
	            case 2:
	            	handleSavingsAcctDeposit();
	                break;
	            case 3:
	            	handleCheckingAcctWithdrawal();
	                break;
	            case 4:
	            	handleSavingsAcctWithdrawal();
	                break;
	            case 5:
	            	checkCheckingAcctBalance();
	                break;
	            case 6:
	            	checkSavingsAcctBalance();
	                break;
	            case 7:
	            	checkCheckingAcctCreditLimit();
	                break;
	            case 8:
	            	checkSavingsAcctInterest();
	                break;
	            case 9:
	            	System.out.println("Exiting the menu... Returning to the beginning");
	            	showRegistrationScreen();
	                break;
	            case 10:
	            	System.out.println("Exiting of your account...\nDone!");
	            	System.exit(0);
	                break;
	            default:
	            	handleInvalidInput();
	                break;
	        }
	    } while (option != 0);

	    System.out.println("\nEnter 1 to register a new client or 0 for the next step!");
	    option = CommonUtils.getIntInput();
	}
		    
	//functions for the second menu (switch case)  
    public void handleCheckingAcctDeposit() {
    	System.out.println("DEPOSIT AMOUNT: \n");
        double depositAmount = CommonUtils.getDoubleInput();
        account[emptyPosition].checkingAcct.deposit(depositAmount);
        System.out.println("\n");
    }
    public void handleSavingsAcctDeposit() {
    	checkSavingsAcct();
        System.out.println("DEPOSIT AMOUNT: \n");
        double depositAmount = CommonUtils.getDoubleInput();
        this.savingsAcct.deposit(depositAmount);
        System.out.println("\n");
    }
    public void handleCheckingAcctWithdrawal() {
        System.out.println("AMOUNT TO WITHDRAW: \n");
        double withdrawAmount = CommonUtils.getDoubleInput();
        account[emptyPosition].checkingAcct.withdraw(withdrawAmount);    
        System.out.println("\n");
    }
    public void handleSavingsAcctWithdrawal() {
    	checkSavingsAcct();
        System.out.println("AMOUNT TO WITHDRAW: \n");
        double withdrawAmount = CommonUtils.getDoubleInput();
        this.savingsAcct.withdraw(withdrawAmount);
        System.out.println("\n");
    }
    public void handleInvalidInput() {
        System.out.println("Invalid input! Please enter a number between 1 and 10.");
    }
    
    public void checkCheckingAcctBalance() {
        double balance = account[emptyPosition].checkingAcct.getBalance();
        String formattedBalance = CommonUtils.formatValue(balance);
        System.out.println("CURRENT ACCOUNT BALANCE: " + formattedBalance + "\n");
    }
    public void checkSavingsAcctBalance() {
        checkSavingsAcct();
        String formattedBalance = CommonUtils.formatValue(this.savingsAcct.getBalance());
        System.out.println("SAVINGS ACCOUNT BALANCE: " + formattedBalance + "\n");
    }
    public void checkCheckingAcctCreditLimit() {
        String formattedCreditLimit = CommonUtils.formatValue(account[emptyPosition].checkingAcct.getCreditLimit());
        System.out.println("CURRENT ACCOUNT CREDIT: " + formattedCreditLimit + "\n");
    }
    public void checkSavingsAcctInterest() {
        checkSavingsAcct();
        String formattedInterest = CommonUtils.formatValue(this.savingsAcct.getInterest());
        System.out.println("SAVINGS ACCOUNT INTEREST: " + formattedInterest + "\n");
    }
}