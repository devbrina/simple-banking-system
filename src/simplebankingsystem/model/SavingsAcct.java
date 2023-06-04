package simplebankingsystem.model;

import java.util.Random;

public class SavingsAcct extends Account {
	private int number = 0;
	private double balance = 0.0;
	private double interest = 7.50; //IT WOULD BE NICE TO CONNECT WITH SELIC API
	Random rand = new Random();

	public void createSavingsAcct() {
		setNumber(rand.nextInt(999999));
        System.out.println("Savings account opened! \nNUMBER : " + getNumber());
	}

	public void deposit(double value) {
		balance += value;
		System.out.printf("DEPOSIT OF %.2f MADE SUCCESSFULLY!"
							+"\nNEW BALANCE: %.2f", value, balance);
	}
	public void withdraw(double value) {
		if (balance > value) {
			balance -= value;
			System.out.printf("WITHDRAWAL OF %.2f MADE SUCCESSFULLY"
								+"\nNEW BALANCE: %.2f", value, balance);
		} else {
			System.out.println("Insufficient balance for withdrawal");
		}
	}

	//getters and setters
	public int getNumber() {
		return number;
	}
    public double getBalance() {
    	return balance;
    }
    public double getInterest() {
        return balance + balance * (interest / 100.00);

    }
	public void setNumber(int number) {
		this.number = number;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
}
