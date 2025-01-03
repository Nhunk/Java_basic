/*Client tạo một dãy gồm 3 số nguyên a,b,và k(k>2) gởi cho Server.
 Sau đó gởi tiếp cho Server một số nguyên p, yêu cầu Server cho biết p có tồn tại trong dãy không, 
 nếu tồn tại thì nó ở số hạng thứ mấy trong dãy.
Biết rằng: 
-	a và b là 2 số hạng đầu của dãy Fibonacci F(n), với F(1) = a, F(2) = b.
-	k là số phần tử trong dãy Fibonacci F(n).
-	Dãy Fibonacci được sinh ra trên Server.
 */
package Ontap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class R4_TCPC_Fibonacci {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2004;

        try (Socket socket = new Socket(hostname, port);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
        Scanner scan = new Scanner(System.in)){
            while(true){
                System.out.println("Nhap cac gia tri a, b, k, p (cach nhau boi dau ';', 'stop' de ket thuc): ");
                String text = scan.nextLine();
                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                String[] in = text.split(";");
                if(in.length !=4){
                    System.out.println("Vui long nhap dung 4 gia tri a, b, k, p cach nhau boi dau ';'");
                    continue;
                }

                output.println(text);
                
                System.out.println(input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
