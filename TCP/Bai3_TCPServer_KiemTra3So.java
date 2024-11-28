package connect_socket;
import java.io.*;
import java.net.*;


public class Bai3_TCPServer_KiemTra3So {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(9874);
            System.out.println("Server is listening on port 9874");    
            while(true){
                try(Socket connectionSocket = serverSocket.accept()){
                    BufferedReader input = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    PrintWriter output = new PrintWriter(connectionSocket.getOutputStream(), true);
                    String sentence;
                    while((sentence = input.readLine()) != null){
                        if(sentence.equalsIgnoreCase("stop")){
                            break;
                        }
                        String[] parts = sentence.split(";");
                        if(parts.length != 3){
                            output.println("Vui long nhap chinh xac 3 so nguyen cach nhau boi dau ';'");
                            continue;
                        }
                        try{
                            int a = Integer.parseInt(parts[0].trim());
                            int b = Integer.parseInt(parts[1].trim());
                            int c = Integer.parseInt(parts[2].trim());
                            if(a + b > c && a + c > b && b + c > a){
                                if(a == b && b == c){
                                    output.println("Day la tam giac deu.");
                                }else if(a == b || b == c || a == c){
                                    output.println("Day la tam giac can.");
                                }else if(a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a){
                                    output.println("Day la tam giac vuong.");
                                }else{
                                    output.println("Day la tam giac thuong.");
                                }
                            }else{
                                output.println("Ba so khong tao thanh tam giac.");
                            }
                        }catch(NumberFormatException e){
                            output.println("Vui long nhap dung 3 so nguyen.");
                        }
                    }
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
