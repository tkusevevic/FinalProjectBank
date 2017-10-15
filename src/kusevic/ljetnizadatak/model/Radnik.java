/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tomislav
 */
@Entity
@Table
public class Radnik extends Entitet implements Serializable {

    private String ime;

    private String prezime;
    
    private String OIB;

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }
    
   
    
    @ManyToOne
    private Radnik nadredeni;
    
    @OneToMany(mappedBy = "nadredeni")
    private List<Radnik> podredeni;


    @OneToMany(mappedBy = "radnik")
    private List<RadiNa> mjesta;

    @OneToMany(mappedBy = "radnik")
    private List<Transakcija> transakcije;

    public List<RadiNa> getMjesta() {
        return mjesta;
    }

    public void setMjesta(List<RadiNa> mjesta) {
        this.mjesta = mjesta;
    }

    public Radnik getNadredeni() {
        return nadredeni;
    }

    public void setNadredeni(Radnik nadredeni) {
        this.nadredeni = nadredeni;
    }

    public List<Radnik> getPodredeni() {
        return podredeni;
    }

    public void setPodredeni(List<Radnik> podredeni) {
        this.podredeni = podredeni;
    }


    
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }


    public List<Transakcija> getTransakcije() {
        return transakcije;
    }

    public void setTransakcije(List<Transakcija> transakcije) {
        this.transakcije = transakcije;
    }

    @Override
    public String toString() {
        return getIme() + " " + getPrezime() ;
    }
    

}
