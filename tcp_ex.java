import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp_ex {
    public static void main(String[] args) {
        try {
            ServerSocket sv = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");
            while(true){
                try (Socket connect = sv.accept();
                BufferedReader in=new BufferedReader(new InputStreamReader(connect.getInputStream()));
                PrintWriter out = new PrintWriter(connect.getOutputStream(),true)){
                    System.out.println("Nhap vao day so('stop' de ket thuc): ");
                    
                    String input;
                    while((input=in.readLine())!=null){
                        // if(input.equalIgnoreCase('stop')){
                        //     break;
                        // }
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
