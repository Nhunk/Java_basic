import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeTranAnhNhung_Bai3 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Nhap day so, ngan cach bang dau ';' (go 'Stop' de dung): ");
            String input = rd.readLine();

            if (input.equalsIgnoreCase("Stop")) {
                System.out.println("Chuong trinh ket thuc.");
                break;
            }
            
            String[] numbers = input.split(";");
            List<Integer> primeNumbers = new ArrayList<>();
            for (String numberStr : numbers) {
                try {
                    int number = Integer.parseInt(numberStr.trim());
                    if (isPrime(number)) {
                        primeNumbers.add(number);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: " + numberStr + " không phải là số nguyên hợp lệ.");
                }
            }
            if (primeNumbers.isEmpty()) {
                System.out.println("Khong co so nguyen to nao.");
            } else {
                System.out.println("Cac so nguyen to: " + primeNumbers);
            }
        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}