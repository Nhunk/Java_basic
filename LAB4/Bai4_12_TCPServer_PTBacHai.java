package LAB4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*Client gởi cho Server 3 số nhập từ bàn phím, mỗi số cách nhau bởi dấu “;”, 
yêu cầu Server giải phương trình: ax2+ bx + c = 0. 
Sau đó gởi kết quả về cho Client. 
Viết chương trình hiển thị kết quả trên màn hình Client theo kỹ thuật TCP. */

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
                                double discriminant = b * b - 4 * a * c;
                                if (discriminant > 0) {
                                    double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                                    double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                                    output.println("The roots are: " + root1 + " and " + root2);
                                } else if (discriminant == 0) {
                                    double root = -b / (2 * a);
                                    output.println("The root is: " + root);
                                } else {
                                    output.println("The equation has no real roots.");
                                }
                            }
                        } catch (NumberFormatException e) {
                            output.println("Vui long nhap dung 3 so nguyen.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
}

}
