package Ontap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class R5_UDPC_SoHoanThien {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);
            try {
                String text;
                while(true){
                    System.out.println("Nhap day so, ngan cach nhau boi ';' hoac 'stop' de dung: ");
                    text = scan.nextLine();
                    
                    byte[] data = text.getBytes();
                    DatagramPacket packet = new DatagramPacket(data, data.length, add, 2004);
                    socket.send(packet);

                    if(text.equals("stop")){
                        break;
                    }
                    byte[] buffer = new byte[1024];
                    DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                    socket.receive(response);

                    String result = new String(response.getData(), 0, response.getLength());
                    System.out.println("So hoan thien: " + result);


                }
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
