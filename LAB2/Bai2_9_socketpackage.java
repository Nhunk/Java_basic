//Bài 9: Tạo kết nối Socket và package hiện thời

package LAB2;

import java.io.*;
import java.net.*;

public class Bai2_9_socketpackage {
    public String downloadWWWPage(URL pageURL) throws Exception {
        String host, file;
        host = pageURL.getHost();
        file = pageURL.getFile();

        InputStream pageStream = getWWWPageStream(host, file);
        if (pageStream == null) {
            return "";
        }

        DataInputStream in = new DataInputStream(pageStream);
        StringBuffer pageBuffer = new StringBuffer();
        String line;
        while ((line = in.readUTF()) != null) {
            pageBuffer.append(line);
        }
        in.close();
        return pageBuffer.toString();
    }

    public InputStream getWWWPageStream(String host, String file) throws IOException, UnknownHostException{
        InetAddress webServer =InetAddress.getByName(host);
        Socket httpPipe = new Socket(webServer, 80);
        if(httpPipe == null){
            System.out.println("Socket den website tao bi loi!");
            return null;
        }
        InputStream inn = httpPipe.getInputStream();
        OutputStream outt= httpPipe.getOutputStream();
        DataInputStream in = new DataInputStream(inn);
        PrintStream out = new PrintStream(outt);
        if(inn==null||outt==null){
            System.out.println("Loi mo streams den socket!");
            return null;
        }
        out.println("GET "+file+" HTTP/1.0\n");
        String response;
        while((response = in.readUTF()).length()>0){
            System.out.println(response);
        }
        return in;
           }
}
