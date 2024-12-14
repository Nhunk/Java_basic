package Ontap;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class R1_UDPC_TongSoNguyen {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("localhost");
            int port = 2004;
            Scanner scan = new Scanner(System.in);

            while (true) {
                System.out.println("Nhap so nguyen n (hoac 'stop' de ket thuc): ");
                String text = scan.nextLine();

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }

                try {
                    int n = Integer.parseInt(text.trim());
                    if (n < 50 || n > 100) {
                        System.out.println("Vui long nhap so nguyen tu 50 den 100.");
                    } else {
                        byte[] data = text.getBytes();
                        DatagramPacket packet = new DatagramPacket(data, data.length, addr, port);
                        socket.send(packet);

                        byte[] buffer = new byte[1024];
                        DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                        socket.receive(response);
                        String result = new String(response.getData(), 0, response.getLength());
                        System.out.println(result);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui long nhap mot so nguyen hop le.");
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}