
import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class TCP_Client_PT2 {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 2004;
        try (Socket socket = new Socket(hostname, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                Scanner scan = new Scanner(System.in)){
            String text;
            while(true){
                System.out.println("Nhap cac so a, b, c ngan cach boi dau ';' hoac 'stop' de dung: ");
                text=scan.nextLine();
                String[] s = text.split(";");
                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                if(s.length!=3){
                    System.out.println("Vui long nhap dung 3 so nguyen!");
                    continue;                    
                }
                out.println(text);
                
                System.out.println(in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
