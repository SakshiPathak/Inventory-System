/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Customer extends javax.swing.JInternalFrame {

    private String Gender;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<CustomerClass> customerList;

    /**
     * Creates new form Customer
     */
    public Customer() {
        initComponents();
        customerList = new ArrayList<>();
        populateCustomerNameCombo();
        
    }

    public void clear() {
        //txtcustomerid.setText("");
        txtfirstname.setText("");
        txtlastname.setText("");
        txtemailid.setText("");
        txtaddress.setText("");
        txtcity.setText("");
        txtpincode.setText("");
        txtstate.setText("");
        txtphoneno.setText("");
        combocustomername.setSelectedIndex(0);
        combocustomertype.setSelectedIndex(0);
    }
//    
//    public ArrayList<CustomerClass> getCustomerList()
//    {
//        ArrayList<CustomerClass> customerList=new ArrayList<CustomerClass>();
//        Connection con=null;
//        ResultSet rs=null;
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorysystem","root","sakshi");
//            Statement st=con.createStatement();
//            rs=st.executeQuery("select ID,First_Name from customer");
//            CustomerClass customer;
//            while(rs.next())
//            {
//            customer=new CustomerClass(rs.getString("First_Name"), rs.getString("Last_Name"), rs.getString("Gender"), rs.getString("Email"), rs.getString("Address"), rs.getString("City"), rs.getString("Pincode"), rs.getString("State"), rs.getString("Phone"), rs.getString("Customer_Type"));
//            customerList.add(customer);
//            }
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//        return customerList;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtfirstname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtlastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        radiomale = new javax.swing.JRadioButton();
        radiofemale = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtemailid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtpincode = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtstate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtphoneno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        combocustomertype = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        combocustomername = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Customer Detail");
        setName("customer"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Basic Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 51, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("First Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Gender");

        buttonGroup1.add(radiomale);
        radiomale.setText("Male");
        radiomale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiomaleActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiofemale);
        radiofemale.setText("Female");
        radiofemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiofemaleActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Email ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Address");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("City");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Pin Code");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("State");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Phone No");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Customer Type");

        combocustomertype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal Customer", "Regular Customer", "Frequent Customer", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(148, 148, 148)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radiomale)
                        .addGap(38, 38, 38)
                        .addComponent(radiofemale))
                    .addComponent(txtlastname)
                    .addComponent(txtfirstname)
                    .addComponent(txtemailid)
                    .addComponent(txtaddress)
                    .addComponent(txtcity)
                    .addComponent(txtpincode)
                    .addComponent(txtstate)
                    .addComponent(txtphoneno)
                    .addComponent(combocustomertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtfirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radiomale)
                    .addComponent(radiofemale))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtemailid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtpincode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtstate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(combocustomertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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
                .addGap(23, 23, 23)
                .addComponent(btnsave)
                .addGap(37, 37, 37)
                .addComponent(btnupdate)
                .addGap(35, 35, 35)
                .addComponent(btndelete)
                .addGap(28, 28, 28)
                .addComponent(btnrefresh)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnupdate)
                    .addComponent(btndelete)
                    .addComponent(btnrefresh))
                .addGap(35, 35, 35))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Search by Name");

        combocustomername.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combocustomernameItemStateChanged(evt);
            }
        });
        combocustomername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocustomernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(combocustomername, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combocustomername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radiomaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiomaleActionPerformed
        // TODO add your handling code here:
        Gender = "M";
    }//GEN-LAST:event_radiomaleActionPerformed

    private void radiofemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiofemaleActionPerformed
        // TODO add your handling code here:
        Gender = "F";
    }//GEN-LAST:event_radiofemaleActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String firstname = txtfirstname.getText();
        String lastname = txtlastname.getText();
        String emailid = txtemailid.getText();
        String address = txtaddress.getText();
        String city = txtcity.getText();
        String pincode = txtpincode.getText();
        String state = txtstate.getText();
        String phoneno = txtphoneno.getText();
        String customertype = combocustomertype.getSelectedItem().toString();
        if (firstname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First Name field is empty... please fill it first!!");
        } else if (lastname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last Name field is empty... please fill it first!!");
        } else if (emailid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email ID field is empty... please fill it first!!");
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address field is empty... please fill it first!!");
        } else if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "City field is empty... please fill it first!!");
        } else if (pincode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pincode field is empty... please fill it first!!");
        } else if (state.isEmpty()) {
            JOptionPane.showMessageDialog(this, "State field is empty... please fill it first!!");
        } else if (phoneno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone No field is empty... please fill it first!!");
        } else if (!(Pattern.matches("^[a-zA-Z ,]+$", txtfirstname.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
        } else if (!(Pattern.matches("^[a-zA-Z ,]+$", txtlastname.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
        } else if (!(Pattern.matches("^[A-Za-z0-9]+[@]{1}+[A-Za-z0-9]+[.]{1}+[A-Za-z0-9]+$", txtemailid.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid email id");
        } else if (!(Pattern.matches("^[a-zA-Z ,]+$", txtcity.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid city");
        } else if (!(Pattern.matches("^[0-9]+", txtpincode.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid pincode");
        } else if (!(Pattern.matches("^[a-zA-Z ,]+$", txtstate.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid state");
        } else if (!(phoneno.matches("\\d{10}"))) {
            JOptionPane.showMessageDialog(this, "Please enter 10 digit phone no");
        } else if (combocustomertype.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
        } else {
            boolean unique = true;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sakshi");
                Statement st = con.createStatement();
                rs = st.executeQuery("select Email,Address,Phone from customer");

                int c = 0;
                while (rs.next()) {
                    c++;
                    String eid = rs.getString("Email");
                    String add = rs.getString("Address");
                    String phno = rs.getString("Phone");

                    if (emailid.equals(eid)) {
                        JOptionPane.showMessageDialog(this, "Email ID already exists");
                        unique = false;
                    } else if (address.equals(add)) {
                        JOptionPane.showMessageDialog(this, "Address already exists");
                        unique = false;
                    } else if (phoneno.equals(phno)) {
                        JOptionPane.showMessageDialog(this, "Phone no already exists");
                        unique = false;
                    }

                }

                if (unique) {
                    pst = con.prepareStatement("insert into customer(First_Name,Last_Name,Gender,Email,Address,City,Pincode,State,Phone,Customer_Type) values(?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, firstname);
                    pst.setString(2, lastname);
                    pst.setString(3, Gender);
                    pst.setString(4, emailid);
                    pst.setString(5, address);
                    pst.setString(6, city);
                    pst.setString(7, pincode);
                    pst.setString(8, state);
                    pst.setString(9, phoneno);
                    pst.setString(10, customertype);
                    int i = pst.executeUpdate();

                    if (i > 0) {
                        JOptionPane.showMessageDialog(this, "Added Successfully");
                        clear();

                    } else {
                        JOptionPane.showMessageDialog(this, "Not added Successfully");
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }

    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        //String customerid=txtcustomerid.getText();
        String firstname = txtfirstname.getText();
        String lastname = txtlastname.getText();
        String emailid = txtemailid.getText();
        String address = txtaddress.getText();
        String city = txtcity.getText();
        String pincode = txtpincode.getText();
        String state = txtstate.getText();
        String phoneno = txtphoneno.getText();
        String customertype = combocustomertype.getSelectedItem().toString();
        if (firstname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First Name field is empty... please fill it first!!");
        } else if (lastname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last Name field is empty... please fill it first!!");
        } else if (emailid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email ID field is empty... please fill it first!!");
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address field is empty... please fill it first!!");
        } else if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "City field is empty... please fill it first!!");
        } else if (pincode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pincode field is empty... please fill it first!!");
        } else if (state.isEmpty()) {
            JOptionPane.showMessageDialog(this, "State field is empty... please fill it first!!");
        } else if (phoneno.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phone No field is empty... please fill it first!!");
        } else if (!(Pattern.matches("^[a-zA-Z ,]+$", txtfirstname.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
        } else if (!(Pattern.matches("^[a-zA-Z ,]+$", txtlastname.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
        } else if (!(Pattern.matches("^[A-Za-z0-9]+[@]{1}+[A-Za-z0-9]+[.]{1}+[A-Za-z0-9]+$", txtemailid.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid email id");
        } else if (!(Pattern.matches("^[a-zA-Z ,]+$", txtcity.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid city");
        } else if (!(Pattern.matches("^[0-9]+", txtpincode.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid pincode");
        } else if (!(Pattern.matches("^[a-zA-Z ,]+$", txtstate.getText()))) {
            JOptionPane.showMessageDialog(this, "Please enter valid state");
        } else if (!(phoneno.matches("\\d{10}"))) {
            JOptionPane.showMessageDialog(this, "Please enter 10 digit phone no");
        } else if (combocustomertype.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
        } else {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sakshi");
                pst = con.prepareStatement("update customer set Last_Name=?,Gender=?,Email=?,Address=?,City=?,Pincode=?,State=?,Phone=?,Customer_Type=? where ID=?");

                pst.setString(1, lastname);
                pst.setString(2, Gender);
                pst.setString(3, emailid);
                pst.setString(4, address);
                pst.setString(5, city);
                pst.setString(6, pincode);
                pst.setString(7, state);
                pst.setString(8, phoneno);
                pst.setString(9, customertype);
                //pst.setString(10, firstname);
                pst.setInt(10, Integer.parseInt(customerList.get(combocustomername.getSelectedIndex()-1).getId()));
                int i = pst.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(this, "Updated Successfully");
                    clear();
                } else {
                    JOptionPane.showMessageDialog(this, "Not updated Successfully");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e);
            }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
      // String firstname = txtfirstname.getText();
        /*if(customerid.isEmpty())
         {
         JOptionPane.showMessageDialog(this, "Customer ID field is empty...please fill it first");
         }
         else if(!(Pattern.matches("^[0-9]+", txtcustomerid.getText())))
         {
         JOptionPane.showMessageDialog(this, "Please enter valid Customer id");
         }*/
        //else
        //{
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sakshi");
            pst = con.prepareStatement("DELETE FROM customer WHERE ID=?");
            pst.setInt(1, Integer.parseInt(customerList.get(combocustomername.getSelectedIndex()-1).getId()));
            int i = pst.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "data deleted successfully");
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "data not found");
               // txtcustomerid.setText("");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //}
    }//GEN-LAST:event_btndeleteActionPerformed

    private void combocustomernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocustomernameActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_combocustomernameActionPerformed

    private void combocustomernameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combocustomernameItemStateChanged
        try {
            if (customerList == null)
                return;
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sakshi");
            pst = con.prepareStatement("SELECT * FROM customer WHERE ID = ?");
            //System.out.println(Integer.parseInt(customerList.get(combocustomername.getSelectedIndex()).getId()));
            
            System.out.println(customerList.size());
            
            pst.setInt(1, Integer.parseInt(customerList.get(combocustomername.getSelectedIndex()-1).getId()));

            ResultSet rs = pst.executeQuery();
            rs.next();

            txtfirstname.setText(rs.getString("First_Name"));
            txtlastname.setText(rs.getString("Last_Name"));
            txtemailid.setText(rs.getString("Email"));
            txtaddress.setText(rs.getString("Address"));
            txtcity.setText(rs.getString("City"));
            txtpincode.setText(rs.getString("Pincode"));
            txtstate.setText(rs.getString("State"));
            txtphoneno.setText(rs.getString("Phone"));
            combocustomertype.setSelectedItem(rs.getString("Customer_Type"));

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_combocustomernameItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox combocustomername;
    private javax.swing.JComboBox combocustomertype;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton radiofemale;
    private javax.swing.JRadioButton radiomale;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtemailid;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtphoneno;
    private javax.swing.JTextField txtpincode;
    private javax.swing.JTextField txtstate;
    // End of variables declaration//GEN-END:variables

    private void populateCustomerNameCombo() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sakshi");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM CUSTOMER ORDER BY First_Name");

            ResultSet rs = pstmt.executeQuery();
            int index = 1;
            Item tItem = new Item(0, "Select Customer...");
            model.addElement(tItem);
            
            while (rs.next()) {
               // combocustomername.addItem(rs.getString("First_Name"));
                Item item = new Item(index++, rs.getString("First_Name"));
                model.addElement(item);
                
                customerList.add(
                        new CustomerClass(
                                String.valueOf(rs.getInt("ID")), 
                                rs.getString("First_Name"),
                                rs.getString("Last_Name"),
                                rs.getString("Gender"), 
                                rs.getString("Email"),
                                rs.getString("Address"),
                                rs.getString("City"),
                                String.valueOf(rs.getInt("Pincode")),
                                rs.getString("State"),
                                rs.getString("Phone"),
                                rs.getString("Customer_Type")
                        ));
            }

            combocustomername.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
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
}
