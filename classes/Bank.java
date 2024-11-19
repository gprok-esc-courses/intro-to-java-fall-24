package classes;

public class Bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("George", "1219");

        account.deposit(1000);
        account.withdraw(4000);

        account.setPin("1009");

        System.out.println(account);
    }
}
