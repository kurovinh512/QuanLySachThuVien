
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        ArrayList<Sach> danhSachSach = new ArrayList<>();

        Sach sach1 = new Sach("S01", "Lap trinh Java",
                "Nguyen Van A", 2022, 10);

        Sach sach2 = new Sach("S02", "Lap trinh OOP",
                "Tran Van B", 2023, 15);

        Sach sach3 = new Sach("S03", "Co so du lieu",
                "Le Van C", 2021, 20);

        danhSachSach.add(sach1);
        danhSachSach.add(sach2);
        danhSachSach.add(sach3);

        System.out.println("DANH SACH SACH TRONG THU VIEN");

        for (Sach sach : danhSachSach) {
            sach.hienThiThongTin();
        }

        System.out.println("Tong so dau sach: "
                + danhSachSach.size());
    }
}
