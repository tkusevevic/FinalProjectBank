/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.pomocno;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Tomislav
 */
public class UpisIspisDatoteka {

    public static void upisi(String s) {
        try {
            PrintWriter pw = new PrintWriter("test.txt");
            pw.write(s);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Integer ispisi() {
        BufferedReader reader = null;
        Integer s = 0;
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
            String text = null;

            while ((text = reader.readLine()) != null) {
                s = Integer.parseInt(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }

        return s;
    }

}
