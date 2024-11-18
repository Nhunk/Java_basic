package REVIEW123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai5_daonguocso {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nhap mot so nguyen duong: ");
        String input = br.readLine();
        int num = Integer.parseInt(input);
        int reversed = 0;
        do {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        } while (num > 0);
        System.out.println("So dao nguoc la: " + reversed);
    }
}
