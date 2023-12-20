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
public class Khoa {
    private String maKhoa;
    private String tenKhoa;

    public Khoa(String maKhoa, String tenKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }
    public Khoa(){
        this.maKhoa = "";
        this.tenKhoa = "";
    }
    @Override
    public String toString() {
        return this.maKhoa+","+this.tenKhoa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maKhoa);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Khoa otherKhoa = (Khoa) obj;
        return Objects.equals(maKhoa, otherKhoa.maKhoa);
    }
    
    
}
