package UDP;

import java.net.*;
import java.util.Scanner;

public class Bai1_UDPClient_BoiSo {
    public static void main(String[] args) {
        try {
           DatagramSocket socket = new DatagramSocket();
           InetAddress addr = InetAddress.getByName("localhost") ;
           Scanner scan = new Scanner(System.in);
           byte[] buffer = new byte[1024];
           while(true){
            System.out.println("Nhap cac so nguyen , ngan cach boi dau ';' hoac 'stop' de ket thuc: ");
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
