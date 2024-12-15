package Ontap;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.xml.crypto.Data;

public class R6_UDPS_Login {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(2004);
            System.out.println("Server is listening...");
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String text = new String(receivePacket.getData());
            String[] arr = text.split(";");
            String result = "";
            if (arr[0].equalsIgnoreCase("admin") && arr[1].equalsIgnoreCase("admin")) {
                result = "true";
            } else {
                result = "false";
            }
            byte[] sendData = result.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
                    receivePacket.getPort());
            socket.send(sendPacket);

            
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}
