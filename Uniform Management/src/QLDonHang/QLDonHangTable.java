/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLDonHang;
import DTO.ThongTinDonHang;
import SanPham.*;
import Entity.SanPham;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class QLDonHangTable extends AbstractTableModel{
    private String name[] = {"Mã ĐH","Mã KH","Thông tin người đặt","Chi tiết", "Tổng tiền", "Trạng thái"};
    
    private Class classes[] = {String.class, String.class, String.class, String.class, String.class, String.class};
   
    List<ThongTinDonHang> dsThongTinDonHang = new ArrayList<ThongTinDonHang>();

    public QLDonHangTable(List<ThongTinDonHang> listThongTinDonHang) {
        dsThongTinDonHang = listThongTinDonHang;
    }

    @Override
    public int getRowCount() {
        return dsThongTinDonHang.size();
    }

    @Override
    public int getColumnCount() {
         return name.length;
    }
//    private String maDH;
//    private String maKh;
//    private String hoTen;
//    private String soDt;
//    private String diaChi;
//    private String ghiChu;
//    private String trangThai; //Chờ duyệt, Đã duyệt, Đã hoàn thành, Khách hủy, Từ chối
//    private double tongTien;
//    private String ngayDat;
//    private List<SanPham> listSp;
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ThongTinDonHang rowInfo = dsThongTinDonHang.get(rowIndex);
        switch(columnIndex){
            
            case 0: return rowInfo.getMaDH();
            case 1: return rowInfo.getMaKh();
            case 2:
                
               
                String view = "Họ tên : " + rowInfo.getHoTen() + "\n";
                view += "Số ĐT : " + rowInfo.getSoDt()+ "\n";
                view += "Số địa chỉ : " + rowInfo.getDiaChi()+ "\n";
                view += "Ghi chú : " + rowInfo.getGhiChu()+ "\n";
                return view;
            case 3:
                ThongTinDonHang rowInfo1 = dsThongTinDonHang.get(rowIndex);
                String viewChiTiet = "";
                for(SanPham sp : rowInfo1.getListSp()){
                    viewChiTiet += sp.toView();
                }
                return viewChiTiet;
            case 4: 
                return rowInfo.getTongTien();
            case 5: 
                DecimalFormat f = new DecimalFormat("###,###");
                return rowInfo.getTrangThai();
            
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
