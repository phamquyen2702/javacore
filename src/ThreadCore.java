import Model.ThreadNew;

public class ThreadCore {
    public static  int count = 1;
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    count += 2;
                    System.out.println(count);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });
        thread.start();
//        ThreadNew threadNew = new ThreadNew();
//        threadNew.start();
        Thread threadNext = new Thread(new ThreadNext());
        threadNext.start();
    }

}
