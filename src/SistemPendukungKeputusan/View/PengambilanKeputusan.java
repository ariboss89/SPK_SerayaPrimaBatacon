package SistemPendukungKeputusan.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SistemPendukungKeputusan.Dao.RumusDao;
import SistemPendukungKeputusan.Dao.KeputusanDao;
import SistemPendukungKeputusan.Dao.KriteriaDao;
import SistemPendukungKeputusan.Dao.ReportDao;
import SistemPendukungKeputusan.Koneksi.Koneksi;
import SistemPendukungKeputusan.Model.tb_model;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariboss89
 */
public class PengambilanKeputusan extends javax.swing.JFrame {

    Koneksi con;
    Statement st;
    ResultSet rs;

    String[][] res2;
    String[] namaKolom2 = {"ID", "ALTERNATIF", "KET", "TANGGAL", "NILAI"};
    int jmlKolom2 = namaKolom2.length;
    int[] lebar2 = {200, 500, 500, 200, 400};

    String[][] res;
    String[] namaKolom = {"ID", "ALTERNATIF", "KRITERIA", "NILAI"};
    int jmlKolom = namaKolom.length;
    int[] lebar = {200, 500, 500, 400};
    tb_model tbm = new tb_model();
    KeputusanDao kd = new KeputusanDao();
    KriteriaDao krd = new KriteriaDao();
    ReportDao rd = new ReportDao();
    RumusDao fd = new RumusDao();

    public PengambilanKeputusan() {
        initComponents();
        ShowAlternatif();
        ShowKriteria();
        DistinctAlternatif();
        DistinctKriteria();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2 + 130;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
        String kk = kd.IdRiwayat();
        
        btnCetak.setEnabled(false);

    }

    List<String> listAlternatif = new ArrayList<String>();

    void Refresh(){
        res = kd.Show();
        tbm.SetTabel(jTable1, res, namaKolom, jmlKolom, lebar);
        
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jTextField1.setText("");
    }
    
    private void ShowAlternatif() {
        con = new Koneksi();

        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT *FROM tb_alternatif ORDER BY Id ASC");
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("nama"));
                listAlternatif.add(rs.getString("nama"));
            }
        } catch (SQLException ex) {

        }
    }

    private ArrayList<String> ShowAlternatifByDescending() {
        con = new Koneksi();

        ArrayList<String> list = new ArrayList<String>();
        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT *FROM tb_alternatif ORDER BY Id DESC");
            while (rs.next()) {

                list.add(rs.getString("nama"));
            }
        } catch (SQLException ex) {

        }

        return list;
    }

    List<String> listKriteria = new ArrayList<String>();

    private void ShowKriteria() {
        con = new Koneksi();

        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT *FROM tb_kriteria");
            while (rs.next()) {
                jComboBox2.addItem(rs.getString("nama_kriteria"));
                listKriteria.add(rs.getString("nama_kriteria"));
            }
        } catch (SQLException ex) {

        }
    }

    private ArrayList<String> DistinctAlternatif() {

        ArrayList<String> listDistinct = new ArrayList<String>();

        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT DISTINCT(alternatif) as dstAlt FROM tb_keputusan");
            while (rs.next()) {
                listDistinct.add(rs.getString("dstAlt"));
            }
        } catch (SQLException ex) {

        }

        return listDistinct;
    }

    private ArrayList<String> DistinctKriteria() {

        ArrayList<String> listDistinctKriteria = new ArrayList<String>();

        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT DISTINCT(kriteria) as dstAlt FROM tb_keputusan");
            while (rs.next()) {
                listDistinctKriteria.add(rs.getString("dstAlt"));
            }
        } catch (SQLException ex) {

        }

        return listDistinctKriteria;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnHitung = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ALTERNATIF");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KRITERIA");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NILAI");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnHitung.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHitung.setText("MEMULAI PERANKINGAN DENGAN MELAKUKAN PERHITUNGAN METODE MABAC");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addComponent(btnHitung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHitung)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("MENU ALTERNATIF", jPanel1);

        jPanel6.setBackground(new java.awt.Color(255, 153, 51));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TAMPIL DATA");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NORMALISASI");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(jTable5);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MATRIKS AREA PERKIRAAN PERBATASAN");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(jTable4);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ELEMEN MATRIKS TERTIMBANG");

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(jTable7);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("HASIL PERANKINGAN");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane12.setViewportView(jTable6);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("MATRIKS JARAK ALTERNATIF DAERAH PERKIRAAN PERBATASAN");

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCetak.setText("CETAK HASIL");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                        .addComponent(jScrollPane12)
                        .addComponent(jScrollPane9)
                        .addComponent(jScrollPane10)
                        .addComponent(jScrollPane3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel11)
                        .addComponent(jLabel10)
                        .addComponent(jLabel12)
                        .addComponent(jScrollPane2)
                        .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel13))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCetak)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane8.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("MENU HASIL PERHITUNGAN MENGGUNAKAN METODE MABAC", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        res = kd.Show();
        tbm.SetTabel(jTable1, res, namaKolom, jmlKolom, lebar);
    }//GEN-LAST:event_formWindowActivated

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggal = Date.valueOf(java.time.LocalDate.now());

        String tgl = formatter.format(tanggal);
        String idriwayat = kd.IdRiwayat();

        rd.CetakHasil(idriwayat);
        
        kd.SaveIdRiwayat(idriwayat);
        
        btnCetak.setEnabled(false);
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:        
        btnHitung.setEnabled(false);
        btnCetak.setEnabled(true);
        
        DefaultTableModel dataModel = (DefaultTableModel) jTable2.getModel();
        jTable2.setAutoCreateColumnsFromModel(true);

        DefaultTableModel dataModel2 = (DefaultTableModel) jTable3.getModel();
        jTable3.setAutoCreateColumnsFromModel(true);

        DefaultTableModel dataModel3 = (DefaultTableModel) jTable4.getModel();
        jTable4.setAutoCreateColumnsFromModel(true);

        DefaultTableModel dataModel4 = (DefaultTableModel) jTable5.getModel();
        jTable5.setAutoCreateColumnsFromModel(true);

        DefaultTableModel dataModel5 = (DefaultTableModel) jTable6.getModel();
        jTable6.setAutoCreateColumnsFromModel(true);

        DefaultTableModel dataModel6 = (DefaultTableModel) jTable7.getModel();
        jTable7.setAutoCreateColumnsFromModel(true);

        dataModel6.addColumn("HASIL");

        int m = listAlternatif.size();
        int n = DistinctAlternatif().size();
        int o = listKriteria.size();
        int p = DistinctKriteria().size();

        //BIKIN FUNGSI UNTUK MENGECEK APAKAH ALT SESUAI SAMA YANG TELAH DI INPUT
        try {
            if (listAlternatif.size() != DistinctAlternatif().size() || listKriteria.size() != DistinctKriteria().size()) {

                JOptionPane.showMessageDialog(null, "PERHITUNGAN TIDAK BISA DILAKUKAN DIKARENAKAN ALTERNATIF BELUM DITAMBAHKAN SEMUA");

            } else {

                for (int i = 0; i < listKriteria.size(); i++) {
                    int columnName = i + 1;
                    dataModel.addColumn("C" + columnName);
                    dataModel2.addColumn("C" + columnName);
                    dataModel3.addColumn("C" + columnName);
                    dataModel4.addColumn("K" + columnName);
                    dataModel5.addColumn("C" + columnName);
                }

                for (int a = 0; a < listAlternatif.size(); a++) {
                    String nama = listAlternatif.get(a);

                    kd.ListGroup(nama);

                    dataModel.addRow(kd.ListGroup(nama).toArray());

                }

                //Mencari minimum dan max di setiap kategori kriteria
                int row = jTable2.getRowCount();
                int column = jTable2.getColumnCount();

                Double[] arrayA = new Double[row];
                Double[][] arrayC = new Double[row][column];
                Double[][] arrayD = new Double[row][column];
                Double[] arrayN = new Double[row];
                Double[][] arrayB = new Double[row][column];
                Double[][] arrayBobot = new Double[row][column];
                Double[] arrayBatas = new Double[column];
                Double[][] arrayJarakAlternatif = new Double[row][column];
                Double[] arrayHasil = new Double[row];
                Double[] arrayUrut = new Double[row];

                ArrayList<String> listHasil = new ArrayList<String>();

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                Date tanggal = Date.valueOf(java.time.LocalDate.now());

                fd.Normalisasi(row, column, jTable2, dataModel, dataModel2, listHasil, formatter, tanggal, arrayA, arrayC, arrayD);

                int row3 = jTable2.getRowCount();
                int column3 = jTable2.getColumnCount();

                fd.ElementMatriksTerbobot(row3, column3, jTable3, arrayBobot, dataModel3);

                //Matriks Area Perkiraan Perbatasan
                int row4 = jTable4.getRowCount();
                int column4 = jTable4.getColumnCount();

                fd.MatriksAreaPerkiraanPerbatasan(row, column, jTable4, arrayBatas, dataModel4);

                //Matriks Jarak Alternatif
                //rumusnya V-G , V = Element Matriks tertimbang dikurangi Matriks Area Perbatasan (G)
                fd.MatriksJarakAlternatif(column, row, jTable4, jTable5, arrayJarakAlternatif, dataModel5);

                //Perankingan
                int row6 = jTable6.getRowCount();
                int column6 = jTable6.getColumnCount();

                fd.Perankingan(row6, column6, jTable6, arrayHasil, listAlternatif, listHasil, formatter, tanggal);

                //END SECTION
                dataModel.addColumn("Alternatif");
                dataModel2.addColumn("Alternatif");
                dataModel3.addColumn("Alternatif");
                dataModel5.addColumn("Alternatif");

                int baris = jTable2.getRowCount();
                int kolom = jTable2.getColumnCount();

                int aa = kolom - 1;

                for (int a = aa; a < kolom; a++) {

                    for (int b = 0; b < baris; b++) {
                        jTable2.setValueAt(listAlternatif.get(b), b, aa);
                        jTable3.setValueAt(listAlternatif.get(b), b, aa);
                        jTable4.setValueAt(listAlternatif.get(b), b, aa);
                        jTable6.setValueAt(listAlternatif.get(b), b, aa);

                    }

                }

                res2 = kd.ShowHasil(kd.IdRiwayat());
                tbm.SetTabel(jTable7, res2, namaKolom2, jmlKolom2, lebar2);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "PERHITUNGAN TIDAK BISA DILAKUKAN DIKARENAKAN ALTERNATIF BELUM DITAMBAHKAN SEMUA");
        }
    }//GEN-LAST:event_btnHitungActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here

        int ok = JOptionPane.showConfirmDialog(null, "Konfirmasi", "Apakah Anda Ingin Menghapus Data ?", JOptionPane.YES_NO_OPTION);

        if (ok == 0) {

            kd.Delete(kd.getId());
            
            Refresh();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!jTextField1.getText().equals("")) {
            Double nilai = Double.parseDouble(jTextField1.getText());

            int min = krd.getMin();
            int max = krd.getMax();

            if (jComboBox1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Alternatif");
            } else if (jComboBox2.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Kriteria");
            } else if (nilai < min) {

                JOptionPane.showMessageDialog(null, "Harap data diisi dengan angka mulai dari" + String.valueOf(min) + " Dan tidak lebih dari " + String.valueOf(max) + "");
            } else if (nilai > max) {

                JOptionPane.showMessageDialog(null, "Harap data diisi dengan angka mulai dari" + String.valueOf(min) + " Dan tidak lebih dari " + String.valueOf(max) + "");
            } else {

                con = new Koneksi();
                try {
                    st = con.connect().createStatement();
                    rs = st.executeQuery("SELECT *FROM tb_keputusan WHERE kriteria = '" + krd.getId_kriteria() + "' AND alternatif = '"+jComboBox1.getSelectedItem().toString()+"'");
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "DATA TELAH DI TAMBAHKAN !");
                    } else {
                        String nama = jComboBox1.getSelectedItem().toString();
                        String kriteria = krd.getId_kriteria();
                        kd.Save(nama, kriteria, nilai);
                        
                        Refresh();
                    }
                } catch (SQLException e) {

                }

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int count = jTable1.getSelectedRow();

        kd.setId(jTable1.getValueAt(count, 0).toString());
        jComboBox1.setSelectedItem(jTable1.getValueAt(count, 1).toString());
        jComboBox2.setSelectedItem(jTable1.getValueAt(count, 2).toString());
        jTextField1.setText(jTable1.getValueAt(count, 3).toString());

        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
        

    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        con = new Koneksi();

        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT *FROM tb_kriteria WHERE nama_kriteria = '" + jComboBox2.getSelectedItem().toString() + "'");
            while (rs.next()) {
                krd.setId_kriteria(rs.getString("id_kriteria"));
                krd.setMin(rs.getInt("min"));
                krd.setMax(rs.getInt("max"));
            }
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Kriteria");
        }else{
        kd.UpdateNilai(jTextField1.getText(), jComboBox1.getSelectedItem().toString(), kd.getId(), krd.getId_kriteria());
        
        Refresh();
        }  
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(PengambilanKeputusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengambilanKeputusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengambilanKeputusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengambilanKeputusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengambilanKeputusan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
