package simplebankingsystem;

import java.util.Random;

public class SavingsAcct {
	private int number = 0;
	private double balance = 0.0;
	private double interest = 0.0;
	Random rand = new Random();

	SavingsAcct (int number, double balance, double interest){
		this.number = number;
		this.balance = balance;
		this.interest = interest;
	}

	public void createSavingsAcct() {
		setNumber(rand.nextInt(999999));
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
	public double getInterest () {
		return balance = balance + balance * (interest/100.00);
	}

	public void setNumber(int number) {
		this.number = number;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
}
