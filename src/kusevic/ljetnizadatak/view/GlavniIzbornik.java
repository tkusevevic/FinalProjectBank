/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.view;

import com.sun.glass.ui.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomislav
 */
public class GlavniIzbornik extends javax.swing.JFrame {

    /**
     * Creates new form GlavniIzbornik
     */
    public GlavniIzbornik() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnKorisnik = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTransakcije = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnRacun = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnRadnoMjesto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnRadnik = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Banka");

        jPanel1.setBackground(new java.awt.Color(55, 56, 76));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(38, 40, 55));

        btnKorisnik.setBackground(new java.awt.Color(38, 40, 55));
        btnKorisnik.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        btnKorisnik.setForeground(new java.awt.Color(102, 178, 255));
        btnKorisnik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Member Filled-50.png"))); // NOI18N
        btnKorisnik.setBorder(null);
        btnKorisnik.setBorderPainted(false);
        btnKorisnik.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnKorisnikMouseMoved(evt);
            }
        });
        btnKorisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKorisnikActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 178, 255));
        jLabel1.setText("KORISNIK");

        jLabel5.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-GitHub Filled-50.png"))); // NOI18N
        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel5MouseMoved(evt);
            }
        });
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        btnTransakcije.setBackground(new java.awt.Color(38, 40, 55));
        btnTransakcije.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        btnTransakcije.setForeground(new java.awt.Color(102, 178, 255));
        btnTransakcije.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Data Transfer-64.png"))); // NOI18N
        btnTransakcije.setBorder(null);
        btnTransakcije.setBorderPainted(false);
        btnTransakcije.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTransakcijeMouseMoved(evt);
            }
        });
        btnTransakcije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransakcijeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 178, 255));
        jLabel8.setText("TRANSAKCIJE");

        btnRacun.setBackground(new java.awt.Color(55, 56, 76));
        btnRacun.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        btnRacun.setForeground(new java.awt.Color(102, 178, 255));
        btnRacun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Credit Card-50.png"))); // NOI18N
        btnRacun.setBorder(null);
        btnRacun.setBorderPainted(false);
        btnRacun.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRacunMouseMoved(evt);
            }
        });
        btnRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRacunActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 178, 255));
        jLabel4.setText("RACUN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnTransakcije, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnKorisnik, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                            .addComponent(btnRacun))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKorisnik))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnRacun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTransakcije, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        btnRadnoMjesto.setBackground(new java.awt.Color(55, 56, 76));
        btnRadnoMjesto.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        btnRadnoMjesto.setForeground(new java.awt.Color(102, 178, 255));
        btnRadnoMjesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Permanent Job Filled-50.png"))); // NOI18N
        btnRadnoMjesto.setBorder(null);
        btnRadnoMjesto.setBorderPainted(false);
        btnRadnoMjesto.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRadnoMjestoMouseMoved(evt);
            }
        });
        btnRadnoMjesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadnoMjestoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 178, 255));
        jLabel3.setText("RADNO MJESTO");

        btnRadnik.setBackground(new java.awt.Color(55, 56, 76));
        btnRadnik.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        btnRadnik.setForeground(new java.awt.Color(102, 178, 255));
        btnRadnik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Workers Filled-50.png"))); // NOI18N
        btnRadnik.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRadnik.setBorderPainted(false);
        btnRadnik.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnRadnikMouseMoved(evt);
            }
        });
        btnRadnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadnikActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 178, 255));
        jLabel6.setText("RADNIK");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel7.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Facebook-48.png"))); // NOI18N
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 178, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Camera Filled-50.png"))); // NOI18N
        jLabel2.setText("ERA DIJAGRAM");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 178, 255));
        jLabel9.setText("BAZA PODATAKA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRadnoMjesto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 169, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRadnoMjesto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRadnik)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRadnoMjestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadnoMjestoActionPerformed
        new FormaRadnaMjesta("").setVisible(true);
    }//GEN-LAST:event_btnRadnoMjestoActionPerformed

    private void btnRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRacunActionPerformed
        new FormaRacun().setVisible(true);
    }//GEN-LAST:event_btnRacunActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
                java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://plus.google.com/photos/photo/115775626123844780468/6466839684878651106?icm=false&iso=true&authkey=CIPn6IftodrDJA&hl=hr"));
//            Runtime.getRuntime().exec("cmd /c start https://plus.google.com/photos/photo/115775626123844780468/6466839684878651106?icm=false&iso=true&authkey=CIPn6IftodrDJA&hl=hr ");
        } catch (IOException ex) {
            Logger.getLogger(GlavniIzbornik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnKorisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKorisnikActionPerformed
        new FormaKorisnik().setVisible(true);
    }//GEN-LAST:event_btnKorisnikActionPerformed

    private void btnKorisnikMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKorisnikMouseMoved
        btnKorisnik.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.CURSOR_RESIZE_UPDOWN));
    }//GEN-LAST:event_btnKorisnikMouseMoved

    private void btnRacunMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRacunMouseMoved
        btnRacun.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.CURSOR_RESIZE_UPDOWN));
    }//GEN-LAST:event_btnRacunMouseMoved

    private void btnRadnoMjestoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadnoMjestoMouseMoved
        btnRadnoMjesto.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.CURSOR_RESIZE_UPDOWN));
    }//GEN-LAST:event_btnRadnoMjestoMouseMoved

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/tkusevevic"));
        } catch (IOException ex) {
            Logger.getLogger(GlavniIzbornik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
        jLabel2.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.CURSOR_RESIZE_UPDOWN));
    }//GEN-LAST:event_jLabel2MouseMoved

    private void jLabel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseMoved
        jLabel5.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.CURSOR_RESIZE_UPDOWN));
    }//GEN-LAST:event_jLabel5MouseMoved

    private void btnRadnikMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRadnikMouseMoved
        btnRadnik.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.CURSOR_RESIZE_UPDOWN));
    }//GEN-LAST:event_btnRadnikMouseMoved

    private void btnRadnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRadnikActionPerformed
        new FormaRadnik().setVisible(true);
    }//GEN-LAST:event_btnRadnikActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://web.facebook.com/tomislav.kusevic"));
        } catch (IOException ex) {
            Logger.getLogger(GlavniIzbornik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
        jLabel7.setCursor(java.awt.Cursor.getPredefinedCursor(Cursor.CURSOR_RESIZE_UPDOWN));
    }//GEN-LAST:event_jLabel7MouseMoved

    private void btnTransakcijeMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransakcijeMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransakcijeMouseMoved

    private void btnTransakcijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransakcijeActionPerformed
        new FormaTransakcije().setVisible(true);
    }//GEN-LAST:event_btnTransakcijeActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlavniIzbornik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKorisnik;
    private javax.swing.JButton btnRacun;
    private javax.swing.JButton btnRadnik;
    private javax.swing.JButton btnRadnoMjesto;
    private javax.swing.JButton btnTransakcije;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
