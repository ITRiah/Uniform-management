package Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

public class KhachHang {
    
    private String maKh; // tự gen or têntk
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private String soDT;
    private String email;
    private String maLop; //combox
    private String lienKhoa;
    
    public KhachHang(){
        
    }

    public KhachHang(String maKh, String hoTen, String ngaySinh, String diaChi, String soDT, String email, String maLop, String lienKhoa) {
        this.maKh = maKh;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.maLop = maLop;
        this.lienKhoa = lienKhoa;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLienKhoa() {
        return lienKhoa;
    }

    public void setLienKhoa(String lienKhoa) {
        this.lienKhoa = lienKhoa;
    }
    
    

    

    @Override
    public String toString() {
        return this.maKh+","+this.hoTen+","+this.diaChi+","+this.email+","+this.soDT+","+this.maLop+","+this.ngaySinh+","+this.lienKhoa;
    }

    public static LinkedHashSet<KhachHang> getKhachHangList() {
        LinkedHashSet<KhachHang> listKH = new LinkedHashSet<KhachHang>();
        String fileName = "CSDL\\KhachHang.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String maKh = fields[0];
                String hoTen = fields[1];
                String diaChi = fields[2];
                String email = fields[3];
                String soDt = fields[4];
                String maLop =fields[5];
                String ngaySinh = fields[6];
                String lienKhoa =fields[7];
                KhachHang nv = new KhachHang(maKh, hoTen, diaChi, email, soDt, maLop, ngaySinh, lienKhoa);
                listKH.add(nv);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listKH;
    }
}
