import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // BAI 1: KIEM TRA THONG TIN SACH
        System.out.println("===== BAI 1: KIEM TRA THONG TIN SACH =====");

        System.out.print("Nhap gia sach: ");
        double gia = sc.nextDouble();

        System.out.print("Nhap so luong: ");
        int soLuong = sc.nextInt();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = sc.nextInt();

        int namHienTai = java.time.Year.now().getValue();

        if (gia > 0 && soLuong >= 0
                && namXuatBan > 0 && namXuatBan <= namHienTai) {
            System.out.println("Thong tin sach hop le.");
        } else {
            System.out.println("Thong tin sach khong hop le.");
        }

        // BAI 2: PHAN LOAI GIA SACH
        System.out.println("\n===== BAI 2: PHAN LOAI GIA SACH =====");

        System.out.print("Nhap gia sach: ");
        gia = sc.nextDouble();

        if (gia <= 0) {
            System.out.println("Gia sach khong hop le.");
        } else if (gia < 50000) {
            System.out.println("Sach gia thap.");
        } else if (gia < 100000) {
            System.out.println("Sach gia trung binh.");
        } else if (gia <= 200000) {
            System.out.println("Sach gia cao.");
        } else {
            System.out.println("Sach gia dac biet.");
        }

        // BAI 3: PHAN LOAI TON KHO
        System.out.println("\n===== BAI 3: PHAN LOAI TON KHO =====");

        System.out.print("Nhap so luong sach con lai: ");
        soLuong = sc.nextInt();

        if (soLuong < 0) {
            System.out.println("So luong khong hop le.");
        } else if (soLuong == 0) {
            System.out.println("Het sach.");
        } else if (soLuong <= 5) {
            System.out.println("Sap het sach.");
        } else if (soLuong <= 20) {
            System.out.println("Con it sach.");
        } else {
            System.out.println("Con nhieu sach.");
        }

        // BAI 4: CHON LOAI SACH BANG SWITCH
        System.out.println("\n===== BAI 4: CHON LOAI SACH =====");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");

        System.out.print("Nhap lua chon: ");
        int luaChon = sc.nextInt();

        switch (luaChon) {
            case 1:
                System.out.println("Loai sach: Sach giao khoa");
                break;
            case 2:
                System.out.println("Loai sach: Sach tham khao");
                break;
            case 3:
                System.out.println("Loai sach: Sach chuyen nganh");
                break;
            case 4:
                System.out.println("Loai sach: Sach khac");
                break;
            default:
                System.out.println("Lua chon khong hop le.");
        }

        sc.close();
    }
}