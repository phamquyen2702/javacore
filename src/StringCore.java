public class StringCore {
    void actionString() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String string = new String("Phạm Văn A");
                double startTime1 = System.currentTimeMillis();
                for (int i = 0; i < 100000; i++) {
                    string.concat("a");
                }
                System.out.println("Thời gian nối chuỗi của String: "
                        + (System.currentTimeMillis() - startTime1) + "ms");
            }
        });
        thread1.start();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuffer stringBuffer = new StringBuffer("Phạm Văn B");
                double startTime2 = System.currentTimeMillis();
                for (int i = 0; i < 100000; i++) {
                    stringBuffer.append("a");
                }
                System.out.println("Thời gian nối chuỗi của StringBuffer: "
                        + (System.currentTimeMillis() - startTime2) + "ms");
            }
        });
        thread3.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder("Phạm Văn C");
                double startTime3 = System.currentTimeMillis();
                for (int i = 0; i < 100000; i++) {
                    stringBuilder.append("a");
                }
                System.out.println("Thời gian nối chuỗi của StringBuidler: "
                        + (System.currentTimeMillis() - startTime3) + "ms");
            }
        });
        thread2.start();

    }

    public static void main(String[] args) {
        new StringCore().actionString();
    }
}
