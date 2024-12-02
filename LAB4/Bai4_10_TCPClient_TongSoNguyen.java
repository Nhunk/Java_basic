package LAB4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Bai4_10_TCPClient_TongSoNguyen {
    public static void main(String[] args) {
        
    String hostname = "localhost";
        int port = 9875;
        try (Socket socket = new Socket(hostname, port);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Nhap so nguyen n ('stop' de ket thuc): ");
                String text = scanner.nextLine();

                output.println(text);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                System.out.println(input.readLine());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
