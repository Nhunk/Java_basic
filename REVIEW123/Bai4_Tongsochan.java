package REVIEW123;

public class Bai4_Tongsochan {
    public static void main(String[] args) {
        int sum = 0;
        int num = 2;
        while (num <= 100) {
            sum += num;
            num += 2;
        }
        System.out.println("Tong cac so chan tu 1 den 100 la: " + sum);
    }
}
