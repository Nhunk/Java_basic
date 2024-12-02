package LAB1;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bai1_3 {
public static void main(String[] args) throws IOException{
    char c;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Nhap chuoi ky tu (gioi han dau cham): ");;
    do{
        c=(char)br.read();
        System.out.println(c);
    }while(c!='.');
}
}
