package LAB2;

import java.net.InetAddress;
import java.net.Socket;

public class Bai2_1_creSocket {
public static void main(String[] args) throws Exception {
    InetAddress addr = InetAddress.getByName("www.https://mydtu.duytan.edu.vn");
    int port = 80;
    Socket socket = new Socket(addr,port);
}
}
