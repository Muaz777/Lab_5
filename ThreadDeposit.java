public class ThreadDeposit extends Thread {
    private Bank bank;
    private String name;
    private int amount;

    public ThreadDeposit(Bank bank, String name, int amount) {
        this.bank = bank;
        this.name = name;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.deposit(name, amount);
    }
}
