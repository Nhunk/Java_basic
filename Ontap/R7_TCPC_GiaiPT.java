/*Client tạo một dãy số nguyên gồm 3 số a,b,c,  sau đó gởi cho Server, 
yêu cầu Server giải phương trình có dạng: ax2+bx + c = 0. 
Hiển thị nghiệm của phương  trình này trên màn hình Client.
 */
package Ontap;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class R7_TCPC_GiaiPT {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2004;
        try (Socket socket = new Socket(hostname, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner scan = new Scanner(System.in)) {
            String text;
            while (true) {
                System.out.println("Nhap 3 so nguyen a, b, c: ");
                text = scan.nextLine();
                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                String[] arr = text.split(";");
                if (arr.length != 3) {
                    System.out.println("Nhap sai dinh dang, nhap lai");
                    continue;
                }
                out.println(text);
                System.out.println("Ket qua: " + in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
