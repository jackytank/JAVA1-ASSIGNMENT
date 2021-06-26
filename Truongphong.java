
public class Truongphong extends NhanvienTemplate {
    private double trachNhiem;

    @Override
    public void Nhap() {
        super.Nhap();
        System.out.println("Nhập vào lương trách nhiệm :");
        setTrachNhiem();
    }

    @Override
    public void Xuat() {
        System.out.println("\n-----TruongPhong-----");
        super.Xuat();
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap() + getTrachNhiem();
    }

    // Getter & Setter
    public double getTrachNhiem() {
        return trachNhiem;
    }

    public void setTrachNhiem() {
        do {
            double initTrachnhiem = Double.parseDouble(sc.nextLine());
            if (initTrachnhiem > 0) {
                this.trachNhiem = initTrachnhiem;
                break;
            } else {
                System.out.println("Nhập lỗi, mời nhập lại...");
            }
        } while (true);
    }
}
