package java_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer_Songuyento {

    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(9876);
            System.out.println("Server is listening on port 9876");

            while (true) {
                Socket connectionSocket = serverSocket.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                PrintWriter output = new PrintWriter(connectionSocket.getOutputStream(), true);

                String sentence = input.readLine();
                
             
                
                String[] numbers = sentence.split(";");
                StringBuilder result = new StringBuilder();

                int i = 0;
                while (i < numbers.length) {
                    int num = Integer.parseInt(numbers[i].trim());
                    if (isPrime(num)) {
                        result.append(num).append(" ");
                    }
                    i++;
                }
                output.println(result.toString().trim());
                connectionSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
