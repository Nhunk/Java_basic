package Ontap;

import java.io.*;
import java.net.*;

public class R5_TCPS_SoHoanThien {
    public static boolean isPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum == num) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2004);
            System.out.println("Server dang lang nghe port 2004");
            try (Socket connect = server.accept();
                    BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                    PrintWriter output = new PrintWriter(connect.getOutputStream(), true)) {
                while(true){
                    String text = input.readLine();
                    if (text.equalsIgnoreCase("stop")) {
                    break;
                    }
                    String[] arr = text.split(";");
                    String result = "";
                    for (int i = 0; i < arr.length; i++) {
                        int num = Integer.parseInt(arr[i]);
                        if (isPerfectNumber(num)) {
                        result += num + " vi tri trong day so: " + (i + 1) + "\n";
                        }
                    }
                    if (result.isEmpty()) {
                        result = "Khong co so hoan thien trong day";
                    }
                    output.println(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
