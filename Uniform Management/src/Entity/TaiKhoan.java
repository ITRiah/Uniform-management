/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class TaiKhoan {
    private String tenTK;
    private String matKhau;
    private String role;
    //1 admin
    //0 khach hang
    private String maKh;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public TaiKhoan() {
        this.tenTK = "";
        this.matKhau = "";
        this.role = "0";
        this.maKh="";
    }

    public TaiKhoan(String tenTK, String matKhau, String maKh) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.maKh = maKh;
        this.role = "0"; //Mặc định khi đăng kí thì là quyền khách hàng  
    }
    public TaiKhoan(String tenTK, String matKhau, String role, String maKh) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
        this.maKh = maKh;
        this.role = role;
    }

    public TaiKhoan(String tenTK, String matKhau) {
        this.tenTK = tenTK;
        this.matKhau = matKhau;
    }
    @Override
    public String toString() {
        return this.tenTK+","+this.matKhau+","+this.role+","+this.maKh;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenTK);
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
        final TaiKhoan other = (TaiKhoan) obj;
        return Objects.equals(this.tenTK, other.tenTK);
    }
    
       public static LinkedHashSet<TaiKhoan> getTKNVList() {
        LinkedHashSet<TaiKhoan> listTK = new LinkedHashSet<TaiKhoan>();
        String fileName = "CSDL\\TaiKhoan.txt";
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                String tenTK = fields[0];
                String matKhau = fields[1];
                String role = fields[2];
                String maKh = fields[3];
                TaiKhoan tk = new TaiKhoan(tenTK, matKhau, role, maKh);
                listTK.add(tk);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file " + fileName);
        }
        return listTK;
    }
}
