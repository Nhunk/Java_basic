import java.util.Scanner;

public class Bai1_LeTranAnhNhung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so n: ");
        int N = scanner.nextInt();
        
        if (N > 10 && N % 3 == 0) {
            System.out.println("So " + N + " la so tu nhien lon hon 10 va chia het cho 3. ");
        } else {
            System.out.println("So " + N + " khong thoa man dieu kien.");
        }
        
        scanner.close();
    }
}