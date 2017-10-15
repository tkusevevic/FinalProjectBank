/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.pomocno;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import kusevic.ljetnizadatak.model.Transakcija;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Tomislav
 */

public class ExcellKlasa {
    public static void exportExcelGrupe(List<Transakcija> transakcije) {

        String putanja = dohvatiPutanju("Transakcije");

        if (putanja == null) {
            return;
        }
        try {
            HSSFWorkbook wb = new HSSFWorkbook();

            // setting sheet name later
            int i = 0;
            Row row;
            Cell cell;
            int red;
            int kolona;

           red = 0;
         wb.createSheet();

            wb.setSheetName(0, "Transakcije");

           kolona = 0;
            row = wb.getSheetAt(i).createRow(red++);
          cell = row.createCell(kolona++);
            cell.setCellValue("Dtuma");
           cell = row.createCell(kolona++);
            cell.setCellValue("Radnik");
          cell = row.createCell(kolona++);
           cell.setCellValue("Korisnik");
            cell = row.createCell(kolona++);
          cell.setCellValue("Racun");
            cell = row.createCell(kolona);
            cell.setCellValue("Iznos");

            for (Transakcija t : transakcije) {
                kolona = 0;
                row = wb.getSheetAt(i).createRow(red++);

              cell = row.createCell(kolona++);
                cell.setCellValue(t.getDatum().toString());
               cell = row.createCell(kolona++);
                cell.setCellValue(t.getKorisnik().toString());
                cell = row.createCell(kolona++);
                cell.setCellValue(t.getRadnik().toString());
               cell = row.createCell(kolona++);
               cell.setCellValue(t.getRacun().toString());
                cell = row.createCell(kolona);
                cell.setCellType(CellType.NUMERIC);
               cell.setCellValue(t.getIznos().doubleValue());

            }
            row = wb.getSheetAt(i).createRow(red++);
            cell = row.createCell(kolona);
           cell.setCellFormula("sum(E2:E" + --red + ")");
           i++;

            zapisiFile(wb, putanja);

            wb.getSheet("Transakcije").setColumnWidth(0, 20);
           wb.getSheet("Transakcije").setColumnWidth(1, 20);
            wb.getSheet("Transakcije").setColumnWidth(2, 20);
            wb.getSheet("Transakcije").setColumnWidth(3, 20);
            wb.getSheet("Transakcije").setColumnWidth(4, 20);

      } catch (Exception e) {
           e.printStackTrace();
      }
        

 }

   private static String dohvatiPutanju(String naziv) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel datoteka", "xls");

       JFileChooser fileChooser = new JFileChooser();
       fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Odaberite datoteku za pohranu");
        fileChooser.setSelectedFile(new File(naziv + ".xls"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
           return fileChooser.getSelectedFile().getAbsolutePath();
        }

        return null;
   }

    private static void zapisiFile(HSSFWorkbook wb, String putanja) throws IOException {
       FileOutputStream fileOut = new FileOutputStream(putanja);
        wb.write(fileOut);
        wb.close();
        fileOut.close();
    }

}
