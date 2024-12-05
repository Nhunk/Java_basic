package UDP;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;

public class B1_UDPS_BoiSo {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(2004);
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(requestPacket);

                String received = new String(requestPacket.getData(), 0, requestPacket.getLength());

                if (received.equalsIgnoreCase("stop")) {
                    break;
                }
                List<Integer> multiplesOf5 = new ArrayList<>();
                List<Integer> multiplesOf6 = new ArrayList<>();
                List<Integer> multiplesOf3 = new ArrayList<>();
                for (String numStr : received.split(";")) {
                    try {
                        int num = Integer.parseInt(numStr.trim());
                        if (num % 5 == 0)
                            multiplesOf5.add(num);
                        if (num % 6 == 0)
                            multiplesOf6.add(num);
                        if (num % 3 == 0)
                            multiplesOf3.add(num);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number: " + numStr);
                    }
                }
                String response = "Boi so cua 5 la: " + multiplesOf5 + "\n" + "Boi so cua 6 la: " + multiplesOf6 + "\n"
                        + "Boi so cua 3 la: " + multiplesOf3;
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                        requestPacket.getAddress(), requestPacket.getPort());
                socket.send(responsePacket);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}