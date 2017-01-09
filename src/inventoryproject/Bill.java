/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

import com.inventorysystem.helpers.DBConnection;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.DesktopPaneUI;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
/**
 *
 * @author HP
 */
public class Bill extends javax.swing.JInternalFrame {
    Connection con;
    PreparedStatement pst;
    List<CustomerClass> billList;
    List<ProductBillClass> productList;
    
    
    //DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
    //JFormattedTextField txtdate = new JFormattedTextField(format);
    //JFormattedTextField dateField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
    //dateField.setValue(new java.util.Date());
    /*SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    Date today=new Date();
        String date = DATE_FORMAT.format(today);
        txtdate.setValue(date);*/
       /* Date date=new Date();
        SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-mm-dd");
                    String newdate = formatdate.format(date);
                    //txtdate.setText(newdate);
                    System.out.println(newdate);*/
                    

    JDesktopPane desktopPane;
    
    /**
     * Creates new form Bill
     */
    public Bill(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        initComponents();
        
        billList = new ArrayList<>();
        productList = new ArrayList<>();
        
        populateCustomerNameCombo();
        populateProductNameCombo1();
        populateProductNameCombo2();
        populateProductNameCombo3();
        populateProductNameCombo4();
        populateProductNameCombo5();
        populateProductNameCombo6();
        populateProductNameCombo7();
        populateProductNameCombo8();
        populateProductNameCombo9();
        populateProductNameCombo10();
        
        Date date=new Date();
        SimpleDateFormat formatdate = new SimpleDateFormat("YYYY-MM-dd");
                    String newdate = formatdate.format(date);
                    txtdate.setText(newdate);
                    //System.out.println(newdate);
    }
    
    
    public void clear()
    {
        //billList.clear();
        combocustomername.setSelectedIndex(0);
        txtaddress.setText("");
        
        comboproductname1.setSelectedIndex(0);
        comboproductname2.setSelectedIndex(0);
        comboproductname3.setSelectedIndex(0);
        comboproductname4.setSelectedIndex(0);
        comboproductname5.setSelectedIndex(0);
        comboproductname6.setSelectedIndex(0);
        comboproductname7.setSelectedIndex(0);
        comboproductname8.setSelectedIndex(0);
        comboproductname9.setSelectedIndex(0);
        comboproductname10.setSelectedIndex(0);
        
        txtqty1.setText("");
        txtqty2.setText("");
        txtqty3.setText("");
        txtqty4.setText("");
        txtqty5.setText("");
        txtqty6.setText("");
        txtqty7.setText("");
        txtqty8.setText("");
        txtqty9.setText("");
        txtqty10.setText("");
        
        txtprice1.setText("");
        txtprice2.setText("");
        txtprice3.setText("");
        txtprice4.setText("");
        txtprice5.setText("");
        txtprice6.setText("");
        txtprice7.setText("");
        txtprice8.setText("");
        txtprice9.setText("");
        txtprice10.setText("");
        
        txtdiscount1.setText("0.0");
        txtdiscount2.setText("0.0");
        txtdiscount3.setText("0.0");
        txtdiscount4.setText("0.0");
        txtdiscount5.setText("0.0");
        txtdiscount6.setText("0.0");
        txtdiscount7.setText("0.0");
        txtdiscount8.setText("0.0");
        txtdiscount9.setText("0.0");
        txtdiscount10.setText("0.0");
        
        txttotal1.setText("");
        txttotal2.setText("");
        txttotal3.setText("");
        txttotal4.setText("");
        txttotal5.setText("");
        txttotal6.setText("");
        txttotal7.setText("");
        txttotal8.setText("");
        txttotal9.setText("");
        txttotal10.setText("");
        
        txtgrandtotal.setText("");
        txttax.setText("");
        txtbill.setText("");
        txtcredit.setText("0.0");
    }
    
    
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
                
                billList.add(
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
    
    
    private void populateProductNameCombo1() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname1.addItem("");
        while (rs.next())
            comboproductname1.addItem(rs.getString("name"));
        
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     private void populateProductNameCombo2() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname2.addItem("");
        while (rs.next())
            comboproductname2.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
      private void populateProductNameCombo3() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname3.addItem("");
        while (rs.next())
            comboproductname3.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
       private void populateProductNameCombo4() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname4.addItem("");
        while (rs.next())
            comboproductname4.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
        private void populateProductNameCombo5() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname5.addItem("");
        while (rs.next())
            comboproductname5.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
         private void populateProductNameCombo6() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname6.addItem("");
        while (rs.next())
            comboproductname6.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
          private void populateProductNameCombo7() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname7.addItem("");
        while (rs.next())
            comboproductname7.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
           private void populateProductNameCombo8() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname8.addItem("");
        while (rs.next())
            comboproductname8.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
            private void populateProductNameCombo9() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname9.addItem("");
        while (rs.next())
            comboproductname9.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             private void populateProductNameCombo10() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname10.addItem("");
        while (rs.next())
            comboproductname10.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    
    /*try {
            if (productList == null)
                return;
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sakshi");
            pst = con.prepareStatement("SELECT * FROM product WHERE ID = ?");
            //System.out.println(Integer.parseInt(customerList.get(combocustomername.getSelectedIndex()).getId()));
            
            //System.out.println(billList.size());
            
            pst.setInt(1, Integer.parseInt(productList.get(combocustomername.getSelectedIndex()-1).getId()));

            ResultSet rs = pst.executeQuery();
            rs.next();

           
            txtaddress.setText(rs.getString("Address"));
           

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    /*DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sakshi");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product ORDER BY Name");

            ResultSet rs = pstmt.executeQuery();
            int index = 1;
            Item tItem = new Item(0, "Select Product...");
            model.addElement(tItem);
            
            while (rs.next()) {
               // combocustomername.addItem(rs.getString("First_Name"));
                Item item = new Item(index++, rs.getString("Name"));
                model.addElement(item);
                
                productList.add(
                        new ProductBillClass(
                                String.valueOf(rs.getInt("ID")), 
                                rs.getString("Name"),
                                rs.getString("Units"),
                                String.valueOf(rs.getString("Quantity")), 
                                String.valueOf(rs.getString("Cost_Price")),
                                String.valueOf(rs.getString("Sale_Price")),
                                String.valueOf(rs.getString("Status")),
                                String.valueOf(rs.getInt("Re_Order_Level")),
                                String.valueOf(rs.getString("Category_ID")),
                                String.valueOf(rs.getString("Supplier_ID"))
                                
                        ));
            }

            comboproductname1.setModel(model);
            comboproductname2.setModel(model);
            comboproductname3.setModel(model);
            comboproductname4.setModel(model);
            comboproductname5.setModel(model);
            comboproductname6.setModel(model);
            comboproductname7.setModel(model);
            comboproductname8.setModel(model);
            comboproductname9.setModel(model);
            comboproductname10.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        combocustomername = new javax.swing.JComboBox();
        txtaddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtgrandtotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btngeneratebill = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtbill = new javax.swing.JTextField();
        radiocash = new javax.swing.JRadioButton();
        radiocredit = new javax.swing.JRadioButton();
        txtcredit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txttax = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        comboproductname1 = new javax.swing.JComboBox();
        comboproductname2 = new javax.swing.JComboBox();
        comboproductname3 = new javax.swing.JComboBox();
        comboproductname4 = new javax.swing.JComboBox();
        comboproductname5 = new javax.swing.JComboBox();
        comboproductname6 = new javax.swing.JComboBox();
        comboproductname7 = new javax.swing.JComboBox();
        comboproductname8 = new javax.swing.JComboBox();
        comboproductname9 = new javax.swing.JComboBox();
        comboproductname10 = new javax.swing.JComboBox();
        txtqty1 = new javax.swing.JTextField();
        txtqty2 = new javax.swing.JTextField();
        txtqty3 = new javax.swing.JTextField();
        txtqty4 = new javax.swing.JTextField();
        txtqty5 = new javax.swing.JTextField();
        txtqty6 = new javax.swing.JTextField();
        txtqty7 = new javax.swing.JTextField();
        txtqty8 = new javax.swing.JTextField();
        txtqty9 = new javax.swing.JTextField();
        txtqty10 = new javax.swing.JTextField();
        txtprice1 = new javax.swing.JTextField();
        txtprice2 = new javax.swing.JTextField();
        txtprice3 = new javax.swing.JTextField();
        txtprice4 = new javax.swing.JTextField();
        txtprice5 = new javax.swing.JTextField();
        txtprice6 = new javax.swing.JTextField();
        txtprice7 = new javax.swing.JTextField();
        txtprice8 = new javax.swing.JTextField();
        txtprice9 = new javax.swing.JTextField();
        txtprice10 = new javax.swing.JTextField();
        txtdiscount1 = new javax.swing.JTextField();
        txtdiscount2 = new javax.swing.JTextField();
        txtdiscount3 = new javax.swing.JTextField();
        txtdiscount4 = new javax.swing.JTextField();
        txtdiscount5 = new javax.swing.JTextField();
        txtdiscount6 = new javax.swing.JTextField();
        txtdiscount7 = new javax.swing.JTextField();
        txtdiscount8 = new javax.swing.JTextField();
        txtdiscount9 = new javax.swing.JTextField();
        txtdiscount10 = new javax.swing.JTextField();
        txttotal1 = new javax.swing.JTextField();
        txttotal2 = new javax.swing.JTextField();
        txttotal3 = new javax.swing.JTextField();
        txttotal4 = new javax.swing.JTextField();
        txttotal5 = new javax.swing.JTextField();
        txttotal6 = new javax.swing.JTextField();
        txttotal7 = new javax.swing.JTextField();
        txttotal8 = new javax.swing.JTextField();
        txttotal9 = new javax.swing.JTextField();
        txttotal10 = new javax.swing.JTextField();
        btnrefresh = new javax.swing.JButton();

        setClosable(true);
        setTitle("Bill of Customer");
        setName(""); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Customer Name");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Address");

        combocustomername.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combocustomernameItemStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Date");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Click Here");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("New Customer?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(31, 31, 31)
                        .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(34, 34, 34)
                        .addComponent(combocustomername, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(combocustomername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generate Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product Name");

        txtgrandtotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtgrandtotalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtgrandtotalFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("S.NO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Total");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Price Of Unit");

        btngeneratebill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btngeneratebill.setText("Generate Bill");
        btngeneratebill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngeneratebillActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Quantity");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Tax(@14.3%)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Grand Total");

        buttonGroup1.add(radiocash);
        radiocash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radiocash.setSelected(true);
        radiocash.setText("Cash");
        radiocash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiocashActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiocredit);
        radiocredit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radiocredit.setText("Credit");
        radiocredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiocreditActionPerformed(evt);
            }
        });

        txtcredit.setEnabled(false);

        jLabel9.setText("/");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Discount");

        jLabel14.setText("1");

        jLabel15.setText("2");

        jLabel16.setText("3");

        jLabel17.setText("4");

        jLabel18.setText("5");

        jLabel19.setText("6");

        jLabel20.setText("7");

        jLabel21.setText("8");

        jLabel22.setText("9");

        jLabel23.setText("10");

        comboproductname1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname1ItemStateChanged(evt);
            }
        });

        comboproductname2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname2ItemStateChanged(evt);
            }
        });

        comboproductname3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname3ItemStateChanged(evt);
            }
        });

        comboproductname4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname4ItemStateChanged(evt);
            }
        });

        comboproductname5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname5ItemStateChanged(evt);
            }
        });

        comboproductname6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname6ItemStateChanged(evt);
            }
        });

        comboproductname7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname7ItemStateChanged(evt);
            }
        });

        comboproductname8.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname8ItemStateChanged(evt);
            }
        });

        comboproductname9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname9ItemStateChanged(evt);
            }
        });

        comboproductname10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname10ItemStateChanged(evt);
            }
        });

        txtqty1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty1FocusLost(evt);
            }
        });

        txtqty2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty2FocusLost(evt);
            }
        });

        txtqty3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty3FocusLost(evt);
            }
        });

        txtqty4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty4FocusLost(evt);
            }
        });

        txtqty5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty5FocusLost(evt);
            }
        });

        txtqty6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty6FocusLost(evt);
            }
        });

        txtqty7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty7FocusLost(evt);
            }
        });

        txtqty8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty8FocusLost(evt);
            }
        });

        txtqty9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty9FocusLost(evt);
            }
        });

        txtqty10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty10FocusLost(evt);
            }
        });

        txtdiscount1.setText("0.0");
        txtdiscount1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount1KeyReleased(evt);
            }
        });

        txtdiscount2.setText("0.0");
        txtdiscount2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount2KeyReleased(evt);
            }
        });

        txtdiscount3.setText("0.0");
        txtdiscount3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount3KeyReleased(evt);
            }
        });

        txtdiscount4.setText("0.0");
        txtdiscount4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount4KeyReleased(evt);
            }
        });

        txtdiscount5.setText("0.0");
        txtdiscount5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount5KeyReleased(evt);
            }
        });

        txtdiscount6.setText("0.0");
        txtdiscount6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount6KeyReleased(evt);
            }
        });

        txtdiscount7.setText("0.0");
        txtdiscount7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscount7ActionPerformed(evt);
            }
        });
        txtdiscount7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount7KeyReleased(evt);
            }
        });

        txtdiscount8.setText("0.0");
        txtdiscount8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount8KeyReleased(evt);
            }
        });

        txtdiscount9.setText("0.0");
        txtdiscount9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount9KeyReleased(evt);
            }
        });

        txtdiscount10.setText("0.0");
        txtdiscount10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount10KeyReleased(evt);
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtqty10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(jLabel16)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(35, 35, 35))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(58, 58, 58))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(58, 58, 58))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(50, 50, 50)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(comboproductname10, 0, 111, Short.MAX_VALUE)
                                                .addComponent(comboproductname9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboproductname8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboproductname7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboproductname1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboproductname2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboproductname3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboproductname4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboproductname5, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(comboproductname6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addComponent(jLabel21))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtqty3)
                                        .addComponent(txtqty4)
                                        .addComponent(txtqty5)
                                        .addComponent(txtqty6)
                                        .addComponent(jLabel3)
                                        .addComponent(txtqty1)
                                        .addComponent(txtqty2)
                                        .addComponent(txtqty7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtqty8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprice10)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtprice1)
                            .addComponent(txtprice2)
                            .addComponent(txtprice3)
                            .addComponent(txtprice4)
                            .addComponent(txtprice5)
                            .addComponent(txtprice6)
                            .addComponent(txtprice7)
                            .addComponent(txtprice8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtprice9))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtdiscount10, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(txtdiscount9)
                                    .addComponent(txtdiscount8)
                                    .addComponent(txtdiscount7)
                                    .addComponent(txtdiscount6)
                                    .addComponent(txtdiscount5)
                                    .addComponent(txtdiscount4)
                                    .addComponent(txtdiscount3)
                                    .addComponent(txtdiscount2)
                                    .addComponent(txtdiscount1))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttotal1)
                                    .addComponent(txttotal2)
                                    .addComponent(txttotal3)
                                    .addComponent(txttotal4)
                                    .addComponent(txttotal5)
                                    .addComponent(txttotal6)
                                    .addComponent(txttotal7)
                                    .addComponent(txttotal8)
                                    .addComponent(txttotal9)
                                    .addComponent(txttotal10, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))))
                        .addGap(61, 61, 61))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(radiocash)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radiocredit))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(txtgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtbill, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcredit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btngeneratebill)
                                .addGap(18, 18, 18)
                                .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(comboproductname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(comboproductname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(comboproductname3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(comboproductname4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(comboproductname5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(comboproductname6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboproductname7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprice8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(comboproductname8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdiscount8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttotal8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboproductname9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtqty9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprice9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiscount9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttotal9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(comboproductname10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtgrandtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtbill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radiocash)
                    .addComponent(radiocredit)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btngeneratebill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnrefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combocustomernameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combocustomernameItemStateChanged
        // TODO add your handling code here:
        try {
            if (billList == null || combocustomername.getSelectedIndex() == 0)
                return;
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "sakshi");
            pst = con.prepareStatement("SELECT * FROM customer WHERE ID = ?");
            //System.out.println(Integer.parseInt(customerList.get(combocustomername.getSelectedIndex()).getId()));
            
            System.out.println(billList.size());
            
            pst.setInt(1, Integer.parseInt(billList.get(combocustomername.getSelectedIndex()-1).getId()));

            ResultSet rs = pst.executeQuery();
            rs.next();

           
            txtaddress.setText(rs.getString("Address"));
           

        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_combocustomernameItemStateChanged

    private void getProductDetails(JComboBox cmb, JTextField txt1, JTextField txt2) {
       //if (productList == null)
         //   return;
        //txt1.setText(productList.get(cmb.getSelectedIndex()-1).getQuantity());
        //txt2.setText(productList.get(cmb.getSelectedIndex()-1).getSaleprice());
        //txt1.setText(productList.get(cmb.getSelectedIndex()-1).getQuantity());
        //txt2.setText(productList.get(cmb.getSelectedIndex()-1).getSaleprice());
        //txt1.setText(cmb.getSelectedItem().toString());
        //txt2.setText(cmb.getSelectedItem().toString());
        try {
        
        String selectedName = (String) cmb.getSelectedItem();
        
        if(selectedName.equals("") || selectedName == null)
            return;
        
        con = DBConnection.getConnection();
        pst = con.prepareStatement("select * from product where id in (select id from product where name = ?)");
        pst.setString(1, selectedName);
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        
        txt1.setText(rs.getString("Quantity"));
        txt2.setText(rs.getString("Sale_Price"));
        
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    /* Create and display the form */
    private void getTextValues(JComboBox cmb, JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt5, JTextField txt6, JTextField txt7)
    {
        //float tax = 0.143f;
        int qty = Integer.parseInt(txt1.getText());
        float discount = 0.0f;
        try {
            discount = Float.parseFloat(txt2.getText());
        } catch (Exception e) { }
        float price = Float.parseFloat(txt3.getText());
        try
                {
                    con=DBConnection.getConnection();

                    pst = con.prepareStatement("select quantity from product where name =?");
                    //pst.setInt(1,id);
                    pst.setString(1, cmb.getSelectedItem().toString());
                    ResultSet rs = pst.executeQuery();
                    rs.next();
                    int qty1 = rs.getInt("quantity");
                    if(qty > qty1)
                    {
                        JOptionPane.showMessageDialog(this, "Qunatity is higher than available stock quantity.. please fill right quantity");
                    }
                    else
                    {
                    float disc = price-discount;
                    float amount = (qty * disc);
                    float tax = (amount * 0.143f);
                    float bill = amount + tax;

                    //float tax = Float.parseFloat((amount*0.143));
                    txt4.setText(String.valueOf(amount));
                    txt5.setText(String.valueOf(amount));
                    txt6.setText(String.valueOf(tax));
                    txt7.setText(String.valueOf(bill));
                     //txt8.setText(String.valueOf(bill));

                    //txt6.setText(String.valueOf(tax));

                    }
                    
                    
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, e);
                }
        
        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Customer customer = new Customer();
                desktopPane.add(customer);
                customer.setVisible(true);
            }
        });
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboproductname1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname1ItemStateChanged
        getProductDetails(comboproductname1, txtqty1, txtprice1);
       
    }//GEN-LAST:event_comboproductname1ItemStateChanged

    private void comboproductname2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname2ItemStateChanged
        getProductDetails(comboproductname2, txtqty2, txtprice2);
    }//GEN-LAST:event_comboproductname2ItemStateChanged

    private void comboproductname3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname3ItemStateChanged
       getProductDetails(comboproductname3, txtqty3, txtprice3);
    }//GEN-LAST:event_comboproductname3ItemStateChanged

    private void comboproductname4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname4ItemStateChanged
        getProductDetails(comboproductname4, txtqty4, txtprice4);
    }//GEN-LAST:event_comboproductname4ItemStateChanged

    private void comboproductname5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname5ItemStateChanged
        getProductDetails(comboproductname5, txtqty5, txtprice5);
    }//GEN-LAST:event_comboproductname5ItemStateChanged

    private void comboproductname6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname6ItemStateChanged
        getProductDetails(comboproductname6, txtqty6, txtprice6);
    }//GEN-LAST:event_comboproductname6ItemStateChanged

    private void comboproductname7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname7ItemStateChanged
        getProductDetails(comboproductname7, txtqty7, txtprice7);
    }//GEN-LAST:event_comboproductname7ItemStateChanged

    private void comboproductname8ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname8ItemStateChanged
       getProductDetails(comboproductname8, txtqty8, txtprice8);
    }//GEN-LAST:event_comboproductname8ItemStateChanged

    private void comboproductname9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname9ItemStateChanged
        getProductDetails(comboproductname9, txtqty9, txtprice9);
    }//GEN-LAST:event_comboproductname9ItemStateChanged

    private void comboproductname10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname10ItemStateChanged
        getProductDetails(comboproductname10, txtqty10, txtprice10);
    }//GEN-LAST:event_comboproductname10ItemStateChanged

    private void txtqty1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty1FocusLost
        getTextValues(comboproductname1, txtqty1, txtdiscount1, txtprice1, txttotal1, txtgrandtotal, txttax, txtbill);
       
    }//GEN-LAST:event_txtqty1FocusLost

    private void txtqty2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty2FocusLost
        getTextValues(comboproductname2, txtqty2, txtdiscount2, txtprice2, txttotal2, txtgrandtotal, txttax, txtbill);
        float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float amt=t1+t2;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
        float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
       
    }//GEN-LAST:event_txtqty2FocusLost

    private void txtqty3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty3FocusLost
       getTextValues(comboproductname3, txtqty3, txtdiscount3, txtprice3, txttotal3, txtgrandtotal, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal3.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float amt=t1+t2+t3;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty3FocusLost

    private void txtqty4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty4FocusLost
        getTextValues(comboproductname4, txtqty4, txtdiscount4, txtprice4, txttotal4, txtgrandtotal, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float amt=t1+t2+t3+t4;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty4FocusLost

    private void txtqty5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty5FocusLost
       getTextValues(comboproductname5, txtqty5, txtdiscount5, txtprice5, txttotal5, txtgrandtotal,txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float amt=t1+t2+t3+t4+t5;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
       // txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty5FocusLost

    private void txtqty6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty6FocusLost
        getTextValues(comboproductname6, txtqty6, txtdiscount6, txtprice6, txttotal6, txtgrandtotal, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float t6 = Float.parseFloat(txttotal6.getText());
       float amt=t1+t2+t3+t4+t5+t6;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty6FocusLost

    private void txtqty7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty7FocusLost
       getTextValues(comboproductname7, txtqty7, txtdiscount7, txtprice7, txttotal7, txtgrandtotal, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float t6 = Float.parseFloat(txttotal6.getText());
       float t7 = Float.parseFloat(txttotal7.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
       // txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty7FocusLost

    private void txtqty8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty8FocusLost
        getTextValues(comboproductname8, txtqty8, txtdiscount8, txtprice8, txttotal8, txtgrandtotal, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float t6 = Float.parseFloat(txttotal6.getText());
       float t7 = Float.parseFloat(txttotal7.getText());
       float t8 = Float.parseFloat(txttotal8.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty8FocusLost

    private void txtqty9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty9FocusLost
        getTextValues(comboproductname9, txtqty9, txtdiscount9, txtprice9, txttotal9, txtgrandtotal,txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float t6 = Float.parseFloat(txttotal6.getText());
       float t7 = Float.parseFloat(txttotal7.getText());
       float t8 = Float.parseFloat(txttotal8.getText());
       float t9 = Float.parseFloat(txttotal9.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty9FocusLost

    private void txtqty10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty10FocusLost
      
//       txtdiscount10.setText(String.valueOf(dis));
       getTextValues(comboproductname10, txtqty10, txtdiscount10, txtprice10, txttotal10, txtgrandtotal,txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float t6 = Float.parseFloat(txttotal6.getText());
       float t7 = Float.parseFloat(txttotal7.getText());
       float t8 = Float.parseFloat(txttotal8.getText());
       float t9 = Float.parseFloat(txttotal9.getText());
       float t10 = Float.parseFloat(txttotal10.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10;
       txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.143f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty10FocusLost

    private void txtgrandtotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgrandtotalFocusLost

    }//GEN-LAST:event_txtgrandtotalFocusLost

    private void txtgrandtotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgrandtotalFocusGained
        
    }//GEN-LAST:event_txtgrandtotalFocusGained

    private void txtdiscount10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount10KeyReleased
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname10, txtqty10, txtdiscount10, txtprice10, txttotal10, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    float t6 = Float.parseFloat(txttotal6.getText());
                    float t7 = Float.parseFloat(txttotal7.getText());
                    float t8 = Float.parseFloat(txttotal8.getText());
                    float t9 = Float.parseFloat(txttotal9.getText());
                    float t10 = Float.parseFloat(txttotal10.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount10KeyReleased

    private void txtdiscount1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount1KeyReleased
        // TODO add your handling code here:
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname1, txtqty1, txtdiscount1, txtprice1, txttotal1, txtgrandtotal, txttax, txtbill);  
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount1KeyReleased

    private void txtdiscount2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount2KeyReleased
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname2, txtqty2, txtdiscount2, txtprice2, txttotal2, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                   
                    float amt=t1+t2;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount2KeyReleased

    private void txtdiscount3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount3KeyReleased
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname3, txtqty3, txtdiscount3, txtprice3, txttotal3, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    
                    float amt=t1+t2+t3;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                   // txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount3KeyReleased

    private void txtdiscount4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount4KeyReleased
       try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname4, txtqty4, txtdiscount4, txtprice4, txttotal4, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    
                    float amt=t1+t2+t3+t4;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                   // txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount4KeyReleased

    private void txtdiscount5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount5KeyReleased
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname5, txtqty5, txtdiscount5, txtprice5, txttotal5, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    
                    float amt=t1+t2+t3+t4+t5;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount5KeyReleased

    private void txtdiscount6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount6KeyReleased
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname6, txtqty6, txtdiscount6, txtprice6, txttotal6, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    float t6 = Float.parseFloat(txttotal6.getText());
                   
                    float amt=t1+t2+t3+t4+t5+t6;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount6KeyReleased

    private void txtdiscount7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount7KeyReleased
       try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname7, txtqty7, txtdiscount7, txtprice7, txttotal7, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    float t6 = Float.parseFloat(txttotal6.getText());
                    float t7 = Float.parseFloat(txttotal7.getText());
                    
                    float amt=t1+t2+t3+t4+t5+t6+t7;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount7KeyReleased

    private void txtdiscount8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount8KeyReleased
       try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname8, txtqty8, txtdiscount8, txtprice8, txttotal8, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    float t6 = Float.parseFloat(txttotal6.getText());
                    float t7 = Float.parseFloat(txttotal7.getText());
                    float t8 = Float.parseFloat(txttotal8.getText());
                   
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount8KeyReleased

    private void txtdiscount9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount9KeyReleased
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname9, txtqty9, txtdiscount9, txtprice9, txttotal9, txtgrandtotal, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    float t6 = Float.parseFloat(txttotal6.getText());
                    float t7 = Float.parseFloat(txttotal7.getText());
                    float t8 = Float.parseFloat(txttotal8.getText());
                    float t9 = Float.parseFloat(txttotal9.getText());
                    
                    
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9;
                    txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.143f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount9KeyReleased

    private void txtdiscount7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscount7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiscount7ActionPerformed

    private void getBillDetails(JComboBox cmb, JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4)
    {
        if (cmb.getSelectedIndex() > 0) {
            if (!txt1.getText().equals("") && !txt2.equals("")) {
                int quantity=Integer.parseInt(txt1.getText());
                float discount=Float.parseFloat(txt3.getText());
                float amount = Float.parseFloat(txt4.getText());
                // Do required calculations and perform insert on
                // bill_detail table with generated bill id
                // Also perform update operation on product
                try
                {
                    con=DBConnection.getConnection();

                    pst = con.prepareStatement("select max(id) from bill");
                    ResultSet rs = pst.executeQuery();
                    rs.next();
                    int billID = rs.getInt("max(id)");

                    pst = con.prepareStatement("select id from product where name = ?");
                    pst.setString(1, cmb.getSelectedItem().toString());
                    rs = pst.executeQuery();
                    rs.next();
                    int productID = rs.getInt("id");

                    pst = con.prepareStatement("insert into bill_detail(bill_id, product_id, quantity, discount, amount) values(?, ?, ?, ?, ?)");
                    pst.setInt(1, billID);
                    pst.setInt(2, productID);
                    pst.setInt(3, quantity);
                    pst.setFloat(4, discount);
                    pst.setFloat(5, amount);
                    int i = pst.executeUpdate();
                    if(i>0)
                    {
                        JOptionPane.showMessageDialog(this, "Added to bill details successfully");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Not added to bill details successfully");
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, e);
                }
                
                
                try
                {
                    con=DBConnection.getConnection();

                    pst = con.prepareStatement("select quantity from product where name = ?");
                    pst.setString(1, cmb.getSelectedItem().toString());
                    ResultSet rs = pst.executeQuery();
                    rs.next();
                    int qty = rs.getInt("quantity");
                    
                    int qty1 = qty-quantity;

                   pst = con.prepareStatement("update product set quantity=? where name=?");
                    pst.setInt(1, qty1);
                    pst.setString(2, cmb.getSelectedItem().toString());
                    int i = pst.executeUpdate();
                    if(i>0)
                    {
                        JOptionPane.showMessageDialog(this, "Update to bill details successfully");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Not update to bill details successfully");
                    }
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this, e);
                }
                          
            }
        }
    }
    
    private void btngeneratebillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngeneratebillActionPerformed
        
        String date=txtdate.getText();
        float total=Float.parseFloat(txtgrandtotal.getText());
        float bill=Float.parseFloat(txtbill.getText());
        boolean status=radiocash.isSelected();
        float pendingpayment = Float.parseFloat(txtcredit.getText());
        
        try
             {
                 con=DBConnection.getConnection();
                
                  pst = con.prepareStatement("select id from customer where first_name = ?");
                pst.setString(1, combocustomername.getSelectedItem().toString());
                ResultSet rs = pst.executeQuery();
                rs.next();
                int customerID = rs.getInt("id");
                
                
                
                pst=con.prepareStatement("insert into bill (user_id,customer_id,date,total,bill,status,pending)values(?, ?, ?, ?, ?, ?, ?)");
                pst.setInt(1, UserClass.userid);
                pst.setInt(2, customerID);
                pst.setString(3, date);
                pst.setFloat(4, total);
                pst.setFloat(5, bill);
                pst.setBoolean(6, status);
                  pst.setFloat(7, pendingpayment);

                int i=pst.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this, "Bill added Successfully");
                    //clear();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Bill not added Successfully");
                }
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
        
       
//        // Insert into bill table and get the generated bill ID
        
        getBillDetails(comboproductname1, txtqty1, txtprice1, txtdiscount1, txttotal1);
        getBillDetails(comboproductname2, txtqty2, txtprice2, txtdiscount2, txttotal2);
        getBillDetails(comboproductname3, txtqty3, txtprice3, txtdiscount3, txttotal3);
        getBillDetails(comboproductname4, txtqty4, txtprice4, txtdiscount4, txttotal4);
        getBillDetails(comboproductname5, txtqty5, txtprice5, txtdiscount5, txttotal5);
        getBillDetails(comboproductname6, txtqty6, txtprice6, txtdiscount6, txttotal6);
        getBillDetails(comboproductname7, txtqty7, txtprice7, txtdiscount7, txttotal7);
        getBillDetails(comboproductname8, txtqty8, txtprice8, txtdiscount8, txttotal8);
        getBillDetails(comboproductname9, txtqty9, txtprice9, txtdiscount9, txttotal9);
        getBillDetails(comboproductname10, txtqty10, txtprice10, txtdiscount10, txttotal10);
        
        
      
        //System.out.println(UserClass.userid);
        
      
        

//   ----------------------------------------------------------------------------------------------------     
//           //------------PDF Part----------------
//        /* Its simple pdf file generator program which works fine
//            how to add bill layout and generate pdf according to billing */
//        
//            
//            JFileChooser fileChooser = new JFileChooser();
//        fileChooser.showSaveDialog(null);
//        
//        File file = fileChooser.getSelectedFile();
//        
//        try {
//            PdfDocument pdf = new PdfDocument(new PdfWriter(file.getCanonicalPath()));
//            Document document = new Document(pdf);
//            
//            document.add(new Paragraph("Hello, World!"));
//            document.close();
//            pdf.close();
//        } catch (IOException ex) {
//            Logger.getLogger(Bill.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
    }//GEN-LAST:event_btngeneratebillActionPerformed

    private void radiocreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiocreditActionPerformed
        if (radiocredit.isSelected()) {
            txtcredit.setEnabled(true);
        } else {
            txtcredit.setEnabled(false);
        }
    }//GEN-LAST:event_radiocreditActionPerformed

    private void radiocashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiocashActionPerformed
        if (radiocash.isSelected()) {
            txtcredit.setText("0.0");
            txtcredit.setEnabled(false);
        } else {
            txtcredit.setEnabled(true);
        }
    }//GEN-LAST:event_radiocashActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        clear();
    }//GEN-LAST:event_btnrefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngeneratebill;
    private javax.swing.JButton btnrefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combocustomername;
    private javax.swing.JComboBox comboproductname1;
    private javax.swing.JComboBox comboproductname10;
    private javax.swing.JComboBox comboproductname2;
    private javax.swing.JComboBox comboproductname3;
    private javax.swing.JComboBox comboproductname4;
    private javax.swing.JComboBox comboproductname5;
    private javax.swing.JComboBox comboproductname6;
    private javax.swing.JComboBox comboproductname7;
    private javax.swing.JComboBox comboproductname8;
    private javax.swing.JComboBox comboproductname9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radiocash;
    private javax.swing.JRadioButton radiocredit;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbill;
    private javax.swing.JTextField txtcredit;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtdiscount1;
    private javax.swing.JTextField txtdiscount10;
    private javax.swing.JTextField txtdiscount2;
    private javax.swing.JTextField txtdiscount3;
    private javax.swing.JTextField txtdiscount4;
    private javax.swing.JTextField txtdiscount5;
    private javax.swing.JTextField txtdiscount6;
    private javax.swing.JTextField txtdiscount7;
    private javax.swing.JTextField txtdiscount8;
    private javax.swing.JTextField txtdiscount9;
    private javax.swing.JTextField txtgrandtotal;
    private javax.swing.JTextField txtprice1;
    private javax.swing.JTextField txtprice10;
    private javax.swing.JTextField txtprice2;
    private javax.swing.JTextField txtprice3;
    private javax.swing.JTextField txtprice4;
    private javax.swing.JTextField txtprice5;
    private javax.swing.JTextField txtprice6;
    private javax.swing.JTextField txtprice7;
    private javax.swing.JTextField txtprice8;
    private javax.swing.JTextField txtprice9;
    private javax.swing.JTextField txtqty1;
    private javax.swing.JTextField txtqty10;
    private javax.swing.JTextField txtqty2;
    private javax.swing.JTextField txtqty3;
    private javax.swing.JTextField txtqty4;
    private javax.swing.JTextField txtqty5;
    private javax.swing.JTextField txtqty6;
    private javax.swing.JTextField txtqty7;
    private javax.swing.JTextField txtqty8;
    private javax.swing.JTextField txtqty9;
    private javax.swing.JTextField txttax;
    private javax.swing.JTextField txttotal1;
    private javax.swing.JTextField txttotal10;
    private javax.swing.JTextField txttotal2;
    private javax.swing.JTextField txttotal3;
    private javax.swing.JTextField txttotal4;
    private javax.swing.JTextField txttotal5;
    private javax.swing.JTextField txttotal6;
    private javax.swing.JTextField txttotal7;
    private javax.swing.JTextField txttotal8;
    private javax.swing.JTextField txttotal9;
    // End of variables declaration//GEN-END:variables
}
