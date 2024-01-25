import Controller.ArrayCommon;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class ArrayINT implements ArrayCommon {
    public static Scanner scanner = new Scanner(System.in);

    public void createData() {
        System.out.print("Số phần tử của mảng : ");
        int n = scanner.nextInt();
        int[] arrName = new int[n];
        System.out.println("Nhập các phần tử trong mảng như sau: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arrName[i] = scanner.nextInt();
            System.out.println(".");
        }
        sort(arrName, 0, n);
        System.out.println("Sắp xếp các phần tử trong mảng từ nhỏ đến lớn:" + Arrays.toString(arrName));
        while (true) {
            System.out.print("Tìm kiếm vị trí số: ");
            int index = scanner.nextInt();
            if (binarySearch(arrName, index) >= 0) {
                System.out.println("Vị trí thứ " + binarySearch(arrName, index) + " trong mảng");
            } else {
                System.out.println("Không tồn tại phần tử trong mảng");
            }
            System.out.println("Bạn có muốn tiếp tục tìm kiếm (Y/N)");
            String x = new Scanner(System.in).nextLine();
            if (!Objects.equals(x, "Y")) {
                break;
            }

        }
    }

}
