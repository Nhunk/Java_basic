
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Server_Fibonacci {

    public static int Fibonacci(int a, int b, int k, int p) {
        int[] fibo = new int[k];
        fibo[0] = a;
        fibo[1] = b;
        int result = -1;
        for (int i = 2; i < k; i++) {
            fibo[i] = fibo[i - 2] + fibo[i - 1];
        }
        for (int i = 0; i < k; i++) {
            if (fibo[i] == p) {
                result = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2004);
            System.out.println("Server is running");
            while (true) {
                byte[] data = new byte[1024];
                DatagramPacket packet = new DatagramPacket(data, data.length);
                server.receive(packet);
                String input = new String(packet.getData(), 0, packet.getLength());
                String[] s = input.split(";");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int k = Integer.parseInt(s[2]);
                int p = Integer.parseInt(s[3]);
                String result = Fibonacci(a, b, k, p) >= 0 ? "So " + p + " o vi tri " + Fibonacci(a, b, k, p) : "Khong tim thay " + p + " trong day fibo";
                byte[] redata = result.getBytes();
                DatagramPacket repacket = new DatagramPacket(redata, redata.length, packet.getAddress(), packet.getPort());
                server.send(repacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
