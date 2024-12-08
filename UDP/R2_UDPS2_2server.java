package UDP;

import java.io.IOException;
import java.net.*;

public class R2_UDPS2_2server {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress add = InetAddress.getByName("localhost");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
