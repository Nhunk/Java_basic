package LAB1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Bai10 {
public static void main(String[] args) {
    String f = "F:\\study\\HK1_3_2425\\CS420_Hephantan\\java_code\\LAB1\\example.txt";
    try(DataOutputStream dout = new DataOutputStream(new FileOutputStream(f))) {
        double[] num = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6};
        for(double i : num){
            dout.writeDouble(i);
        }
        System.out.println("Da ghi 6 ki tu!");
        
    } catch (IOException e) {
        System.out.println("Loi ghi: "+e.getMessage());
    }
    try(RandomAccessFile randomf = new RandomAccessFile(f, "r")){
        int [] index = {2,4,3,5,1,0};
        System.out.println("Doc ngau nhien: ");
        for (int i : index){
            randomf.seek(i*8);
            double value = randomf.readDouble();
            System.out.println("Double o vi tri "+i+": "+value);
        }
    }catch(IOException e){
        System.out.println("Loi doc file: "+e.getMessage());
    }
}
}
