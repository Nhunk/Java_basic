package Ontap;

import java.util.Scanner;

public class R4_RMIC_Fibonacci {
    public static void main(String[] args) {
        try {
            R4_RMI_Interface sv = (R4_RMI_Interface) java.rmi.Naming.lookup("rmi://localhost:2005/fibonacciService");
            Scanner scan = new Scanner(System.in);
            String text;
            while (true) {
                System.out.println("Nhap so a, b, k, p cach nhau boi dau ';'");
                text = scan.nextLine();
                if (text.equalsIgnoreCase("stop")) {
                    break;
                }
                try {
                    String[] arr = text.split(";");
                    int a = Integer.parseInt(arr[0]);
                    int b = Integer.parseInt(arr[1]);
                    int k = Integer.parseInt(arr[2]);
                    int p = Integer.parseInt(arr[3]);
                    int result = sv.fibonacci(a, b, k, p);
                    if (result != -1) {
                        System.out.println("So " + p + " xuat hien trong day Fibonacci va o vi tri thu " + result);
                    } else {
                        System.out.println("So " + p + " khong xuat hien trong day Fibonacci");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
