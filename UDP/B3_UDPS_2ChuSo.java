package UDP;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class B3_UDPS_2ChuSo {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(12345);
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(requestPacket);

                String received = new String(requestPacket.getData(), 0, requestPacket.getLength());

                if (received.equalsIgnoreCase("stop")) {
                    break;
                }

                String[] numbers = received.split(";");
                List<Integer> twoDigitNumbers = new ArrayList<>();

                for (String number : numbers) {
                    
                        int n = Integer.parseInt(number.trim());
                        if (isTwoDigitNumber(n)) {
                            twoDigitNumbers.add(n);
                        }
                }
                String response =twoDigitNumbers.isEmpty() ? "No find!" : twoDigitNumbers.toString();
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                        requestPacket.getAddress(), requestPacket.getPort());
                socket.send(responsePacket);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isTwoDigitNumber(int n) {
        return n >= 10 && n <= 99;
    }
}