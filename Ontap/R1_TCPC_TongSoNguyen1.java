package Ontap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class R1_TCPC_TongSoNguyen1 {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2004;
        try (Socket socket = new Socket(hostname, port);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scan = new Scanner(System.in)){

            while (true) {

                System.out.println("Nhap so nguyen n: ");
                String text = scan.nextLine();

                try {
                    String[] s = text.split(";");
                    if (s.length == 1 && Integer.parseInt(text) >= 50 && Integer.parseInt(text) <= 100) {
                        output.println(text);
                        if (text.equalsIgnoreCase("stop")) {
                            break;
                        }
                        System.out.println(input.readLine());
                    } else {
                        System.out.println("Vui long nhap so nguyen");
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
