
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class UDP_Client_Fibonacci {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            Scanner scan = new Scanner(System.in);
            String text;
            while(true){
                System.out.println("Nhap cac so a, b, k, p ngan cach boi ';' hoac 'stop' de ket thuc: ");
                text=scan.nextLine();
                String[] s = text.split(";");
                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                if(s.length!=4){
                    System.out.println("Vui long nhap dung 4 so nguyen!");
                    continue;
                }
                 byte[] data = text.getBytes();
                 DatagramPacket packet = new DatagramPacket(data,data.length,add,2004);
                 socket.send(packet);
                
                 byte[] redata = new byte[1024];
                 DatagramPacket repacket = new DatagramPacket(redata, redata.length);
                 socket.receive(repacket);
                 
                 String result = new String(repacket.getData(), 0, repacket.getLength());
                 System.out.println(result);
                        
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
