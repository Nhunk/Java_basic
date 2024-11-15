package LAB2;

import java.net.InetAddress;

public class Bai2_4_ping {
public static void main(String[] args) {
    String ip="www.google.com.vn";
    try {
        InetAddress inet = InetAddress.getByName(ip);
        System.out.println("Hello!");
        if(inet.isReachable(5000)){
            System.out.println("Dang hoat dong.");
        }else{
            System.out.println("Tat ket noi");
        }
    } catch (Exception e) {
        System.out.println("Loi ping : "+e.getMessage());
    }
}
}
