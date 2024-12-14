package Ontap;

import java.io.*;
import java.net.*;

public class R1_TCPS_TongSoNguyen {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2004);
            System.out.println("Server da san sang!");
            try (Socket connet = server.accept();
                    BufferedReader input = new BufferedReader(new InputStreamReader(connet.getInputStream()));
                    PrintWriter output = new PrintWriter(connet.getOutputStream(), true)) {
                while (true) {
                    String text = input.readLine();

                    if (text.equalsIgnoreCase("stop")) {
                        break;
                    }
                    int n = Integer.parseInt(text);
                    int sum = 0;
                    for (int i = 1; i <= n; i++) {
                        sum += i;
                    }
                    output.println("Tong tu 1 den " + n + ": " + sum);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
