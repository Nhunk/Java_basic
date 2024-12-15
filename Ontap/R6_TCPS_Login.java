package Ontap;

import java.io.*;
import java.net.*;

public class R6_TCPS_Login {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2004);
            System.out.println("Server is listening...");
            try (Socket connect = server.accept();
                    BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                    PrintWriter output = new PrintWriter(connect.getOutputStream(), true)) {
                String text;
                while (true) {
                    text = input.readLine();
                    String[] arr = text.split(";");
                    int count = 0;
                    if (arr[0].equalsIgnoreCase("admin") && arr[1].equalsIgnoreCase("admin")) {
                        output.println("success");
                    } else {
                        count++;
                        if (count == 3) {
                            output.println("disconnect");
                            break;
                        }
                        output.println("User hoac Password cua ban khong dung, yeu cau nhap lai");

                    }

                }
                server.close();
            }
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}
