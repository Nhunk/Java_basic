package LAB2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Bai2_5_Doc_Server {

    public static void main(String args[]) throws IOException {
        String server = args[0];
        int port = Integer.parseInt(args[1]);
        Socket s = new Socket(server, port);
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println(dis.readInt());
        s.close();
    }
}
