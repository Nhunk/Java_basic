
import java.net.Socket;
import java.io.*;
import java.util.Scanner;

public class Client_SoHoanThien {

    public static void main(String args[]) {
        String hostname = "localhost";
        int port = 2004;
        try (Socket socket = new Socket(hostname, port); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter out = new PrintWriter(socket.getOutputStream(), true); Scanner scan = new Scanner(System.in)) {
            String text;
            while (true) {
                System.out.println("Nhap day so ngan cach boi ';' hoac 'stop' de dung: ");
                text = scan.nextLine();
                out.println(text);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                System.out.println("Ket qua: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
