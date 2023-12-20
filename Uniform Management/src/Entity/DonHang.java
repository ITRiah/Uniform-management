/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import Utils.GenerateID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DonHang {
    private String maDH;
    private String maKh;
    private String hoTen;
    private String soDt;
    private String diaChi;
    private String ghiChu;
    private String trangThai; //Chờ duyệt, Đã duyệt, Đã hoàn thành, Khách hủy, Từ chối
    private double tongTien;
    private String ngayDat;
    
    public static int nextID = GenerateID.getNextID("CSDL\\DonHang.txt", "DH", 2, ",");
    public DonHang() {
        
    }

    public DonHang(String maDH, String maKh, String hoTen, String soDt, String diaChi, String ghiChu, String trangThai, double tongTien, String ngayDat) {
        this.maDH = maDH;
        this.maKh = maKh;
        this.hoTen = hoTen;
        this.soDt = soDt;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
        this.ngayDat = ngayDat;
    }
    public DonHang(String maKh, String hoTen, String soDt, String diaChi, String ghiChu, String trangThai, double tongTien, String ngayDat) {
        this.maDH = generateID();
        this.maKh = maKh;
        this.hoTen = hoTen;
        this.soDt = soDt;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
        this.ngayDat = ngayDat;
    }

    

    
    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) {
        this.soDt = soDt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return maDH + "," + maKh + "," + hoTen +","  +  soDt + "," + diaChi + "," +ghiChu + "," + trangThai + "," + tongTien + "," + ngayDat;
    }
   
    private static String generateID() {
        // Tạo mã dựa trên loạt số tự tăng
        String ID = "DH" + nextID;
        nextID++;
        return ID;
    }
    
    public static List<DonHang> getDonHang() {
        List<DonHang> list = new ArrayList<DonHang>();
        String fileName = "CSDL\\DonHang.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
//return maDH + "," + maKh + "," + hoTen +","  +  soDt + "," + diaChi + "," + trangThai + "," + tongTien + "," + ngayDat;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String maDH = fields[0];
                String maKh = fields[1];
                String hoTen = fields[2];
                String soDt = fields[3];
                String diaChi = fields[4];
                String ghiChu = fields[5];
                String trangThai = fields[6];
                double tongTien = Double.parseDouble(fields[7]);
                String ngayDat = fields[8];
                DonHang item = new DonHang(maDH, maKh, hoTen, soDt, diaChi, ghiChu, trangThai, tongTien, ngayDat);
                list.add(item);
//                
//                DonHang item = new DonHang(maDH, maKh, trangThai, tongTien, ngayDat);
//                
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return list;
    }    
    
}
