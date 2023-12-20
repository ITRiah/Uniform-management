/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThongKe;

import DTO.ThongTinDonHang;
import Entity.SanPham;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class ThongKeTable extends AbstractTableModel{
     private String name[] = {"Mã đơn hàng","Mã khách hàng"," Ngày đặt","Tổng tiền"};
    
    private Class classes[] = {String.class, String.class, LocalDate.class, String.class, Double.class};
   
    List<ThongTinDonHang> dsDH = new ArrayList<ThongTinDonHang>();

    public ThongKeTable(List<ThongTinDonHang> lst) {
        dsDH = lst;
    }

    @Override
    public int getRowCount() {
        return dsDH.size();
    }

    @Override
    public int getColumnCount() {
         return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return dsDH.get(rowIndex).getMaDH();
            case 1: return dsDH.get(rowIndex).getMaKh();
            
            case 2: return dsDH.get(rowIndex).getNgayDat();
            
            case 3: return dsDH.get(rowIndex).getTongTien();
                        
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
