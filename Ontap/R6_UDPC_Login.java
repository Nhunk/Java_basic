package Ontap;

import java.net.*;
import java.util.Scanner;

public class R6_UDPC_Login {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        Scanner scan = new Scanner(System.in);
        String text;
        while (true) {
            System.out.println("Nhap User va Password ngan cach boi ';': ");
            text = scan.nextLine();

            byte[] sendData = text.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 2004);
            socket.send(sendPacket);

            if (text.equalsIgnoreCase("exit")) {
                break;
            }

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());

            if (result.equalsIgnoreCase("true")) {
                System.out.println("Ban da truy cap thanh cong");
                break;
            } else if (result.equalsIgnoreCase("false")) {
                System.out.println("Ban da nhap sai 3 lan, ban da het quyen truy cap vao he thong");
                break;
            } else {
                System.out.println(result);
            }
        }

    }
}
