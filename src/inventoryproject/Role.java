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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Role extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    List<RoleClass> roleList;
   
    

    /**
     * Creates new form Role
     */
    public Role() {
        initComponents();
        roleList = new ArrayList<>();
        populateRoleNameCombo();
        btndelete.setVisible(false);
    }
    public void clear() {
        //roleList.clear();
         txtname.setText("");
        // combopermission.setSelectedIndex(0);
         comborolename.setSelectedIndex(0);
         }
    
    private void populateRoleNameCombo() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
    try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from role order by name");
        
        ResultSet rs = pstmt.executeQuery();
        int index = 1;
            Role.Item tItem = new Role.Item(0, "Select Role...");
            model.addElement(tItem);
            roleList = new ArrayList<>();
            while (rs.next()) {
               // combocustomername.addItem(rs.getString("First_Name"));
                Role.Item item = new Role.Item(index++, rs.getString("name"));
                model.addElement(item);
                
                roleList.add(
                        new RoleClass(String.valueOf(rs.getInt("id")), 
                                rs.getString("name")));
                               
//                                rs.getString("permission")
                                
                            
                        
            }

            comborolename.setModel(model);
        
    } catch (SQLException ex) {
        Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    class Item {
        private int index;
        private String name;

        public Item(int index, String name) {
            this.index = index;
            this.name = name;
        }

        @Override
        public String toString() {
            return name; //To change body of generated methods, choose Tools | Templates.
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
        txtname = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comborolename = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Role Assign");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Role Assigned", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(143, 143, 143)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnsave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnrefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnrefresh.setText("Refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsave)
                .addGap(18, 18, 18)
                .addComponent(btnupdate)
                .addGap(18, 18, 18)
                .addComponent(btndelete)
                .addGap(18, 18, 18)
                .addComponent(btnrefresh)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnupdate)
                    .addComponent(btndelete)
                    .addComponent(btnrefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Search by Name");

        comborolename.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comborolenameItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(comborolename, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comborolename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String name=txtname.getText();
      //  String permission=combopermission.getSelectedItem().toString();
        if(name.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Name field is empty... please fill it first!!");
        }
       /* else if(combopermission.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
        }*/
        else if(!(Pattern.matches("^[a-zA-Z ,]+$", txtname.getText())))
        {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
        }
        else
        {
            try
            {
                con=DBConnection.getConnection();
                pst=con.prepareStatement("insert into role(name) values(?)");
                pst.setString(1, name);
//                pst.setString(2, permission);
                int i=pst.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this, "Added Successfully");
                    txtname.setText("");
               //     combopermission.setSelectedIndex(0);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Not added Successfully");
                }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
        }
        populateRoleNameCombo();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        // String rolename = (String) comborolename.getSelectedItem();
        String name=txtname.getText();
//        String permission=combopermission.getSelectedItem().toString();
        /*if(roleid.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Role id field is empty...please fill it first");
            }
            else if(!(Pattern.matches("^[0-9]+", txtroleid.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid role id");
            }*/
             if(name.isEmpty())
            {
            JOptionPane.showMessageDialog(this, "Name field is empty... please fill it first!!");
            }
/*            else if(combopermission.getSelectedItem().toString().equals(""))
            {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
            }*/
        else if(!(Pattern.matches("^[a-zA-Z ,]+$", txtname.getText())))
        {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
        }
        
        else
        {
            try
            {
                con=DBConnection.getConnection();
                pst=con.prepareStatement("update role set name=? where id=?");
                
                pst.setString(1, name);
//                pst.setString(2, permission);
                
                pst.setInt(2, Integer.parseInt(roleList.get(comborolename.getSelectedIndex()-1).getId()));
                int i=pst.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this, "Updated Successfully");
                    clear();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Not updated Successfully");
                }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
        }
        populateRoleNameCombo();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
       // String name=txtname.getText();
        //String permission=combopermission.getSelectedItem().toString();
        /*if(roleid.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Role id field is empty...please fill it first");
        }
        else if(!(Pattern.matches("^[0-9]+", txtroleid.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid role id");
            }*/
        //else
        //{
        try
        {
            
            con=DBConnection.getConnection();
            pst=con.prepareStatement("delete from role where id=?");
            pst.setInt(1, Integer.parseInt(roleList.get(comborolename.getSelectedIndex()-1).getId()));
            int i=pst.executeUpdate();
            if(i>0)
            {
               JOptionPane.showMessageDialog(this, "data deleted successfully");
                    clear();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "data not found");
                //txtroleid.setText("");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        populateRoleNameCombo();
      //}
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnrefreshActionPerformed

    int selectedRoleId = 0;
    private void comborolenameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comborolenameItemStateChanged
        // TODO add your handling code here:
        try {
        
        /*String selectedName = (String) comborolename.getSelectedItem();
        
        if(selectedName.equals("") || selectedName == null)
            return;*/
             if (roleList == null || comborolename.getSelectedIndex() == 0)
                return;
        
        con = DBConnection.getConnection();
        pst = con.prepareStatement("select * from role where id=?");
        //pst.setString(1, selectedName);
        pst.setInt(1, Integer.parseInt(roleList.get(comborolename.getSelectedIndex()-1).getId()));
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        
        txtname.setText(rs.getString("name"));
       // combopermission.setSelectedItem(rs.getString("permission"));
        selectedRoleId = comborolename.getSelectedIndex();
    } catch (SQLException ex) {
        Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_comborolenameItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox comborolename;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
