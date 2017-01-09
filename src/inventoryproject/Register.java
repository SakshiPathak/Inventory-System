/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

import com.inventorysystem.helpers.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Register extends javax.swing.JInternalFrame {
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        populateRoleNameCombo();
    }
    
    public void clear() {

         
        txtusername.setText("");
        txtpassword.setText("");
       comborolename.setSelectedIndex(-1);
        
    }
    
    private void populateRoleNameCombo() {
    try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from role order by name");
        
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
            comborolename.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnregister = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();
        btnrefresh = new javax.swing.JButton();
        comborolename = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Register User");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register Form", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("User Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Role Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Password");

        btnregister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnregister.setText("Register");
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });

        btnrefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnrefresh.setText("Refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        comborolename.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comborolenameItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(93, 93, 93))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(92, 92, 92)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusername, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(comborolename, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnregister, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comborolename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnregister)
                    .addComponent(btnrefresh))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
        // TODO add your handling code here:
        String username=txtusername.getText();
        String password=String.valueOf(txtpassword.getPassword());
        
        if(username.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Username field is empty...please fill it first");
        }
        else if(password.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Password field is empty...please fill it first");
        }
        
        else if(!(Pattern.matches("^[a-zA-Z ,]+$", txtusername.getText())))
        {
            JOptionPane.showMessageDialog(this, "Please enter valid username");
        }
        else if(password.length()>8)
        {
            JOptionPane.showMessageDialog(this, "Password should not greater than 8 characters");
        }
       /* else if(comborolename.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
        }*/
        else
        {
            
        boolean unique = true;
             try
             {
                 con=DBConnection.getConnection();
            pst = con.prepareStatement("select Password from user");
            rs = pst.executeQuery();
            
            
            int c=0;
            while(rs.next())
            {
            c++;
            String pass=rs.getString("password");
            
            if (password.equals(pass))
            {
	  JOptionPane.showMessageDialog(this, "Password already exists");
          unique = false;
            }
            
            }
         
            if(unique)
            {
                
            pst = con.prepareStatement("select id from role where name = ?");
            pst.setString(1, comborolename.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            rs.next();
            int roleID = rs.getInt("id");
            pst=con.prepareStatement("insert into user(username,password,role_id) values(?,?,?)");
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setInt(3, roleID);
            
            int i=pst.executeUpdate();
          
            if(i>0)
            {
            JOptionPane.showMessageDialog(this, "Added Successfully");
           clear();
             
            }
           
            else
            {
                JOptionPane.showMessageDialog(this, "Not added Successfully");
            }
          
        }
             }
             
             catch(Exception e)
             {
                 JOptionPane.showMessageDialog(this, e);
             }
         }

        

    }//GEN-LAST:event_btnregisterActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void comborolenameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comborolenameItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comborolenameItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnregister;
    private javax.swing.JComboBox comborolename;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
