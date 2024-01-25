public class ThreadNext extends ThreadCore implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count += 1;
            System.out.println(count);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
