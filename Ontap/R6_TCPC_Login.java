/*Để truy cập vào hệ thống, Client phải nhập User và Password của mình và gởi cho Server xác thực.  
Quá trình xác thực trên Server diễn ra như sau :
-	Nếu Client nhập User (hoặc Password) không đúng, 
Server trả về cho Client thông báo “ User (hoặc Password) của bạn không đúng, yêu cầu nhập lại”.  
-	Nếu sau 3 lần đăng nhập liên tiếp vẫn không đúng, 
Server trả về cho Client thông báo “ Bạn đã nhập sai 3 lần, bạn đã hết quyền truy cập vào hệ thống. “ 
Hệ thống đóng kết nối.
-	Nếu Client nhập User và Password đúng, 
Server trả về cho Client thông báo “Bạn đã truy cập thành công “.
Biết rằng, User và Password ở Server được mặc định là : 
User =”CS420”, Password =”123”
 */
package Ontap;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class R6_TCPC_Login {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2004;
        try (Socket socket = new Socket(hostname, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner scan = new Scanner(System.in)) {
            String text;
            while (true) {
                System.out.println("Nhap User va Password ngan cach boi ';': ");
                text = scan.nextLine();
                out.println(text);

                if(text.equalsIgnoreCase("exit")){
                    break;
                }
                
                String result = in.readLine();
                if(result.equalsIgnoreCase("success")){
                    System.out.println("Ban da truy cap thanh cong");
                    break;
                }else if(result.equalsIgnoreCase("Disconnect")){
                    System.out.println("Ban da nhap sai 3 lan, ban da het quyen truy cap vao he thong");
                    break;
                }else{
                    System.out.println(result);
                }
            }
            }catch (IOException e) {
                e.printStackTrace();
    
            }

        } 
    }

