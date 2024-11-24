package REVIEW123;

import java.util.Scanner;

interface Expression {
    double tinhToanBieuThuc(int a, int b, int c, int d);
}

abstract class AbstractCalculator {
    public abstract int tinhTong(int a, int b);
    public abstract int tinhHieu(int c, int d);
}

class Calculator extends AbstractCalculator implements Expression {
    @Override
    public int tinhTong(int a, int b) {
        return a + b;
    }

    @Override
    public int tinhHieu(int c, int d) {
        return 3 * c - 2 * d;
    }

    @Override
    public double tinhToanBieuThuc(int a, int b, int c, int d) {
        return 25 * tinhTong(a, b) - 6 * tinhHieu(c, d);
    }
}

public class Bai3_abstract_interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        try {
            System.out.print("Nhap gia tri a: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap gia tri b: ");
            int b = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap gia tri c: ");
            int c = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap gia tri d: ");
            int d = Integer.parseInt(scanner.nextLine());
            System.out.println("Gia tri bieu thuc S la: " + calculator.tinhToanBieuThuc(a, b, c, d));
        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long nhap so nguyen hop le.");
        } finally {
            scanner.close();
        }
    }
}
