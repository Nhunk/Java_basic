/*Viết chương trình sau theo kỹ thuật TCP, yêu cầu:
Để thực hiện dãy tính: S = 2*(3a+2b) + 4*(7c- 8d), Client thực hiện gởi đến:
+ Server 1: các  giá trị a và b, yêu cầu thực hiện tính tổng:  3a+2b
+ Server 2: các  giá trị c và d,  yêu cầu thực hiện tính hiệu:  7c- 8d
Yêu cầu: 
Hiển thị kết quả của S trên màn hình Client theo kỹ thuật TCP trong các trường hợp sau:
1. Các giá trị  a,b,c,d được nhập từ bàn phím trên cùng  dòng, mỗi giá trị cách nhau bởi dấu “;”
2. Quá trình được thực hiện nhiều lần cho đến khi dòng gởi có dạng “stop”thì quá trình trên chấm dứt. 
 */
package LAB4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Bai4_13_TCPClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2013;
        try (Socket socket = new Socket(hostname, port);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        Scanner scan = new Scanner(System.in)){
            while(true){
                System.out.println("Nhap cac gia tri a, b, c, d (cach nhau boi dau ';', 'stop' de ket thuc): ");
                String text = scan.nextLine();
                output.println(text);

                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                String response = input.readLine();
                if(response !=null){
                    System.out.println(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }