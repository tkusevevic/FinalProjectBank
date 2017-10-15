/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.model;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;

/**
 *
 * @author tjakopec
 */
@MappedSuperclass
public abstract class Entitet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sifra;

    public Long getSifra() {
        return sifra;
    }

    public void setSifra(Long id) {
        this.sifra = id;
    }

    private boolean obrisan = false;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datumKreiranja;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datumPromjene;

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Date getDatumPromjene() {
        return datumPromjene;
    }

    public void setDatumPromjene(Date datumPromjene) {
        this.datumPromjene = datumPromjene;
    }

}
