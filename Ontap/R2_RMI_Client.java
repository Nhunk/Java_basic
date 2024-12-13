package Ontap;

import java.rmi.Naming;
import java.util.Scanner;

public class R2_RMI_Client {
    public static void main(String[] args) {

        try {
            R2_RMI_interface sv1 = (R2_RMI_interface) Naming.lookup("rmi://localhost:2001/tinhTongService");
            R2_RMI_interface sv2 = (R2_RMI_interface) Naming.lookup("rmi://localhost:2001/tinhHieuService");
            Scanner sc = new Scanner(System.in);

            String text;
            while (true) {
                System.out.println("Nhap cac so a, b, c, d cach nhau boi dau cach hoac 'stop' de ket thuc: ");
                text = sc.nextLine();

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }

                try {
                    String[] s = text.split(";");
                    int a = Integer.parseInt(s[0].trim());
                    int b = Integer.parseInt(s[1].trim());
                    int c = Integer.parseInt(s[2].trim());
                    int d = Integer.parseInt(s[3].trim());
                    try {
                        int tong = sv1.tinhTong(a, b);
                        int hieu = sv2.tinhHieu(c, d);
                        int result = tong - hieu;
                        System.out.println(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
