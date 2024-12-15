package Ontap;

import java.util.Scanner;

public class R7_RMIC_GiaiPT {
    public static void main(String[] args) {
        try {
            R7_RMI_Interface_GiaiPT sv = (R7_RMI_Interface_GiaiPT) java.rmi.Naming
                    .lookup("rmi://localhost:2004/giaiPT");
            Scanner scan = new Scanner(System.in);
            String text;
            while (true) {
                System.out.println("Nhap 3 so nguyen a, b, c: ");
                text = scan.nextLine();
                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                String[] arr = text.split(";");
                if (arr.length != 3) {
                    System.out.println("Nhap sai dinh dang, nhap lai");
                    continue;
                } else {
                    try{
                        int a = Integer.parseInt(arr[0]);
                    int b = Integer.parseInt(arr[1]);
                    int c = Integer.parseInt(arr[2]);
                    System.out.println(sv.giaiPT(a, b, c));
                    }catch(NumberFormatException e){
                        System.out.println("Nhap sai dinh dang, nhap lai");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
