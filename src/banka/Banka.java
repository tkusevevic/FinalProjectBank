/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banka;

import java.io.IOException;
import kusevic.ljetnizadatak.pomocno.HibernateUtil;
import kusevic.ljetnizadatak.view.GlavniIzbornik;
import kusevic.ljetnizadatak.view.Ucitavanje;

/**
 *
 * @author Tomislav
 */
public class Banka {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
           Ucitavanje ucitavanje = new Ucitavanje();
          
       new GlavniIzbornik().setVisible(true);
        HibernateUtil.getSession();
    }
    
}
