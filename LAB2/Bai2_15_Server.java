
package LAB2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Bai2_15_Server {
    Socket socket = null;
    public Bai2_15_Server(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while(true){
                line = in.readLine();
                Calendar cal = new GregorianCalendar();
                if(line.equalsIgnoreCase("quit"))
                    break;
                else{
                    out.println(daochuoi(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        public String daochuoi(String str){
            int j = 0;
            char[] c = str.toCharArray();
            for(int i = str.length();i>=0;i--){
                c[j]=str.charAt(i);
                ++j;
            }
            String str2 =String(c);
            return str2;
        
    }

    private String String(char[] c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
