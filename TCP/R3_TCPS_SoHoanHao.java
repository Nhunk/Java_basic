package TCP;

import java.io.*;
import java.net.*;

public class R3_TCPS_SoHoanHao {
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(2004);
            while(true){
                try(Socket connect = server.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                PrintWriter output = new PrintWriter(connect.getOutputStream(),true)){
                    String text;
                    while((text = input.readLine())!=null){
                        if(text.equalsIgnoreCase("stop")){
                            break;
                        }
                        try {
                            int n = Integer.parseInt(text);
                            if(n<1){
                                output.println("So nhap vao phai lon hon 0");
                            }else{
                                int sum = 0;
                                for (int i = 1; i < n; i++) {
                                    if(n%i==0){
                                        sum+=i;
                                    }
                                }
                                if(sum==n){
                                    output.println(n + " la so hoan hao");
                                }else{
                                    output.println(n + " khong phai la so hoan hao");
                                }
                            }
                        } catch (NumberFormatException e) {
                            output.println("Vui long nhap so nguyen.");
                        }
                    }   
                    

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
