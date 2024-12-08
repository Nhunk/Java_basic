package TCP;

import java.io.*;
import java.net.*;

public class R2_TCPS1_2server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2001);
            System.out.println("Server is listening on port 2001");
            while(true){
                try (Socket connect = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                PrintWriter out = new PrintWriter(connect.getOutputStream(),true)){
                    String text;
                    while((text = in.readLine())!=null){
                        if(text.equalsIgnoreCase("quit")){
                            break;
                        }
                        String[] input = text.split(";");
                        if(input.length != 4){
                            System.out.println("Vui long nhap dung 4 gia tri a, b, c, d cach nhau boi dau ';'");
                            continue;
                        }
                        try {   
                            int a = Integer.parseInt(input[0].trim());
                            int b = Integer.parseInt(input[1].trim());
                           
                            int tong = a + b;
                       
                            out.println(tong);
                            
                        } catch (NumberFormatException e) {
                            System.out.println("Vui long nhap dung 4 so nguyen.");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
