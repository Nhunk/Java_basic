package Ontap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class R4_UDPS_Fibonacci {
    public static void main(String[] args) throws SocketException, IOException, NumberFormatException {
        DatagramSocket server = new DatagramSocket(2004);
        System.out.println("Server dang lang nghe port 2004!");

        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket request = new DatagramPacket(data, data.length);
            server.receive(request);

            String input = new String(request.getData(), 0, request.getLength());
            String[] s = input.split(";");
            int a = Integer.parseInt(s[0].trim());
            int b = Integer.parseInt(s[1].trim());
            int k = Integer.parseInt(s[2].trim());
            int p = Integer.parseInt(s[3].trim());
            int[] fibo = new int[k];
            fibo[0] = a;
            fibo[1] = b;
            for (int i = 2; i < k; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }

            int result = -1;
            for (int i = 0; i < k; i++) {
                if (fibo[i] == p) {
                    result = i + 1;
                    break;
                }
            }
            if (result != -1) {
                byte[] output = ("So " + p + " xuat hien trong day Fibonacci va o vi tri thu " + result).getBytes();
                DatagramPacket response = new DatagramPacket(output, output.length, request.getAddress(),
                        request.getPort());
                server.send(response);
            }else{
                byte[] output = ("So " + p + " khong xuat hien trong day Fibonacci").getBytes();
                DatagramPacket response = new DatagramPacket(output, output.length, request.getAddress(),
                        request.getPort());
                server.send(response);
            }
        }
    }
}
