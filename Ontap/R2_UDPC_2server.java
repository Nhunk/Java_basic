package Ontap;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class R2_UDPC_2server {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress addr = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);

            while (true) {
                System.out.println("Nhap cac so a, b, c, d (cach nhau boi dau ';', 'stop' de ket thuc): ");
                String text = scan.nextLine();

                if (text.equalsIgnoreCase("stop")) {
                    byte[] stopData = text.getBytes();
                    DatagramPacket stopPacket1 = new DatagramPacket(stopData, stopData.length, addr, 2004);
                    DatagramPacket stopPacket2 = new DatagramPacket(stopData, stopData.length, addr, 2005);
                    socket.send(stopPacket1);
                    socket.send(stopPacket2);
                    break;
                }

                try {
                    String[] s = text.split(";");
                    if (s.length != 4) {
                        System.out.println("Vui long nhap dung 4 gia tri a, b, c, d cach nhau boi dau ';'");
                        continue;
                    }

                    for (String value : s) {
                        Integer.parseInt(value.trim());
                    }

                    byte[] data = text.getBytes();
                    DatagramPacket packet1 = new DatagramPacket(data, data.length, addr, 2004);
                    DatagramPacket packet2 = new DatagramPacket(data, data.length, addr, 2005);
                    socket.send(packet1);
                    socket.send(packet2);

                    byte[] buffer1 = new byte[1024];
                    DatagramPacket response1 = new DatagramPacket(buffer1, buffer1.length);
                    socket.receive(response1);
                    String tong = new String(response1.getData(), 0, response1.getLength());

                    byte[] buffer2 = new byte[1024];
                    DatagramPacket response2 = new DatagramPacket(buffer2, buffer2.length);
                    socket.receive(response2);
                    String hieu = new String(response2.getData(), 0, response2.getLength());

                    int s1 = Integer.parseInt(tong.trim());
                    int s2 = Integer.parseInt(hieu.trim());
                    System.out.println("Gia tri cua bieu thuc S = 25*(a+b) - 6*(3*c-2*d) la: " + (s1 + s2));
                } catch (NumberFormatException e) {
                    System.out.println("Vui long nhap dung 4 so nguyen.");
                }
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}