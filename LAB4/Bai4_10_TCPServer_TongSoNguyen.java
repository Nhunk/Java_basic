package LAB4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Bai4_10_TCPServer_TongSoNguyen {
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
                        int n = Integer.parseInt(sentence);
                        int sum = 0;
                        for(int i = 0; i <=n;i++){
                            sum +=i;
                        }
                        output.println("Tong cac so tu 1 den "+n+" : "+sum);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
