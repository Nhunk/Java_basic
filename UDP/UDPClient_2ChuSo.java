package UDP;

import java.net.*;
import java.util.Scanner;

public class UDPClient_2ChuSo {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);
            byte[] buffer = new byte[1024];

            while (true) {
                System.out.println("Nhap day so ngan cach boi ';' hoac 'stop' de dung: ");
                String text = scan.nextLine();

                byte[] data = text.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, addr, 12345);
                socket.send(packet);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);

                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("So co hai chu so: " + response);

            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}