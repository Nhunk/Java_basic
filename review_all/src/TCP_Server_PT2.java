
import java.io.*;
import java.net.*;

public class TCP_Server_PT2 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2004);
            System.out.println("Server dang lang nghe port 2004");
            
                try (Socket connect = server.accept(); BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream())); PrintWriter out = new PrintWriter(connect.getOutputStream(), true)) {
                    String data;
while (true) {
                    data = in.readLine();
                    if(data.equalsIgnoreCase("stop")){
                        break;
                    }
                    String[] s = data.split(";");
                    int a = Integer.parseInt(s[0]);
                    int b = Integer.parseInt(s[1]);
                    int c = Integer.parseInt(s[2]);
                    String result;
                    if (a == 0) {
                        result = "Phuong trinh co nghiem x ="+(-b/c);
                    }else{
                        double delta = b*b-4*a*c;
                        if(delta >0){
                            double x1= (-b+ Math.sqrt(delta))/2*a;
                            double x2= (-b- Math.sqrt(delta))/2*a;
                            result = "Phuong trinh co 2 nghiem x1="+x1+" ; x2="+x2;
                        }else if(delta ==0){
                            result = "Phuong trinh co nghiem kep x = "+(-b/(2*a));
                        }else{
                            result = "Phuong trinh vo nghiem!";
                        }
                    }
                    out.println(result);
                    
                }

            }catch(IOException e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
