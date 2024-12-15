package Ontap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class R2_UDPS2_2server {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2005);
            System.out.println("Server dang lang nghe port 2005!");
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
                    int c = Integer.parseInt(s[2].trim());
                    int d = Integer.parseInt(s[3].trim());
                    int sum = 6 * (3 * c - 2 * d);
                    byte[] data = (sum + "").getBytes();
                    DatagramPacket response = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
                    server.send(response);

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}