
package LAB2;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Bai2_8_iluvu {

    public static void main(String args[]) throws Exception{
        int port=2000;
        ServerSocket srv = new ServerSocket(port);
        Socket socket = srv.accept();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("I love you");
        bw.flush();        
    }
}
