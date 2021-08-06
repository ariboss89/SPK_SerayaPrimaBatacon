/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nova.Model;

/**
 *
 * @author ariboss89
 */
public class tb_keputusan {
    public String alternatif;
    public String kriteria;
    public Double nilai;
    public String Id;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }
    
    public String getAlternatif() {
        return alternatif;
    }

    public void setAlternatif(String alternatif) {
        this.alternatif = alternatif;
    }

    public String getKriteria() {
        return kriteria;
    }

    public void setKriteria(String kriteria) {
        this.kriteria = kriteria;
    }

    public Double getNilai() {
        return nilai;
    }

    public void setNilai(Double nilai) {
        this.nilai = nilai;
    }
    
    
}
