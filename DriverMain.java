public class DriverMain {
    public static void main(String[] args) {
        Bank obj = new Bank();

        Thread[] threads = new Thread[8];

        // 4 withdrawals of $100
        threads[0] = new ThreadWithdrawal(obj, "User1", 100);
        threads[1] = new ThreadWithdrawal(obj, "User2", 100);
        threads[2] = new ThreadWithdrawal(obj, "User3", 100);
        threads[3] = new ThreadWithdrawal(obj, "User4", 100);

        // 4 deposits of $50
        threads[4] = new ThreadDeposit(obj, "User5", 50);
        threads[5] = new ThreadDeposit(obj, "User6", 50);
        threads[6] = new ThreadDeposit(obj, "User7", 50);
        threads[7] = new ThreadDeposit(obj, "User8", 50);

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println("Final Balance: $" + obj.getBalance());
    }
}
