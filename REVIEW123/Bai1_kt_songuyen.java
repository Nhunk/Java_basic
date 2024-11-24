package REVIEW123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai1_kt_songuyen {

    public static void main(String[] args) {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Nhap so nguyen: ");
            try {
                str = br.readLine();
                if ("stop".equalsIgnoreCase(str)) {
                    System.out.println("Da dung chuong trinh");
                    break;
                }
                int num = Integer.parseInt(str);
                System.out.println("So " + num + " hop le.");
            } catch (NumberFormatException e) {
                System.out.println("Day khong phai la so nguyen! Vui long nhap lai!");
            } catch (IOException e) {
                System.out.println("Loi " + e.getMessage());
            }

        }
    }
}
