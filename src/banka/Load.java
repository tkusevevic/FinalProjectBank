/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banka;

import java.util.Date;
import kusevic.ljetnizadatak.controller.Obrada;
import kusevic.ljetnizadatak.model.Korisnik;
import kusevic.ljetnizadatak.model.Racun;
import kusevic.ljetnizadatak.model.Radnik;
import kusevic.ljetnizadatak.model.RadnoMjesto;



/**
 *
 * @author Tomislav
 */
public class Load {
    public static void main(String[] args) {
        
    // 3 racuna
        Obrada<Racun> or = new Obrada<>();
        Racun r = new Racun();
        r.setBrojRacuna("10000000001");
        r.setDatumKreiranja(new Date());
        r.setStanjeRacuna("0.00");
        r = or.save(r);
        
        Racun r1 = new Racun();
        r1.setBrojRacuna("10000000002");
        r1.setDatumKreiranja(new Date());
        r1.setStanjeRacuna("0.00");
        r1 = or.save(r1);
        
        Racun r2 = new Racun();
        r2.setBrojRacuna("10000000003");
        r2.setDatumKreiranja(new Date());
        r2.setStanjeRacuna("0.00");
        r2 = or.save(r2);
        
    // 3 korisnika
        
        Obrada<Korisnik> ok = new Obrada();
        Korisnik k = new Korisnik();
        k.setDatumKreiranja(new Date());
        k.setIme("Andro");
        k.setPrezime("Marković");
        k.setRacun("10000000001");
        k.setOib("39182938192");
       
        k  = ok.save(k);
        
        
        Korisnik k1 = new Korisnik();
        k1.setDatumKreiranja(new Date());
        k1.setIme("Marija");
        k1.setPrezime("Marjanović");
        k1.setRacun("10000000002");
        k1.setOib("69103918392");
        k1 = ok.save(k1);
        
        Korisnik k2 = new Korisnik();
        k2.setDatumKreiranja(new Date());
        k2.setIme("Dario");
        k2.setPrezime("Markanović");
        k2.setRacun("10000000003");
        k2.setOib("82910392911");
        k2 = ok.save(k2);
        
        
    // 3 radnika
    
        Obrada<Radnik> oradnik = new Obrada();
        Radnik ra1 = new Radnik();
        ra1.setDatumKreiranja(new Date());
        ra1.setIme("Davor");
        ra1.setPrezime("Marić");
        ra1.setOIB("10203919283");
        ra1 = oradnik.save(ra1);
        
        
        Radnik ra3 = new Radnik();
        ra3.setDatumKreiranja(new Date());
        ra3.setIme("Martina");
        ra3.setPrezime("Zivko");
        ra3.setOIB("30192039182");
        ra3.setNadredeni(ra1);
        ra3 = oradnik.save(ra3);
        
        Radnik ra2 = new Radnik();
        ra2.setDatumKreiranja(new Date());
        ra2.setIme("Miran");
        ra2.setPrezime("Antunović");
        ra2.setOIB("38192019283");
        ra2.setNadredeni(ra3);
        ra2 = oradnik.save(ra2);
        
        
        
        
        
        
        
        
        
    // 3 radna mjesta
        
        
        Obrada<RadnoMjesto> orm = new Obrada();
        
        RadnoMjesto rm = new RadnoMjesto();
        rm.setDatumKreiranja(new Date());
        rm.setNaziv("Direktor");
        rm.setOdjel("Dionice");
        rm = orm.save(rm);
        
        
        RadnoMjesto rm2 = new RadnoMjesto();
        rm2.setDatumKreiranja(new Date());
        rm2.setNaziv("Službenik");
        rm2.setOdjel("Dionice");
        rm2 = orm.save(rm2);
        
        RadnoMjesto rm3 = new RadnoMjesto();
        rm3.setDatumKreiranja(new Date());
        rm3.setNaziv("Službenik");
        rm3.setOdjel("Šalter");
        rm3 = orm.save(rm3);
        
        
                
    }
    
}
