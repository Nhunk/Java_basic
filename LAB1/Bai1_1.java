package LAB1;

import java.io.*;
public class Bai1_1 {
public static void main(String[] args) throws IOException{
    byte data[] = new byte[100];
    System.out.print("Nhap mot ky tu: ");;
    System.in.read(data);
    System.out.print("Cac ky tu da nhap la: ");
    for(int i = 0; i<data.length;i++)
    System.out.print((char)data[i]);
}
}
