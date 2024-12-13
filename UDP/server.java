package UDP;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(12345);
        while (true) {
            byte[] input = new byte[1024];
            DatagramPacket request = new DatagramPacket(input, input.length);
            server.receive(request);
            String text = new String(request.getData(), 0, request.getLength());

            if (text.equalsIgnoreCase("stop")) {
                break;
            }
            int n = Integer.parseInt(text);
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            String result = String.valueOf(sum);
            byte[] output = result.getBytes();
            DatagramPacket response = new DatagramPacket(output, output.length, request.getAddress(),
                    request.getPort());
            server.send(response);
        }
    }
}
