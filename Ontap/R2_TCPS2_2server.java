package Ontap;

import java.io.*;
import java.net.*;

public class R2_TCPS2_2server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2002) ;
            System.out.println("Server is listening on port 2002");
            while (true) {
                try (Socket connect = server.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                        PrintWriter out = new PrintWriter(connect.getOutputStream(), true)) {
                    String text;
                    while ((text = in.readLine()) != null) {
                        if (text.equalsIgnoreCase("quit")) {
                            break;
                        }
                        String[] input = text.split(";");
                        if (input.length != 4) {
                            System.out.println("Vui long nhap dung 4 gia tri a, b, c, d cach nhau boi dau ';'");
                            continue;
                        }
                        try {
                            int c = Integer.parseInt(input[2].trim());
                            int d = Integer.parseInt(input[3].trim());

                            int hieu = 3 * c - 2 * d;

                            out.println(hieu);

                        } catch (NumberFormatException e) {
                            System.out.println("Vui long nhap dung 4 so nguyen.");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
