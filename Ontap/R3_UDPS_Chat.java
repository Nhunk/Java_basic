package Ontap;

import java.net.*;
import java.util.Scanner;

public class R3_UDPS_Chat {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(12345);
            System.out.println("Server is running. Waiting for client...");
            while(true){
                byte[] receive = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
                server.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client: " + clientMessage);
                if (clientMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                Scanner sc = new Scanner(System.in);
                System.out.print("You: ");
                String serverMessage = sc.nextLine();
                byte[] send = serverMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(send, send.length, receivePacket.getAddress(), receivePacket.getPort());
                server.send(sendPacket);
                if (serverMessage.equalsIgnoreCase("bye")) {
                    System.out.println("Ending chat.");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}
