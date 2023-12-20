/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyTaiKhoan;

import Entity.KhachHang_TaiKhoan;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class KhachHang_TaiKhoan_Table extends AbstractTableModel {

    private String name[] = {"Mã KH", "Tên", "Ngày sinh", "Địa chỉ", "Số ĐT", "Email", "Mã Lớp", "Khóa", "Tên TK", "Mật khẩu","Role"};

    private Class classes[] = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class,String.class};

    LinkedHashSet<KhachHang_TaiKhoan> dsKH_TK = new LinkedHashSet<>();

    public KhachHang_TaiKhoan_Table(LinkedHashSet<KhachHang_TaiKhoan> lst) {
        dsKH_TK = lst;
    }

    @Override
    public int getRowCount() {
        return dsKH_TK.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KhachHang_TaiKhoan khachHang = dsKH_TK.toArray(new KhachHang_TaiKhoan[0])[rowIndex];
        switch (columnIndex) {
            case 0:
                return khachHang.getMaKh();
            case 1:
                return khachHang.getHoTen();
            case 2:
                return khachHang.getNgaySinh();
            case 3:
                return khachHang.getDiaChi();
            case 4:
                return khachHang.getSoDT();
            case 5:
                return khachHang.getEmail();
            case 6:
                return khachHang.getMaLop();
            case 7:
                return khachHang.getLienKhoa();
            case 8:
                return khachHang.getTenTK();
            case 9:
                return khachHang.getMatKhau();
            case 10:
                return khachHang.getRole();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return name[column];
    }
}
