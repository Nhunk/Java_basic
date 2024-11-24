package LAB2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Bai2_7_DocGhi_Stream {

    private final static int BUFSIZE = 20;

    public static void main(String args[]) throws Exception {
        String server = args[0];
        int port=Integer.parseInt(args[1]);
        double value = Double.valueOf(args[2]).doubleValue();
        Socket s = new Socket();
        OutputStream os = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeDouble(value);
        
        InputStream is =s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        value = dis.readDouble();
        
        System.out.println(value);
        s.close();
    }
}
