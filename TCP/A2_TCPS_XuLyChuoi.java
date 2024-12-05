package TCP;

import java.io.*;
import java.net.*;

public class A2_TCPS_XuLyChuoi {
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
                        // a. Đếm số ký tự 'a' trong chuỗi
                        long countA = sentence.chars().filter(ch -> ch == 'a' || ch == 'A').count();

                        // b. Kiểm tra chuỗi có chứa "java" hay không
                        boolean containsJava = sentence.toLowerCase().contains("java");

                        // c. Đảo ngược chuỗi
                        String reversed = new StringBuilder(sentence).reverse().toString();

                        output.println("So ky tu 'a' hoac 'A': " + countA);
                        output.println("Co chua tu 'java': " + (containsJava ? "Co" : "Khong"));
                        output.println("Chuoi dao nguoc: " + reversed);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
