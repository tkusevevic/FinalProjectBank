
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.model;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import kusevic.ljetnizadatak.pomocno.UpisIspisDatoteka;

/**
 *
 * @author Tomislav
 */
@Entity
@Table
public class Racun extends Entitet implements Serializable {

    private String brojRacuna,  datumZatvaranja, stanjeRacuna;
    private static Integer iterator;
    private static final String RACUNCIC = "10000000000";
    
    
    public Racun(boolean novi){
        BigInteger izDatoteke;
        izDatoteke = BigInteger.valueOf(UpisIspisDatoteka.ispisi());
        BigInteger brojRacunaa = new BigInteger(RACUNCIC);
        BigInteger krajnjiBrojRacuna = brojRacunaa.add(izDatoteke);
        brojRacuna = krajnjiBrojRacuna.toString();
        stanjeRacuna="0.00";
        super.setDatumKreiranja(new Date());
        super.setObrisan(false);
        iterator = izDatoteke.intValue();
        iterator++;
        UpisIspisDatoteka.upisi(iterator.toString());
        
        
    }
    
    public Racun()
    {
        
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }


    public String getDatumZatvaranja() {
        return datumZatvaranja;
    }

    public void setDatumZatvaranja(String datumZatvaranja) {
        this.datumZatvaranja = datumZatvaranja;
    }

    public String getStanjeRacuna() {
        return stanjeRacuna;
    }

    public void setStanjeRacuna(String stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }

    @Override
    public String toString() {
        return getBrojRacuna();
    }

    
}
