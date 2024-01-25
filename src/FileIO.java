import java.io.*;

public class FileIO {
    public void readAndWriteFileByteStream() throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        inputStream = new FileInputStream("C:\\Project_study_workplace\\FileDemo\\inStream.txt");
        outputStream = new FileOutputStream("C:\\Project_study_workplace\\FileDemo\\outStream.txt");
        int c;
        while ((c = inputStream.read()) != -1) {
            outputStream.write(c);
        }
        inputStream.close();
        outputStream.close();
    }

    public void readAndWriteCharStream() throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        fileReader = new FileReader("C:\\Project_study_workplace\\FileDemo\\fileReader.txt");
        fileWriter = new FileWriter("C:\\Project_study_workplace\\FileDemo\\fileWriter.txt");
        int c;
        while ((c = fileReader.read()) != -1) {
            fileWriter.write(c);
        }
        fileReader.close();
        fileWriter.close();

    }

    public void readAndWriteBufferByteStream() throws IOException {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        FileInputStream inputStream = new FileInputStream("C:\\Project_study_workplace\\FileDemo\\bufferInStream.txt");
        FileOutputStream outputStream = new FileOutputStream("C:\\Project_study_workplace\\FileDemo\\bufferOutStream.txt");
        bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedOutputStream = new BufferedOutputStream(outputStream);
        int c;
        while ((c = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(c);
        }
        bufferedOutputStream.close();
        bufferedOutputStream.close();


    }

    public void readAndWriteBufferCharStream() throws IOException {
        BufferedReader bufferedIR = null;
        BufferedWriter bufferedWriter = null;

        FileReader fileReader = new FileReader("C:\\Project_study_workplace\\FileDemo\\bufferReader.txt");
        FileWriter fileWriter = new FileWriter("C:\\Project_study_workplace\\FileDemo\\bufferWriter.txt");
        bufferedIR = new BufferedReader(fileReader);
        bufferedWriter = new BufferedWriter(fileWriter);
        int c;
        while ((c = bufferedIR.read()) != -1) {
            bufferedWriter.write(c);
        }

        bufferedIR.close();
        bufferedWriter.close();

    }

    public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    double timeStart = System.currentTimeMillis();
                    fileIO.readAndWriteFileByteStream();
                    System.out.println("Thời gian copy File by Byte: " + (System.currentTimeMillis() - timeStart) + " ms");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread1");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    double timeStart = System.currentTimeMillis();
                    fileIO.readAndWriteCharStream();
                    System.out.println("Thời gian copy File by Char: " + (System.currentTimeMillis() - timeStart) + " ms");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread2");


        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    double timeStart = System.currentTimeMillis();
                    fileIO.readAndWriteBufferByteStream();
                    System.out.println("Thời gian copy File by bufferByte: " + (System.currentTimeMillis() - timeStart) + " ms");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        },"3");


        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    double timeStart = System.currentTimeMillis();
                    fileIO.readAndWriteBufferCharStream();
                    System.out.println("Thời gian copy File by bufferChar: " + (System.currentTimeMillis() - timeStart) + " ms");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread4");
        thread1.setPriority(Thread.MIN_PRIORITY);

        thread2.setPriority(Thread.MIN_PRIORITY);

        thread3.setPriority(Thread.NORM_PRIORITY);

        thread4.setPriority(Thread.MAX_PRIORITY);
        thread3.start();
        thread2.start();
        thread1.start();
        thread4.start();

    }

}
