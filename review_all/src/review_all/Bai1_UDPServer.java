package review_all;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class Bai1_UDPServer {

    public static void main(String args[]) {
        try {
            DatagramSocket server = new DatagramSocket(2004);
            System.out.println("Server is running!");
            while(true){
                byte[] request = new byte[1024];
                DatagramPacket packet = new DatagramPacket(request,request.length);
                server.receive(packet);
                String data = new String(packet.getData(),0,packet.getLength());
                if(data.equalsIgnoreCase("stop")){
                    break;
                }
                int num = Integer.parseInt(data);
                int sum = 0;
                for(int i = 0;i<=num;i++){
                    sum+=i;
                }
                String result = "Tong cac so nguyen tu 1 den "+num+" la: "+sum;
                byte[] redata=result.getBytes();
                DatagramPacket response = new DatagramPacket(redata,redata.length,packet.getAddress(), packet.getPort());
                server.send(response);
            }
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
