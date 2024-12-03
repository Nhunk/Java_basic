/*Client gởi cho Server 3 số nhập từ bàn phím, mỗi số cách nhau bởi dấu “;”, 
yêu cầu Server giải phương trình: ax2+ bx + c = 0. 
Sau đó gởi kết quả về cho Client. 
Viết chương trình hiển thị kết quả trên màn hình Client theo kỹ thuật TCP. */

package LAB4;

import java.io.*;
import java.net.*;

public class Bai4_12_TCPServer_PTBacHai {
public static void main(String[] args) {
    try {
            ServerSocket serverSocket = new ServerSocket(9874);
            System.out.println("Server is listening on port 9874");

            while (true) {

                try (Socket connectionSocket = serverSocket.accept()) {
                    BufferedReader input = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    PrintWriter output = new PrintWriter(connectionSocket.getOutputStream(), true);
                    String sentence;
                    while ((sentence = input.readLine()) != null) {
                        if (sentence.equalsIgnoreCase("stop")) {
                            break;
                        }

                        String[] parts = sentence.split(";");
                        if (parts.length != 3) {
                            output.println("Vui long nhap chinh xac 3 so nguyen cach nhau boi dau ';'");
                            continue;
                        }
                        
                        try {
                            double a = Double.parseDouble(parts[0].trim());
                            double b = Double.parseDouble(parts[1].trim());
                            double c = Double.parseDouble(parts[2].trim());

                            if (a == 0) {
                                output.println("Day khong phai phuong trinh bac 2.");
                            } else {
                                double delta = b * b - 4 * a * c;
                                if (delta > 0) {
                                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                                    output.println("Nghiem cua phuong trinh la: x1 = " + x1 + " va x2 = " + x2);
                                } else if (delta == 0) {
                                    double x = -b / (2 * a);
                                    output.println("Phuong trinh co nghiem kep: " + x);
                                } else {
                                    output.println("Phuong trinh vo nghiem.");
                                }
                            }
                        } catch (NumberFormatException e) {
                            output.println("Vui long nhap dung 3 he so cua phuong trinh!");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}

}
