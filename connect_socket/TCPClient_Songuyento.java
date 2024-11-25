package java_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient_Songuyento {

    public static void main(String args[]) {
        String hostname = "localhost";
        int port = 9876;
        try (Socket socket = new Socket(hostname, port); PrintWriter output = new PrintWriter(socket.getOutputStream(), true); BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())); Scanner scanner = new Scanner(System.in)) {
            String text;

            while (true) {
                System.out.println("Nhap so cach bang ';' hoac 'stop' de ket thuc: ");
                text = scanner.nextLine();

                output.println(text);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }

                String response = input.readLine();
                System.out.println("So nguyen to: " + response);
            }
            socket.close();

        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }

    }
}
