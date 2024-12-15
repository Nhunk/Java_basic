package Ontap;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class R7_UDPS_GiaiPT {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2004);
            System.out.println("Server is listening...");
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            server.receive(packet);
            String text = new String(packet.getData(), 0, packet.getLength());
            String[] arr = text.split(";");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            double delta = b * b - 4 * a * c;
            String result="";
            if (a == 0) {
                result = "Phuong trinh co nghiem kep: " + -b / (2 * a);
            } else{
                if (delta < 0) {
                    result = "Phuong trinh vo nghiem";
                } else if (delta == 0) {
                    result = "Phuong trinh co nghiem kep: " + -b / (2 * a);
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    result = "Phuong trinh co 2 nghiem: x1 = " + x1 + ", x2 = " + x2;
                }
            }
            byte[] response = result.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(response, response.length, packet.getAddress(), packet.getPort());
            server.send(sendPacket);

            
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}
