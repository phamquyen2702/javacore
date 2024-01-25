public class multiThreadDemo {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Double v = threadDemo.rutTien(10000);
                //System.out.println(v);
                //threadDemo.increment();
                threadDemo.printTable(10);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Double v= threadDemo.rutTien(20000);
               // System.out.println(v);
                //threadDemo.increment();
                threadDemo.printTable(100);

            }
        });
        thread1.start();
        thread2.start();
    }
}
class ThreadDemo {
    public static double money = 100000;

    synchronized public Double rutTien(double money1){
        return money - money1;
    }
    public void increment(){
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    synchronized public void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}