/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.controller;

import kusevic.ljetnizadatak.model.Entitet;
import kusevic.ljetnizadatak.pomocno.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tkusevic
 * @param <T> bilo koji entitet mapiran putem ORM-a
 */
public class Obrada<T extends Entitet> {

    private final Session session;

    public Obrada() {
        session = HibernateUtil.getSession();
    }

    //Create ili Update jednog entiteta
    public T save(T entitet) {
        Date d = new Date();

        if (entitet.getSifra() == null) {
            entitet.setDatumKreiranja(d);
            entitet.setObrisan(false);
        }
        entitet.setDatumPromjene(d);
        session.beginTransaction();
        session.saveOrUpdate(entitet);
        session.getTransaction().commit();
        return entitet;
    }

    //funckija za 'upit' u bazu
    @Deprecated
    public List<T> createQuery(String hql) {
        Query q = session.createQuery(hql);
        return q.list();
    }

    //Postavljanje atributa obrisano na true
    public void delete(T entitet) {
        entitet.setObrisan(true);
        save(entitet);
    }

    //create ili update liste entiteta
    public List<T> save(List<T> lista) {
        Date d = new Date();
        session.beginTransaction();
        lista.stream().forEach((entitet) -> {
            if (entitet.getSifra() == null) {
                entitet.setDatumKreiranja(new Date());
            }
            entitet.setDatumPromjene(new Date());
            session.saveOrUpdate(entitet);
        });
        session.getTransaction().commit();
        return lista;
    }

}
