import Controller.ArrayCommon;
import Model.Person;

import java.util.*;

import static java.util.Arrays.sort;

public class ListObject implements ArrayCommon {
    public static Scanner scannerString = new Scanner(System.in);
    public static Scanner scannerInt = new Scanner(System.in);

    @Override
    public void createData() {
        System.out.print("Số phần tử của danh sách : ");
        int n;
        try {
            n = new Scanner(System.in).nextInt();
        }catch (Exception ex){
            System.out.println("Sai định dạng số, hãy nhập lại số phần tử trong mảng: ");
            n = new Scanner(System.in).nextInt();
        }
        List<Person> arrName = new ArrayList<Person>();
        System.out.println("Nhập các phần tử trong danh sách như sau: ");
        for (int i = 0; i < n; i++) {
            System.out.println("Người thứ " + (i + 1) + ": ");
            Person person = new Person();

            System.out.print("Id: ");
            person.setId(scannerInt.nextInt());
            System.out.print("FirstName: ");
            person.setFirstName(scannerString.nextLine());
            System.out.print("LastName: ");
            person.setLastName(scannerString.nextLine());

            System.out.print("DiemTB: ");
            person.setDiemTB(new Scanner(System.in).nextDouble());
            arrName.add(person);
            System.out.println(".");
        }
        arrName.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getDiemTB() - o2.getDiemTB() == 0) {
                    return o1.getLastName().compareTo(o2.getLastName());
                } else {
                    return o1.getDiemTB().compareTo(o2.getDiemTB());
                }
            }
        });
        System.out.println("Danh sách sinh viên trong mảng theo thứ tự DiemTB:");
        for (Person p : arrName) {
            System.out.println(p.toString());
        }
        while (true) {
            System.out.print("Tìm kiếm vị trí tên: ");
            String name = scannerString.nextLine();
            for (int i = 0; i < arrName.size(); i++) {
                if (Objects.equals(name, arrName.get(i).getLastName())) {
                    System.out.println("Vị trí thứ " + i + " trong mảng");
                }
            }
            System.out.println("Bạn có muốn tiếp tục tìm kiếm (Y/N)");
            String x = scannerString.nextLine();
            if (!Objects.equals(x, "Y")) {
                break;
            }

        }
    }
}
