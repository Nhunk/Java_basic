package LAB1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bai7 {
public static void main(String[] args) {
    String filePath ="F:\\test.txt";
    try (BufferedReader rd = new BufferedReader(new FileReader(filePath))) {
        String line;
        while((line = rd.readLine())!= null){
            System.out.println(line);
        }
     } catch (IOException e) {
        System.out.println("Loi doc file"+e.getMessage());
     }
}
}
