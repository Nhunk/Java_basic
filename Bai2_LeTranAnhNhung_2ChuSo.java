import java.util.Scanner;

public class Bai2_LeTranAnhNhung_2ChuSo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu cua day: ");
        int n =scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Nhap day co 2 chu so:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            
            if (array[i] < 10 || array[i] > 99) {
                System.out.println("So " + array[i] + " khong phai so co 2 chu so. Vui long nhap lai.");
                i--; 
            }
        }
        
        System.out.println("Cac so có hang chuc va hang don vi giong nhau la:");
        for (int num : array) {
            int tens = num / 10;  
            int units = num % 10; 
            if (tens == units) {
                System.out.println(num);
            }
        }
        
        scanner.close();
    }
}
