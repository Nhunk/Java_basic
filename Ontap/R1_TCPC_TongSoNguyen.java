/*Client nhập từ bàn phím 1 số nguyên n. 
Sau đó gởi số nguyên này cho Server, yêu cầu Server tính tổng S:= 1+2+….+ n. 
Viết chương trình hiển thị tổng trên ở màn hình Client bằng giao thức TCP. */

package Ontap;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class R1_TCPC_TongSoNguyen {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2004;
        try (Socket socket = new Socket(hostname, port);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                Scanner scan = new Scanner(System.in);) {
            String text;
            while (true) {
                System.out.println("Nhap so nguyen n: ");

                while (true) {
                    text = scan.nextLine();
                    String[] s = text.split(";");
                    int n = Integer.parseInt(s[0]);
                    if (s.length == 1 && n >= 50 && n <= 100) {
                        output.println(n);
                        break;
                    } else {
                        System.out.println("Nhap lai so nguyen n thuoc [50;100]: ");
                    }

                }

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }

                System.out.println(input.readLine());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
