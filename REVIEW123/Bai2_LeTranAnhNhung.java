package REVIEW123;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Bai2_LeTranAnhNhung {
    public static void main(String[] args) {
        String din = "F:\\study\\HK1_3_2425\\CS420_Hephantan\\java_code\\din.txt";
        String dout = "F:\\study\\HK1_3_2425\\CS420_Hephantan\\java_code\\dout.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(din));
                BufferedWriter bw = new BufferedWriter(new FileWriter(dout))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Sao chep file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi doc file hoac ghi file: " + e.getMessage());
        }
    }
}
