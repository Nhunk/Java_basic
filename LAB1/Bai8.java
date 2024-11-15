package LAB1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bai8 {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream("F:\\study\\HK1_3_2425\\CS420_Hephantan\\java_code\\LAB1\\example.txt");
            fout = new FileOutputStream("F:\\study\\HK1_3_2425\\CS420_Hephantan\\java_code\\LAB1\\test.txt");
            int data;
            while ((data = fin.read()) != -1) {
                fout.write(data);
            }
            System.out.println("Da copy thanh cong!");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing files: " + e.getMessage());
            }
        }
    }
}
