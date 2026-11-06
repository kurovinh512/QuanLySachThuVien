
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] maSach = new String[100];
        String[] tenSach = new String[100];
        int[] soLuong = new int[100];
        double[] donGia = new double[100];

        int n = 0;
        int chon;

        do {
            System.out.println("\n========== QUAN LY SACH ==========");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Tinh tong so luong va tong gia tri sach");
            System.out.println("3. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.print("Nhap so luong sach: ");
                    n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.println("\nNhap thong tin sach thu " + (i + 1));

                        System.out.print("Ma sach: ");
                        maSach[i] = sc.nextLine();

                        System.out.print("Ten sach: ");
                        tenSach[i] = sc.nextLine();

                        System.out.print("So luong: ");
                        soLuong[i] = sc.nextInt();

                        System.out.print("Don gia: ");
                        donGia[i] = sc.nextDouble();
                        sc.nextLine();
                    }
                    System.out.println("Nhap sach thanh cong!");
                    break;

                case 2:
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;

                    for (int i = 0; i < n; i++) {
                        tongSoLuong += soLuong[i];
                        tongGiaTri += soLuong[i] * donGia[i];
                    }

                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    System.out.println("Tong gia tri sach: " + tongGiaTri);
                    break;

                case 3:
                    if (n == 0) {
                        System.out.println("Chua co sach trong thu vien!");
                        break;
                    }

                    System.out.print("Nhap ma sach can tim: ");
                    String maCanTim = sc.nextLine();

                    boolean timThay = false;

                    for (int i = 0; i < n; i++) {
                        if (maSach[i].equalsIgnoreCase(maCanTim)) {
                            System.out.println("Tim thay sach!");
                            System.out.println("Ma sach: " + maSach[i]);
                            System.out.println("Ten sach: " + tenSach[i]);
                            System.out.println("So luong: " + soLuong[i]);
                            System.out.println("Don gia: " + donGia[i]);
                            timThay = true;
                            break;
                        }
                    }

                    if (!timThay) {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 0:
                    System.out.println("Da thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }
}
