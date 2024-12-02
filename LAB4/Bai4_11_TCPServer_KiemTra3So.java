package LAB4;
//Client nhập vào một dãy số nguyên gồm n số (n>=3), cách nhau bởi dấu “;”từ bàn phím, sau đó gởi cho Server, yêu cầu Server tính tổng dãy số đó. Sau đó Server gởi kết quả cho Client. Xuất kết quả trên màn hình Client. 

import java.io.*;
import java.net.*;

public class Bai4_11_TCPServer_KiemTra3So {
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
                            int a = Integer.parseInt(parts[0].trim());
                            int b = Integer.parseInt(parts[1].trim());
                            int c = Integer.parseInt(parts[2].trim());
                            int sum = a + b + c;
                            output.println("Tong 3 so la: " + sum);
                           
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
