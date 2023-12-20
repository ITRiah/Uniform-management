/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SanPham;
import Entity.SanPham;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class SanPhamTable extends AbstractTableModel{
    private String name[] = {"Mã sản phẩm","Tên sản phẩm","Size","Đơn giá", "Số lượng có"};
    
    private Class classes[] = {String.class, String.class, String.class, Double.class, Integer.class};
   
    List<SanPham> dsSp = new ArrayList<SanPham>();

    public SanPhamTable(List<SanPham> listSp) {
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
            case 0: return dsSp.get(rowIndex).getMaSp();
            
            case 1: return dsSp.get(rowIndex).getTenSp();
            
            case 2: return dsSp.get(rowIndex).getSize();
            
            case 3: return dsSp.get(rowIndex).getDonGia();
            
            case 4: return dsSp.get(rowIndex).getSoLuongCon();
            
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
