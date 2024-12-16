package Ontap;

import java.net.*;
import java.util.Scanner;

public class R3_UDPC_Chat {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);
            String text;
            while (true) {
                System.out.print("You: ");
                text = scan.nextLine();
                byte[] send = text.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(send, send.length, add, 12345);
                socket.send(sendPacket);
                if (text.equalsIgnoreCase("bye")) {
                    System.out.println("Ending chat.");
                    break;
                }
                byte[] receive = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
                socket.receive(receivePacket);
                String serverMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + serverMessage);
                if (serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Server disconnected.");
                    break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}
