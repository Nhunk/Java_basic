import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap so luong phan tu cua mang: ");
        int n = scanner.nextInt();
        
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[ " + (i + 1) + "]: ");
            array[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        System.out.println("Tổng của các phần tử trong mảng là: " + sum);
        
        scanner.close();
    }
}
