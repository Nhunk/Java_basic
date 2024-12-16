package Ontap;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import UDP.server;

public class R6_UDPS_Login {
    public static void main(String[] args) {
        try {
            DatagramSocket server = new DatagramSocket(2004);
            System.out.println("Server is listening...");
            int count = 0;
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                server.receive(receivePacket);

                String text = new String(receivePacket.getData());
                String[] arr = text.split(";");

                String result = "";
                if (arr[0].equalsIgnoreCase("admin") && arr[1].equalsIgnoreCase("admin")) {
                    result = "true";
                    byte[] sendData = result.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                            receivePacket.getAddress(),
                            receivePacket.getPort());
                    server.send(sendPacket);
                    break;
                } else {
                    count++;
                    if (count == 3) {
                        result = "false";
                        byte[] sendData = result.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                                receivePacket.getAddress(),
                                receivePacket.getPort());
                        server.send(sendPacket);
                        break;
                    } else {
                        result = "Ban da nhap sai ,vui long nhap lai";
                        byte[] sendData = result.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
                                receivePacket.getAddress(),
                                receivePacket.getPort());
                        server.send(sendPacket);
                    }
                }
            }
            server.close();

        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}
