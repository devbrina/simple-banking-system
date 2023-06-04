package simplebankingsystem.model;

public class CheckingAcct extends Account {
	private int number;
    private double balance;
    private double creditLimit;
    	
    public void deposit(double value) {
        balance += value;
        System.out.printf("DEPOSIT OF %.2f SUCCESSFULLY MADE\nNEW BALANCE: %.2f", value, balance);
    }

    public void withdraw(double value) {
        if (balance >= value) {
            balance -= value;
            System.out.printf("WITHDRAWAL OF %.2f SUCCESSFULLY MADE\nNEW BALANCE: %.2f", value, balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
    
    // getters and setters
    public double getCreditLimit() {
        if (balance <= 10000.00) {
            creditLimit = balance * 0.05;
        } else if (balance <= 50000.00) {
            creditLimit = balance * 0.06;
        } else {
            creditLimit = balance * 0.07;
        }
        return creditLimit;
    }

    public int getNumber() {
        return number;
    }
    public double getBalance() {
    	return balance;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
