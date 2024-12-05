/*Client tạo một dãy Fibonacci F(n) với F(1) = a, F(2) = b, 
sau đó gởi F(1), F(2) và  k(k>2) là số phần tử trong dãy cho Server. 
Tiếp đó, Client  gởi một số nguyên p,  yêu cầu Server cho biết p có tồn tại trong dãy không, 
nếu tồn tại thì nó ở số hạng thứ mấy trong dãy.

Yêu cầu: 
Viết chương trình hiển thị kết quả trên màn hình Client theo kỹ thuật TCP trong các trường hợp sau:
1. Các giá trị  a,b, k và p được nhập từ bàn phím trên cùng dòng, mỗi giá trị cách nhau bởi dấu “;”.
2. Quá trình được thực hiện nhiều lần cho đến khi dòng gởi có dạng “stop” thì quá trình trên chấm dứt. 
 */
package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class B14_TCPC_Fibonacci {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2014;

        try (Socket socket = new Socket(hostname, port);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        Scanner scan = new Scanner(System.in)){
            while(true){
                System.out.println("Nhap cac gia tri a, b, k, p (cach nhau boi dau ';', 'stop' de ket thuc): ");
                String text = scan.nextLine();
                output.println(text);

                if(text.equalsIgnoreCase("stop")){
                    break;
                }

                System.out.println(input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
