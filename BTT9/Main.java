
import java.util.ArrayList;
import java.util.Scanner;

// LOP CHA
abstract class Sach {
    protected String maSach;
    protected String ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public void nhap(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();

        System.out.print("Nhap ngay nhap (dd/MM/yyyy): ");
        ngayNhap = sc.nextLine();

        System.out.print("Nhap don gia: ");
        donGia = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap nha xuat ban: ");
        nhaXuatBan = sc.nextLine();
    }

    public abstract double tinhThanhTien();

    public void xuat() {
        System.out.printf("%-12s %-15s %-12.2f %-10d %-20s",
                maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
    }
}

// LOP SACH GIAO KHOA
class SachGiaoKhoa extends Sach {
    private String tinhTrang;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        System.out.print("Nhap tinh trang (moi/cu): ");
        tinhTrang = sc.nextLine();
    }

    @Override
    public double tinhThanhTien() {
        if (tinhTrang.equalsIgnoreCase("moi")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 0.5;
        }
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-12s %-15.2f%n",
                tinhTrang, tinhThanhTien());
    }
}

// LOP SACH THAM KHAO
class SachThamKhao extends Sach {
    private double thue;

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        System.out.print("Nhap thue: ");
        thue = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double tinhThanhTien() {
        return soLuong * donGia + thue;
    }

    public double getDonGia() {
        return donGia;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf("%-12.2f %-15.2f%n",
                thue, tinhThanhTien());
    }
}

// LOP CHUONG TRINH CHINH
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Sach> danhSach = new ArrayList<>();

        int n;

        System.out.print("Nhap so luong sach: ");
        n = Integer.parseInt(sc.nextLine());

        // NHAP DANH SACH SACH
        for (int i = 0; i < n; i++) {
            System.out.println("\n1. Sach giao khoa");
            System.out.println("2. Sach tham khao");
            System.out.print("Chon loai sach: ");

            int loai = Integer.parseInt(sc.nextLine());

            Sach sach;

            if (loai == 1) {
                sach = new SachGiaoKhoa();
            } else if (loai == 2) {
                sach = new SachThamKhao();
            } else {
                System.out.println("Loai sach khong hop le!");
                i--;
                continue;
            }

            System.out.println("--- Nhap thong tin sach ---");
            sach.nhap(sc);

            danhSach.add(sach);
        }

        // XUAT DANH SACH SACH
        System.out.println("\n========== DANH SACH SACH ==========");

        System.out.println("\n--- SACH GIAO KHOA ---");
        System.out.printf("%-12s %-15s %-12s %-10s %-20s %-12s %-15s%n",
                "Ma sach", "Ngay nhap", "Don gia",
                "So luong", "Nha xuat ban", "Tinh trang", "Thanh tien");

        for (Sach sach : danhSach) {
            if (sach instanceof SachGiaoKhoa) {
                sach.xuat();
            }
        }

        System.out.println("\n--- SACH THAM KHAO ---");
        System.out.printf("%-12s %-15s %-12s %-10s %-20s %-12s %-15s%n",
                "Ma sach", "Ngay nhap", "Don gia",
                "So luong", "Nha xuat ban", "Thue", "Thanh tien");

        for (Sach sach : danhSach) {
            if (sach instanceof SachThamKhao) {
                sach.xuat();
            }
        }

        // TINH TONG THANH TIEN TUNG LOAI
        double tongSGK = 0;
        double tongSTK = 0;

        for (Sach sach : danhSach) {
            if (sach instanceof SachGiaoKhoa) {
                tongSGK += sach.tinhThanhTien();
            } else if (sach instanceof SachThamKhao) {
                tongSTK += sach.tinhThanhTien();
            }
        }

        System.out.printf("%nTong tien sach giao khoa: %.2f%n", tongSGK);
        System.out.printf("Tong tien sach tham khao: %.2f%n", tongSTK);

        // TINH TRUNG BINH DON GIA SACH THAM KHAO
        double tongDonGia = 0;
        int dem = 0;

        for (Sach sach : danhSach) {
            if (sach instanceof SachThamKhao) {
                SachThamKhao stk = (SachThamKhao) sach;
                tongDonGia += stk.getDonGia();
                dem++;
            }
        }

        if (dem > 0) {
            System.out.printf("Trung binh don gia sach tham khao: %.2f%n",
                    tongDonGia / dem);
        } else {
            System.out.println("Khong co sach tham khao!");
        }

        // XUAT SACH GIAO KHOA CUA NHA XUAT BAN X
        System.out.println("\n--- SACH GIAO KHOA CUA NHA XUAT BAN X ---");

        boolean timThay = false;

        for (Sach sach : danhSach) {
            if (sach instanceof SachGiaoKhoa
                    && sach.nhaXuatBan.equalsIgnoreCase("X")) {
                sach.xuat();
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach giao khoa cua nha xuat ban X!");
        }

        sc.close();
    }
}
