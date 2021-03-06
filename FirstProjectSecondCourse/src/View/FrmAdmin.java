/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Purchase;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author pc
 */
public class FrmAdmin extends javax.swing.JFrame {

    private Model.User u;

    /**
     * Creates new form FrmMarket
     */
    public FrmAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        u = new User();
        load();
    }

    public FrmAdmin(Model.User u) {
        initComponents();
        setLocationRelativeTo(null);
        this.u = u;
        load();
    }

    private void sold() {
        DefaultCategoryDataset chart = new DefaultCategoryDataset();
        Controller.Purchase oPurchase = new Controller.Purchase();
        LinkedList<Model.Purchase> mPurchase = oPurchase.select();
        for (int i = 0; i < mPurchase.size(); i++) {
            if (rbMovies.isSelected()) {
                if (mPurchase.get(i).getType().equals("movie")) {
                    chart.setValue(mPurchase.get(i).getCant(), "+ Sold", mPurchase.get(i).getCategory());
                }
            } else {
                if (mPurchase.get(i).getType().equals("music")) {
                    chart.setValue(mPurchase.get(i).getCant(), "+ Sold", mPurchase.get(i).getCategory());
                }
            }
        }
        chart(chart, "+ Sold", "Disc", "Amount");
    }

    private void bought() {
        DefaultCategoryDataset chart = new DefaultCategoryDataset();
        Controller.Purchase oPurchase = new Controller.Purchase();
        LinkedList<Model.Purchase> mPurchase = oPurchase.select();
        for (int i = 0; i < mPurchase.size(); i++) {
            if (rbMovies.isSelected()) {
                if (mPurchase.get(i).getType().equals("movie")) {
                    chart.setValue(mPurchase.get(i).getCant(), "bought", mPurchase.get(i).getUserName());
                }
            } else {
                if (mPurchase.get(i).getType().equals("music")) {
                    chart.setValue(mPurchase.get(i).getCant(), "bought", mPurchase.get(i).getUserName());
                }
            }
        }
        chart(chart, "Bought", "Discs", "Amount");
    }

    private void byDate() {
        String from = txtDesde.getText();
        String to = txtHasta.getText();
        DefaultCategoryDataset chart = new DefaultCategoryDataset();
        Controller.Purchase oPurchase = new Controller.Purchase();
        LinkedList<Model.Purchase> mPurchase = oPurchase.select();
        for (int i = 0; i < mPurchase.size(); i++) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date dateDisc = dateFormat.parse(mPurchase.get(i).getDate());
                Date dateFrom = dateFormat.parse(mPurchase.get(i).getDate());
                Date dateTo = dateFormat.parse(mPurchase.get(i).getDate());
                if (rbMovies.isSelected()) {
                    if ((dateDisc.before(dateFrom)||dateDisc.equals(dateFrom))&&(dateDisc.after(dateTo)||dateDisc.equals(dateTo))&&mPurchase.get(i).getType().equals("music"))  {
                        chart.setValue(mPurchase.get(i).getCant(), "By date", mPurchase.get(i).getDisc());
                    }
                } else {
                    if ((dateDisc.before(dateFrom)||dateDisc.equals(dateFrom))&&(dateDisc.after(dateTo)||dateDisc.equals(dateTo))&&mPurchase.get(i).getType().equals("music"))  {
                        chart.setValue(mPurchase.get(i).getCant(), "By date", mPurchase.get(i).getDisc());
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(FrmAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void hide(boolean permt) {
        btnAccep.setEnabled(permt);
        txtDesde.enable(permt);
        txtHasta.enable(permt);
    }

    private void chart(DefaultCategoryDataset chart, String title, String time, String value) {
        JFreeChart barchart = ChartFactory.createAreaChart(title, time, value, chart, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barChart = barchart.getCategoryPlot();
        barChart.setRangeGridlinePaint(Color.GREEN);
        ChartPanel barPanel = new ChartPanel(barchart);
        pChart.setLayout(new java.awt.BorderLayout());
        pChart.add(barPanel);
        pChart.validate();
    }

    private void load() {
        rbMusic.setSelected(true);
        lblWelcome.setText("Welcome " + u.getName() + "!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnMovies = new javax.swing.JButton();
        btnMusic = new javax.swing.JButton();
        btnPurchases = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnSold = new javax.swing.JButton();
        btnBought = new javax.swing.JButton();
        btnDate = new javax.swing.JButton();
        pChart = new javax.swing.JPanel();
        rbMusic = new javax.swing.JRadioButton();
        rbMovies = new javax.swing.JRadioButton();
        txtDesde = new javax.swing.JTextField();
        txtHasta = new javax.swing.JTextField();
        btnAccep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblWelcome.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("Welcome user!");

        btnClose.setBackground(new java.awt.Color(204, 102, 0));
        btnClose.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Log out");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(357, 357, 357)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(btnClose))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Maintenance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 13))); // NOI18N

        btnMovies.setText("Movies");
        btnMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoviesActionPerformed(evt);
            }
        });

        btnMusic.setText("Music");
        btnMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusicActionPerformed(evt);
            }
        });

        btnPurchases.setText("Purchases");
        btnPurchases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchasesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMovies, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(btnMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPurchases, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMovies, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPurchases, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reports", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 13))); // NOI18N

        btnSold.setText("-/+ Sold");
        btnSold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoldActionPerformed(evt);
            }
        });

        btnBought.setText("+ Bought");
        btnBought.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoughtActionPerformed(evt);
            }
        });

        btnDate.setText("By date");
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBought, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDate, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSold, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBought, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pChart.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout pChartLayout = new javax.swing.GroupLayout(pChart);
        pChart.setLayout(pChartLayout);
        pChartLayout.setHorizontalGroup(
            pChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        pChartLayout.setVerticalGroup(
            pChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
        );

        rbMusic.setBackground(new java.awt.Color(255, 255, 255));
        bgType.add(rbMusic);
        rbMusic.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        rbMusic.setText("Music");

        rbMovies.setBackground(new java.awt.Color(255, 255, 255));
        bgType.add(rbMovies);
        rbMovies.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        rbMovies.setText("Movies");

        txtDesde.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtDesde.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDesde.setText("From");
        txtDesde.setEnabled(false);

        txtHasta.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txtHasta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHasta.setText("To");
        txtHasta.setEnabled(false);

        btnAccep.setText("Accept");
        btnAccep.setEnabled(false);
        btnAccep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccepActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(pChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(rbMusic)
                        .addGap(18, 18, 18)
                        .addComponent(rbMovies))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnAccep, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbMusic)
                            .addComponent(rbMovies))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAccep, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(pChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        FrmMain oMain = new FrmMain();
        oMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoviesActionPerformed
        FrmMoviesMaintenance oMaintenance = new FrmMoviesMaintenance(this, true);
        oMaintenance.setVisible(true);
    }//GEN-LAST:event_btnMoviesActionPerformed

    private void btnMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusicActionPerformed
        FrmMusicMaintenance oMaintenance = new FrmMusicMaintenance(this, true);
        oMaintenance.setVisible(true);
    }//GEN-LAST:event_btnMusicActionPerformed

    private void btnPurchasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchasesActionPerformed
        FrmPurchases oPurchases = new FrmPurchases(this, true);
        oPurchases.setVisible(true);
    }//GEN-LAST:event_btnPurchasesActionPerformed

    private void btnSoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoldActionPerformed
        sold();
    }//GEN-LAST:event_btnSoldActionPerformed

    private void btnBoughtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoughtActionPerformed
        bought();
    }//GEN-LAST:event_btnBoughtActionPerformed

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        hide(true);
    }//GEN-LAST:event_btnDateActionPerformed

    private void btnAccepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccepActionPerformed
        byDate();
    }//GEN-LAST:event_btnAccepActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgType;
    private javax.swing.JButton btnAccep;
    private javax.swing.JButton btnBought;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDate;
    private javax.swing.JButton btnMovies;
    private javax.swing.JButton btnMusic;
    private javax.swing.JButton btnPurchases;
    private javax.swing.JButton btnSold;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pChart;
    private javax.swing.JRadioButton rbMovies;
    private javax.swing.JRadioButton rbMusic;
    private javax.swing.JTextField txtDesde;
    private javax.swing.JTextField txtHasta;
    // End of variables declaration//GEN-END:variables
}
