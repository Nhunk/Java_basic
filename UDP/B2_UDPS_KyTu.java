/*a. Đếm số ký tự 'a' trong chuỗi
  b. Kiểm tra chuỗi có chứa "java" hay không
  c. Đảo ngược chuỗi */

package UDP;
import java.io.IOException;
import java.net.*;
public class B2_UDPS_KyTu {
    public static void main(String[] args) {
        try{
            DatagramSocket socket = new DatagramSocket(2004);
            byte[] buffer = new byte[1024];
            while(true){
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(requestPacket);

                String received = new String(requestPacket.getData(),0, requestPacket.getLength());

                if(received.equalsIgnoreCase("stop")){
                    break;
                }
                long countA = received.chars().filter(ch -> ch == 'a' || ch == 'A').count();
                boolean containsJava = received.toLowerCase().contains("java");
                String reversed = new StringBuilder(received).reverse().toString();
                String response = "So ki tu A: " + (countA >0 ? Long.toString(countA) : "No find!") + "\n"+"Chuoi chua ki tu 'java': "+ (containsJava ? "co" : "khong")+"\nChuoi dao nguoc: "+reversed;
                byte[] responseData=response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData,responseData.length,requestPacket.getAddress(),requestPacket.getPort());
                socket.send(responsePacket);

            }
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
