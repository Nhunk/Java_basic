package Ontap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class R4_UDPC_Fibonacci {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {

        DatagramSocket socket = new DatagramSocket();
        InetAddress add = InetAddress.getByName("localhost");
        Scanner scan = new Scanner(System.in);

        String text;
        while (true) {
            System.out.println("Nhap cac gia tri a, b, k, p (cach nhau boi dau ';', 'stop' de ket thuc): ");
            text = scan.nextLine();

            if (text.equalsIgnoreCase("stop")) {
                break;
            }

            String[] s = text.split(";");
            if (s.length != 4) {
                System.out.println("Vui long nhap dung 4 so nguyen !");
                continue;
            }

            byte[] data = text.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, add, 2004);
            socket.send(packet);

            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);

            String result = new String(response.getData(), 0, response.getLength());
            System.out.println("Ket qua: " + result);

        }

    }
}
