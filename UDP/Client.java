package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {

        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("localhost");
        Scanner scan = new Scanner(System.in);
        while (true) {
            String text;
            while (true) {
                System.out.println("Nhap so nguyen n: ");
                text = scan.nextLine();
                String[] S = text.split(";");
                if (S.length == 1) {
                    break;
                } else {
                    System.out.println("Nhap lai so nguyen n");
                }
            }

            byte[] data = text.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, addr, 12345);
            socket.send(packet);
            if (text.equalsIgnoreCase("stop")) {
                break;
            }
            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(response);
            String output = new String(response.getData(), 0, response.getLength());
            System.out.println(output);
        }
    }
}
