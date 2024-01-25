import Controller.ArrayCommon;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class ArrayString implements ArrayCommon {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Create Data String
     * return
     */
    public void createData() {


        System.out.print("Số phần tử của mảng : ");
        int n = new Scanner(System.in).nextInt();
        String[] arrName = new String[n];
        System.out.println("Nhập các phần tử trong mảng như sau: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arrName[i] = scanner.nextLine();
            System.out.println(".");
        }
        sort(arrName, 0, n);
        System.out.println("Sắp xếp các phần tử trong mảng theo thứ tự Alpha B:" + Arrays.toString(arrName));
        while (true) {
            System.out.print("Tìm kiếm vị trí tên: ");
            String index = scanner.nextLine();
            if (binarySearch(arrName, index) >= 0) {
                System.out.println("Vị trí thứ " + binarySearch(arrName, index) + " trong mảng");
            } else {
                System.out.println("Không tồn tại phần tử trong mảng");
            }
            System.out.println("Bạn có muốn tiếp tục tìm kiếm (Y/N)");
            String x = scanner.nextLine();
            if (!Objects.equals(x, "Y")) {
                break;
            }

        }
    }
}
