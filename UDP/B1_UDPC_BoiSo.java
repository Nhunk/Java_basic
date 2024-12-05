package UDP;

import java.net.*;
import java.util.Scanner;

public class B1_UDPC_BoiSo {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);
            byte[] buffer = new byte[1024];
            while (true) {
                System.out.println("Nhap cac so nguyen , ngan cach boi dau ';' hoac 'stop' de ket thuc: ");
                String text = scan.nextLine();

                byte[] data = text.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, addr, 2004);
                socket.send(packet);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }

                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);

                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println(response);

            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
