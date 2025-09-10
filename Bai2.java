import java.util.*;

class TaiKhoan {
  private String soTaiKhoan;
  private String tenChuTaiKhoan;
  private Double soDu;
  private static double laiSuatNam = 0.05;

  public TaiKhoan(String soTaiKhoan, String tenChuTaiKhoan, double soDu) {
    this.soTaiKhoan = soTaiKhoan;
    this.tenChuTaiKhoan = tenChuTaiKhoan;
    this.soDu = soDu;
  }

  public void napTien(double tien) {
    if (tien > 0) {
      soDu += tien;
      System.out.println("Đã nạp: " + tien + " vào TK " + soTaiKhoan);
    } else {
      System.out.println("Số tiền nạp không hợp lệ!");
    }
  }

  public void rutTien(double tien) {
    if (tien > 0 && tien <= soDu) {
      soDu -= tien;
      System.out.println("Đã rút: " + tien + " từ TK " + soTaiKhoan);
    } else {
      System.out.println("Số tiền rút không hợp lệ hoặc vượt quá số dư!");
    }
  }

  public double tinhLaiThang() {
    return soDu * (laiSuatNam / 12);
  }

  public void hienThiThongTin() {
    System.out.println("Số TK: " + soTaiKhoan);
    System.out.println("Chủ TK: " + tenChuTaiKhoan);
    System.out.println("Số dư: " + soDu);
    System.out.println("Lãi suất năm: " + (laiSuatNam * 100) + "%");
  }

  public static void thayDoiLaiSuat(double laiMoi) {
    if (laiMoi >= 0) {
      laiSuatNam = laiMoi;
      System.out.println("Lãi suất mới là: " + (laiSuatNam * 100) + "%");
    } else {
      System.out.println("Lãi suất không hợp lệ!");
    }
  }

  public double getSoDu() {
    return soDu;
  }

  public String getSoTaiKhoan() {
    return soTaiKhoan;
  }
}

public class Bai2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<TaiKhoan> danhSach = new ArrayList<>();

    danhSach.add(new TaiKhoan("001", "Nguyen Van A", 1000));
    danhSach.add(new TaiKhoan("002", "Tran Thi B", 5000));
    danhSach.add(new TaiKhoan("003", "Le Van C", 3000));

    danhSach.get(0).napTien(500);
    danhSach.get(1).rutTien(1000);

    for (TaiKhoan tk : danhSach) {
      double laiThang = tk.tinhLaiThang();
      tk.napTien(laiThang);
      System.out.println("Đã cộng lãi tháng: " + laiThang + " vào TK " + tk.getSoTaiKhoan());
    }

    System.out.println("\nDanh sách tài khoản sau giao dịch:");
    for (TaiKhoan tk : danhSach) {
      tk.hienThiThongTin();
    }

    TaiKhoan.thayDoiLaiSuat(0.06); // 6%/năm

    System.out.print("\nNhập số tài khoản cần tìm: ");
    String soTKTim = sc.nextLine();
    boolean found = false;
    for (TaiKhoan tk : danhSach) {
      if (tk.getSoTaiKhoan().equals(soTKTim)) {
        System.out.println("Tài khoản tìm thấy:");
        tk.hienThiThongTin();
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("Không tìm thấy tài khoản!");
    }

    Collections.sort(danhSach, new Comparator<TaiKhoan>() {
      @Override
      public int compare(TaiKhoan t1, TaiKhoan t2) {
        return Double.compare(t2.getSoDu(), t1.getSoDu());
      }
    });

    System.out.println("\nDanh sách tài khoản sau khi sắp xếp theo số dư giảm dần:");
    for (TaiKhoan tk : danhSach) {
      tk.hienThiThongTin();
    }

    sc.close();
  }
}
