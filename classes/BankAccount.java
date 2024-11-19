package classes;

public class BankAccount {
    private String ownersName;
    private String pin;
    private double balance;

    // Constructor
    public BankAccount(String owner, String initialPin) {
        ownersName = owner;
        pin  = initialPin;
        balance = 0;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return ownersName + ", Balance: " + balance;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
