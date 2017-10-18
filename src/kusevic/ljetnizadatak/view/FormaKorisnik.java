/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.view;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import kusevic.ljetnizadatak.controller.Obrada;

import kusevic.ljetnizadatak.controller.Provjera;
import kusevic.ljetnizadatak.model.Korisnik;
import kusevic.ljetnizadatak.pomocno.HibernateUtil;
import kusevic.ljetnizadatak.pomocno.UpisIspisDatoteka;

/**
 *
 * @author Tomislav
 */
public class FormaKorisnik extends Forma<Korisnik> implements EnablingButtons {

    private static FormaKorisnik instance;

    private List<Korisnik> rezultati;
    private List<Korisnik> korisnici;
    private Document dokument;

    Korisnik k;

    public FormaKorisnik() {
        initComponents();
       nakonInitComponents();

        obrada = new Obrada<>();
        korisnici = HibernateUtil.getSession().createQuery("FROM Korisnik WHERE obrisan=null").list();
        trazilica();
        provjeriJelOdabran();
        ucitaj();
        instance = this;
        
    }

    @Override
    public void provjeriJelOdabran() {
        tabelica.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            btnPromjena.setEnabled(true);
            btnBrisanje.setEnabled(true);
        });
    }

    @Override
    protected void ucitaj() {

        DefaultTableModel model = new DefaultTableModel();
        rezultati = HibernateUtil.getSession().createQuery("from Korisnik a where "
                + " a.obrisan=false and concat(a.ime, ' ', a.prezime) like :uvjet").setString("uvjet", "%" + txtUvjet.getText() + "%").list();
        rezultati.forEach((s) -> {
            model.addRow(new Object[]{s, s.getIme(), s.getPrezime(), s.getOib(), s.getRacun()});
        });
        ucitavanje();

    }

    @Override
    protected void spremi() {

        entitet.setIme(txtIme.getText().substring(0, 1).toUpperCase() + txtIme.getText().substring(1).toLowerCase());
        entitet.setPrezime(txtPrezime.getText().substring(0, 1).toUpperCase() + txtPrezime.getText().substring(1).toLowerCase());
        entitet.setOib(txtOIB.getText());
        entitet.setRacun(txtRacun.getText());
        super.spremi();

    }

    private void trazilica() {

        txtUvjet.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent arg0) {

            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                if (cbImePrezime.isSelected()) {
                    rezultati = HibernateUtil.getSession().createQuery("from Korisnik a where a.obrisan=false and concat(a.ime, ' ', a.prezime)"
                            + " like :uvjet").setString("uvjet", "%" + txtUvjet.getText() + "%").list();
                }
                if (cbRacun.isSelected()) {
                    rezultati = HibernateUtil.getSession().createQuery("from Korisnik a where a.obrisan=false and racun"
                            + " like :uvjet").setString("uvjet", "%" + txtUvjet.getText() + "%").list();

                }
                ucitavanje();
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {

                if (cbImePrezime.isSelected()) {
                    rezultati = HibernateUtil.getSession().createQuery("from Korisnik a where a.obrisan=false and concat(a.ime, ' ', a.prezime)"
                            + " like :uvjet").setString("uvjet", "%" + txtUvjet.getText() + "%").list();
                }
                if (cbRacun.isSelected()) {
                    rezultati = HibernateUtil.getSession().createQuery("from Korisnik a where a.obrisan=false and racun"
                            + " like :uvjet").setString("uvjet", "%" + txtUvjet.getText() + "%").list();

                }
                ucitavanje();
            }
        });

    }

    private void ucitavanje() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Objekt");
        model.addColumn("Ime");
        model.addColumn("Prezime");
        model.addColumn("Oib");
        model.addColumn("Racun");

        tabelica.setModel(model);
        rezultati.forEach((s) -> {
            model.addRow(new Object[]{s, s.getIme(), s.getPrezime(), s.getOib(), s.getRacun()});
        });
        tabelica.getColumnModel().getColumn(0).setWidth(0);
        tabelica.getColumnModel().getColumn(0).setMinWidth(0);
        tabelica.getColumnModel().getColumn(0).setMaxWidth(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelica = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        txtUvjet = new javax.swing.JTextField();
        cbRacun = new javax.swing.JCheckBox();
        cbImePrezime = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        txtIme = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRacun = new javax.swing.JTextField();
        txtOIB = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPromjena = new javax.swing.JButton();
        btnBrisanje = new javax.swing.JButton();
        btnUnos = new javax.swing.JButton();
        lblGreska = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        greskaPrezime = new javax.swing.JLabel();
        greskaIme = new javax.swing.JLabel();
        greskaOIB = new javax.swing.JLabel();
        greskaRacun = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Korisnik");
        setBackground(new java.awt.Color(38, 40, 55));
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(38, 40, 55));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 440));

        tabelica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelicaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelicaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelica);
        if (tabelica.getColumnModel().getColumnCount() > 0) {
            tabelica.getColumnModel().getColumn(0).setResizable(false);
            tabelica.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            tabelica.getColumnModel().getColumn(1).setResizable(false);
            tabelica.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            tabelica.getColumnModel().getColumn(2).setResizable(false);
            tabelica.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            tabelica.getColumnModel().getColumn(3).setResizable(false);
            tabelica.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jButton1.setBackground(new java.awt.Color(38, 40, 55));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Search-50.png"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtUvjet.setBackground(new java.awt.Color(38, 40, 55));
        txtUvjet.setFont(new java.awt.Font("Arial Unicode MS", 0, 16)); // NOI18N
        txtUvjet.setForeground(new java.awt.Color(102, 178, 255));
        txtUvjet.setBorder(null);
        txtUvjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjetActionPerformed(evt);
            }
        });

        cbRacun.setBackground(new java.awt.Color(55, 56, 76));
        cbRacun.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        cbRacun.setForeground(new java.awt.Color(102, 178, 255));
        cbRacun.setText("Racun");
        cbRacun.setBorder(null);
        cbRacun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbRacunMouseClicked(evt);
            }
        });
        cbRacun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRacunActionPerformed(evt);
            }
        });

        cbImePrezime.setBackground(new java.awt.Color(55, 56, 76));
        cbImePrezime.setFont(new java.awt.Font("Arial Unicode MS", 0, 12)); // NOI18N
        cbImePrezime.setForeground(new java.awt.Color(102, 178, 255));
        cbImePrezime.setSelected(true);
        cbImePrezime.setText("Ime Prezime");
        cbImePrezime.setBorder(null);
        cbImePrezime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbImePrezimeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(cbImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbRacun))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(txtUvjet, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbRacun)
                            .addComponent(cbImePrezime))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(55, 56, 76));

        txtIme.setBackground(new java.awt.Color(55, 56, 76));
        txtIme.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        txtIme.setForeground(new java.awt.Color(204, 204, 204));
        txtIme.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 178, 255));
        jLabel1.setText("Ime");

        txtPrezime.setBackground(new java.awt.Color(55, 56, 76));
        txtPrezime.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        txtPrezime.setForeground(new java.awt.Color(204, 204, 204));
        txtPrezime.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 178, 255));
        jLabel2.setText("Racun");

        txtRacun.setBackground(new java.awt.Color(55, 56, 76));
        txtRacun.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        txtRacun.setForeground(new java.awt.Color(204, 204, 204));
        txtRacun.setBorder(null);
        txtRacun.setEnabled(false);

        txtOIB.setBackground(new java.awt.Color(55, 56, 76));
        txtOIB.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        txtOIB.setForeground(new java.awt.Color(204, 204, 204));
        txtOIB.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 178, 255));
        jLabel3.setText("OIB");

        jLabel4.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 178, 255));
        jLabel4.setText("Prezime");

        btnPromjena.setBackground(new java.awt.Color(55, 56, 76));
        btnPromjena.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btnPromjena.setForeground(new java.awt.Color(102, 178, 255));
        btnPromjena.setText("PROMJENA");
        btnPromjena.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPromjena.setEnabled(false);
        btnPromjena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjenaActionPerformed(evt);
            }
        });

        btnBrisanje.setBackground(new java.awt.Color(55, 56, 76));
        btnBrisanje.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btnBrisanje.setForeground(new java.awt.Color(102, 178, 255));
        btnBrisanje.setText("BRISANJE");
        btnBrisanje.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBrisanje.setEnabled(false);
        btnBrisanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrisanjeActionPerformed(evt);
            }
        });

        btnUnos.setBackground(new java.awt.Color(55, 56, 76));
        btnUnos.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btnUnos.setForeground(new java.awt.Color(102, 178, 255));
        btnUnos.setText("UNOS");
        btnUnos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnosActionPerformed(evt);
            }
        });

        lblGreska.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        lblGreska.setForeground(new java.awt.Color(255, 0, 0));

        greskaPrezime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        greskaPrezime.setForeground(new java.awt.Color(255, 51, 0));

        greskaIme.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        greskaIme.setForeground(new java.awt.Color(255, 51, 0));

        greskaOIB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        greskaOIB.setForeground(new java.awt.Color(255, 51, 0));

        greskaRacun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        greskaRacun.setForeground(new java.awt.Color(255, 51, 0));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kusevic/ljetnizadatak/icons/icons8-Plus Filled-50.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnUnos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPromjena, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrisanje, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(greskaPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(greskaOIB, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtRacun, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                    .addComponent(jSeparator3)
                                    .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtOIB, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblGreska, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(greskaRacun, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(203, Short.MAX_VALUE)
                    .addComponent(greskaIme, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(74, 74, 74)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(greskaOIB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(txtOIB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(greskaRacun, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRacun, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(lblGreska, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBrisanje, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUnos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPromjena, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(greskaPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(greskaIme, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(418, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void tabelicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelicaMouseClicked
        this.entitet = (Korisnik) tabelica.getModel().getValueAt(tabelica.getSelectedRow(), 0);
        tabelica.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                tabelica = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = tabelica.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    FormaRacun f = new FormaRacun(entitet.getRacun());
                    f.setVisible(true);
                    instance.setVisible(false);
                }
            }

        });


    }//GEN-LAST:event_tabelicaMouseClicked

    private void btnUnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnosActionPerformed

        greskaIme.setText("");
        greskaOIB.setText("");
        greskaPrezime.setText("");
        greskaRacun.setText("");

        boolean provjeraIme;
        boolean provjeraPrezime;
        boolean provjeraOIB;
        boolean provjeraRacun;
        boolean provjeraOIBpostojeci = false;
        korisnici = HibernateUtil.getSession().createQuery("FROM Korisnik WHERE obrisan=false").list();
        for (Korisnik korisnik : korisnici) {
            if (korisnik.getOib().equals(txtOIB.getText())) {
                provjeraOIBpostojeci = true;
            }
        }

        provjeraIme =  Provjera.provjeriJelText(txtIme.getText());
        provjeraPrezime = Provjera.provjeriJelText(txtPrezime.getText());
        provjeraOIB = (txtOIB.getText().length() != 11);
        provjeraRacun = (txtRacun.getText().length() != 11);

        if (txtIme.getText().isEmpty()) {
            greskaIme.setText("Unesite IME");
        }
        if (txtPrezime.getText().isEmpty()) {
            greskaPrezime.setText("Unesite IME");
        }

        if (provjeraIme == false) {
            greskaIme.setText("ERROR!");
        }
        if (provjeraPrezime == false) {
            greskaPrezime.setText("ERROR!");
        }
        if (provjeraOIB == true) {
            greskaOIB.setText("ERROR!");
        }
        if (provjeraOIBpostojeci == true) {
            greskaOIB.setText("POSTOJEČI OIB");
        }

        if (provjeraRacun == true) {
            greskaRacun.setText("ERROR!");
        }
        if (provjeraPrezime == true && provjeraIme == true && provjeraOIB == false && provjeraOIBpostojeci == false && provjeraRacun == false) {
            entitet = new Korisnik();
            spremi();
            ucitaj();

            FormaRacun fr = new FormaRacun(true);

        }

    }//GEN-LAST:event_btnUnosActionPerformed

    private void btnPromjenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjenaActionPerformed

        Korisnik k = (Korisnik) (tabelica.getModel().getValueAt(tabelica.getSelectedRow(), 0));

        boolean provjeraIme = false;
        boolean provjeraPrezime = false;
        boolean provjeraRacun = true;
        boolean provjeraOIB;

        greskaIme.setText("");
        greskaOIB.setText("");
        greskaPrezime.setText("");
        greskaRacun.setText("");

        provjeraIme = Provjera.onlyLettersSpaces(txtIme.getText());
        provjeraPrezime = Provjera.onlyLettersSpaces(txtPrezime.getText());
        provjeraOIB = (txtOIB.getText().length() != 11);
        provjeraRacun = (txtRacun.getText().length() != 11);

        if (provjeraOIB == true) {
            greskaOIB.setText("ERROR");
        }
        if (provjeraIme == false) {
            greskaIme.setText("ERROR");
        }
        if (provjeraRacun == true) {
            greskaRacun.setText("ERROR");
        }

        if (provjeraPrezime == false) {
            greskaPrezime.setText("ERROR");
        }
        if (provjeraIme == true && provjeraPrezime == true && provjeraOIB == false) {
            entitet.setSifra(k.getSifra());
            entitet.setIme(k.getIme());
            entitet.setOib(k.getOib());
            entitet.setPrezime(k.getPrezime());

            spremi();
            ucitavanje();

        }

    }//GEN-LAST:event_btnPromjenaActionPerformed

    private void btnBrisanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrisanjeActionPerformed
        if (tabelica.getModel().getValueAt(tabelica.getSelectedRow(), 0) == (null)) {
            JOptionPane.showConfirmDialog(rootPane, "Prvo odaberite stavku");
        } else {

            rezultati = HibernateUtil.getSession().createQuery("from Korisnik where obrisan=false").list();
            entitet = (Korisnik) tabelica.getModel().getValueAt(tabelica.getSelectedRow(), 0);

            entitet.setObrisan(true);
            spremi();
            ucitavanje();
        }
    }//GEN-LAST:event_btnBrisanjeActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        rezultati = HibernateUtil.getSession().createQuery("from Korisnik a where a.obrisan=false and "
                + "concat(a.ime, ' ', a.prezime) like :uvjet").setString("uvjet", "%" + txtUvjet.getText() + "%").list();
        ucitavanje();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbRacunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbRacunMouseClicked
        cbImePrezime.setSelected(false);
        cbRacun.setSelected(true);

    }//GEN-LAST:event_cbRacunMouseClicked

    private void cbImePrezimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbImePrezimeMouseClicked
        cbImePrezime.setSelected(true);
        cbRacun.setSelected(false);
    }//GEN-LAST:event_cbImePrezimeMouseClicked

    private void cbRacunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRacunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRacunActionPerformed

    private void tabelicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelicaMousePressed
        this.entitet = (Korisnik) tabelica.getModel().getValueAt(tabelica.getSelectedRow(), 0);
        txtIme.setText(this.entitet.getIme());
        txtPrezime.setText(this.entitet.getPrezime());
        txtOIB.setText(this.entitet.getOib());
        txtRacun.setText(this.entitet.getRacun());
    }//GEN-LAST:event_tabelicaMousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        BigInteger izDatoteke;
        izDatoteke = BigInteger.valueOf(UpisIspisDatoteka.ispisi());
        BigInteger brojRacunaa = new BigInteger("10000000000");
        BigInteger krajnjiBrojRacuna = brojRacunaa.add(izDatoteke);
        txtRacun.setText(krajnjiBrojRacuna.toString());
    }//GEN-LAST:event_jLabel5MousePressed

    private void txtUvjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrisanje;
    private javax.swing.JButton btnPromjena;
    private javax.swing.JButton btnUnos;
    private javax.swing.JCheckBox cbImePrezime;
    private javax.swing.JCheckBox cbRacun;
    private javax.swing.JLabel greskaIme;
    private javax.swing.JLabel greskaOIB;
    private javax.swing.JLabel greskaPrezime;
    private javax.swing.JLabel greskaRacun;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblGreska;
    private javax.swing.JTable tabelica;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOIB;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtRacun;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

}
