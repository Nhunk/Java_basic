package LAB1;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bai4_stopinput {
public static void main(String[] args) throws IOException{
    String str;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Nhap cac chuoi ky tu (gioi han bang: stop)");
    do {
        str = br.readLine();
        System.out.println(str);
    } while (!"stop".equalsIgnoreCase(str));
    System.out.println("Da dung chuong trinh!");
}
}
