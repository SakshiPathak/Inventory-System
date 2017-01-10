/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

import java.awt.Toolkit;

/**
 *
 * @author HP
 */
public class Menu extends javax.swing.JFrame {
    
    private int roleId;
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
    }

    public Menu(int roleId) {
        this.roleId = roleId;
        initComponents();
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
    
        if (roleId != 1) {
            mnuadmin.setEnabled(false);
           // mnucustomerdetail.setEnabled(false);
            mnucategorydetail.setEnabled(false);
            mnuproductdetail.setEnabled(false);
            mnureport.setEnabled(false);
            mnuregister.setEnabled(false);
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktoppane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnulogout = new javax.swing.JMenu();
        mnuexit = new javax.swing.JMenuItem();
        mnuadmin = new javax.swing.JMenu();
        mnusupplier = new javax.swing.JMenuItem();
        mnurole = new javax.swing.JMenuItem();
        mnucustomerdetail = new javax.swing.JMenu();
        mnucustomer = new javax.swing.JMenuItem();
        mnucategorydetail = new javax.swing.JMenu();
        mnucategory = new javax.swing.JMenuItem();
        mnuproductdetail = new javax.swing.JMenu();
        mnuproduct = new javax.swing.JMenuItem();
        mnubillgenerate = new javax.swing.JMenu();
        mnubill = new javax.swing.JMenuItem();
        mnureport = new javax.swing.JMenu();
        mnustockreport = new javax.swing.JMenuItem();
        mnureorderreport = new javax.swing.JMenuItem();
        mnubillreport = new javax.swing.JMenuItem();
        mnuregister = new javax.swing.JMenu();
        mnustockreport1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktoppaneLayout = new javax.swing.GroupLayout(desktoppane);
        desktoppane.setLayout(desktoppaneLayout);
        desktoppaneLayout.setHorizontalGroup(
            desktoppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        desktoppaneLayout.setVerticalGroup(
            desktoppaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        mnulogout.setText("File");

        mnuexit.setText("Logout");
        mnuexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuexitActionPerformed(evt);
            }
        });
        mnulogout.add(mnuexit);

        jMenuBar1.add(mnulogout);

        mnuadmin.setText("Admin Details");

        mnusupplier.setText("Add/Update/Delete Supplier");
        mnusupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnusupplierActionPerformed(evt);
            }
        });
        mnuadmin.add(mnusupplier);

        mnurole.setText("Assign Role");
        mnurole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuroleActionPerformed(evt);
            }
        });
        mnuadmin.add(mnurole);

        jMenuBar1.add(mnuadmin);

        mnucustomerdetail.setText("Customer Details");

        mnucustomer.setText("Add/Update/Delete Customer");
        mnucustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnucustomerActionPerformed(evt);
            }
        });
        mnucustomerdetail.add(mnucustomer);

        jMenuBar1.add(mnucustomerdetail);

        mnucategorydetail.setText("Category Details");

        mnucategory.setText("Add/Delete Category");
        mnucategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnucategoryActionPerformed(evt);
            }
        });
        mnucategorydetail.add(mnucategory);

        jMenuBar1.add(mnucategorydetail);

        mnuproductdetail.setText("Product Details");

        mnuproduct.setText("Add Product");
        mnuproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuproductActionPerformed(evt);
            }
        });
        mnuproductdetail.add(mnuproduct);

        jMenuBar1.add(mnuproductdetail);

        mnubillgenerate.setText("Billing");

        mnubill.setText("Generate Bill");
        mnubill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnubillActionPerformed(evt);
            }
        });
        mnubillgenerate.add(mnubill);

        jMenuBar1.add(mnubillgenerate);

        mnureport.setText("Report");

        mnustockreport.setText("Product Report");
        mnustockreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnustockreportActionPerformed(evt);
            }
        });
        mnureport.add(mnustockreport);

        mnureorderreport.setText("Stock Reorder Report");
        mnureorderreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnureorderreportActionPerformed(evt);
            }
        });
        mnureport.add(mnureorderreport);

        mnubillreport.setText("Bill Report");
        mnubillreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnubillreportActionPerformed(evt);
            }
        });
        mnureport.add(mnubillreport);

        jMenuBar1.add(mnureport);

        mnuregister.setText("Register User");

        mnustockreport1.setText("Registration");
        mnustockreport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnustockreport1ActionPerformed(evt);
            }
        });
        mnuregister.add(mnustockreport1);

        jMenuBar1.add(mnuregister);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktoppane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktoppane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnusupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnusupplierActionPerformed
        // TODO add your handling code here:
        Supplier sup=new Supplier();
        desktoppane.add(sup);
        sup.setVisible(true);
    }//GEN-LAST:event_mnusupplierActionPerformed

    private void mnuroleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuroleActionPerformed
        // TODO add your handling code here:
        Role role=new Role();
        desktoppane.add(role);
        role.setVisible(true);
    }//GEN-LAST:event_mnuroleActionPerformed

    private void mnucustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnucustomerActionPerformed
        // TODO add your handling code here:
        Customer cust=new Customer();
        desktoppane.add(cust);
        cust.setVisible(true);
    }//GEN-LAST:event_mnucustomerActionPerformed

    private void mnucategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnucategoryActionPerformed
        // TODO add your handling code here:
        Category category=new Category();
        desktoppane.add(category);
        category.setVisible(true);
    }//GEN-LAST:event_mnucategoryActionPerformed

    private void mnuproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuproductActionPerformed
        // TODO add your handling code here:
        Product prod=new Product();
        desktoppane.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_mnuproductActionPerformed

    private void mnuexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuexitActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_mnuexitActionPerformed

    private void mnubillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnubillActionPerformed
        // TODO add your handling code here:
        Bill bill=new Bill(desktoppane);
        desktoppane.add(bill);
        bill.setVisible(true);
    }//GEN-LAST:event_mnubillActionPerformed

    private void mnustockreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnustockreportActionPerformed
        // TODO add your handling code here:
        ProductReport pr=new ProductReport();
        desktoppane.add(pr);
        pr.setVisible(true);
    }//GEN-LAST:event_mnustockreportActionPerformed

    private void mnustockreport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnustockreport1ActionPerformed
        // TODO add your handling code here:
        Register reg=new Register();
        desktoppane.add(reg);
        reg.setVisible(true);
    }//GEN-LAST:event_mnustockreport1ActionPerformed

    private void mnureorderreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnureorderreportActionPerformed
        ReorderReport reorder=new ReorderReport();
        desktoppane.add(reorder);
        reorder.setVisible(true);
    }//GEN-LAST:event_mnureorderreportActionPerformed

    private void mnubillreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnubillreportActionPerformed
        BillReport bill=new BillReport();
        desktoppane.add(bill);
        bill.setVisible(true);
    }//GEN-LAST:event_mnubillreportActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktoppane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnuadmin;
    private javax.swing.JMenuItem mnubill;
    private javax.swing.JMenu mnubillgenerate;
    private javax.swing.JMenuItem mnubillreport;
    private javax.swing.JMenuItem mnucategory;
    private javax.swing.JMenu mnucategorydetail;
    private javax.swing.JMenuItem mnucustomer;
    private javax.swing.JMenu mnucustomerdetail;
    private javax.swing.JMenuItem mnuexit;
    private javax.swing.JMenu mnulogout;
    private javax.swing.JMenuItem mnuproduct;
    private javax.swing.JMenu mnuproductdetail;
    private javax.swing.JMenu mnuregister;
    private javax.swing.JMenuItem mnureorderreport;
    private javax.swing.JMenu mnureport;
    private javax.swing.JMenuItem mnurole;
    private javax.swing.JMenuItem mnustockreport;
    private javax.swing.JMenuItem mnustockreport1;
    private javax.swing.JMenuItem mnusupplier;
    // End of variables declaration//GEN-END:variables
}
