package Ontap;

import java.io.*;
import java.net.*;

public class R1_TCPS_TongSoNguyen1{
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(2004);
            System.out.println("Server dang lang nghe port 2004");
            while(true){
                try (Socket connect = server.accept();
                    BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                    PrintWriter output = new PrintWriter(connect.getOutputStream(),true)){
                    
                    String request=input.readLine();
                    
                    if(request.equalsIgnoreCase("stop")){
                        break;
                    }

                    int n = Integer.parseInt(request);
                    int sum= 0;
                    for(int i = 1; i<=n;i++){
                        sum+=i;
                    }
                    String result = "Tong cac so nguyen tu 1 den "+n+": "+sum;
                    output.println(result);
                                        
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}