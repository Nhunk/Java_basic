package LAB2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Bai2_15_Client {

    public static void main(String args[]) throws IOException {
        Socket cSk = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            cSk = new Socket("127.0.0.1", 9999); 
            out = new PrintWriter(cSk.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(cSk.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inLine;
        BufferedReader uIn = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            inLine = uIn.readLine();
            if (inLine.equalsIgnoreCase("quit")) {
                break;
            }
            out.println(inLine);
            out.flush();
            System.out.println(in.readLine());// in ra màn hình chuỗi nhận về từ server
        }
    }

}
