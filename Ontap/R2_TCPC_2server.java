/*Viết chương trình sau theo kỹ thuật TCP, yêu cầu:
Để thực hiện dãy tính: S = 25*(a + b) - 6*(3c- 2d), Client thực hiện gởi đến:
+ Server 1: các  giá trị a và b, yêu cầu thực hiện tính tổng:  a + b
+ Server 2: các  giá trị c và d,  yêu cầu thực hiện tính hiệu:  3c - 2d
Yêu cầu: 
Hiển thị kết quả của S trên màn hình Client theo kỹ thuật TCP trong các trường hợp sau:
1. Các giá trị  a,b,c,d được nhập từ bàn phím trên cùng  dòng, mỗi giá trị cách nhau bởi dấu “;”
2. Quá trình được thực hiện nhiều lần cho đến khi dòng gởi có dạng “quit” thì quá trình trên chấm dứt. 
 */
package Ontap;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class R2_TCPC_2server {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port1 = 2001;
        int port2 = 2002;
        try (Socket socket1 = new Socket(hostname, port1);
            Socket socket2 = new Socket(hostname, port2);
            BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
            PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);
            PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true);
            Scanner scan = new Scanner(System.in);) {
                while(true){
                    System.out.println("Nhap a, b, c, d cach nhau boi dau ';' hoac 'quit' de thoat: ");
                    String text = scan.nextLine();
                    out1.println(text);
                    out2.println(text);

                    if(text.equalsIgnoreCase("quit")){
                        break;
                    }
                    String response1 = in1.readLine();
                    String response2 = in2.readLine();
                    if(response1 != null && response2 != null){
                        int tong = Integer.parseInt(response1);
                        int hieu = Integer.parseInt(response2);
                        System.out.println("Ket qua: " + (25*tong - 6*hieu));
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
