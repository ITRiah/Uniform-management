/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PhanHoi;

import Entity.TaiKhoan;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhanHoi implements Comparable<PhanHoi>{
    private static int maPHCounter = 0; // Biến tĩnh để theo dõi mã phản hồi

    private String maPH;
    private String maKH;
    private String hinhAnh;
    private String diemDG;
    private String nhanXet;

    public PhanHoi() {
        maPHCounter++;
        this.maPH = "PH" + maPHCounter;
    }

    public PhanHoi(String maKH, String hinhAnh, String diemDG, String nhanXet) {
        this(); // Gọi constructor mặc định để tăng giá trị biến tĩnh và gán mã phản hồi
        this.maKH = maKH;
        this.hinhAnh = hinhAnh;
        this.diemDG = diemDG;
        this.nhanXet = nhanXet;
    }

    public PhanHoi(String maPH, String maKH, String hinhAnh, String diemDG, String nhanXet) {
        this.maPH = maPH;
        this.maKH = maKH;
        this.hinhAnh = hinhAnh;
        this.diemDG = diemDG;
        this.nhanXet = nhanXet;
    }
    
    public String getMaPH() {
        return maPH;
    }

    public void setMaPH(String maPH) {
        this.maPH = maPH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getDiemDG() {
        return diemDG;
    }

    public void setDiemDG(String diemDG) {
        this.diemDG = diemDG;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }
      
    public static ArrayList<PhanHoi> getList() {
        ArrayList<PhanHoi> listPH = new ArrayList<PhanHoi>();
        String fileName = "CSDL\\PhanHoi.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String maPH = fields[0];
                String maKH = fields[1];
                String hinhAnh = fields[2];
                String diemDG = fields[3];
                String NhanXet = fields[4];
                PhanHoi ph = new PhanHoi(maPH, maKH, hinhAnh, diemDG, NhanXet);
                listPH.add(ph);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listPH;
    }

    @Override
    public int compareTo(PhanHoi o) {
           int diemDG1 = Integer.parseInt(this.getDiemDG().split(" ")[0]);
           int diemDG2 = Integer.parseInt(o.getDiemDG().split(" ")[0]);
           return Integer.compare(diemDG1, diemDG2);
    }
}
