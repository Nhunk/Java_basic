package connect_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Bai1_TCPClient_Boi {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 9876;
        try (Socket socket = new Socket(hostname, port);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Nhap day cac so nguyen (cach nhau boi dau ';' hoac 'stop' de ket thuc): ");
                String text = scanner.nextLine();
                output.println(text);
                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                System.out.println("_________________________");
                System.out.println("Ket qua: ");
                System.out.println(input.readLine());
                System.out.println(input.readLine());   
                System.out.println(input.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}