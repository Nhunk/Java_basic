package LAB1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Bai1_11 {
public static void main(String[] args) {
    String f = "F:\\study\\HK1_3_2425\\CS420_Hephantan\\java_code\\LAB1\\new.txt";
    
    try(FileWriter fw = new FileWriter(f);
        PrintWriter pw = new PrintWriter(f);
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in))){
        
        System.out.println("Nhap du lieu (Go 'stop' de dung): ");
        
        while (true) {
            String input =s.readLine();
            if("stop".equalsIgnoreCase(input)){
                break;
            }
            pw.println(input);
            pw.flush();

        try (FileReader fr = new FileReader(f)){
            int c;
            System.out.println("________________________");
            System.out.println("   Noi dung file hien tai:");
            while((c = fr.read()) != -1){
                System.out.print((char)c);
            }
            System.out.println("________________________");
        } catch (IOException e) {
        System.out.println("Loi doc file: "+e.getMessage());    
        }
    }   
    System.out.println("Ket thuc!");
    }catch(IOException e){
        System.out.println("Loi ghi file: "+e.getMessage());
    }
}
}
