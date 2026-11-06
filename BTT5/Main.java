
import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    String maSach;
    String tenSach;
    int soLuong;
    double donGia;

    Sach(String maSach, String tenSach, int soLuong, double donGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> danhSachMaSach = new ArrayList<>();
        ArrayList<Sach> danhSachSach = new ArrayList<>();

        int chon;

        do {
            System.out.println("\n========== QUAN LY SACH ==========");
            System.out.println("1. Nhap mang so luong 5 cuon sach");
            System.out.println("2. Them sach");
            System.out.println("3. Hien thi danh sach sach");
            System.out.println("4. Tim sach theo ma");
            System.out.println("5. Xoa sach");
            System.out.println("6. Sua sach");
            System.out.println("7. Tinh tong so luong sach");
            System.out.println("8. Tinh tong gia tri sach");
            System.out.println("9. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    int[] soLuongSach = new int[5];
                    int tong = 0;
                    int lonNhat = 0;

                    for (int i = 0; i < 5; i++) {
                        System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
                        soLuongSach[i] = sc.nextInt();

                        tong += soLuongSach[i];

                        if (soLuongSach[i] > lonNhat) {
                            lonNhat = soLuongSach[i];
                        }
                    }

                    System.out.println("So luong sach trong mang: " + soLuongSach.length);
                    System.out.println("Tong so luong: " + tong);
                    System.out.println("So luong lon nhat: " + lonNhat);
                    sc.nextLine();
                    break;

                case 2:
                    System.out.print("Nhap ma sach: ");
                    String ma = sc.nextLine();

                    if (danhSachMaSach.contains(ma)) {
                        System.out.println("Ma sach da ton tai!");
                        break;
                    }

                    System.out.print("Nhap ten sach: ");
                    String ten = sc.nextLine();

                    System.out.print("Nhap so luong: ");
                    int sl = sc.nextInt();

                    System.out.print("Nhap don gia: ");
                    double gia = sc.nextDouble();
                    sc.nextLine();

                    Sach s = new Sach(ma, ten, sl, gia);

                    danhSachMaSach.add(ma);
                    danhSachSach.add(s);

                    System.out.println("Them sach thanh cong!");
                    break;

                case 3:
                    if (danhSachSach.size() == 0) {
                        System.out.println("Danh sach sach rong!");
                    } else {
                        System.out.println("\nDANH SACH SACH");

                        for (int i = 0; i < danhSachSach.size(); i++) {
                            Sach sach = danhSachSach.get(i);

                            System.out.println("Ma sach: " + sach.maSach);
                            System.out.println("Ten sach: " + sach.tenSach);
                            System.out.println("So luong: " + sach.soLuong);
                            System.out.println("Don gia: " + sach.donGia);
                            System.out.println("----------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma sach can tim: ");
                    String maTim = sc.nextLine();

                    int viTri = danhSachMaSach.indexOf(maTim);

                    if (viTri != -1) {
                        Sach sach = danhSachSach.get(viTri);

                        System.out.println("Tim thay sach!");
                        System.out.println("Ma sach: " + sach.maSach);
                        System.out.println("Ten sach: " + sach.tenSach);
                        System.out.println("So luong: " + sach.soLuong);
                        System.out.println("Don gia: " + sach.donGia);
                    } else {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 5:
                    System.out.print("Nhap ma sach can xoa: ");
                    String maXoa = sc.nextLine();

                    int vtXoa = danhSachMaSach.indexOf(maXoa);

                    if (vtXoa != -1) {
                        danhSachMaSach.remove(vtXoa);
                        danhSachSach.remove(vtXoa);
                        System.out.println("Xoa sach thanh cong!");
                    } else {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 6:
                    System.out.print("Nhap ma sach can sua: ");
                    String maSua = sc.nextLine();

                    int vtSua = danhSachMaSach.indexOf(maSua);

                    if (vtSua != -1) {
                        Sach sach = danhSachSach.get(vtSua);

                        System.out.print("Nhap ten sach moi: ");
                        sach.tenSach = sc.nextLine();

                        System.out.print("Nhap so luong moi: ");
                        sach.soLuong = sc.nextInt();

                        System.out.print("Nhap don gia moi: ");
                        sach.donGia = sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Sua sach thanh cong!");
                    } else {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 7:
                    int tongSoLuong = 0;

                    for (int i = 0; i < danhSachSach.size(); i++) {
                        tongSoLuong += danhSachSach.get(i).soLuong;
                    }

                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    break;

                case 8:
                    double tongGiaTri = 0;

                    for (int i = 0; i < danhSachSach.size(); i++) {
                        Sach sach = danhSachSach.get(i);
                        tongGiaTri += sach.soLuong * sach.donGia;
                    }

                    System.out.println("Tong gia tri sach: " + tongGiaTri);
                    break;

                case 9:
                    System.out.println("Da thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 9);

        sc.close();
    }
}
