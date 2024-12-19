package Ontap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class R7_TCPS_GiaiPT {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2004);
            System.out.println("Server is listening...");
            try(Socket connect = server.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            PrintWriter output = new PrintWriter(connect.getOutputStream(),true)){
                String text;
                while(true){
                    text = input.readLine();
                    if(text.equalsIgnoreCase("stop")){
                        break;
                    }
                    String[] arr = text.split(";");
                    int a = Integer.parseInt(arr[0]);
                    int b = Integer.parseInt(arr[1]);
                    int c = Integer.parseInt(arr[2]);
                    double delta = b*b - 4*a*c;
                    if(a==0){
                        output.println("Phuong trinh co nghiem kep: x = " + -b/(2*a));
                    }else{
                        if(delta < 0){
                            output.println("Phuong trinh vo nghiem");
                        }else if(delta == 0){
                            output.println("Phuong trinh co nghiem kep: x = " + -b/(2*a));
                        }else{
                            double x1 = (-b + Math.sqrt(delta))/(2*a);
                            double x2 = (-b - Math.sqrt(delta))/(2*a);
                            output.println("Phuong trinh co 2 nghiem: x1 = " + x1 + ", x2 = " + x2);
                        }
                    }
                    
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
