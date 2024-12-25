package review_all;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Bai1UDPClient {


    public static void main(String args[]) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);
            String test;
            while (true) {
                System.out.println("Nhap 1 so nguyen n hoac 'stop' de ket thuc: ");
                test = scan.nextLine();
                if (test.equalsIgnoreCase("stop")) {
                    break;
                }
                int n = Integer.parseInt(test.trim());
                if (n >= 50 && n <= 100) {
                    byte[] data = test.getBytes();
                    DatagramPacket request = new DatagramPacket(data, data.length, add, 2004);
                    socket.send(request);

                    
                    byte[] response = new byte[1024];
                    DatagramPacket repacket = new DatagramPacket(response,response.length);
                    socket.receive(repacket);
                    String result = new String(repacket.getData(),0,repacket.getLength());
                    System.out.println(result);

                }else{
                    System.out.println("Vui long nhap lai so trong khoang [50;100]!");
                }
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
