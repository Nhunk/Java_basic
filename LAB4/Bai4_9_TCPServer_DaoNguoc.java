package LAB4;

// Client nhập vào một chuỗi từ bàn phím, sau đó gởi cho Server, yêu cầu Server đảo ngược chuỗi đó. Viết chương trình hiển thị chuổi đảo ngược trên màn hình Client theo giao thức TCP.

import java.io.*;
import java.net.*;

public class Bai4_9_TCPServer_DaoNguoc {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(9875);
            System.out.println("Server is listening on port 9875");

            while (true) {
                try (Socket connectionSocket = serverSocket.accept()) {
                    BufferedReader input = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    PrintWriter output = new PrintWriter(connectionSocket.getOutputStream(), true);

                    String sentence;
                    while ((sentence = input.readLine()) != null) {
                        if (sentence.equalsIgnoreCase("stop")) {
                            break;
                        }
                        String reversed = new StringBuilder(sentence).reverse().toString();
                        output.println("Chuoi dao nguoc: " + reversed);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
