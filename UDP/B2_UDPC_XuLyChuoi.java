package UDP;
import java.net.*;
import java.util.Scanner;
public class B2_UDPC_XuLyChuoi {
     public static void main(String[] args) {
        try {
          DatagramSocket socket = new DatagramSocket();
          InetAddress addr = InetAddress.getByName("localhost");
          Scanner scan = new Scanner(System.in);
          byte[] buffer = new byte[1024];
          
          while(true){
            System.out.println("______________________________________");
            System.out.println("Nhap day ky tu hoac 'stop' de dung: ");
            String text = scan.nextLine();
            
            byte[] data=text.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length,addr,2004);
            socket.send(packet);
            
            if(text.equalsIgnoreCase("stop")){
              break;
            }
            
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            String reponse = new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println("______________________________________");
            System.out.println("Ket qua: \n"+reponse);
          }
          socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}
