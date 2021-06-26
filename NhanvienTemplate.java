import java.util.*;

abstract class NhanvienTemplate {
    Scanner sc = new Scanner(System.in);
    private String maso;
    private String hoten;
    private double luong;

    public void Nhap() {
        System.out.println("\nNhập họ tên :");
        setHoten();
        System.out.println("Nhập mã số  :");
        setMaso();
        System.out.println("Nhập lương  :");
        setLuong();
    }

    public void Xuat() {
        System.out.println("\nHọ tên   : " + getHoten());
        System.out.println("Mã số    : " + getMaso());
        System.out.printf("Lương    : %.0f VND\n", getLuong());
        System.out.printf("Thu nhập : %.0f VND\n", getThuNhap());
    }

    public double getThuNhap() {
        return getLuong() - getThueThuNhap(getLuong());
    }

    public double getThueThuNhap(double initLuong) {
        double base = 9000000;
        double thue = 0;
        if (initLuong > 15000000) {
            thue = (initLuong - base) * 0.12;
        } else if (initLuong > 9000000) {
            thue = (initLuong - base) * 0.1;
        } else {
            thue = 0;
        }
        return thue;
    }

    // Getter & Setter
    public double getLuong() {
        return luong;
    }

    public void setLuong() {
        do {
            double initLuong = Double.parseDouble(sc.nextLine());
            if (initLuong > 0) {
                this.luong = initLuong;
                break;
            } else {
                System.out.println("Nhập lỗi, mời nhập lại...");
            }
        } while (true);
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten() {
        String initHoten = String.valueOf(sc.nextLine());
        this.hoten = initHoten;
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso() {
        String initMaso = String.valueOf(sc.nextLine());
        this.maso = String.valueOf(initMaso);
    }
}
