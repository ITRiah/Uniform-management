/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PhanHoi;

import Entity.KhachHang_TaiKhoan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class PhanHoi_Table extends AbstractTableModel{
    private String name[] = {"Mã PH", "Mã KH", "Hình ảnh", "Điểm đánh giá", "Nhận xét"};

    private Class classes[] = {String.class, String.class, String.class, String.class, String.class};
    
    ArrayList<PhanHoi> dsPH = new ArrayList<>();

    public PhanHoi_Table(ArrayList<PhanHoi> lst) {
        dsPH = lst;
    }

    @Override
    public int getRowCount() {
        return dsPH.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dsPH.get(rowIndex).getMaPH();
            case 1:
                return dsPH.get(rowIndex).getMaKH();
            case 2:
                return dsPH.get(rowIndex).getHinhAnh();
            case 3:
                return dsPH.get(rowIndex).getDiemDG();
            case 4:
                return dsPH.get(rowIndex).getNhanXet();
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
