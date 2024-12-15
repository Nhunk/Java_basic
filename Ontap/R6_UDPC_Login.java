package Ontap;

import java.net.*;
import java.util.Scanner;


public class R6_UDPC_Login {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        Scanner scan = new Scanner(System.in);
        String text;
        while(true){
            System.out.println("Nhap User va Password ngan cach boi ';': ");
            text = scan.nextLine();
            byte[] sendData = text.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 2004);
            socket.send(sendPacket);
            if(text.equalsIgnoreCase("exit")){
                break;
            }
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String result = new String(receivePacket.getData());
            if(result.equalsIgnoreCase("true")){
                System.out.println("Ban da truy cap thanh cong");
                break;
            }else{
                System.out.println("User hoac Password cua ban khong dung, yeu cau nhap lai");
            }
        }
        
    }
}
