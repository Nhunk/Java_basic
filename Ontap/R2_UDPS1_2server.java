package Ontap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class R2_UDPS1_2server {

    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2004);
            System.out.println("Server dang lang nghe port 2004!");
            while (true) {
                try {
                    byte[] request = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(request, request.length);
                    server.receive(packet);

                    String text = new String(packet.getData(), 0, packet.getLength());
                    if (text.equalsIgnoreCase("stop")) {
                        break;
                    }

                    String[] s = text.split(";");
                    int a = Integer.parseInt(s[0].trim());
                    int b = Integer.parseInt(s[1].trim());
                    int sum = 25 * (a + b);
                    byte[] data = (sum + "").getBytes();
                    DatagramPacket response = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
                    server.send(response);

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}