package TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class R3_TCPC_SoHoanHao {
    public static void main(String[] args){
        String hostname = "localhost";
        int port = 9876;
        try{ 
            Socket socket = new Socket(hostname, port);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            Scanner scan = new Scanner(System.in);
            
            while(true){
                System.out.println("Nhap so cach nhau bang ';' hoac 'stop' de ket thuc: ");
                String text = scan.nextLine();
                output.println(text);

                if(text.equalsIgnoreCase("stop")){
                    break;
                }

                String response = input.readLine().isEmpty() ? "Khong co so hoan hao" : input.readLine();
                System.out.println("Ket qua: "+response);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
