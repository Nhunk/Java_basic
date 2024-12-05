/* Client nhập vào một chuỗi từ bàn phím, sau đó gởi cho Server, 
 yêu cầu Server đảo ngược chuỗi đó. 
 Viết chương trình hiển thị chuổi đảo ngược trên màn hình Client theo giao thức TCP. */
package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class B9_TCPC_DaoNguoc {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 9875;
        try (Socket socket = new Socket(hostname, port);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("Nhap chuoi ('stop' de ket thuc): ");
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
