
package LAB2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Bai2_6_Doc_Socket {

    public static void main(String args[]) throws IOException {
        int port = 2000;
        ServerSocket srv = new ServerSocket(port);
         //Chờ đợi để kết nối từ Client
        Socket socket = srv.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str;
        while((str=br.readLine()) !=null){
            System.out.println(str);
        }
        br.close();
    }
}
