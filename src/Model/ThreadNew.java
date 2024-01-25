package Model;

public class ThreadNew extends Thread{
    public void run(){

        for (int i = 0; i < 10; i++) {
            System.out.println("Hello 1 , world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
