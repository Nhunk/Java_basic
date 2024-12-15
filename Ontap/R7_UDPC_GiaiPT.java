package Ontap;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class R7_UDPC_GiaiPT {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);
            String text;
            while(true){
                System.out.println("Nhap 3 so nguyen a, b, c: ");
                text = scan.nextLine();
                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                String[] arr = text.split(";");
                if(arr.length != 3){
                    System.out.println("Vui long nhap ba so nguyen cach nhau boi dau ;");
                    continue;
                }
                // Gửi dữ liệu
                byte[] data = text.getBytes();
               DatagramPacket packet = new DatagramPacket(data, data.length, add, 2004);
                socket.send(packet);


                byte[] buffer = new byte[1024];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
                System.out.println("Ket qua: " + new String(response.getData(), 0, response.getLength()));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
