import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex {
public static void main(String[] args) {
    String f = "F:\\study\\HK1_3_2425\\CS420_Hephantan\\java_code\\LAB1\\new.txt";
    try(FileWriter fw = new FileWriter(f);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        System.out.println("Nhap lieu(go 'stop' de dung): ");
        while (true) {
            String data = br.readLine();
            if("stop".equalsIgnoreCase(data)){
                break;
            }
            fw.write(data);
            fw.flush();
        }
        fw.close();
        System.out.println("Ket thuc!");
    } catch (IOException e) {
        System.out.println("Loi ghi file: "+e.getMessage());
    }
}
}
