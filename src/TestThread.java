import java.util.Scanner;

class Customer {
    int amount = 10000;
    boolean  check = true;

    synchronized void withdraw(int amount) {
        System.out.println("Rút tiền...");
        while (this.amount < amount){
            System.out.println("Tài khoản không đủ; đợi gửi tiền...");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.amount -= amount;
        System.out.println("Hoàn thành rút tiền!");
        check = false;
        System.out.println("Số tiền hiện tại: "+ this.amount);
    }

    synchronized void deposit(int amount) {
        System.out.println("Gửi tiền...");
        this.amount += amount;
        System.out.println("Hoàn thành gửi tiền!");
        System.out.println("Số tiền hiện tại: "+ this.amount);
        notify();
    }
}

public class TestThread {
    public static void main(String []args) {
        final Customer c = new Customer();
        Scanner  scanner = new Scanner(System.in);
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();
        new Thread() {
            public void run() {
                while (c.check){
                    System.out.println("Nhập số tiền gửi: ");
                    int n = scanner.nextInt();
                    c.deposit(n);
                }

            }
        }.start();
    }
}