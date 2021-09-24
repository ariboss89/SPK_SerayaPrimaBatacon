package SistemPendukungKeputusan.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SistemPendukungKeputusan.Koneksi.Koneksi;
import SistemPendukungKeputusan.Model.tb_keputusan;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class KeputusanDao extends tb_keputusan{
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public String IdRiwayat() {
        String idKriteria = "";
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from tb_riwayat ORDER BY id_riwayat DESC");
            if (res.first()== false) {
                idKriteria = ("R001");
            } else {
                System.out.println("COT: " + res.getString("id_riwayat").substring(3, 4));
                int no = Integer.valueOf(res.getString("id_riwayat").substring(3, 4)) + 1;
                System.out.println(no);
                if (no < 10) {
                    idKriteria = ("R00" + no);
                }
                if (no >10 && no < 100 ) {
                    idKriteria = ("R0" + no);
                }
                if (no >=100 && no <999) {
                    idKriteria = ("R" + no);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return idKriteria;
    };
    
    public void SaveIdRiwayat(String idRiwayat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_riwayat(id_riwayat)values('" + idRiwayat + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            //JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Save(String alternatif, String kriteria, Double nilai) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_keputusan(alternatif, kriteria, nilai)values('" + alternatif + "','" + kriteria + "', '"+nilai+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            //JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public Double minKriteria(String Id){
        Double kriteria = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT MIN('"+Id+"') as minValue FROM tb_keputusan");
            while(res.next()){
                kriteria = res.getDouble("minValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return kriteria;
    }
    
    public Double maxKriteria(String Id){
        Double kriteria = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT MAX('"+Id+"') as maxValue FROM tb_keputusan");
            while(res.next()){
                kriteria = res.getDouble("maxValue");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return kriteria;
    }
    
    public ArrayList<Double> ListGroup(String nama){
        ArrayList<Double> listAlt = new ArrayList<Double>() ;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_keputusan WHERE alternatif = '"+nama+"' ORDER BY Id ASC");
            while(res.next()){
                listAlt.add(res.getDouble("nilai"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return listAlt;
    }
    
     public String ShowJenis(String Id){
        String jenis = "";
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_kriteria WHERE id_kriteria = '"+Id+"'");
            while(res.next()){
                jenis = res.getString("jenis");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return jenis;
    }
    
     public Double ShowBobot(String Id){
        Double jenis = 0.0;
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_kriteria WHERE id_kriteria = '"+Id+"'");
            while(res.next()){
                jenis = res.getDouble("nilai_kriteria");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return jenis;
    }
    
    public void SaveHasil(String nilai, String alternatif, Date tanggal, String idRiwayat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_hasil(nilai, alternatif, tanggal, id_riwayat)values('" + nilai + "','" + alternatif + "', '"+tanggal+"', '"+idRiwayat+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
           //JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Simpan");
        }
    }
    
    public void UpdateNilai(String nilai, String nama, String Id, String kriteria) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_keputusan set nilai ='" + nilai + "', alternatif = '" + nama + "', kriteria = '"+kriteria+"'  WHERE Id = '"+Id+"'";
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
            
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Update");
        }
    }
    
    //nama dan tanggal update by
    public void Update(String nilai, String nama, Date tanggal) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_hasil set nilai ='" + nilai + "' WHERE alternatif = '" + nama + "' AND tanggal = '"+tanggal+"'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
          //  JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Update");
        }
    }
    
    public void UpdateKet(String Id, String rank) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_hasil set ket ='" + rank + "' WHERE Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
          //  JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Update");
        }
    }
    
    public void Delete(String Id) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_keputusan where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {
        }
    }
    
    public String[][] ShowHasil(String idRiwayat) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_hasil";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_hasil WHERE id_riwayat = '"+idRiwayat+"' ORDER BY nilai DESC";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][5];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("alternatif");
                data[r][2] = res.getString("ket");
                data[r][3] = res.getString("tanggal");
                data[r][4] = res.getString("nilai");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][5];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <5; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
    
    public String[][] Show() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_keputusan";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_keputusan";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][4];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("alternatif");
                data[r][2] = res.getString("kriteria");
                data[r][3] = res.getString("nilai");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][4];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <4; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
    
    public ArrayList<String> ShowIdHasil(String idRiwayat) {
        con = new Koneksi();

        ArrayList<String> list = new ArrayList<String>();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_hasil WHERE id_riwayat = '"+idRiwayat+"' ORDER BY nilai DESC");
            while (res.next()) {

                list.add(res.getString("Id"));
            }
        } catch (SQLException ex) {

        }

        return list;
    }
}
