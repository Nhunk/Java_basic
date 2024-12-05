package UDP;
import java.net.*;
public class B10_UDPS_TongSoNguyen {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(12345);
            byte[] buffer = new byte[1024];
            while(true){
                DatagramPacket requestPacket = new DatagramPacket(buffer,buffer.length);
                socket.receive(requestPacket);
                
                String received = new String(requestPacket.getData(),0,requestPacket.getLength());
                
                if(received.equalsIgnoreCase("stop")){
                    break;
                }
                
                int n = Integer.parseInt(received);
                int sum=0;
                for(int i = 1; i<=n;i++){
                    sum+=i;
                }
                String response = String.valueOf(sum);
                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                        requestPacket.getAddress(), requestPacket.getPort());
                socket.send(responsePacket);
            }
            socket.close();
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
