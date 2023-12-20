/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import DTO.SanPhamDat;
import static Entity.SanPham.nextID;
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
public class GioHang {
    private String maGioHang;
    private String maKh;
    private String maSp;
    private int soLuongDat;
    
    
    public static int nextID = GenerateID.getNextID("CSDL\\GioHang.txt", "GH", 2, ",");
    private static String generateID() {
        // Tạo mã dựa trên loạt số tự tăng
        String ID = "GH" + nextID;
        nextID++;
        return ID;
    }
    public String getMaGioHang() {
        return maGioHang;
    }

    public void setMaGioHang(String maGioHang) {
        this.maGioHang = maGioHang;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getSoLuongDat() {
        return soLuongDat;
    }

    public void setSoLuongDat(int soLuongDat) {
        this.soLuongDat = soLuongDat;
    }

    public GioHang() {
    }

    public GioHang(String maKh, String maSp, int soLuongDat) {
        this.maGioHang = generateID();
        this.maKh = maKh;
        this.maSp = maSp;
        this.soLuongDat = soLuongDat;
    }
    public GioHang(String maGh,String maKh, String maSp, int soLuongDat) {
        this.maGioHang = maGh;
        this.maKh = maKh;
        this.maSp = maSp;
        this.soLuongDat = soLuongDat;
    }

    @Override
    public String toString() {
        return maGioHang +"," + maKh + "," + maSp + "," + soLuongDat;
    }
    public static List<GioHang> getGioHang() {
        List<GioHang> listGioHang = new ArrayList<GioHang>();
        String fileName = "CSDL\\GioHang.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                if(fields.length >= 3){
                    String maGH = fields[0];
                    String maKh = fields[1];
                    String maSp = fields[2];
                    int soLuongDat = Integer.parseInt(fields[3]);



                    GioHang gioHang = new GioHang(maGH,maKh, maSp, soLuongDat);
                    listGioHang.add(gioHang);
                }
                
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listGioHang;
    }
    public static List<SanPhamDat> getSanPhamCoTrongGioHang(String maKh) {
        List<GioHang> listGioHang = GioHang.getGioHang();
        List<SanPham> listSanPham = SanPham.getSanPhamList();
        List<SanPhamDat> listSpCart = new ArrayList<>();
        for (GioHang gioHang : listGioHang) {
            if(gioHang.getMaKh().equals(maKh)){
                for (SanPham sanPham : listSanPham) {
                    if(sanPham.getMaSp().equals(gioHang.getMaSp())){
                        SanPhamDat sanPhamDat = new SanPhamDat(gioHang.getMaGioHang(),sanPham.getMaSp(), sanPham.getTenSp(), sanPham.getSize(), sanPham.getDonGia(), gioHang.getSoLuongDat());
                        listSpCart.add(sanPhamDat);
                    }
                }
            }
        }
        return listSpCart;
    }
}
