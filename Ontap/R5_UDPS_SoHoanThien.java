package Ontap;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class R5_UDPS_SoHoanThien {
    public static boolean isPerfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        if (sum == n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2004);
            System.out.println("Server dang lang nghe port 2004");
            try (DatagramSocket socket = server) {
                while (true) {
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    String text = new String(packet.getData(), 0, packet.getLength());
                    if (text.equalsIgnoreCase("stop")) {
                        break;
                    }
                    String[] arr = text.split(";");
                    String result = "";
                    for (int i = 0; i < arr.length; i++) {
                        int num = Integer.parseInt(arr[i]);
                        if (isPerfectNumber(num)) {
                            result += num + " vi tri trong day so: " + (i + 1) + "\n";
                        }
                    }
                    if (result.isEmpty()) {
                        result = "Khong co so hoan thien trong day";
                    }
                    byte[] data = result.getBytes();
                    DatagramPacket response = new DatagramPacket(data, data.length, packet.getAddress(),
                            packet.getPort());
                    socket.send(response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
