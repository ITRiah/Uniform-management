/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Lop {
    private String maLop;
    private String tenLop;
    private String maKhoa;

    public Lop(){
        this.maLop = "";
        this.tenLop = "";
        this.maKhoa = "";
    }
    @Override
    public String toString() {
        return this.maKhoa+","+this.tenLop+","+this.maKhoa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop);
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
        final Lop other = (Lop) obj;
        return Objects.equals(this.maLop, other.maLop);
    }
    public Lop(String maLop, String tenLop, String maKhoa) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maKhoa = maKhoa;
    }
    
}
