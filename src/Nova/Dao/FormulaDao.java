/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nova.Dao;

import Nova.Koneksi.Koneksi;
import static groovy.ui.text.FindReplaceUtility.dispose;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariboss89
 */
public class FormulaDao {

    KeputusanDao kd = new KeputusanDao();
    Koneksi con;
    Statement st;
    ResultSet rs;

    public void Normalisasi(int row, int column, JTable tbl, DefaultTableModel dft, DefaultTableModel dft2, ArrayList<String> listHasil, SimpleDateFormat formatter, Date tanggal, Double[] arrayA, Double[][] arrayC, Double[][] arrayD) {

        arrayA = new Double[row];
        arrayC = new Double[row][column];
        arrayD = new Double[row][column];

        listHasil = new ArrayList<String>();

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {

                Double aaa = Double.parseDouble(tbl.getValueAt(j, i).toString());
                arrayA[j] = aaa;

                arrayC[j][i] = aaa;
            }

            Double max = arrayA[0];
            Double min = arrayA[0];
            for (int k = 0; k < arrayA.length; k++) {
                if (arrayA[k] >= max) {
                    max = arrayA[k];
                } else if (arrayA[k] <= min) {
                    min = arrayA[k];
                }
            }

            //mencari nama kolom untuk mengambil data jenis berdasarkan nama kolom dan melakukan perhitungan
            //normalisasi
            String columnName = tbl.getColumnName(i);

            String jenis = kd.ShowJenis(columnName);

            if (jenis.equals("Benefit")) {

                Double nilai = 0.0;
                Double normalisasi = 0.0;

                for (int b = 0; b < row; b++) {

                    Double azz = arrayC[b][i];
                    nilai = azz;

                    normalisasi = Math.abs(nilai - min) / Math.abs(max - min);
                    
                    arrayD[b][i] = normalisasi;
                }

            } else {
                Double nilai = 0.0;
                Double normalisasi = 0.0;

                for (int b = 0; b < row; b++) {

                    Double azz = arrayC[b][i];
                    nilai = azz;

                    normalisasi = (nilai - max) / (min - max);
                    
                    if(normalisasi == -0){
                        arrayD[b][i] = Math.abs(normalisasi);
                    }else{
                        arrayD[b][i] = normalisasi;
                    }
                }
            }
        }

        for (int x = 0; x < arrayD.length; x++) {
            Double[] rowa = new Double[arrayD[x].length];

            for (int y = 0; y < arrayD[x].length; y++) {
                rowa[y] = arrayD[x][y];
            }

            dft2.addRow(rowa);

        }
    }

    public void ElementMatriksTerbobot(int row, int column, JTable tbl, Double arrayBobot[][], DefaultTableModel dft) {
        row = tbl.getRowCount();
        column = tbl.getColumnCount();

        for (int b = 0; b < column; b++) {

            String Id = tbl.getColumnName(b);
            Double koefisien = kd.ShowBobot(Id);

            for (int c = 0; c < row; c++) {

                Double nilai = Double.parseDouble(tbl.getValueAt(c, b).toString());

                Double matriksTerbobot = ((koefisien*nilai) + koefisien);

                arrayBobot[c][b] = matriksTerbobot;
            }
        }

        for (int x = 0; x < arrayBobot.length; x++) {
            Double[] rowa = new Double[arrayBobot[x].length];

            for (int y = 0; y < arrayBobot[x].length; y++) {
                rowa[y] = arrayBobot[x][y];
            }

            dft.addRow(rowa);

        }
    }

    public void MatriksAreaPerkiraanPerbatasan(int row, int column, JTable tbl, Double arrayBatas[], DefaultTableModel dft) {

        Double hasil = 1.0;

        Double convert = Double.valueOf(row);
        Double perpangkatan = 1.0 / convert;

        for (int a = 0; a < column; a++) {
            for (int b = 0; b < row; b++) {

                Double nilai = Double.parseDouble(tbl.getValueAt(b, a).toString());

                hasil *= nilai;

            }

            Double matriksPerbatasan = Math.pow(hasil, perpangkatan);

            arrayBatas[a] = matriksPerbatasan;

        }

        dft.addRow(arrayBatas);
    }

    public void MatriksJarakAlternatif(int column, int row, JTable tbl4, JTable tbl5, Double arrayJarakAlternatif[][], DefaultTableModel dft) {
        for (int a = 0; a < column; a++) {

            Double G = Double.parseDouble(tbl5.getValueAt(0, a).toString());

            for (int b = 0; b < row; b++) {

                Double nilai = Double.parseDouble(tbl4.getValueAt(b, a).toString());

                Double Q = nilai - G;

                arrayJarakAlternatif[b][a] = Q;

            }
        }

        for (int x = 0; x < arrayJarakAlternatif.length; x++) {
            Double[] rowa = new Double[arrayJarakAlternatif[x].length];

            for (int y = 0; y < arrayJarakAlternatif[x].length; y++) {
                rowa[y] = arrayJarakAlternatif[x][y];
            }

            dft.addRow(rowa);

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

    public void Perankingan(int row, int column, JTable tbl6, Double arrayHasil[], List<String> listAlternatif, ArrayList<String> listHasil, SimpleDateFormat formatter, Date tanggal) {

        for (int a = 0; a < row; a++) {

            Double nilai = 0.0;

            for (int b = 0; b < column; b++) {

                Double hasilnya = Double.parseDouble(tbl6.getValueAt(a, b).toString());

                nilai = nilai + hasilnya;
            }

            arrayHasil[a] = nilai;

        }

        Arrays.sort(arrayHasil);

        int rowCoun = arrayHasil.length;

        for (int a = rowCoun; a > 0; a--) {

            String nama = listAlternatif.get(a - 1);

            Arrays.sort(arrayHasil);

            String rank = "Ranking " + a + " ";

            listHasil.add(rank);

            System.out.println(rank);

            con = new Koneksi();

            try {

                st = con.connect().createStatement();
                rs = st.executeQuery("SELECT *FROM tb_hasil WHERE alternatif = '" + nama + "'");

                if (rs.next()) {
                    //JOptionPane.showMessageDialog(null, "Proses Perhitungan Untuk Alternatif "+nama+" Hari Ini Telah Terjadi !!");

                    dispose();
                } else {
                    kd.SaveHasil(nama, rank, Date.valueOf(formatter.format(tanggal)));
                }
            } catch (SQLException e) {

            }
        }

        for (int a = 0; a < arrayHasil.length; a++) {

            String nilai = String.valueOf(arrayHasil[a]);
            String alternatif = ShowAlternatifByDescending().get(a);

            con = new Koneksi();

            try {

                st = con.connect().createStatement();
                rs = st.executeQuery("SELECT *FROM tb_hasil WHERE alternatif = '" + alternatif + "'");

                if (rs.next()) {
                    kd.Update(nilai, alternatif, Date.valueOf(formatter.format(tanggal)));
                }
            } catch (SQLException ex) {

            }
        }
    }
}
