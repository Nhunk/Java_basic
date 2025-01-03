package TCP;
import java.io.*;
import java.net.*;
public class B14_TCPS_Fibonacci {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2014);
            System.out.println("Server is listening on port 2014");

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
                            System.out.println("Vui long nhap dung 4 gia tri a, b, k, p cach nhau boi dau ';'");
                            continue;
                        }

                        try {
                            int a = Integer.parseInt(in[0].trim());
                            int b = Integer.parseInt(in[1].trim());
                            int k = Integer.parseInt(in[2].trim());
                            int p = Integer.parseInt(in[3].trim());

                            int[] fibo = new int[k];
                            fibo[0] = a;
                            fibo[1] = b;
                            for (int i = 2; i < k; i++) {
                                fibo[i] = fibo[i-1] + fibo[i-2];
                            }

                            int result = -1;
                            for (int i = 0; i < k; i++) {
                                if(fibo[i] == p){
                                    result = i+1;
                                    break;
                                }
                            }

                            if(result != -1){
                                output.println("So " + p + " xuat hien trong day Fibonacci va o vi tri thu " + result);
                            }else{
                                output.println("So " + p + " khong xuat hien trong day Fibonacci");
                            }
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
