package Ontap;

import java.io.*;
import java.net.*;

public class R1_UDPS_TongSoNguyen {

    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(4331);
            while (true) {
                byte[] in = new byte[1024];
                DatagramPacket input = new DatagramPacket(in, in.length);
                server.receive(input);

                String request = new String(input.getData(), 0, input.getLength());
                if (request.equalsIgnoreCase("stop")) {
                    break;
                }
                int n = Integer.parseInt(request);
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += i;
                }

                String result = "Tong tu 1 den " + n + " :" + sum;
                byte[] out = result.getBytes();
                DatagramPacket output = new DatagramPacket(out, out.length, input.getAddress(), input.getPort());
                server.send(output);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
