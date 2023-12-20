/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import DTO.SanPhamDat;
import static Entity.DonHang.nextID;
import Utils.GenerateID;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author admin
 */
public class SanPham {
    private String maSp;
    private String tenSp;
    private String size;
    private double donGia;
    private int soLuongCon;

    public static int nextID = GenerateID.getNextID("CSDL\\SanPham.txt", "SP", 2, ",");
    private static String generateID() {
        // Tạo mã dựa trên loạt số tự tăng
        String ID = "SP" + nextID;
        nextID++;
        return ID;
    }
    public SanPham(String maSp, String tenSp, String size, double donGia, int soLuongCon) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.size = size;
        this.donGia = donGia;
        this.soLuongCon = soLuongCon;
    }
    public SanPham(String tenSp, String size, double donGia, int soLuongCon) {
        this.maSp = generateID();
        this.tenSp = tenSp;
        this.size = size;
        this.donGia = donGia;
        this.soLuongCon = soLuongCon;
    }

    public SanPham() {
        this.maSp = generateID();
        this.tenSp = "";
        this.size = "";
        this.donGia = 0;
        this.soLuongCon = 0;
    }
    

    
    @Override
    public String toString() {
        return this.maSp+","+this.tenSp+","+this.size+","+this.donGia+","+this.soLuongCon;
    }
    public String toView() {
        return "\tSản phẩm : "+ maSp +" - số lượng : " + soLuongCon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maSp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SanPham otherSp = (SanPham) obj;
        return Objects.equals(maSp, otherSp.maSp);
    }

    public String getMaSp() {
        return maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public String getSize() {
        return size;
    }

    public double getDonGia() {
        return donGia;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setMaSp(String maSp) throws Exception {
            this.maSp = maSp;
    }

    public void setTenSp(String tenSp) throws Exception {
        if(tenSp.trim().equals(""))
            throw new Exception("Tên sản phẩm không được để trống\n");
        else
            this.tenSp = tenSp;
    }

    public void setSize(String size) throws Exception {
        if(size.trim().equals(""))
            throw new Exception("Size không được để trống\n");
        else
            this.size = size;
    }

    public void setDonGia(double donGia) throws Exception {
        if(donGia < 0)
            throw new Exception("Đơn giá phải >= 0\n");
        else
            this.donGia = donGia;
    }

    public void setSoLuongCon(int soLuongCon) throws Exception {
        if(soLuongCon < 0)
            throw new Exception("Số lượng còn phải >= 0\n");
        else
            this.soLuongCon = soLuongCon;
    }
    
    public static List<SanPham> getSanPhamList() {
        List<SanPham> listSP = new ArrayList<SanPham>();
        String fileName = "CSDL\\SanPham.txt";
        

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 5) {
                    String maSP = fields[0];
                    String tenSP = fields[1];
                    String size = fields[2];
                    double donGia = Double.parseDouble(fields[3]);
                    int soLuongCon = Integer.parseInt(fields[4]);
                    SanPham SP = new SanPham(maSP, tenSP, size, donGia, soLuongCon);
                    listSP.add(SP);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listSP;
    }
    
    public static SanPham getSanPhamByID(String maSp, List<SanPham> listSp){
        SanPham sanpham = new SanPham();
        for(SanPham sp : listSp){
            if(sp.getMaSp().equals(maSp)){
                sanpham = sp;
                break;
            }
        }
        return sanpham;
    }
    
}
