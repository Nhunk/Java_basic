package TCP;

import java.io.*;
import java.net.*;

public class B13_TCPS1 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2013);
            System.out.println("Server is listening on port 2013");

            while (true) {
                try (Socket connect = server.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                PrintWriter output = new PrintWriter(connect.getOutputStream(),true)){
                    String text;

                    while((text=input.readLine())!=null){
                        if(text.equalsIgnoreCase("stop")){
                            break;
                        }

                        String[] in = text.split(";");
                        if(in.length !=4){
                            System.out.println("Vui long nhap dung 4 gia tri a, b, c, d cach nhau boi dau ';'");
                            continue;
                        }

                        try {
                            int a = Integer.parseInt(in[0].trim());
                            int b = Integer.parseInt(in[1].trim());
                            int c = Integer.parseInt(in[2].trim());
                            int d = Integer.parseInt(in[3].trim());

                            int tong = 3*a + 2*b;

                            output.println(tong);
                        } catch (NumberFormatException e) {
                            System.out.println("Vui long nhap dung 4 so nguyen.");
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
