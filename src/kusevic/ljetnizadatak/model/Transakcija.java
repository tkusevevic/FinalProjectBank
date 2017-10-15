/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Tomislav
 */
@Entity
@Table
public class Transakcija extends Entitet implements Serializable {

    private Date datum;
    private BigDecimal iznos;

    @ManyToOne
    private Radnik radnik;

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    @ManyToOne
    private Racun racun;
    @ManyToOne
    private Korisnik korisnik;

    @Override
    public String toString() {
        return getDatum()+ " " + getRadnik()+  " " + getKorisnik()+ " " + getRacun() +" "+ getIznos();
    }

    
}
