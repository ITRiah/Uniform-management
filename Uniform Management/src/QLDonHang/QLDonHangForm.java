/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QLDonHang;

import DTO.ThongTinDonHang;
import static DTO.ThongTinDonHang.getListChiTietDhByMaDh;
import DangNhap.DangNhapForm;
import DangNhap.Menu;
import Entity.ChiTietDonHang;
import Entity.DonHang;
import Entity.SanPham;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import PhanHoi.QuanLyPhanHoi;
import QuanLyTaiKhoan.QuanLyTaiKhoan;
import SanPham.SanPhamForm;
import ThongKe.ThongKe;

/**
 *
 * @author admin
 */
public class QLDonHangForm extends javax.swing.JFrame {

    /**
     * Creates new form QLDonHangForm
     */
    public QLDonHangForm() {
        initComponents();
        loadComBoBox();
        loadTableSanPham();
        viewThanhTien();
    }

    List<DonHang> listFullDH = DonHang.getDonHang();
    List<ThongTinDonHang> listThongTinDonHang = getListThongTinDonHang();
    int dongChon = -1;//Dòng chọn bảng đơn hàng
    int x = 160;
    int y = 540;

    void openMenu() {
        x = 0;
        if (x == 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= 160; i++) {
                            PnSlideMenu.setSize(i, y);
                            Thread.sleep(2);
                        }
                    } catch (Exception e) {
                    }
                }
            }).start();
            x = 160;
        }
    }

    void closeMenu() {
        PnSlideMenu.setSize(x, y);
        if (x == 160) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 160; i >= 0; i--) {
                            PnSlideMenu.setSize(i, y);
                            Thread.sleep(2);
                        }
                    } catch (Exception e) {
                    }
                }
            }).start();
            x = 0;
        }
    }

    public void loadTableSanPham() {
        tblDonHang.setModel(new QLDonHangTable(listThongTinDonHang));
    }

    public DonHang findDonHangById(List<DonHang> listDH, String maDH) {
        DonHang donHang = new DonHang();
        for (DonHang dh : listDH) {
            if (dh.getMaDH().equals(maDH)) {
                donHang = dh;
            }
        }
        return donHang;
    }

    public void viewThanhTien() {
        double sum = 0;
        for (DonHang dh : listFullDH) {
            sum += dh.getTongTien();
        }
        DecimalFormat f = new DecimalFormat("###,###");
        labelThanhTien.setText(f.format(sum) + "VND");
    }

    private void updateFileDonHang() {
        try {
            FileWriter fw = new FileWriter("CSDL\\DonHang.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (DonHang donHang : listFullDH) {
                bw.write(donHang.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ThongTinDonHang> getListThongTinDonHang() {

        List<SanPham> listFullSp = SanPham.getSanPhamList();
        List<ChiTietDonHang> listFullCTDH = ChiTietDonHang.getChiTietDH();

        List<ThongTinDonHang> listThongTinDonHang = new ArrayList<>();
        for (DonHang donHang : listFullDH) {

            List<ChiTietDonHang> listCTDHByDH = getListChiTietDhByMaDh(donHang.getMaDH(), listFullCTDH);
            List<SanPham> listSpByDh = new ArrayList<>();
            for (ChiTietDonHang chiTietDonHang : listCTDHByDH) {
                SanPham sp = SanPham.getSanPhamByID(chiTietDonHang.getMaSp(), listFullSp);
                try {
                    sp.setSoLuongCon(chiTietDonHang.getSoLuongMua());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                }
                listSpByDh.add(sp);
            }
            ThongTinDonHang thongTinDonHang = new ThongTinDonHang(donHang.getMaDH(), donHang.getMaKh(),
                    donHang.getHoTen(), donHang.getSoDt(), donHang.getDiaChi(),
                    donHang.getGhiChu(), donHang.getTrangThai(), donHang.getTongTien(),
                    donHang.getNgayDat(), listSpByDh);
            listThongTinDonHang.add(thongTinDonHang);
        }
        return listThongTinDonHang;
    }

    public void loadComBoBox() {
        // Xóa tất cả các mục trong JComboBox để cập nhật lại dữ liệu
        cboTrangThai.removeAllItems();

        // Thêm các mã lớp vào JComboBox
        cboTrangThai.addItem("Tất cả");
        cboTrangThai.addItem("Chờ duyệt");
        cboTrangThai.addItem("Đã duyệt");
        cboTrangThai.addItem("Đã hoàn thành");
        cboTrangThai.addItem("Khách hủy");
        cboTrangThai.addItem("Từ chối");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        PnTitile = new javax.swing.JPanel();
        PnSlideMenu = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbClose = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbQLSP = new javax.swing.JLabel();
        lbQLTK = new javax.swing.JLabel();
        lbQLDonHang = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbThongKe = new javax.swing.JLabel();
        lbQLPH = new javax.swing.JLabel();
        lbTrangChu = new javax.swing.JLabel();
        lbDangxuat = new javax.swing.JLabel();
        PnMenuBar = new javax.swing.JPanel();
        lbOpenMenu = new javax.swing.JLabel();
        pnMain = new javax.swing.JPanel();
        cardTrangChu = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonHang = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnXacNhan = new javax.swing.JButton();
        btnTuChoi = new javax.swing.JButton();
        btnHoanThanh = new javax.swing.JButton();
        btnExportExcel = new javax.swing.JButton();
        btnKhoiPhuc = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        txtMaDh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        labelThanhTien = new javax.swing.JLabel();
        btnLoad = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PnTitile.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout PnTitileLayout = new javax.swing.GroupLayout(PnTitile);
        PnTitile.setLayout(PnTitileLayout);
        PnTitileLayout.setHorizontalGroup(
            PnTitileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        PnTitileLayout.setVerticalGroup(
            PnTitileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel4.add(PnTitile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 30));

        PnSlideMenu.setBackground(new java.awt.Color(102, 153, 255));
        PnSlideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lbClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbClose.setText("X");
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/avatar.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbClose, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PnSlideMenu.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 100));

        lbQLSP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbQLSP.setForeground(new java.awt.Color(255, 255, 255));
        lbQLSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQLSP.setText("Quản lý sản phẩm");
        lbQLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLSPMouseClicked(evt);
            }
        });
        PnSlideMenu.add(lbQLSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 30));

        lbQLTK.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbQLTK.setForeground(new java.awt.Color(255, 255, 255));
        lbQLTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQLTK.setText("Quản lý tài khoản");
        lbQLTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLTKMouseClicked(evt);
            }
        });
        PnSlideMenu.add(lbQLTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 160, 30));

        lbQLDonHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbQLDonHang.setForeground(new java.awt.Color(255, 255, 255));
        lbQLDonHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQLDonHang.setText("Quản lý đơn hàng");
        lbQLDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLDonHangMouseClicked(evt);
            }
        });
        PnSlideMenu.add(lbQLDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 160, 30));
        PnSlideMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 190, -1));

        lbThongKe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lbThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbThongKe.setText("Thống kê");
        lbThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbThongKeMouseClicked(evt);
            }
        });
        PnSlideMenu.add(lbThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 160, 30));

        lbQLPH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbQLPH.setForeground(new java.awt.Color(255, 255, 255));
        lbQLPH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQLPH.setText("Quản lý phản hồi");
        lbQLPH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbQLPHMouseClicked(evt);
            }
        });
        PnSlideMenu.add(lbQLPH, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 160, 30));

        lbTrangChu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangChu.setText("Trang chủ");
        lbTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbTrangChuMouseClicked(evt);
            }
        });
        PnSlideMenu.add(lbTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 160, 30));

        lbDangxuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbDangxuat.setForeground(new java.awt.Color(255, 255, 255));
        lbDangxuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDangxuat.setText("Đăng xuất");
        lbDangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDangxuatMouseClicked(evt);
            }
        });
        PnSlideMenu.add(lbDangxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 390, 150, -1));

        jPanel4.add(PnSlideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 160, 560));

        lbOpenMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/menu.png"))); // NOI18N
        lbOpenMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbOpenMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PnMenuBarLayout = new javax.swing.GroupLayout(PnMenuBar);
        PnMenuBar.setLayout(PnMenuBarLayout);
        PnMenuBarLayout.setHorizontalGroup(
            PnMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnMenuBarLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lbOpenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(974, Short.MAX_VALUE))
        );
        PnMenuBarLayout.setVerticalGroup(
            PnMenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnMenuBarLayout.createSequentialGroup()
                .addComponent(lbOpenMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.add(PnMenuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1060, 50));

        pnMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnMain.setLayout(new java.awt.CardLayout());

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("QUẢN LÝ ĐƠN HÀNG");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDonHang);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/confirm.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        btnTuChoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/remove (1).png"))); // NOI18N
        btnTuChoi.setText("Từ chối");
        btnTuChoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTuChoiActionPerformed(evt);
            }
        });

        btnHoanThanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/done.png"))); // NOI18N
        btnHoanThanh.setText("Hoàn thành");
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        btnExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/excel.png"))); // NOI18N
        btnExportExcel.setText("Xuất Excel");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        btnKhoiPhuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh (1).png"))); // NOI18N
        btnKhoiPhuc.setText("Khôi phục");
        btnKhoiPhuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTuChoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHoanThanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhoiPhuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnXacNhan)
                .addGap(18, 18, 18)
                .addComponent(btnHoanThanh)
                .addGap(18, 18, 18)
                .addComponent(btnTuChoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKhoiPhuc)
                .addGap(18, 18, 18)
                .addComponent(btnExportExcel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã đơn hàng : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã khách hàng :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Trạng thái :");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaDh, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaKh)))
                .addGap(123, 123, 123)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaDh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Tổng tiền các đơn hàng :");

        labelThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelThanhTien.setForeground(new java.awt.Color(255, 0, 0));
        labelThanhTien.setText("Value");

        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh (1).png"))); // NOI18N
        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searching.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardTrangChuLayout = new javax.swing.GroupLayout(cardTrangChu);
        cardTrangChu.setLayout(cardTrangChuLayout);
        cardTrangChuLayout.setHorizontalGroup(
            cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardTrangChuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(420, 420, 420))
            .addGroup(cardTrangChuLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardTrangChuLayout.createSequentialGroup()
                        .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardTrangChuLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardTrangChuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardTrangChuLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        cardTrangChuLayout.setVerticalGroup(
            cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTrangChuLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btnSearch)
                .addGap(37, 37, 37)
                .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardTrangChuLayout.createSequentialGroup()
                        .addComponent(btnLoad)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelThanhTien)
                    .addComponent(jLabel4))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(cardTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cardTrangChuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(317, Short.MAX_VALUE)))
        );

        pnMain.add(cardTrangChu, "card2");

        jPanel4.add(pnMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1060, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangMouseClicked
        // TODO add your handling code here:
        dongChon = tblDonHang.getSelectedRow();
        String maDH = tblDonHang.getValueAt(dongChon, 0).toString();
        txtMaDh.setText(maDH);

        String maKH = tblDonHang.getValueAt(dongChon, 1).toString();
        txtMaKh.setText(maKH);

        String tt = tblDonHang.getValueAt(dongChon, 5).toString();
        cboTrangThai.setSelectedItem(tt);

    }//GEN-LAST:event_tblDonHangMouseClicked

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        dongChon = tblDonHang.getSelectedRow();
        if (dongChon != -1) {

            DonHang donHang = listFullDH.get(dongChon);
            if (donHang.getTrangThai().equals("Chờ duyệt")) {
                donHang.setTrangThai("Đã duyệt");
                listFullDH.set(dongChon, donHang);
                updateFileDonHang();
                List<ThongTinDonHang> listThongTinDonHang = getListThongTinDonHang();
                tblDonHang.setModel(new QLDonHangTable(listThongTinDonHang));
            } else {
                JOptionPane.showMessageDialog(this,
                        "Trạng thái đơn hàng không hợp lệ !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

        } else
            JOptionPane.showMessageDialog(this,
                    "Bạn chưa chọn đơn hàng", "Thông báo", ERROR);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
        // TODO add your handling code here:
        dongChon = tblDonHang.getSelectedRow();
        if (dongChon != -1) {

            DonHang donHang = listFullDH.get(dongChon);
            if (donHang.getTrangThai().equals("Đã duyệt")) {
                donHang.setTrangThai("Đã hoàn thành");
                listFullDH.set(dongChon, donHang);
                updateFileDonHang();
                List<ThongTinDonHang> listThongTinDonHang = getListThongTinDonHang();
                tblDonHang.setModel(new QLDonHangTable(listThongTinDonHang));
            } else {
                JOptionPane.showMessageDialog(this,
                        "Trạng thái đơn hàng không hợp lệ !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

        } else
            JOptionPane.showMessageDialog(this,
                    "Bạn chưa chọn đơn hàng", "Thông báo", ERROR);
    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void btnTuChoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTuChoiActionPerformed
        // TODO add your handling code here:
        dongChon = tblDonHang.getSelectedRow();
        if (dongChon != -1) {

            DonHang donHang = listFullDH.get(dongChon);
            if (donHang.getTrangThai().equals("Chờ duyệt")) {
                donHang.setTrangThai("Từ chối");
                listFullDH.set(dongChon, donHang);
                updateFileDonHang();
                List<ThongTinDonHang> listThongTinDonHang = getListThongTinDonHang();
                tblDonHang.setModel(new QLDonHangTable(listThongTinDonHang));
            } else {
                JOptionPane.showMessageDialog(this,
                        "Trạng thái đơn hàng không hợp lệ !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

        } else
            JOptionPane.showMessageDialog(this,
                    "Bạn chưa chọn đơn hàng", "Thông báo", ERROR);
    }//GEN-LAST:event_btnTuChoiActionPerformed

    private void btnKhoiPhucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucActionPerformed
        // TODO add your handling code here:
        dongChon = tblDonHang.getSelectedRow();
        if (dongChon != -1) {

            DonHang donHang = listFullDH.get(dongChon);
            if (donHang.getTrangThai().equals("Từ chối")) {
                donHang.setTrangThai("Chờ duyệt");
                listFullDH.set(dongChon, donHang);
                updateFileDonHang();
                List<ThongTinDonHang> listThongTinDonHang = getListThongTinDonHang();
                tblDonHang.setModel(new QLDonHangTable(listThongTinDonHang));
            } else {
                JOptionPane.showMessageDialog(this,
                        "Trạng thái đơn hàng không hợp lệ !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }

        } else
            JOptionPane.showMessageDialog(this,
                    "Bạn chưa chọn đơn hàng", "Thông báo", ERROR);
    }//GEN-LAST:event_btnKhoiPhucActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String maDH = txtMaDh.getText();
        List<ThongTinDonHang> lst = new ArrayList<>();
        for (ThongTinDonHang dh : listThongTinDonHang) {
            if (dh.getMaDH().equals(maDH)) {
                lst.add(dh);
            }
        }

        tblDonHang.setModel(new QLDonHangTable(lst));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        loadTableSanPham();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        // TODO add your handling code here:
        closeMenu();
    }//GEN-LAST:event_lbCloseMouseClicked

    private void lbQLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLSPMouseClicked
        // TODO add your handling code here:
        SanPhamForm sp = new SanPhamForm();
        sp.setVisible(true);
        sp.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        this.dispose();
    }//GEN-LAST:event_lbQLSPMouseClicked

    private void lbQLTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLTKMouseClicked
        // TODO add your handling code here:
        QuanLyTaiKhoan sp = null;
        try {
            sp = new QuanLyTaiKhoan();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage()
            );
        }
        sp.setVisible(true);
        sp.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        this.dispose();
    }//GEN-LAST:event_lbQLTKMouseClicked

    private void lbQLDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLDonHangMouseClicked
        // TODO add your handling code here:
        QLDonHang.QLDonHangForm sp = new QLDonHangForm();
        sp.setVisible(true);
        sp.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        this.dispose();
    }//GEN-LAST:event_lbQLDonHangMouseClicked

    private void lbThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbThongKeMouseClicked
        // TODO add your handling code here:
        ThongKe sp = new ThongKe();
        sp.setVisible(true);
        sp.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        this.dispose();
    }//GEN-LAST:event_lbThongKeMouseClicked

    private void lbQLPHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbQLPHMouseClicked
        // TODO add your handling code here:
        QuanLyPhanHoi sp = new QuanLyPhanHoi();
        sp.setVisible(true);
        sp.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        this.dispose();
    }//GEN-LAST:event_lbQLPHMouseClicked

    private void lbTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTrangChuMouseClicked
        // TODO add your handling code here:
        Menu sp = new Menu();
        sp.setVisible(true);
        sp.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        this.dispose();
    }//GEN-LAST:event_lbTrangChuMouseClicked

    private void lbOpenMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbOpenMenuMouseClicked
        // TODO add your handling code here:
        openMenu();
    }//GEN-LAST:event_lbOpenMenuMouseClicked

    private void lbDangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDangxuatMouseClicked
        // TODO add your handling code here:
        DangNhapForm sp = new DangNhapForm();
        sp.setVisible(true);
        sp.setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình
        this.dispose();
    }//GEN-LAST:event_lbDangxuatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLDonHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDonHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDonHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDonHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDonHangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnMenuBar;
    private javax.swing.JPanel PnSlideMenu;
    private javax.swing.JPanel PnTitile;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JButton btnKhoiPhuc;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTuChoi;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JPanel cardTrangChu;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelThanhTien;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbDangxuat;
    private javax.swing.JLabel lbOpenMenu;
    private javax.swing.JLabel lbQLDonHang;
    private javax.swing.JLabel lbQLPH;
    private javax.swing.JLabel lbQLSP;
    private javax.swing.JLabel lbQLTK;
    private javax.swing.JLabel lbThongKe;
    private javax.swing.JLabel lbTrangChu;
    private javax.swing.JPanel pnMain;
    private javax.swing.JTable tblDonHang;
    private javax.swing.JTextField txtMaDh;
    private javax.swing.JTextField txtMaKh;
    // End of variables declaration//GEN-END:variables
}
