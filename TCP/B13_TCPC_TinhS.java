/*Viết chương trình sau theo kỹ thuật TCP, yêu cầu:
Để thực hiện dãy tính: S = 2*(3a+2b) + 4*(7c- 8d), Client thực hiện gởi đến:
+ Server 1: các  giá trị a và b, yêu cầu thực hiện tính tổng:  3a+2b
+ Server 2: các  giá trị c và d,  yêu cầu thực hiện tính hiệu:  7c- 8d
Yêu cầu: 
Hiển thị kết quả của S trên màn hình Client theo kỹ thuật TCP trong các trường hợp sau:
1. Các giá trị  a,b,c,d được nhập từ bàn phím trên cùng  dòng, mỗi giá trị cách nhau bởi dấu “;”
2. Quá trình được thực hiện nhiều lần cho đến khi dòng gởi có dạng “stop”thì quá trình trên chấm dứt. 
 */
package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class B13_TCPC_TinhS {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port1 = 2013;
        int port2 = 2014;
        try (Socket socket1 = new Socket(hostname, port1);
        Socket socket2 = new Socket(hostname, port2);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        BufferedReader input2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
        PrintWriter output = new PrintWriter(socket1.getOutputStream(),true);
        PrintWriter output2 = new PrintWriter(socket2.getOutputStream(),true);
        Scanner scan = new Scanner(System.in)){
            while(true){
                System.out.println("Nhap cac gia tri a, b, c, d (cach nhau boi dau ';', 'stop' de ket thuc): ");
                String text = scan.nextLine();
                output.println(text);
                output2.println(text);

                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                String response1 = input.readLine();
                String response2 = input2.readLine();
                if(response1 !=null && response2 !=null){
                    int tong= Integer.parseInt(response1);
                    int hieu=Integer.parseInt(response2);
                    System.out.println("Ket qua cua S = 2*(3a+2b) + 4*(7c-8d) la: " + (3*tong+4*hieu));
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 }