
import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        String maSach, tenSach, tacGia;
        int namXuatBan, soLuong;
        double donGia;

        // Bai 1: Nhap va hien thi thong tin sach
        System.out.println("===== QUAN LY SACH =====");

        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();

        System.out.print("Nhap tac gia: ");
        tacGia = sc.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = sc.nextInt();

        System.out.print("Nhap don gia: ");
        donGia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        soLuong = sc.nextInt();

        System.out.println("\n===== THONG TIN SACH =====");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + donGia);
        System.out.println("So luong: " + soLuong);

        // Bai 2: Tinh thanh tien
        double thanhTien = donGia * soLuong;

        // Bai 3: Tinh phi van chuyen
        double phiVanChuyen = thanhTien * 0.05;

        // Bai 4: Tinh tong tien nhap
        double tongTien = thanhTien + phiVanChuyen;

        System.out.println("\n===== KET QUA TINH TOAN =====");
        System.out.printf("Thanh tien: %.2f%n", thanhTien);
        System.out.printf("Phi van chuyen (5%%): %.2f%n", phiVanChuyen);
        System.out.printf("Tong tien nhap: %.2f%n", tongTien);

        sc.close();
    }
}
