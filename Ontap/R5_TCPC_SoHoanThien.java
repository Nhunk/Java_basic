/*Client tạo một dãy số nguyên, sau đó gởi cho Server, 
yêu cầu Server cho biết những số nào trong dãy là số hoàn thiện, ở số hạng thứ mấy trong dãy. 
Biết rằng số hoàn thiện là số tự nhiên mà tổng tất cả các ước tự nhiên của nó trừ chính nó thì bằng chính nó.
Vi dụ:    6 =1+2+3  6 là số hoàn thiện
Client nhập sãy số: 5,12, 6, v.v…
Kết quả: Số hoàn thiện: 6 vị trí trong dãy số: 3
 */
package Ontap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class R5_TCPC_SoHoanThien {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2004;
        try (Socket socket = new Socket(hostname, port);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                Scanner scan = new Scanner(System.in)) {
            String text;
            while (true) {
                System.out.println("Nhap day so, cach nhau boi dau ';' hoac 'stop' de dung: ");
                text = scan.nextLine();
                output.println(text);

                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                System.out.println("__________________________________________");
                System.out.println("Ket qua: \n" + input.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
