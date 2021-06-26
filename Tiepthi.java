
public class Tiepthi extends NhanvienTemplate {
    private double doanhSo;
    private double hueHong;

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.println("Nhập doanh số bán hàng : ");
        setDoanhSo();
        System.out.println("Nhập huê hồng :");
        setHueHong();
    }

    @Override
    public void Xuat() {
        System.out.println("\n-----TiepThi-----");
        super.Xuat();
        System.out.printf("Doanh số bán hàng : %.0f \n", getDoanhSo());
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap() + getHueHong();
    }

    // Getter & Setter
    public double getHueHong() {
        return hueHong;
    }

    public void setHueHong() {
        do {
            double initHuehong = Double.parseDouble(sc.nextLine());
            if (initHuehong > 0) {
                this.hueHong = initHuehong;
                break;
            } else {
                System.out.println("Nhập lỗi, mời nhập lại...");
            }
        } while (true);
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo() {
        do {
            double initDoanhso = Double.parseDouble(sc.nextLine());
            if (initDoanhso > 0) {
                this.doanhSo = initDoanhso;
                break;
            } else {
                System.out.println("Nhập lỗi, mời nhập lại...");
            }
        } while (true);

    }
}
