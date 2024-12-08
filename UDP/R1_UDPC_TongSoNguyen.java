package UDP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class R1_UDPC_TongSoNguyen {

    public static void main(String[] args) throws IOException, SocketException {

        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("localhost");
        Scanner scan = new Scanner(System.in);
        while (true) {
            String text;
            while (true) {
                System.out.print("Nhap: ");
                text = scan.nextLine();
                String[] S = text.split(";");
                if (S.length == 1) {
                    break;
                } else {
                    System.out.println("Nhap lai le lonnnn!!!");
                }
            }

            byte[] data = text.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length,addr,4331);
            socket.send(packet);

             if (text.equalsIgnoreCase("stop")) {
                break;
            }

            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);
            String output = new String(response.getData(), 0, response.getLength());
            System.out.println(output);

        }
    }
}
