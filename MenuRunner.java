
import java.util.*;

public class MenuRunner {
    Scanner sc = new Scanner(System.in);
    ArrayList<NhanvienTemplate> arrAll = new ArrayList<>();

    ArrayList<Nhanvien> arrNV = new ArrayList<Nhanvien>();
    ArrayList<Tiepthi> arrTT = new ArrayList<Tiepthi>();
    ArrayList<Truongphong> arrTP = new ArrayList<Truongphong>();

    Nhanvien nhanvien;
    Tiepthi tiepthi;
    Truongphong truongphong;

    Comparator<NhanvienTemplate> HoTenComparator;
    Comparator<NhanvienTemplate> ThuNhapComparator;

    public void Menu() {
        do {
            System.out.println("\n------------------------------");
            System.out.println("-----------QLNHANVIEN---------");
            System.out.println("1. Nhap danh sach nhan vien");
            System.out.println("2. Xuat danh sach nhan vien");
            System.out.println("3. Tim va hien thi nhan vien");
            System.out.println("4. Xoa nhan vien");
            System.out.println("5. Cap nhat thong tin nhan vien");
            System.out.println("6. Tim cac nhan vien theo khoang luong nhap");
            System.out.println("7. Sap xep nhan vien theo ho va ten");
            System.out.println("8. Sap xep nhan vien theo thu nhap");
            System.out.println("9. Xuat 5 nhan vien co thu nhap cao nhat");
            System.out.println("10. Thoat");
            System.out.println("------------------------------");
            System.out.println(" Ban hay lua chon( 1 - 10 ): ...");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1 -> NhapDSNV();
                case 2 -> XuatDSNV();
                case 3 -> TimXuatMaNhap();
                case 4 -> TimXoaMaNhap();
                case 5 -> TimCapNhatMaNhap();
                case 6 -> XuatKhoangLuong();
                case 7 -> SapXepHoTen();
                case 8 -> SapXepThuNhap();
                case 9 -> Xuat5();
                case 10 -> System.exit(0);
                default -> System.out.printf("Nhập lỗi...");
            }
        } while (true);
    }

    private void NhapDSNV() {
        do {
            System.out.println("\n1. Nhập nhân viên hành chính");
            System.out.println("2. Nhập tiếp thị");
            System.out.println("3. Nhập trưởng phòng");
            System.out.println("4. Quay về..");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    nhanvien = new Nhanvien();
                    nhanvien.Nhap();
                    arrNV.add(nhanvien);
                    arrAll.add(nhanvien);
                }
                case 2 -> {
                    tiepthi = new Tiepthi();
                    tiepthi.Nhap();
                    arrTT.add(tiepthi);
                    arrAll.add(tiepthi);
                }
                case 3 -> {
                    truongphong = new Truongphong();
                    truongphong.Nhap();
                    arrTP.add(truongphong);
                    arrAll.add(truongphong);
                }
                case 4 -> Menu();
                default -> System.out.println("Nhập lỗi...");
            }
        } while (true);
    }

    private void XuatDSNV() {
        do {
            System.out.println("\n1. Xuất nhân viên hành chính");
            System.out.println("2. Xuất tiếp thị");
            System.out.println("3. Xuất trưởng phòng");
            System.out.println("4. Xuất tất cả ");
            System.out.println("5. Quay về..");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    if (arrNV.size() > 0) {
                        XuatNV();
                    } else {
                        System.out.println("Không có nhân viên hành chính nào cả");
                    }

                }
                case 2 -> {
                    if (arrTT.size() > 0) {
                        XuatTT();
                    } else {
                        System.out.println("Không có tiếp thị nào cả");
                    }
                }
                case 3 -> {
                    if (arrTP.size() > 0) {
                        XuatTP();
                    } else {
                        System.out.println("Không có trưởng phòng nào cả");
                    }
                }
                case 4 -> {
                    System.out.println("-----Tất Cả nhân viên-----");
                    if (arrAll.size() > 0) {
                        XuatAll();
                    } else {
                        System.out.println("Không tồn tại nhân viên nào cả...");
                    }
                }
                case 5 -> Menu();
                default -> System.out.println("Nhập lỗi...");
            }
        } while (true);
    }

    private void XuatNV() {
        for (Nhanvien i : arrNV) {
            i.Xuat();
        }
    }

    private void XuatTT() {
        for (Tiepthi i : arrTT) {
            i.Xuat();
        }
    }

    private void XuatTP() {
        for (Truongphong i : arrTP) {
            i.Xuat();
        }
    }

    private void XuatAll() {
        for (NhanvienTemplate i : arrAll) {
            i.Xuat();
        }
    }

    private void TimXuatMaNhap() {
        System.out.println("\nHãy nhập vào mã nhân viên cần hiển thị:");
        String search = String.valueOf(sc.nextLine());
        boolean checkExist = false;
        for (NhanvienTemplate x : arrAll) {
            if (x.getMaso().contains(search)) {
                x.Xuat();
                checkExist = true;
                break;
            }
        }
        if (checkExist == false) {
            System.out.println("Không tồn tại nhân viên trên...");
        }
    }

    private void TimXoaMaNhap() {
        System.out.println("\nHãy nhập vào mã nhân viên cần xóa:");
        String search = String.valueOf(sc.nextLine());
        boolean checkExist = false;
        for (NhanvienTemplate i : arrAll) {
            if (i.getMaso().contains(search)) {
                System.out.println("Nhân viên " + i.getHoten() + " đã được xóa..");
                arrAll.remove(i);
                arrNV.remove(i);
                arrTT.remove(i);
                arrTP.remove(i);
                checkExist = true;
                break;
            }
        }
        if (checkExist == false) {
            System.out.println("Không tồn tại nhân viên trên...");
        }
    }

    private void TimCapNhatMaNhap() {
        System.out.println("\nHãy nhập vào mã nhân viên cần cập nhật:");
        String search = String.valueOf(sc.nextLine());
        boolean checkExist = false;
        for (Nhanvien nv : arrNV) {
            if (nv.getMaso().contains(search)) {
                nv.Nhap();
                checkExist = true;
                break;
            }
        }
        for (Tiepthi tt : arrTT) {
            if (tt.getMaso().contains(search)) {
                tt.Nhap();
                checkExist = true;
                break;
            }
        }
        for (Truongphong tp : arrTP) {
            if (tp.getMaso().contains(search)) {
                tp.Nhap();
                checkExist = true;
                break;
            }
        }
        if (checkExist == false) {
            System.out.println("Không tồn tại nhân viên trên...");
        }
    }

    private void XuatKhoangLuong() {
        double x, y;
        boolean checkExist = false;
        while (true) {
            System.out.println("Hãy nhập vào khoảng lương từ x -> y :");
            System.out.println("Lưu ý: x <= y\n       x > 0\n       y > 0");
            System.out.print("x : ");
            x = Double.parseDouble(sc.nextLine());
            System.out.print("y : ");
            y = Double.parseDouble(sc.nextLine());
            if (x >= 0 && y >= 0 && x <= y) {
                for (NhanvienTemplate i : arrAll) {
                    if (i.getThuNhap() <= y && i.getThuNhap() >= x) {
                        checkExist = true;
                        i.Xuat();
                    }
                }
                break;
            } else {
                System.out.println("Nhập không đúng...");
            }
        }
        if (checkExist == false) {
            System.out.println("Không có nhân viên nào thuộc khoảng lương trên!");
        }
    }

    private void SapXepHoTen() {
        HoTenComparator = new Comparator<NhanvienTemplate>() {
            @Override
            public int compare(NhanvienTemplate o1, NhanvienTemplate o2) {
                return o1.getHoten().length() > o2.getHoten().length() ? -1
                        : o1.getHoten().length() < o2.getHoten().length() ? 1 : 0;
            }
        };
        Collections.sort(arrAll, HoTenComparator);
        XuatAll();
    }

    private void SapXepThuNhap() {
        ThuNhapComparator = new Comparator<NhanvienTemplate>() {
            @Override
            public int compare(NhanvienTemplate o1, NhanvienTemplate o2) {
                return Double.compare(o1.getThuNhap(), o2.getThuNhap());
            }
        };
        Collections.sort(arrAll, ThuNhapComparator);
        Collections.reverse(arrAll);
        XuatAll();
    }

    private void Xuat5() {
        ThuNhapComparator = new Comparator<NhanvienTemplate>() {
            @Override
            public int compare(NhanvienTemplate o1, NhanvienTemplate o2) {
                return Double.compare(o1.getThuNhap(), o2.getThuNhap());
            }
        };
        Collections.sort(arrAll, ThuNhapComparator);
        Collections.reverse(arrAll);
        int count = 0;
        for (NhanvienTemplate i : arrAll) {
            i.Xuat();
            count++;
            if (count >= 5) {
                break;
            }
        }
    }
}
