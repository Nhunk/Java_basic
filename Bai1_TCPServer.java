
import java.io.*;
import java.net.*;


public class Bai1_TCPServer {


    public static void main(String args[]) {
        try{
            ServerSocket server = new ServerSocket(2004);
            System.out.println("Server dang lang nghe port 2004!");
            
                try (Socket connect = server.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                        PrintWriter out = new PrintWriter(connect.getOutputStream(),true)){
                            while(true){
                            String data = in.readLine();
                    
                    if(data.equalsIgnoreCase("stop")){
                        break;
                    }
                    
                    int n = Integer.parseInt(data);
                    int sum = 0;
                    if(n<=100&&n>=50){
                        for(int i = 0;i<=n;i++){
                            sum+=i;
                        }
                        String result = "Tong tu 1 den "+n+" la: "+sum;
                        out.println(result);
                    }else{
                    out.println("So khong hop le!");
                    }  
                }                      
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
            server.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
