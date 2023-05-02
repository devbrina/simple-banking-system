package simplebankingsystem;

public class CheckingAcct {
    private int number = 0;
    private double balance = 0.0;
    private double creditLimit = 0.0;

    public void deposit(double amount) {
        balance += amount;
        System.out.printf("DEPOSIT OF %.2f SUCCESSFULLY MADE\nNEW BALANCE: %.2f", amount, balance);
    }

    public void withdraw(double amount) {
        if (balance + creditLimit >= amount) {
            balance -= amount;
            System.out.printf("WITHDRAWAL OF %.2f SUCCESSFULLY MADE\nNEW BALANCE: %.2f", amount, balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

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

    // getters and setters
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
