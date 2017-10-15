/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Tomislav
 */
@Entity
@Table
public class RadiNa extends Entitet implements Serializable {

    @ManyToOne
    private Radnik radnik;

    @ManyToOne
    private RadnoMjesto radnoMjesto;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pocetakRada;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date krajRada;

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public RadnoMjesto getRadnoMjesto() {
        return radnoMjesto;
    }

    public void setRadnoMjesto(RadnoMjesto radnoMjesto) {
        this.radnoMjesto = radnoMjesto;
    }

    public Date getPocetakRada() {
        return pocetakRada;
    }

    public void setPocetakRada(Date pocetakRada) {
        this.pocetakRada = pocetakRada;
    }

    public Date getKrajRada() {
        return krajRada;
    }

    public void setKrajRada(Date krajRada) {
        this.krajRada = krajRada;
    }
}
