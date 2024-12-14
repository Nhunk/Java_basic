package Ontap;

import java.io.*;
import java.net.*;

public class R1_UDPS_TongSoNguyen {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2004);
            System.out.println("Server da san sang!");
            while (true) {
                try {
                    byte[] request = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(request, request.length);
                    server.receive(packet);
                    String text = new String(packet.getData(), 0, packet.getLength());
                    if (text.equalsIgnoreCase("stop")) {
                        break;
                    }
                    int n = Integer.parseInt(text);
                    int sum = 0;
                    for (int i = 1; i <= n; i++) {
                        sum += i;
                    }
                    byte[] data = (sum + "").getBytes();
                    DatagramPacket response = new DatagramPacket(data, data.length, packet.getAddress(),
                            packet.getPort());
                    server.send(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
