package SistemPendukungKeputusan.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SistemPendukungKeputusan.Koneksi.Koneksi;
import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class ReportDao {
    private Koneksi con;

    public void CetakHasil(String tanggal) {
        
        con = new Koneksi();

        try {
            HashMap parameter = new HashMap();
            File file = new File("src/SistemPendukungKeputusan/Laporan/HasilPerankingan.jasper");
            parameter.put("parameter1", tanggal);
            
            JasperReport jp = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jp, parameter, con.connect());
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void CetakHasilQuery(String tanggal) {
        
        con = new Koneksi();

        try {
            File file = new File("src/SistemPendukungKeputusan/Laporan/HasilPerankingan.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            String sql = "Select *FROM tb_hasil WHERE tanggal = '"+tanggal+"'";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jasperDesign.setQuery(newQuery);
            JasperReport jp = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jp, null, con.connect());
            JasperViewer.viewReport(jPrint, false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void CetakRiwayat(String dari, String sampai){
        con = new Koneksi();

        try {
            HashMap parameter = new HashMap();
            File file = new File("src/SistemPendukungKeputusan/Laporan/RiwayatPerankingan.jasper");
            parameter.put("parameter1", dari);
            parameter.put("parameter2", sampai);
            JasperReport jp = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jp, parameter, con.connect());
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
