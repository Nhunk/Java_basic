import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeTranAnhNhung_Bai2 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Nhap day so, ngan cach bang dau ';' (go 'stop' de dung): ");
            String input = rd.readLine();

            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Chuong trinh ket thuc.");
                break;
            }
            String[] numbers = input.split(";");
            List<Integer> perfectNumbers = new ArrayList<>();
            for (String numberStr : numbers) {
                try {
                    int number = Integer.parseInt(numberStr.trim());
                    if (isPerfectNumber(number)) {
                        perfectNumbers.add(number);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: " + numberStr + " không phải là số nguyên hợp lệ.");
                }
            }
            if (perfectNumbers.isEmpty()) {
                System.out.println("Khong co so hoan thien nao.");
            } else {
                System.out.println("Cac so hoan thien: " + perfectNumbers);
            }
        }
    }
    public static boolean isPerfectNumber(int n) {
        if (n < 2)
            return false;
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum == n;
    }
}
