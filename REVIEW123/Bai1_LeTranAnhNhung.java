package REVIEW123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai1_LeTranAnhNhung {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean check = false;
        while(!check){
            System.out.print("Nhap so nguyen: ");
            try {
                String input=br.readLine();
                num = Integer.parseInt(input);
                check = true;
                System.out.println("So nguyen hop le.");
            } catch (NumberFormatException e) {
                System.out.println("Day khong phai la so nguyen! Vui long nhap so nguyen hop le!_");
            } catch (IOException e){
                System.out.println("Loi "+e.getMessage());
            }
        }
    }
}
