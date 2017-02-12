/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;
import com.inventorysystem.helpers.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
/**
 *
 * @author HP
 */
public class Product extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    List<ProductBillClass> productList;
    /**
     * Creates new form Product
     */
    public Product() {
        initComponents();
        productList = new ArrayList<>();
        populateCategoryNameCombo();
        populateSupplierNameCombo();
        populateProductNameCombo();
    }
    
    public void clear()
    {
        txtproductname.setText("");
        txtunit.setText("");
        txtquantity.setText("");
        txtcostprice.setText("");
        txtsaleprice.setText("");
        txtmrp.setText("");
        buttonGroup1.clearSelection();
        txtreorderlevel.setText("");
        comboproductname.setSelectedIndex(-1);
        combocategory.setSelectedIndex(-1);
        combosupplier.setSelectedIndex(-1);
                
        
    }
    
     private void populateCategoryNameCombo() {
    try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from category order by name");
        
        ResultSet rs = pstmt.executeQuery();
        combocategory.addItem("");
        
        while (rs.next())
            combocategory.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
     private void populateSupplierNameCombo() {
    try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from supplier order by name");
        
        ResultSet rs = pstmt.executeQuery();
        combosupplier.addItem("");
        while (rs.next())
            combosupplier.addItem(rs.getString("name"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     
//     private void populateProductNameCombo() {
//        try {
//        con = DBConnection.getConnection();
//        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
//        
//        ResultSet rs = pstmt.executeQuery();
//        comboproductname.removeAllItems();
//        comboproductname.addItem("");
//                productList = new ArrayList<>();
//
//        while (rs.next())
//            comboproductname.addItem(rs.getString("name"));
//        
//        
//    } catch (SQLException ex) {
//        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    }
     
     private void populateProductNameCombo() {
         DefaultComboBoxModel model = new DefaultComboBoxModel();
    try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select * from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        int index = 1;
            Product.Item tItem = new Product.Item(0, "Select Product...");
            model.addElement(tItem);
            productList = new ArrayList<>();
            while (rs.next()) {
               // combocustomername.addItem(rs.getString("First_Name"));
                Product.Item item = new Product.Item(index++, rs.getString("name"));
                model.addElement(item);
                
                productList.add(
                        new ProductBillClass(String.valueOf(rs.getInt("id")), 
                                rs.getString("name"),
                                rs.getString("units"),
                                rs.getString("quantity"),
                                rs.getString("cost_price"),
                                rs.getString("sale_price"),
                                rs.getString("mrp"),
                                rs.getString("status"),
                                rs.getString("re_order_level"),
                                rs.getString("category_id"),
                                rs.getString("supplier_id")
                        
                        )
                );
                               
//                                rs.getString("permission")
                                
                            
                        
            }

            comboproductname.setModel(model);
        
    } catch (SQLException ex) {
        Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtunit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtcostprice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsaleprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtreorderlevel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        combocategory = new javax.swing.JComboBox();
        combosupplier = new javax.swing.JComboBox();
        radiotrue = new javax.swing.JRadioButton();
        radiofalse = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtmrp = new javax.swing.JTextField();
        txtproductname = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        btnrefresh = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        comboproductname = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Add Products");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Units");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Quantity");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Cost Price");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Sale Price");

        txtsaleprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsalepriceActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Status");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Reorder Level");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product Name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Category Name");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Supplier Name");

        buttonGroup1.add(radiotrue);
        radiotrue.setText("True");
        radiotrue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiotrueActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiofalse);
        radiofalse.setText("False");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("MRP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radiotrue, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(radiofalse, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(128, 128, 128)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsaleprice, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtreorderlevel, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addComponent(combosupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(combocategory, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtmrp)))
                                .addContainerGap(25, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcostprice, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtunit, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(txtproductname))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(343, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtproductname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcostprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsaleprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtmrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radiotrue)
                        .addComponent(radiofalse))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtreorderlevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combocategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(combosupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(366, Short.MAX_VALUE)))
        );

        btnsave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnrefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnrefresh.setText("Refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnrefresh)
                    .addComponent(btnupdate))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Search by Name");

        comboproductname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductnameItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(comboproductname, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboproductname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        String productname=txtproductname.getText();
        String units=txtunit.getText();
        String quantity=txtquantity.getText();
        String costprice=txtcostprice.getText();
        String saleprice=txtsaleprice.getText();
        String mrp=txtmrp.getText();
        boolean status=radiotrue.isSelected();
        String reorder=txtreorderlevel.getText();
       // String categoryname=combocategory.getSelectedItem().toString();
       // String suppliername=combosupplier.getSelectedItem().toString(); 
        
        if(productname.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Product Name field is empty... please fill it first!!");
        }
         
         else if(units.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Unit field is empty... please fill it first!!");
        }
         else if(quantity.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Quantity field is empty... please fill it first!!");
         }
         else if(costprice.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Cost Price field is empty... please fill it first!!");
         }
         else if(saleprice.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Sale Price field is empty... please fill it first!!");
         }
         else if(mrp.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "MRP field is empty... please fill it first!!");
         }
         
         else if(reorder.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Reorder Level field is empty... please fill it first!!");
         }
         
       else  if(combocategory.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
        }
       else  if(combosupplier.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
        }
//       else if(!(Pattern.matches("^[A-Za-z0-9 ,]+$", txtproductname.getText())))
//         {
//             JOptionPane.showMessageDialog(this, "Please enter valid Productname");
//         }
//        
//         else if(!(Pattern.matches("^[a-zA-Z ,]+$", txtunit.getText())))
//         {
//             JOptionPane.showMessageDialog(this, "Please enter valid Units");
//         }
        else if(!(Pattern.matches("^[0-9]+", txtquantity.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid Quantity");
            }
        else if(!(Pattern.matches("^[0-9]+", txtcostprice.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid Cost Price");
            }
        else if(!(Pattern.matches("^[0-9]+", txtsaleprice.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid Sale Price");
            }
         else if(!(Pattern.matches("^[0-9]+", txtmrp.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid MRP");
            }
        else if(!(Pattern.matches("^[0-9]+", txtreorderlevel.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid Reorder Level");
            }
        
        else
        {
            try
            {
                con=DBConnection.getConnection();
             
                pst = con.prepareStatement("select id from category where name = ?");
                pst.setString(1, combocategory.getSelectedItem().toString());
                ResultSet rs = pst.executeQuery();
                rs.next();
                int categoryID = rs.getInt("id");
                
                pst = con.prepareStatement("select id from supplier where name = ?");
                pst.setString(1, combosupplier.getSelectedItem().toString());
                rs = pst.executeQuery();
                rs.next();
                int supplierID = rs.getInt("id");
                
                pst=con.prepareStatement("insert into product (name,units,quantity,cost_price,sale_price,mrp,status,re_order_level,category_id,supplier_id)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pst.setString(1, productname);
                pst.setString(2, units);
                pst.setString(3, quantity);
                pst.setString(4, costprice);
                pst.setString(5, saleprice);
                pst.setString(6, mrp);
                pst.setBoolean(7, status);
                pst.setString(8, reorder);
                pst.setInt(9, categoryID);
                pst.setInt(10, supplierID);
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
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e);
            }
        }
        populateProductNameCombo();
       
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void txtsalepriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsalepriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsalepriceActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
       String productname=txtproductname.getText();
        String units=txtunit.getText();
        String quantity=txtquantity.getText();
        String costprice=txtcostprice.getText();
        String saleprice=txtsaleprice.getText();
        String mrp=txtmrp.getText();
        boolean status=radiotrue.isSelected();
        String reorder=txtreorderlevel.getText();
       // String categoryname=combocategory.getSelectedItem().toString();
       // String suppliername=combosupplier.getSelectedItem().toString(); 
        
        if(productname.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Product Name field is empty... please fill it first!!");
        }
         
         else if(units.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Unit field is empty... please fill it first!!");
        }
         else if(quantity.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Quantity field is empty... please fill it first!!");
         }
         else if(costprice.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Cost Price field is empty... please fill it first!!");
         }
         else if(saleprice.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Sale Price field is empty... please fill it first!!");
         }
         else if(mrp.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "MRP field is empty... please fill it first!!");
         }
         
         else if(reorder.isEmpty())
         {
             JOptionPane.showMessageDialog(this, "Reorder Level field is empty... please fill it first!!");
         }
         
       else  if(combocategory.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
        }
       else  if(combosupplier.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please select item first!!");
        }
//       else if(!(Pattern.matches("^[A-Za-z0-9 ,]+$", txtproductname.getText())))
//         {
//             JOptionPane.showMessageDialog(this, "Please enter valid Productname");
//         }
//        
//         else if(!(Pattern.matches("^[a-zA-Z ,]+$", txtunit.getText())))
//         {
//             JOptionPane.showMessageDialog(this, "Please enter valid Units");
//         }
        else if(!(Pattern.matches("^[0-9]+", txtquantity.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid Quantity");
            }
        else if(!(Pattern.matches("^[0-9]+", txtcostprice.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid Cost Price");
            }
        else if(!(Pattern.matches("^[0-9]+", txtsaleprice.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid Sale Price");
            }
         else if(!(Pattern.matches("^[0-9]+", txtmrp.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid MRP");
            }
        else if(!(Pattern.matches("^[0-9]+", txtreorderlevel.getText())))
            {
                JOptionPane.showMessageDialog(this, "Please enter valid Reorder Level");
            }
        
        else
        {
            try
            {
                con=DBConnection.getConnection();
             
                
                pst=con.prepareStatement("update product set name=?, units=?, quantity=?, cost_price=?, sale_price=?, mrp=?, status=?, re_order_level=? where id = ?");
                
                pst.setString(1, productname);
                pst.setString(2, units);
                pst.setString(3, quantity);
                pst.setString(4, costprice);
                pst.setString(5, saleprice);
                pst.setString(6, mrp);
                pst.setBoolean(7, status);
                pst.setString(8, reorder);
               pst.setInt(9, Integer.parseInt(productList.get(comboproductname.getSelectedIndex()-1).getId()));
                //pst.setString(9, productname);
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
        
        /*
        pst=con.prepareStatement("update supplier set Address=?,City=?,Pincode=?,State=?,Phone=? where ID=?");
             
                pst.setString(1, address);
                pst.setString(2, city);
                pst.setString(3, pincode);
                pst.setString(4, state);
                pst.setString(5, phoneno);
                 pst.setInt(6, Integer.parseInt(supplierList.get(combosuppliername.getSelectedIndex()-1).getId()));
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
        */
        populateProductNameCombo();
    }//GEN-LAST:event_btnupdateActionPerformed

    int selectedProductId = 0;
    private void comboproductnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductnameItemStateChanged
//        try {
//        
//       /* String selectedName = (String) combosuppliername.getSelectedItem();
//        
//        if(selectedName.equals("") || selectedName == null)
//            return;*/
//            if (productList == null || comboproductname.getSelectedIndex() == 0)
//                return;
//        
//        con = DBConnection.getConnection();
//        pst = con.prepareStatement("select * from supplier where ID = ?");
//        //pst.setString(1, selectedName);
//        pst.setInt(1, Integer.parseInt(supplierList.get(combosuppliername.getSelectedIndex()-1).getId()));
//        ResultSet rs = pst.executeQuery();
//        rs.next();
//        
//        
//        txtsuppliername.setText(rs.getString("Name"));
//        txtaddress.setText(rs.getString("Address"));
//        txtcity.setText(rs.getString("City"));
//        txtpincode.setText(rs.getString("Pincode"));
//        txtstate.setText(rs.getString("State"));
//        txtphoneno.setText(rs.getString("Phone"));
//       selectedSupplierId = combosuppliername.getSelectedIndex();
//        
//    } catch (SQLException ex) {
//        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//    }
        
//        try {
//        
//        String selectedName = (String) comboproductname.getSelectedItem();
//        
//        if(selectedName.equals("") || selectedName == null)
//            return;
//        
//        con = DBConnection.getConnection();
//        
//        pst = con.prepareStatement("select c.name from product p, category c where p.category_id=c.id and p.id = (select id from product where name = ?)");
//            pst.setString(1, selectedName);
//            rs = pst.executeQuery();
//            rs.next(); 
//            String categoryname = rs.getString("c.name");
//         
//            
//            pst = con.prepareStatement("select s.name from product p, supplier s where p.supplier_id=s.id and p.id = (select id from product where name = ?)");
//            pst.setString(1, selectedName);
//            rs = pst.executeQuery();
//            rs.next(); 
//     
//            String suppliertname = rs.getString("s.name");
//            
//        
//        pst = con.prepareStatement("select * from product where id IN (select id from product where name = ?)");
//        pst.setString(1, selectedName);
//        
//        ResultSet rs = pst.executeQuery();
//        rs.next();
//        
//        txtproductname.setText(rs.getString("name"));
//        txtunit.setText(rs.getString("units"));
//        txtquantity.setText(rs.getString("Quantity"));
//        txtcostprice.setText(rs.getString("cost_Price"));
//        txtsaleprice.setText(rs.getString("Sale_Price"));
//        txtmrp.setText(rs.getString("mrp"));
//        
//        //if(radiotrue.isSelected()==true)
//        //{
////            if(rs.getBoolean("status")==true)
////            {
////            radiotrue.setSelected(rs.getBoolean("status"));
////                System.out.println("true selected");
////            }
////            if(rs.getBoolean("status")==false)
////            {
////                radiofalse.setSelected(rs.getBoolean("status"));
////                System.out.println("false selected");
////            }
//        
//        if(rs.getBoolean("status")==true)
//            {
//                radiotrue.setSelected(true);
//               
//            }
//           else
//            {
//               radiofalse.setSelected(true);
//            }
//            
//            
//        //}
////        else
////        {
////        radiofalse.setSelected(rs.getBoolean("status"));
////        }
//        //if(radiotrue.isSelected()==true)
//        //{
//           // buttonGroup1.getSelection().getActionCommand();
//        //}
//        txtreorderlevel.setText(rs.getString("re_order_level"));
//        combocategory.setSelectedItem(categoryname);
//        combosupplier.setSelectedItem(suppliertname);
//        selectedProductId = comboproductname.getSelectedIndex();
//        
//    } catch (SQLException ex) {
//        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
//    } catch (NullPointerException e) {
//        //populateProductNameCombo();
//    }
        try {
        
        /*String selectedName = (String) comborolename.getSelectedItem();
        
        if(selectedName.equals("") || selectedName == null)
            return;*/
             if (productList == null || comboproductname.getSelectedIndex() == 0)
                return;
        
        con = DBConnection.getConnection();
        pst = con.prepareStatement("select c.name from product p, category c where p.category_id=c.id and p.id = ?");
             pst.setInt(1, Integer.parseInt(productList.get(comboproductname.getSelectedIndex()-1).getId()));
            rs = pst.executeQuery();
            rs.next(); 
            String categoryname = rs.getString("c.name");
         
            
            pst = con.prepareStatement("select s.name from product p, supplier s where p.supplier_id=s.id and p.id = ?");
             pst.setInt(1, Integer.parseInt(productList.get(comboproductname.getSelectedIndex()-1).getId()));
            rs = pst.executeQuery();
            rs.next(); 
     
            String suppliertname = rs.getString("s.name");
            
        
        pst = con.prepareStatement("select * from product where id = ?");
         pst.setInt(1, Integer.parseInt(productList.get(comboproductname.getSelectedIndex()-1).getId()));
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        
        txtproductname.setText(rs.getString("name"));
        txtunit.setText(rs.getString("units"));
        txtquantity.setText(rs.getString("Quantity"));
        txtcostprice.setText(rs.getString("cost_Price"));
        txtsaleprice.setText(rs.getString("Sale_Price"));
        txtmrp.setText(rs.getString("mrp"));
        
        //if(radiotrue.isSelected()==true)
        //{
//            if(rs.getBoolean("status")==true)
//            {
//            radiotrue.setSelected(rs.getBoolean("status"));
//                System.out.println("true selected");
//            }
//            if(rs.getBoolean("status")==false)
//            {
//                radiofalse.setSelected(rs.getBoolean("status"));
//                System.out.println("false selected");
//            }
        
        if(rs.getBoolean("status")==true)
            {
                radiotrue.setSelected(true);
               
            }
           else
            {
               radiofalse.setSelected(true);
            }
            
            
        //}
//        else
//        {
//        radiofalse.setSelected(rs.getBoolean("status"));
//        }
        //if(radiotrue.isSelected()==true)
        //{
           // buttonGroup1.getSelection().getActionCommand();
        //}
        txtreorderlevel.setText(rs.getString("re_order_level"));
        combocategory.setSelectedItem(categoryname);
        combosupplier.setSelectedItem(suppliertname);
        selectedProductId = comboproductname.getSelectedIndex();
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception e) {
        //populateProductNameCombo();
    }
    
    }//GEN-LAST:event_comboproductnameItemStateChanged

    private void radiotrueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiotrueActionPerformed
//      if(evt.getSource() instanceof JRadioButton){
//            JRadioButton radioButton = (JRadioButton) evt.getSource();
//            if(radioButton.isSelected()){
//                radiotrue.setText(radioButton.getText());
//            }
//        }
        if(radiotrue.isSelected()==true)
        {
            buttonGroup1.getSelection().getActionCommand();
        }
    }//GEN-LAST:event_radiotrueActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combocategory;
    private javax.swing.JComboBox comboproductname;
    private javax.swing.JComboBox combosupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton radiofalse;
    private javax.swing.JRadioButton radiotrue;
    private javax.swing.JTextField txtcostprice;
    private javax.swing.JTextField txtmrp;
    private javax.swing.JTextField txtproductname;
    private javax.swing.JTextField txtquantity;
    private javax.swing.JTextField txtreorderlevel;
    private javax.swing.JTextField txtsaleprice;
    private javax.swing.JTextField txtunit;
    // End of variables declaration//GEN-END:variables
}
