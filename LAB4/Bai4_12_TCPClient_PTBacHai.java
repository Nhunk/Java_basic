package LAB4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Bai4_12_TCPClient_PTBacHai {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 9874;
        try (Socket socket = new Socket(hostname, port);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Nhap 3 so nguyen (cach nhau boi dau ';' , 'stop' de ket thuc): ");
                String text = scanner.nextLine();

                output.println(text);
                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                System.out.println("_________________________");
                System.out.println(input.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
