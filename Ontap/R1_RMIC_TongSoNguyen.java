package Ontap;

import java.rmi.Naming;
import java.util.Scanner;

public class R1_RMIC_TongSoNguyen {
    public static void main(String[] args) {
        try {
            R1_RMI_Interface_TongSoNguyen service = (R1_RMI_Interface_TongSoNguyen) Naming
                    .lookup("rmi://localhost:2004/tinhTongService");
            Scanner scan = new Scanner(System.in);

            String text;
            while (true) {
                System.out.println("Nhap so nguyen n hoac 'stop' de dung: ");
                text = scan.nextLine();

                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                String[] s = text.split(";");
                int n = Integer.parseInt(s[0].trim());
                if (s.length == 1 && n >= 50 && n <= 100) {

                    try {
                        int result = service.tinhTong(n);
                        System.out.println("Tong tu 1 den " + n + ": " + result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    
                }else{
                    System.out.println("Vui long nhap 1 so nguyen thuoc khoang tu [50,100]:");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
