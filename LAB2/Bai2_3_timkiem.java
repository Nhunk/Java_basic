package LAB2;

import java.io.IOException;
import java.net.Socket;

public class Bai2_3_timkiem {
public static void main(String[] args) {
    int start = 0;
    int end = 1024;
    for(int port = start; port<=end;port++){
        try (Socket socket = new Socket("localhost", port)){
            System.out.println("Port"+port+"is open");
        } catch (IOException e) {
        System.out.println(e.getMessage());        }
    }
}
}
