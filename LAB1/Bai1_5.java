package LAB1;

import java.io.File;
import java.io.IOException;


public class Bai1_5 {
public static void main(String[] args) {
   try {
      File f = new File("filename.txt");
      if ((f).createNewFile()) {
        System.out.println("File da tao: " + f.getName());
      } else {
        System.out.println("File da ton tai!.");
      }
    } catch (IOException e) {
      System.out.println("Loi nhap!.");
      e.printStackTrace();
    }
    }
}


