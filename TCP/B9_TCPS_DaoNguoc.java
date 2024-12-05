package TCP;

import java.io.*;
import java.net.*;

public class B9_TCPS_DaoNguoc {
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
