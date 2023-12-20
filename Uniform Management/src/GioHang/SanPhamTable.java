/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GioHang;
import DTO.SanPhamDat;
import ThemVaoGioHang.*;
import SanPham.*;
import Entity.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class SanPhamTable extends AbstractTableModel{
    private String name[] = {"Tên sản phẩm","Size","Đơn giá", "Số lượng đặt"};
    
    private Class classes[] = {String.class, String.class, Double.class, Integer.class};
   
    List<SanPhamDat> dsSp = new ArrayList<SanPhamDat>();

    public SanPhamTable(List<SanPhamDat> listSp) {
        dsSp = listSp;
    }

    @Override
    public int getRowCount() {
        return dsSp.size();
    }

    @Override
    public int getColumnCount() {
         return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsSp.get(rowIndex).getTenSp();
            
            case 1: return dsSp.get(rowIndex).getSize();
            
            case 2: return dsSp.get(rowIndex).getDonGia();
            
            case 3: return dsSp.get(rowIndex).getSoLuongDat();
            
            default : return null;
        }
    }
     @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }
    
}
