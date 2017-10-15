/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tomislav
 */
@Entity
@Table
public class RadnoMjesto extends Entitet implements Serializable {

    private String odjel, naziv;

    @OneToMany(mappedBy = "radnoMjesto")
    private List<RadiNa> radnici;

    public List<RadiNa> getRadnici() {
        return radnici;
    }

    public void setRadnici(List<RadiNa> radnici) {
        this.radnici = radnici;
    }

    public String getOdjel() {
        return odjel;
    }

    public void setOdjel(String odjel) {
        this.odjel = odjel;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
