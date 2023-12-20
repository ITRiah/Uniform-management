/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class SanPhamDat {
    private String maGh;
    private String maSp;
    private String tenSp;
    private String size;
    private double donGia;
    private int soLuongDat;

    public String getMaGh() {
        return maGh;
    }

    public void setMaGh(String maGh) {
        this.maGh = maGh;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongDat() {
        return soLuongDat;
    }

    public void setSoLuongDat(int soLuongDat) {
        this.soLuongDat = soLuongDat;
    }
    
    

    public SanPhamDat(String maGh, String maSp, String tenSp, String size, double donGia, int soLuongDat) {
        this.maGh = maGh;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.size = size;
        this.donGia = donGia;
        this.soLuongDat = soLuongDat;
    }

    @Override
    public String toString() {
        return maSp + " - " + tenSp + " - size: " + size + " - giá : " + donGia + " - số lượng : " + soLuongDat;
    }
    
    
}
