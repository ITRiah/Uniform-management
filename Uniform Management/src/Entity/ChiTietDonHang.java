/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import static Entity.DonHang.nextID;
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
public class ChiTietDonHang {
    private String maChiTietDonHang;
    private String maDH;
    private String maSp;
    private  int soLuongMua;
    
    public static int nextID = GenerateID.getNextID("CSDL\\ChiTietDonHang.txt", "CT", 2, ","); 
    private static String generateID() {
        // Tạo mã dựa trên loạt số tự tăng
        String ID = "CT" + nextID;
        nextID++;
        return ID;
    }
    public String getMaChiTietDonHang() {
        return maChiTietDonHang;
    }

    public void setMaChiTietDonHang(String maChiTietDonHang) {
        this.maChiTietDonHang = maChiTietDonHang;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    

    public ChiTietDonHang() {
    }

    public ChiTietDonHang(String maChiTietDonHang, String maDH, String maSp, int soLuongMua) {
        this.maChiTietDonHang = maChiTietDonHang;
        this.maDH = maDH;
        this.maSp = maSp;
        this.soLuongMua = soLuongMua;
    }
    public ChiTietDonHang(String maDH, String maSp, int soLuongMua) {
        this.maChiTietDonHang = generateID();
        this.maDH = maDH;
        this.maSp = maSp;
        this.soLuongMua = soLuongMua;
    }

    @Override
    public String toString() {
        return maChiTietDonHang + "," + maDH + "," + maSp + "," + soLuongMua;
    }
    
    
    
    public static List<ChiTietDonHang> getChiTietDH() {
        List<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
        String fileName = "CSDL\\ChiTietDonHang.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String maCTDH = fields[0];
                String maDH = fields[1];
                String maSp = fields[2];
                int soLuongMua = Integer.parseInt(fields[3]);
                ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maCTDH, maDH, maSp, soLuongMua);
                list.add(chiTietDonHang);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return list;
    }
    
}
