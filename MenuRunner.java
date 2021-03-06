
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
                default -> System.out.printf("Nh???p l???i...");
            }
        } while (true);
    }

    private void NhapDSNV() {
        do {
            System.out.println("\n1. Nh???p nh??n vi??n h??nh ch??nh");
            System.out.println("2. Nh???p ti???p th???");
            System.out.println("3. Nh???p tr?????ng ph??ng");
            System.out.println("4. Quay v???..");
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
                default -> System.out.println("Nh???p l???i...");
            }
        } while (true);
    }

    private void XuatDSNV() {
        do {
            System.out.println("\n1. Xu???t nh??n vi??n h??nh ch??nh");
            System.out.println("2. Xu???t ti???p th???");
            System.out.println("3. Xu???t tr?????ng ph??ng");
            System.out.println("4. Xu???t t???t c??? ");
            System.out.println("5. Quay v???..");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1 -> {
                    if (arrNV.size() > 0) {
                        XuatNV();
                    } else {
                        System.out.println("Kh??ng c?? nh??n vi??n h??nh ch??nh n??o c???");
                    }

                }
                case 2 -> {
                    if (arrTT.size() > 0) {
                        XuatTT();
                    } else {
                        System.out.println("Kh??ng c?? ti???p th??? n??o c???");
                    }
                }
                case 3 -> {
                    if (arrTP.size() > 0) {
                        XuatTP();
                    } else {
                        System.out.println("Kh??ng c?? tr?????ng ph??ng n??o c???");
                    }
                }
                case 4 -> {
                    System.out.println("-----T???t C??? nh??n vi??n-----");
                    if (arrAll.size() > 0) {
                        XuatAll();
                    } else {
                        System.out.println("Kh??ng t???n t???i nh??n vi??n n??o c???...");
                    }
                }
                case 5 -> Menu();
                default -> System.out.println("Nh???p l???i...");
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
        System.out.println("\nH??y nh???p v??o m?? nh??n vi??n c???n hi???n th???:");
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
            System.out.println("Kh??ng t???n t???i nh??n vi??n tr??n...");
        }
    }

    private void TimXoaMaNhap() {
        System.out.println("\nH??y nh???p v??o m?? nh??n vi??n c???n x??a:");
        String search = String.valueOf(sc.nextLine());
        boolean checkExist = false;
        for (NhanvienTemplate i : arrAll) {
            if (i.getMaso().contains(search)) {
                System.out.println("Nh??n vi??n " + i.getHoten() + " ???? ???????c x??a..");
                arrAll.remove(i);
                arrNV.remove(i);
                arrTT.remove(i);
                arrTP.remove(i);
                checkExist = true;
                break;
            }
        }
        if (checkExist == false) {
            System.out.println("Kh??ng t???n t???i nh??n vi??n tr??n...");
        }
    }

    private void TimCapNhatMaNhap() {
        System.out.println("\nH??y nh???p v??o m?? nh??n vi??n c???n c???p nh???t:");
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
            System.out.println("Kh??ng t???n t???i nh??n vi??n tr??n...");
        }
    }

    private void XuatKhoangLuong() {
        double x, y;
        boolean checkExist = false;
        while (true) {
            System.out.println("H??y nh???p v??o kho???ng l????ng t??? x -> y :");
            System.out.println("L??u ??: x <= y\n       x > 0\n       y > 0");
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
                System.out.println("Nh???p kh??ng ????ng...");
            }
        }
        if (checkExist == false) {
            System.out.println("Kh??ng c?? nh??n vi??n n??o thu???c kho???ng l????ng tr??n!");
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
