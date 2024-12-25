package review_all;

import java.util.Scanner;
import java.rmi.Naming;
public class Bai5_RMIC_SoHoanHao {

    public static void main(String[] args) {
        try {
            Bai5_RMI_Interface service = (Bai5_RMI_Interface) Naming.lookup("rmi://localhost/Sohoanhao");

            Scanner scan = new Scanner(System.in);
            String text;
            while (true) {
                System.out.println("Nhap day so ngan cach boi dau ';' hoac 'stop' de ket thuc: ");
                text = scan.nextLine();
                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                for (String number : text.split(";")) {
                    try {
                        int n = Integer.parseInt(number.trim());
                        if (service.isperfectnumber(n)) {
                            System.out.println(n + " la so hoan hao.");
                        } else {
                            System.out.println(n + " khong phai la so hoan hao.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(number + " khong phai la so hop le.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
