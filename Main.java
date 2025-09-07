import java.util.Scanner;

class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;
    
    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
    
    public double tinhChuVi() {
        return (chieuDai + chieuRong) * 2;
    }
    
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }
    
    public void hienThiThongTin() {
        System.out.printf("Chiều dài: %.2f\n", chieuDai);
        System.out.printf("Chiều rộng: %.2f\n", chieuRong);
        System.out.printf("Chu vi: %.2f\n", tinhChuVi());
        System.out.printf("Diện tích: %.2f\n", tinhDienTich());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập chiều dài: ");
        double cd = scanner.nextDouble();
        
        System.out.print("Nhập chiều rộng: ");
        double cr = scanner.nextDouble();
        
        // Tạo đối tượng hình chữ nhật
        HinhChuNhat hcn = new HinhChuNhat(cd, cr);
        
        // Hiển thị kết quả
        System.out.println("\n=== THÔNG TIN HÌNH CHỮ NHẬT ===");
        hcn.hienThiThongTin();
        
        scanner.close();
    }
}