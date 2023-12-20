/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class KhachHang_TaiKhoan {
    private String maKh; // tự gen or têntk
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private String soDT;
    private String email;
    private String maLop; //combox
    private String lienKhoa;
     private String tenTK;
    private String matKhau;
    private String role;
    
    public KhachHang_TaiKhoan(){
        
    }
   
    
    public KhachHang_TaiKhoan(String maKh, String hoTen, String ngaySinh, String diaChi, String soDT, String email, String maLop, String lienKhoa, String tenTK, String matKhau, String role) {
        this.maKh = maKh;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.maLop = maLop;
        this.lienKhoa = lienKhoa;
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.role = role;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) throws Exception{
        if(maKh.trim().equals(""))
            throw new Exception("Mã khách hàng không được để trống\n");
        else
            this.maKh = maKh;
       
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) throws Exception  {
        if(hoTen.trim().equals(""))
            throw new Exception("Họ tên không được để trống\n");
        else
            this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) throws Exception {
        if(ngaySinh.trim().equals(""))
            throw new Exception("Ngày sinh không được để trống\n");
        else
            this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi)throws Exception{
        if(diaChi.trim().equals(""))
            throw new Exception("Địa chỉ không được để trống\n");
        else
            this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) throws Exception {
        if(soDT.trim().equals(""))
            throw new Exception("Số điện thoại không được để trống\n");
        else
            this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email.trim().equals(""))
            throw new Exception("Email không được để trống\n");
        else
            this.email = email;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) throws Exception {
        if(maLop.trim().equals(""))
            throw new Exception("Mã lớp không được để trống\n");
        else
            this.maLop = maLop;
    }

    public String getLienKhoa() {
        return lienKhoa;
    }

    public void setLienKhoa(String lienKhoa) throws Exception {
        if(lienKhoa.trim().equals(""))
            throw new Exception("Liên khóa không được để trống\n");
        else
            this.lienKhoa = lienKhoa;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) throws Exception {
        if(tenTK.trim().equals(""))
            throw new Exception("Tên tài khoản không được để trống\n");
        else
            this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) throws Exception {
        if(matKhau.trim().equals(""))
            throw new Exception("Mật khẩu không được để trống\n");
        else
            this.matKhau = matKhau;
    }

    public void setRole(String role) throws Exception {
        if(role.trim().equals(""))
            throw new Exception("Role không được để trống\n");
        else
            this.role = role;
    }
    
    public String getRole() {
        return role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.maKh);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang_TaiKhoan other = (KhachHang_TaiKhoan) obj;
        return Objects.equals(this.maKh, other.maKh);
    }
    

    @Override
    public String toString() {
        return "KhachHang_TaiKhoan{" + "maKh=" + maKh + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", soDT=" + soDT + ", email=" + email + ", maLop=" + maLop + ", lienKhoa=" + lienKhoa + ", tenTK=" + tenTK + ", matKhau=" + matKhau + ", role=" + role + '}';
    }
    
    
    
    public static LinkedHashSet<KhachHang_TaiKhoan> getList() throws Exception  {
        LinkedHashSet<KhachHang> dsKH = KhachHang.getKhachHangList();
        LinkedHashSet<TaiKhoan> dsTK = TaiKhoan.getTKNVList();
        LinkedHashSet<KhachHang_TaiKhoan> result = new LinkedHashSet<>();

        for (KhachHang kh : dsKH) {
            for (TaiKhoan tk : dsTK) {
                if (kh.getMaKh().equals(tk.getMaKh())) {
                    // Match found, create a KhachHang_TaiKhoan object
                    KhachHang_TaiKhoan khTk = new KhachHang_TaiKhoan();
                    
                    khTk.setMaKh(kh.getMaKh());
                    
                    try {
                        khTk.setHoTen(kh.getHoTen());
                    } catch (Exception ex) {
                        Logger.getLogger(KhachHang_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    khTk.setNgaySinh(kh.getNgaySinh());
                    khTk.setDiaChi(kh.getDiaChi());
                    khTk.setSoDT(kh.getSoDT());
                    khTk.setEmail(kh.getEmail());
                    khTk.setMaLop(kh.getMaLop());
                    khTk.setLienKhoa(kh.getLienKhoa());
                    khTk.setTenTK(tk.getTenTK());
                    khTk.setMatKhau(tk.getMatKhau());
                    khTk.setRole(tk.getRole());

                    // Add the combined object to the result list
                    result.add(khTk);
                }
            }
        }

        return result;
    }

  
}
