package RMI;

import java.rmi.Naming;
import java.util.Scanner;

public class RMIClient_2ChuSo {
    public static void main(String[] args) {
        try {
            isTwoDigitInterface isTwoDigit = (isTwoDigitInterface) Naming.lookup("rmi://localhost/isTwoDigitService");

            Scanner scan = new Scanner(System.in);
            String input;

            while (true) {
                System.out.println("Nhap day so nguyen ngan cach ';' hoac 'stop' de ket thuc: ");
                input = scan.nextLine();

                if (input.equalsIgnoreCase("stop")) {
                    break;
                }

                for (String number : input.split(";")) {
                    try {
                        int n = Integer.parseInt(number.trim());
                        if (isTwoDigit.isTwoDigitNumber(n)) {
                            System.out.println(n + " la so co 2 chu so.");
                        } else {
                            System.out.println(n + " khong phai la so co 2 chu so.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(number + " khong phai la so hop le.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}