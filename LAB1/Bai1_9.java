package LAB1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bai1_9 {
public static void main(String[] args) {
    String f = "F:\\study\\HK1_3_2425\\CS420_Hephantan\\java_code\\LAB1\\test.txt";
    try (DataOutputStream dout = new DataOutputStream(new FileOutputStream(f))){
        dout.writeInt(24);
        dout.writeFloat(0.2f);
        dout.writeBoolean(false);
        dout.writeUTF("Day la Nhunk!");//Chuỗi
        System.out.println("Ghi thanh cong!");
    } catch (IOException e) {
    System.out.println("Loi ghi: "+e.getMessage());
    }
    try (DataInputStream din = new DataInputStream(new FileInputStream(f))){
        int iv = din.readInt();
        float fv = din.readFloat();
        boolean bv = din.readBoolean();
        String sv = din.readUTF();
        System.out.println("Doc du lieu tu file: ");
        System.out.println("Integer: "+iv);
        System.out.println("Float: "+fv);
        System.out.println("Boolean: "+bv);
        System.out.println("String: "+sv);
    } catch (IOException e) {
        System.out.println("Loi doc: "+e.getMessage());
    }
}
}
