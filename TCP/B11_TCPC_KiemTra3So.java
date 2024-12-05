/*Client nhập vào một dãy số nguyên gồm n số (n>=3), 
cách nhau bởi dấu “;”từ bàn phím, sau đó gởi cho Server, 
yêu cầu Server tính tổng dãy số đó. Sau đó Server gởi kết quả cho Client. 
Xuất kết quả trên màn hình Client. */

package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class B11_TCPC_KiemTra3So {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 9874;
        try(Socket socket = new Socket(hostname,port);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        Scanner scanner = new Scanner(System.in)){
            while(true){
                System.out.println("Nhap 3 so nguyen (cach nhau boi dau ';' , 'stop' de ket thuc): ");
                String text = scanner.nextLine();

                output.println(text);
                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                System.out.println("_________________________");
                System.out.println(input.readLine());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
