public class Bank {
    private int balance = 500;

    public synchronized void deposit(String name, int amount) {
        balance += amount;
        System.out.println(name + " deposited $" + amount + ". Balance: $" + balance);
    }

    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(name + " withdrew $" + amount + ". Balance: $" + balance);
        } else {
            System.out.println(name + " failed to withdraw $" + amount + ". Insufficient funds. Balance: $" + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}
