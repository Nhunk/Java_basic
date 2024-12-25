package review_all;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Bai1_TCPClient {

    public static void main(String args[]) {
        String hostname = "localhost";
        int port = 2004;
        try (Socket socket = new Socket(hostname, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner scan = new Scanner(System.in)) {
            String text;
            while (true) {
                System.out.println("Nhap so nguyen n hoac 'stop' de ket thuc: ");
                text = scan.nextLine();
                out.println(text);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }

                String result = in.readLine();
                System.out.println("Ket qua: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
