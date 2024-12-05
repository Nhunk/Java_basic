/*Client nhập từ bàn phím 1 số nguyên n. 
Sau đó gởi số nguyên này cho Server, yêu cầu Server tính tổng S:= 1+2+….+ n. 
Viết chương trình hiển thị tổng trên ở màn hình Client bằng giao thức TCP. */

package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class B10_TCPC_TongSoNguyen {
    public static void main(String[] args) {
        
    String hostname = "localhost";
        int port = 9875;
        try (Socket socket = new Socket(hostname, port);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Nhap so nguyen n ('stop' de ket thuc): ");
                String text = scanner.nextLine();

                output.println(text);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                System.out.println(input.readLine());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
