package UDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class B10_UDPC_TongSoNguyen {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);
            byte[] buffer = new byte[1024];

            while (true) {
                System.out.println("Nhap so nguyen n: ");
                String text = scan.nextLine();

                byte[] data = text.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, addr, 2009);
                socket.send(packet);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                DatagramPacket responsePacket = new DatagramPacket(buffer, 0, buffer.length);
                socket.receive(responsePacket);

                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("Tong cac so tu nhien tu 1 den" + text + " : " + response);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
