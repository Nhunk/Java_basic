import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
public class SoHoanThien {
    public static boolean isPerfectNumber(int n){
        int sum = 0;
        for(int i = 1; i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        if(n==sum){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(2004);
            System.out.println("Server dang lang nghe port 2004!");
            
                try (Socket connect = server.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                PrintWriter out = new PrintWriter(connect.getOutputStream(),true)){
                    while(true){
                    String text = in.readLine();
                    String[] s = text.split(";");
                    if(text.equalsIgnoreCase("stop")){
                        break;
                    }
                    List<Integer> shh = new ArrayList<>();
                    for(int i = 0; i<s.length;i++){
                        int num = Integer.parseInt(s[i]);
                        if(isPerfectNumber(num)){
                            shh.add(num);
                        }
                    }
                    // String result = shh.isEmpty() ? "Khong co so hoan hao trong day!" : shh;
                    out.println(shh);
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
