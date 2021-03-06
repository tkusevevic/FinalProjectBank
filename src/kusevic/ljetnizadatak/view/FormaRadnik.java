/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kusevic.ljetnizadatak.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import kusevic.ljetnizadatak.controller.Obrada;
import kusevic.ljetnizadatak.controller.Provjera;
import kusevic.ljetnizadatak.model.Radnik;
import kusevic.ljetnizadatak.model.RadnoMjesto;
import kusevic.ljetnizadatak.pomocno.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Tomislav
 */
public class FormaRadnik extends Forma<Radnik> implements EnablingButtons {

    private List<Radnik> rezultati;
    private DefaultTreeModel modelStabla;
    private boolean ucitavam;

    public FormaRadnik() {
        initComponents();
        nakonInitComponents();
        obrada = new Obrada();
        provjeriJelOdabran();
        ucitaj();

    }

    @Override
    protected void ucitaj() {
        Session session = HibernateUtil.getSession();
        session.clear();
        List<Radnik> nadredeni = new ArrayList<>();
        nadredeni = HibernateUtil.getSession().createQuery("FROM Radnik WHERE obrisan=false").list();
        for (Radnik r : nadredeni) {
            cmbNadredeni.setSelectedItem(r);
        }
        rezultati = HibernateUtil.getSession().createQuery("FROM "
                + " Radnik a WHERE a.obrisan=false and nadredeni is null").list();
        DefaultComboBoxModel<Radnik> model = new DefaultComboBoxModel<>();
        cmbNadredeni.setModel(model);

        ucitavanje();

    }

    private void ucitavanje() {
        ucitavam = true;
        modelStabla = (DefaultTreeModel) stablo.getModel();

        modelStabla.setRoot(null);

        DefaultMutableTreeNode root = new DefaultMutableTreeNode();

        root.setUserObject("Radnici");

        DefaultMutableTreeNode node;
        for (Radnik radnik : rezultati) {
            node = new DefaultMutableTreeNode(radnik);
            root.add(node);
            ucitajStablo(node, radnik);
        }
        modelStabla.setRoot(root);
        stablo.expandPath(new TreePath(root.getPath()));
        ucitavam = false;
    }

    private void ucitajStablo(DefaultMutableTreeNode node, Radnik radnik) {
        if (radnik.getPodredeni() == null) {
            return;
        }
        DefaultMutableTreeNode podredeniNode;
        for (Radnik podredeniRadnik : radnik.getPodredeni()) {
            podredeniNode = new DefaultMutableTreeNode(podredeniRadnik);
            node.add(podredeniNode);
            ucitajStablo(podredeniNode, podredeniRadnik);
        }

    }

    @Override
    public void provjeriJelOdabran() {
        stablo.addTreeSelectionListener((new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) stablo.getLastSelectedPathComponent();

                if (node == null) {
                    return;
                }
                

                btnUnos.setEnabled(true);
                btnPromjena.setEnabled(true);
                btnBrisanje.setEnabled(true);

            }
        }));
    }

    @Override

    protected void spremi() {
        entitet.setIme(txtIme.getText());
        entitet.setPrezime(txtPrezime.getText());
        entitet.setOIB(txtOIB.getText());
        Radnik p = (Radnik) cmbNadredeni.getSelectedItem();
        entitet.setNadredeni(p.getSifra().equals(new Long(0)) ? null : p);
        super.spremi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stablo = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtIme = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        lblNadređeni = new javax.swing.JLabel();
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
        greskaPrezime = new javax.swing.JLabel();
        greskaIme = new javax.swing.JLabel();
        greskaOIB = new javax.swing.JLabel();
        greskaOIB1 = new javax.swing.JLabel();
        cmbNadredeni = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Radnici");
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(38, 40, 55));

        stablo.setBackground(new java.awt.Color(38, 40, 55));
        stablo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        stablo.setForeground(new java.awt.Color(102, 178, 255));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        stablo.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        stablo.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                stabloValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(stablo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(55, 56, 76));

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

        lblNadređeni.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        lblNadređeni.setForeground(new java.awt.Color(102, 178, 255));
        lblNadređeni.setText("Nadređeni");

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
        btnUnos.setEnabled(false);
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

        greskaOIB1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        greskaOIB1.setForeground(new java.awt.Color(255, 51, 0));

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
                        .addComponent(btnBrisanje, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(greskaPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(greskaOIB, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblGreska, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator3)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(txtIme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(txtOIB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(49, 49, 49))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblNadređeni, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(greskaOIB1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 55, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(193, Short.MAX_VALUE)
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
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(txtOIB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(greskaOIB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(greskaPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addComponent(lblNadređeni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 164, Short.MAX_VALUE)
                        .addComponent(greskaOIB1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(122, 122, 122)
                .addComponent(lblGreska, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBrisanje, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUnos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPromjena, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(greskaIme, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(418, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(cmbNadredeni, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbNadredeni, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnosActionPerformed
         if (Provjera.provjeriJelText(txtIme.getText()) == false) {
            greskaIme.setText("ERROR");
        }
        if (Provjera.provjeriJelText(txtPrezime.getText()) == false) {
            greskaPrezime.setText("ERROR");
        }
        if(txtOIB.getText().length()!=11){
            greskaOIB.setText("ERROR");
        }
        
        if (Provjera.provjeriJelText(txtIme.getText()) == true && Provjera.provjeriJelText(txtPrezime.getText()) == true && txtOIB.getText().length()==11) {
           
        entitet = new Radnik();
        spremi();
    }
    }//GEN-LAST:event_btnUnosActionPerformed

    private void btnBrisanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrisanjeActionPerformed
        entitet.setObrisan(true);
        spremi();
    }//GEN-LAST:event_btnBrisanjeActionPerformed

    private void btnPromjenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjenaActionPerformed
        if (Provjera.provjeriJelText(txtIme.getText()) == false) {
            greskaIme.setText("ERROR");
        }
        if (Provjera.provjeriJelText(txtPrezime.getText()) == false) {
            greskaPrezime.setText("ERROR");
        }
        if(txtOIB.getText().length()!=11){
            greskaOIB.setText("ERROR");
        }
        
        if (Provjera.provjeriJelText(txtIme.getText()) == true && Provjera.provjeriJelText(txtPrezime.getText()) == true && txtOIB.getText().length()==11) {
           
        spremi();
        }
    }//GEN-LAST:event_btnPromjenaActionPerformed

    private void ucitajComboBox() {

        DefaultComboBoxModel<Radnik> m = new DefaultComboBoxModel<>();
        cmbNadredeni.setModel(m);

        Radnik root = new Radnik();
        root.setIme("Root");
        root.setPrezime("");
        root.setSifra(new Long(0));
        m.addElement(root);

        List<Radnik> nadredeni = HibernateUtil.getSession().
                createQuery("from Radnik a where "
                        + "a.obrisan=false and a.sifra!=:sifra ")
                .setLong("sifra", entitet.getSifra()).list();

        for (Radnik p : nadredeni) {

            m.addElement(p);
            if (entitet.getNadredeni() != null && entitet.getNadredeni().getSifra().equals(p.getSifra())) {
                cmbNadredeni.setSelectedItem(p);
            }
        }
    }


    private void stabloValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_stabloValueChanged
        if (ucitavam) {
            return;
        }

        DefaultMutableTreeNode node
                = (DefaultMutableTreeNode) stablo.getLastSelectedPathComponent();

        if (node.getUserObject().getClass() != new Radnik().getClass()) {
            return;
        }

        this.entitet = (Radnik) node.getUserObject();
        this.txtIme.setText(entitet.getIme());
        this.txtPrezime.setText(entitet.getPrezime());
        this.txtOIB.setText(entitet.getOIB());

        ucitajComboBox();
    }//GEN-LAST:event_stabloValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrisanje;
    private javax.swing.JButton btnPromjena;
    private javax.swing.JButton btnUnos;
    private javax.swing.JComboBox<Radnik> cmbNadredeni;
    private javax.swing.JLabel greskaIme;
    private javax.swing.JLabel greskaOIB;
    private javax.swing.JLabel greskaOIB1;
    private javax.swing.JLabel greskaPrezime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblGreska;
    private javax.swing.JLabel lblNadređeni;
    private javax.swing.JTree stablo;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOIB;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

}
