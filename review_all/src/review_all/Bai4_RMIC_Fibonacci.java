package review_all;
import java.util.Scanner;

public class Bai4_RMIC_Fibonacci {
    public static void main(String[] args) {
        try {
            Bai4_RMI_interface service = (Bai4_RMI_interface) java.rmi.Naming.lookup("rmi://localhost/FibonacciService");
            Scanner scan = new Scanner(System.in);
            String text;
            while(true){
                System.out.println("Nhap day so nguyen ngan cach ';' hoac 'stop' de ket thuc: ");
                text = scan.nextLine();
                if(text.equalsIgnoreCase("stop")){
                    break;
                }
                String[] numbers = text.split(";");
                int a = Integer.parseInt(numbers[0].trim());
                int b = Integer.parseInt(numbers[1].trim());
                int k = Integer.parseInt(numbers[2].trim());
                int p = Integer.parseInt(numbers[3].trim());
                int result = service.Fibonacci(a, b, k, p);
                if(result == -1){
                    System.out.println("Khong tim thay so " + p + " trong day Fibonacci(" + a + ", " + b + ", " + k + ")");
                } else {
                    System.out.println("So " + p + " xuat hien tai vi tri " + result + " trong day Fibonacci(" + a + ", " + b + ", " + k + ")");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
