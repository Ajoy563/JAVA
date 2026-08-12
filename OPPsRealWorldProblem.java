abstract class BankAccount {
    private String name;
    private double balance;

    BankAccount(String name, double balance) { // Constructor
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void showBalance() {
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
    }

    public abstract void calculateInterest();

}

class SavingAccount extends BankAccount {
    SavingAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Saving Account Interest rate is 6%");
    }
}

public class OPPsRealWorldProblem {
    public static void main(String[] args) {
        BankAccount account = new SavingAccount("Ajoy", 2000); 
        account.showBalance();
        account.deposit(2000);
        account.withdraw(3000);
        account.showBalance();
        account.calculateInterest();
    }
}
