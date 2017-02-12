/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

import com.inventorysystem.helpers.DBConnection;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
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
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HP
 */
public class Bill extends javax.swing.JInternalFrame {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    List<CustomerClass> billList;
    List<ProductBillClass> productList;
    List<pdfclass> pdfList;
   
                    

    JDesktopPane desktopPane;
    
    /**
     * Creates new form Bill
     */
    public Bill(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        initComponents();
        
        billList = new ArrayList<>();
        productList = new ArrayList<>();
        pdfList = new ArrayList<>();
        txttax.setEnabled(false);
        txtaddress.setEditable(false);
        txttax.setVisible(false);
        lbltax.setVisible(false);
        
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
        populateProductNameCombo11();
        populateProductNameCombo12();
        populateProductNameCombo13();
        populateProductNameCombo14();
        populateProductNameCombo15();
        populateProductNameCombo16();
        populateProductNameCombo17();
        populateProductNameCombo18();
        populateProductNameCombo19();
        populateProductNameCombo20();
        
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
        comboproductname11.setSelectedIndex(0);
        comboproductname12.setSelectedIndex(0);
        comboproductname13.setSelectedIndex(0);
        comboproductname14.setSelectedIndex(0);
        comboproductname15.setSelectedIndex(0);
        comboproductname16.setSelectedIndex(0);
        comboproductname17.setSelectedIndex(0);
        comboproductname18.setSelectedIndex(0);
        comboproductname19.setSelectedIndex(0);
        comboproductname20.setSelectedIndex(0);
        
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
        txtqty11.setText("");
        txtqty12.setText("");
        txtqty13.setText("");
        txtqty14.setText("");
        txtqty15.setText("");
        txtqty16.setText("");
        txtqty17.setText("");
        txtqty18.setText("");
        txtqty19.setText("");
        txtqty20.setText("");
        
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
        txtprice11.setText("");
        txtprice12.setText("");
        txtprice13.setText("");
        txtprice14.setText("");
        txtprice15.setText("");
        txtprice16.setText("");
        txtprice17.setText("");
        txtprice18.setText("");
        txtprice19.setText("");
        txtprice20.setText("");
        
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
        txtdiscount11.setText("0.0");
        txtdiscount12.setText("0.0");
        txtdiscount13.setText("0.0");
        txtdiscount14.setText("0.0");
        txtdiscount15.setText("0.0");
        txtdiscount16.setText("0.0");
        txtdiscount17.setText("0.0");
        txtdiscount18.setText("0.0");
        txtdiscount19.setText("0.0");
        txtdiscount20.setText("0.0");
        
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
        txttotal11.setText("");
        txttotal12.setText("");
        txttotal13.setText("");
        txttotal14.setText("");
        txttotal15.setText("");
        txttotal16.setText("");
        txttotal17.setText("");
        txttotal18.setText("");
        txttotal19.setText("");
        txttotal20.setText("");
        
     
        txttax.setText("");
        txtbill.setText("");
        txtcredit.setText("0.0");
    }
    
    
    private void populateCustomerNameCombo() {
    DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
             con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM CUSTOMER ORDER BY first_name");

            ResultSet rs = pstmt.executeQuery();
            int index = 1;
            Item tItem = new Item(0, "Select Customer...");
            model.addElement(tItem);
            billList = new ArrayList<>();
            while (rs.next()) {
               // combocustomername.addItem(rs.getString("First_Name"));
                Item item = new Item(index++, rs.getString("first_name") + " " + rs.getString("last_name"));
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
                                rs.getString("Phone")
                        ));
            }

            combocustomername.setModel(model);
            con.close();
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
        
        con.close();
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
        con.close();
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
        con.close();
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
        con.close();
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
        con.close();
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
        con.close();
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
        con.close();
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
        con.close();
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
        con.close();
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
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo11() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname11.addItem("");
        while (rs.next())
            comboproductname11.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo12() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname12.addItem("");
        while (rs.next())
            comboproductname12.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo13() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname13.addItem("");
        while (rs.next())
            comboproductname13.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo14() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname14.addItem("");
        while (rs.next())
            comboproductname14.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo15() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname15.addItem("");
        while (rs.next())
            comboproductname15.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo16() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname16.addItem("");
        while (rs.next())
            comboproductname16.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo17() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname17.addItem("");
        while (rs.next())
            comboproductname17.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo18() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname18.addItem("");
        while (rs.next())
            comboproductname18.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo19() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname19.addItem("");
        while (rs.next())
            comboproductname19.addItem(rs.getString("name"));
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
             
             private void populateProductNameCombo20() {
        try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select name from product order by name");
        
        ResultSet rs = pstmt.executeQuery();
        comboproductname20.addItem("");
        while (rs.next())
            comboproductname20.addItem(rs.getString("name"));
        con.close();
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
        btnrefreshname = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btngeneratebill = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbltax = new javax.swing.JLabel();
        txtbill = new javax.swing.JTextField();
        radiocash = new javax.swing.JRadioButton();
        radiocredit = new javax.swing.JRadioButton();
        txtcredit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
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
        jLabel25 = new javax.swing.JLabel();
        comboproductname11 = new javax.swing.JComboBox();
        txtprice11 = new javax.swing.JTextField();
        txtqty11 = new javax.swing.JTextField();
        txtdiscount11 = new javax.swing.JTextField();
        txttotal11 = new javax.swing.JTextField();
        txtqty12 = new javax.swing.JTextField();
        txtprice12 = new javax.swing.JTextField();
        txtdiscount12 = new javax.swing.JTextField();
        txttotal12 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        comboproductname12 = new javax.swing.JComboBox();
        txtqty13 = new javax.swing.JTextField();
        txtprice13 = new javax.swing.JTextField();
        txtdiscount13 = new javax.swing.JTextField();
        txttotal13 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        comboproductname13 = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        comboproductname14 = new javax.swing.JComboBox();
        txtqty14 = new javax.swing.JTextField();
        txtprice14 = new javax.swing.JTextField();
        txtdiscount14 = new javax.swing.JTextField();
        txttotal14 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        comboproductname15 = new javax.swing.JComboBox();
        txtqty15 = new javax.swing.JTextField();
        txtprice15 = new javax.swing.JTextField();
        txtdiscount15 = new javax.swing.JTextField();
        txttotal15 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        comboproductname16 = new javax.swing.JComboBox();
        txtqty16 = new javax.swing.JTextField();
        txtprice16 = new javax.swing.JTextField();
        txtdiscount16 = new javax.swing.JTextField();
        txttotal16 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        comboproductname17 = new javax.swing.JComboBox();
        txtqty17 = new javax.swing.JTextField();
        txtprice17 = new javax.swing.JTextField();
        txtdiscount17 = new javax.swing.JTextField();
        txttotal17 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        comboproductname18 = new javax.swing.JComboBox();
        txtqty18 = new javax.swing.JTextField();
        txtprice18 = new javax.swing.JTextField();
        txtdiscount18 = new javax.swing.JTextField();
        txttotal18 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        comboproductname19 = new javax.swing.JComboBox();
        txtqty19 = new javax.swing.JTextField();
        txtprice19 = new javax.swing.JTextField();
        txtdiscount19 = new javax.swing.JTextField();
        txttotal19 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        comboproductname20 = new javax.swing.JComboBox();
        txtqty20 = new javax.swing.JTextField();
        txtprice20 = new javax.swing.JTextField();
        txtdiscount20 = new javax.swing.JTextField();
        txttotal20 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Bill of Customer");
        setMaximumSize(new java.awt.Dimension(2147483647, 2147));
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

        btnrefreshname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnrefreshname.setText("Refresh");
        btnrefreshname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshnameActionPerformed(evt);
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
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combocustomername, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnrefreshname))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(1, 1, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(combocustomername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnrefreshname))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel24))
                    .addComponent(jButton1))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generate Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Product Name");

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

        lbltax.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltax.setText("Tax(@14.3%)");

        buttonGroup1.add(radiocash);
        radiocash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        comboproductname6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboproductname6ActionPerformed(evt);
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

        jLabel25.setText("11");

        comboproductname11.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname11ItemStateChanged(evt);
            }
        });

        txtqty11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty11FocusLost(evt);
            }
        });

        txtdiscount11.setText("0.0");
        txtdiscount11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount11KeyReleased(evt);
            }
        });

        txtqty12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty12FocusLost(evt);
            }
        });

        txtdiscount12.setText("0.0");
        txtdiscount12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount12KeyReleased(evt);
            }
        });

        jLabel26.setText("12");

        comboproductname12.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname12ItemStateChanged(evt);
            }
        });

        txtqty13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty13FocusLost(evt);
            }
        });

        txtdiscount13.setText("0.0");
        txtdiscount13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount13KeyReleased(evt);
            }
        });

        jLabel27.setText("13");

        comboproductname13.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname13ItemStateChanged(evt);
            }
        });

        jLabel28.setText("14");

        comboproductname14.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname14ItemStateChanged(evt);
            }
        });

        txtqty14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty14FocusLost(evt);
            }
        });

        txtdiscount14.setText("0.0");
        txtdiscount14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount14KeyReleased(evt);
            }
        });

        jLabel29.setText("15");

        comboproductname15.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname15ItemStateChanged(evt);
            }
        });

        txtqty15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty15FocusLost(evt);
            }
        });

        txtdiscount15.setText("0.0");
        txtdiscount15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount15KeyReleased(evt);
            }
        });

        jLabel30.setText("16");

        comboproductname16.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname16ItemStateChanged(evt);
            }
        });

        txtqty16.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty16FocusLost(evt);
            }
        });

        txtdiscount16.setText("0.0");
        txtdiscount16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount16KeyReleased(evt);
            }
        });

        jLabel31.setText("17");

        comboproductname17.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname17ItemStateChanged(evt);
            }
        });

        txtqty17.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty17FocusLost(evt);
            }
        });

        txtdiscount17.setText("0.0");
        txtdiscount17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount17KeyReleased(evt);
            }
        });

        jLabel32.setText("18");

        comboproductname18.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname18ItemStateChanged(evt);
            }
        });

        txtqty18.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty18FocusLost(evt);
            }
        });
        txtqty18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqty18ActionPerformed(evt);
            }
        });

        txtdiscount18.setText("0.0");
        txtdiscount18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount18KeyReleased(evt);
            }
        });

        jLabel33.setText("19");

        comboproductname19.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname19ItemStateChanged(evt);
            }
        });

        txtqty19.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty19FocusLost(evt);
            }
        });
        txtqty19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqty19ActionPerformed(evt);
            }
        });

        txtdiscount19.setText("0.0");
        txtdiscount19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount19KeyReleased(evt);
            }
        });

        jLabel34.setText("20");

        comboproductname20.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboproductname20ItemStateChanged(evt);
            }
        });

        txtqty20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtqty20FocusLost(evt);
            }
        });
        txtqty20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqty20ActionPerformed(evt);
            }
        });

        txtdiscount20.setText("0.0");
        txtdiscount20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdiscount20KeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Discount");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(25, 25, 25))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(33, 33, 33)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboproductname10, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname9, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname7, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname14, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname15, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname16, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname17, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname18, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname19, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboproductname20, 0, 121, Short.MAX_VALUE)
                            .addComponent(comboproductname8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtqty8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtqty1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel10)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtprice20)
                            .addComponent(txtprice19)
                            .addComponent(txtprice18)
                            .addComponent(txtprice17)
                            .addComponent(txtprice16)
                            .addComponent(txtprice15)
                            .addComponent(txtprice14)
                            .addComponent(txtprice13)
                            .addComponent(txtprice12)
                            .addComponent(txtprice11)
                            .addComponent(txtprice10)
                            .addComponent(txtprice9)
                            .addComponent(txtprice8)
                            .addComponent(txtprice7)
                            .addComponent(txtprice6)
                            .addComponent(txtprice5)
                            .addComponent(txtprice4)
                            .addComponent(txtprice2)
                            .addComponent(txtprice1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprice3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdiscount14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount16, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount17, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount18, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount19, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount20, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txttotal19, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                            .addComponent(txttotal18, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttotal17, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttotal16)
                                            .addComponent(txttotal20))
                                        .addGap(50, 50, 50)
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
                                                        .addComponent(lbltax, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtbill, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txttax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtcredit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(btngeneratebill)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txttotal15, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttotal14, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txttotal13))
                                        .addGap(313, 313, 313))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtdiscount12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txttotal12, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtdiscount11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txttotal11))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtdiscount3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtdiscount4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtdiscount5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtdiscount6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtdiscount7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtdiscount8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtdiscount9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtdiscount2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdiscount1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtdiscount10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txttotal1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                        .addComponent(txttotal2)
                                        .addComponent(txttotal8, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                        .addComponent(txttotal6)
                                        .addComponent(txttotal3)
                                        .addComponent(txttotal4)
                                        .addComponent(txttotal5)
                                        .addComponent(txttotal7)
                                        .addComponent(txttotal9)
                                        .addComponent(txttotal10)))))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel10))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboproductname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtqty1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtprice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdiscount1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txttotal10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboproductname10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtqty10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtprice10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdiscount10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(51, 51, 51)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(txtqty3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtprice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtdiscount3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txttotal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(comboproductname3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel16)))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(13, 13, 13)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(comboproductname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtqty2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtprice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtdiscount2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txttotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel15))
                                                        .addGap(50, 50, 50)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(txtqty4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtprice4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtdiscount4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txttotal4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(comboproductname4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel17))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(comboproductname5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtqty5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtprice5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtdiscount5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txttotal5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel18))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(comboproductname6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtqty6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtprice6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtdiscount6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txttotal6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel19))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(comboproductname7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtqty7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtprice7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtdiscount7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txttotal7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel20))))
                                                .addGap(18, 18, 18)
                                                .addComponent(txttotal8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(comboproductname8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtqty8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtprice8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtdiscount8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel21))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboproductname9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtqty9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtprice9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdiscount9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22)
                                            .addComponent(txttotal9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 44, Short.MAX_VALUE)))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboproductname11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprice11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotal11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboproductname12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprice12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotal12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboproductname13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtqty13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprice13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotal13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboproductname14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtqty14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtprice14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdiscount14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28))
                                    .addComponent(txttotal14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel29)
                                        .addComponent(comboproductname15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtqty15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtprice15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdiscount15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txttotal15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel30)
                                        .addComponent(comboproductname16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtqty16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtprice16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdiscount16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txttotal16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel31)
                                        .addComponent(comboproductname17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtqty17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtprice17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdiscount17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txttotal17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel32)
                                        .addComponent(comboproductname18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtqty18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtprice18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdiscount18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txttotal18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtqty19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboproductname19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33)
                                    .addComponent(txtprice19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdiscount19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttotal19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltax)
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
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btngeneratebill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnrefresh))))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotal20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiscount20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtqty20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboproductname20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addContainerGap(375, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int selectedCustomerId = 0;
    private void combocustomernameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combocustomernameItemStateChanged
        // TODO add your handling code here:
        try {
            if (billList == null || combocustomername.getSelectedIndex() == 0)
                return;
            
            con = DBConnection.getConnection();
            pst = con.prepareStatement("SELECT * FROM customer WHERE ID = ?");
            //System.out.println(Integer.parseInt(customerList.get(combocustomername.getSelectedIndex()).getId()));
            
            System.out.println(billList.size());
            
            pst.setInt(1, Integer.parseInt(billList.get(combocustomername.getSelectedIndex()-1).getId()));

            ResultSet rs = pst.executeQuery();
            rs.next();

           
            txtaddress.setText(rs.getString("Address"));
           selectedCustomerId = combocustomername.getSelectedIndex();
           con.close();
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
        
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    /* Create and display the form */
    private void getTextValues(JComboBox cmb, JTextField txt1, JTextField txt2, JTextField txt3, JTextField txt4, JTextField txt6, JTextField txt7)
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
                    if(qty > qty1 || qty1 <= 0 || qty == 0)
                    {
                        JOptionPane.showMessageDialog(this, "Qunatity is higher than available stock quantity.. please fill right quantity");
                    }
                    else
                    {
                    float disc = price-discount;
                    float amount = (qty * disc);
                    float tax = (amount * 0.0f);
                    float bill = amount + tax;

                    //float tax = Float.parseFloat((amount*0.143));
                    txt4.setText(String.valueOf(amount));
                    //txt5.setText(String.valueOf(amount));
                    txt6.setText(String.valueOf(tax));
                    txt7.setText(String.valueOf(bill));
                     //txt8.setText(String.valueOf(bill));

                    //txt6.setText(String.valueOf(tax));

                    }
                    con.close();
                    
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
        getTextValues(comboproductname1, txtqty1, txtdiscount1, txtprice1, txttotal1, txttax, txtbill);
       
    }//GEN-LAST:event_txtqty1FocusLost

    private void txtqty2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty2FocusLost
        getTextValues(comboproductname2, txtqty2, txtdiscount2, txtprice2, txttotal2, txttax, txtbill);
        float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float amt=t1+t2;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
        float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
       
    }//GEN-LAST:event_txtqty2FocusLost

    private void txtqty3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty3FocusLost
       getTextValues(comboproductname3, txtqty3, txtdiscount3, txtprice3, txttotal3, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float amt=t1+t2+t3;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty3FocusLost

    private void txtqty4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty4FocusLost
        getTextValues(comboproductname4, txtqty4, txtdiscount4, txtprice4, txttotal4, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float amt=t1+t2+t3+t4;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty4FocusLost

    private void txtqty5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty5FocusLost
       getTextValues(comboproductname5, txtqty5, txtdiscount5, txtprice5, txttotal5, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float amt=t1+t2+t3+t4+t5;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
       // txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty5FocusLost

    private void txtqty6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty6FocusLost
        getTextValues(comboproductname6, txtqty6, txtdiscount6, txtprice6, txttotal6, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float t6 = Float.parseFloat(txttotal6.getText());
       float amt=t1+t2+t3+t4+t5+t6;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty6FocusLost

    private void txtqty7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty7FocusLost
       getTextValues(comboproductname7, txtqty7, txtdiscount7, txtprice7, txttotal7, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float t6 = Float.parseFloat(txttotal6.getText());
       float t7 = Float.parseFloat(txttotal7.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
       // txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty7FocusLost

    private void txtqty8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty8FocusLost
        getTextValues(comboproductname8, txtqty8, txtdiscount8, txtprice8, txttotal8, txttax, txtbill);
       float t1 = Float.parseFloat(txttotal1.getText());
       float t2 = Float.parseFloat(txttotal2.getText());
       float t3 = Float.parseFloat(txttotal3.getText());
       float t4 = Float.parseFloat(txttotal4.getText());
       float t5 = Float.parseFloat(txttotal5.getText());
       float t6 = Float.parseFloat(txttotal6.getText());
       float t7 = Float.parseFloat(txttotal7.getText());
       float t8 = Float.parseFloat(txttotal8.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty8FocusLost

    private void txtqty9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty9FocusLost
        getTextValues(comboproductname9, txtqty9, txtdiscount9, txtprice9, txttotal9, txttax, txtbill);
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
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty9FocusLost

    private void txtqty10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty10FocusLost
      
//       txtdiscount10.setText(String.valueOf(dis));
       getTextValues(comboproductname10, txtqty10, txtdiscount10, txtprice10, txttotal10, txttax, txtbill);
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
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
        //txtcredit.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty10FocusLost

    private void txtdiscount10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount10KeyReleased
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname10, txtqty10, txtdiscount10, txtprice10, txttotal10, txttax, txtbill);
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
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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
                 getTextValues(comboproductname1, txtqty1, txtdiscount1, txtprice1, txttotal1, txttax, txtbill);  
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount1KeyReleased

    private void txtdiscount2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount2KeyReleased
        try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname2, txtqty2, txtdiscount2, txtprice2, txttotal2, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                   
                    float amt=t1+t2;
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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
                 getTextValues(comboproductname3, txtqty3, txtdiscount3, txtprice3, txttotal3, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    
                    float amt=t1+t2+t3;
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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
                 getTextValues(comboproductname4, txtqty4, txtdiscount4, txtprice4, txttotal4, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    
                    float amt=t1+t2+t3+t4;
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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
                 getTextValues(comboproductname5, txtqty5, txtdiscount5, txtprice5, txttotal5, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    
                    float amt=t1+t2+t3+t4+t5;
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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
                 getTextValues(comboproductname6, txtqty6, txtdiscount6, txtprice6, txttotal6, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    float t6 = Float.parseFloat(txttotal6.getText());
                   
                    float amt=t1+t2+t3+t4+t5+t6;
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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
                 getTextValues(comboproductname7, txtqty7, txtdiscount7, txtprice7, txttotal7, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    float t6 = Float.parseFloat(txttotal6.getText());
                    float t7 = Float.parseFloat(txttotal7.getText());
                    
                    float amt=t1+t2+t3+t4+t5+t6+t7;
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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
                 getTextValues(comboproductname8, txtqty8, txtdiscount8, txtprice8, txttotal8, txttax, txtbill);
                    float t1 = Float.parseFloat(txttotal1.getText());
                    float t2 = Float.parseFloat(txttotal2.getText());
                    float t3 = Float.parseFloat(txttotal3.getText());
                    float t4 = Float.parseFloat(txttotal4.getText());
                    float t5 = Float.parseFloat(txttotal5.getText());
                    float t6 = Float.parseFloat(txttotal6.getText());
                    float t7 = Float.parseFloat(txttotal7.getText());
                    float t8 = Float.parseFloat(txttotal8.getText());
                   
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8;
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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
                 getTextValues(comboproductname9, txtqty9, txtdiscount9, txtprice9, txttotal9, txttax, txtbill);
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
                    //txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
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

    int billID = 0;
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
                    billID = rs.getInt("max(id)");

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
                       // JOptionPane.showMessageDialog(this, "Added to bill details successfully");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Not added to bill details");
                    }
                    con.close();
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
                       // JOptionPane.showMessageDialog(this, "Update to bill details successfully");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Not update to product table");
                    }
                    con.close();
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
        //float total=Float.parseFloat(txtgrandtotal.getText());
        float bill=Float.parseFloat(txtbill.getText());
        boolean status=radiocash.isSelected();
        float pendingpayment = Float.parseFloat(txtcredit.getText());
        
        try
             {
                 con=DBConnection.getConnection();
                
//                  pst = con.prepareStatement("select id from customer where first_name = ? and id= ?");
//                pst.setString(1, combocustomername.getSelectedItem().toString());
//                pst.setInt(2, Integer.parseInt(billList.get(combocustomername.getSelectedIndex()-1).getId()));
//                ResultSet rs = pst.executeQuery();
//                rs.next();
//                int customerID = rs.getInt("id");
                 int customerID = Integer.parseInt(billList.get(combocustomername.getSelectedIndex()-1).getId());
                
                
                
                pst=con.prepareStatement("insert into bill (user_id,customer_id,date,bill,status,pending)values(?, ?, ?, ?, ?, ?)");
                pst.setInt(1, UserClass.userid);
                pst.setInt(2, customerID);
                pst.setString(3, date);
                //pst.setFloat(4, total);
                pst.setFloat(4, bill);
                pst.setBoolean(5, status);
                  pst.setFloat(6, pendingpayment);

                int i=pst.executeUpdate();
                if(i>0)
                {
                    JOptionPane.showMessageDialog(this, "Bill Generated Successfully");
                    //clear();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Bill not added Successfully");
                }
                con.close();
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
        getBillDetails(comboproductname11, txtqty11, txtprice11, txtdiscount11, txttotal11);
        getBillDetails(comboproductname12, txtqty12, txtprice12, txtdiscount12, txttotal12);
        getBillDetails(comboproductname13, txtqty13, txtprice13, txtdiscount13, txttotal13);
        getBillDetails(comboproductname14, txtqty14, txtprice14, txtdiscount14, txttotal14);
        getBillDetails(comboproductname15, txtqty15, txtprice15, txtdiscount15, txttotal15);
        getBillDetails(comboproductname16, txtqty16, txtprice16, txtdiscount16, txttotal16);
        getBillDetails(comboproductname17, txtqty17, txtprice17, txtdiscount17, txttotal17);
        getBillDetails(comboproductname18, txtqty18, txtprice18, txtdiscount18, txttotal18);
        getBillDetails(comboproductname19, txtqty19, txtprice19, txtdiscount19, txttotal19);
        getBillDetails(comboproductname20, txtqty20, txtprice20, txtdiscount20, txttotal20);
        
        
      
        //System.out.println(UserClass.userid);
        
      
        

//   ----------------------------------------------------------------------------------------------------     
//           //------------PDF Part----------------

        
        try {
           con=DBConnection.getConnection();
           
           PreparedStatement pst = con.prepareStatement("select max(id) from bill");
            ResultSet rs = pst.executeQuery();
            rs.next();
           int billid = rs.getInt("max(id)");
            
           
            pst = con.prepareStatement("select date from bill where id = (select max(id) from bill)");
            rs = pst.executeQuery();
            rs.next(); 
            date = rs.getString("date");
            
            pst = con.prepareStatement("select c.first_name, c.last_name from bill b, customer c where b.customer_id=c.id and b.id = (select max(id) from bill)");
            rs = pst.executeQuery();
            rs.next(); 
            String firstname = rs.getString("c.first_name");
            String lastname = rs.getString("c.last_name");
            
             
            pst = con.prepareStatement("select p.sale_price, amount from product p, bill_detail bd where bd.product_id = p.id and bd.bill_id = (select max(bill_id) from bill_detail)");
            rs = pst.executeQuery();
            rs.next(); 
            int saleprice = rs.getInt("p.sale_price");
            int amount = rs.getInt("amount");
            
            pst = con.prepareStatement("select bill from bill where id = (select max(id) from bill)");
            rs = pst.executeQuery();
            rs.next(); 
            bill = rs.getFloat("bill");
            
            pst = con.prepareStatement("select p.name, bd.quantity, p.sale_price, bd.amount from product p, bill_detail bd where bd.product_id=p.id and bd.bill_id = (select max(bill_id) from bill_detail)");
            rs = pst.executeQuery();
            int serialNo = 1;
            
            File file = new File(billid + ".html");
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(file));
            fileWriter.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "	<title></title>\n" +
                "	<link rel='stylesheet' type='text/css' href='css/bootstrap.min.css'>\n" +
                "	<link rel=\"stylesheet\" type=\"text/css\" href=\"\">\n" +
                "	<style type=\"text/css\">\n" +
                "		.shop-name {\n" +
                "			font-size: 6.5em;\n" +
                "		}\n" +
                "\n" +
                "		th {\n" +
                "			background-color: #EBEBEB;\n" +
                "		}\n" +
                "\n" +
                "		th, td:nth-child(1), td:nth-child(3), td:nth-child(4) {\n" +
                "			text-align: center;\n" +
                "		}\n" +
                "\n" +
                "		td:nth-child(5), td:last-child {\n" +
                "			text-align: right;\n" +
                "		}\n" +
                "\n" +
                "		.bold {\n" +
                "			font-weight: bolder;\n" +
                "		}\n" +
                "\n" +
                "		td:first-child {\n" +
                "			width: 100px;\n" +
                "		}\n" +
                "\n" +
                "		td:nth-child(3) {\n" +
                "			width: 100px;\n" +
                "		}\n" +
                "		.container{border:2px solid gray;border-top:none;}\n" +
                "	</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class='container'>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-4'>\n" +
                "			<span>TIN No: 03362196323</span>\n" +
                "		</div>\n" +
                "		<div class='col-md-4 text-center'>\n" +
                "			<span>VAT INVOICE</span>\n" +
                "		</div>\n" +
                "		<div class='col-md-4'>\n" +
                "			<div class='pull-right'>\n" +
                "				<address>\n" +
               
                "					<span>Mob: 99141-26604</span><br>\n" +
                "					<span>Mob: 78373-39294</span>\n" +
                "				</address>\n" +
                "			</div>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h1 class='text-center shop-name'>Pawla Paint Store</h1>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h4 class='text-center clearfix'>DEALS IN ALL KIND OF PAINTS</h4>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-8 col-md-offset-2'>\n" +
                "			<h4 class='text-center clearfix'>SCO #6, SHINE COMPLEX, OPP. SHANKAR NAGAR, HOSHIARPUR-146001</h4>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<hr>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-6'>\n" +
                "			<span>No."+ billid +" </span>\n" +
                "		</div>\n" +
                "		<div class='col-md-6'>\n" +
                "			<span class='pull-right'>Date:" + date + "  </span>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div class='col-md-12'>\n" +
                "			<span>To:"+ firstname +" "+ lastname +"</span>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "\n" +
                "	<div class='row'>\n" +
                "		<div>\n" +
                "			<table class='table table-hover table-bordered'>\n" +
                "				<thead>\n" +
                "					<tr>\n" +
                "						<th style=\"width:8%;\">SR. NO.</th>\n" +
                "						<th>DESCRIPTION</th>\n" +
                "						<th style=\"width:10%;\">QUANTITY</th>\n" +
                "						<th style=\"width:10%;\">RATE</th>\n" +
                "						<th style=\"width:10%;border:none;\"><b>AMOUNT</b><b style=\"float:right;\">(Rs.)</b></th>\n" +
               
                "					</tr>\n" +
                "				</thead>\n" +
                "				<tbody>\n");
            
            while (rs.next()) {
                fileWriter.println("<tr>\n" +
                "						<td>" + serialNo++ + "</td>\n" +
                "						<td>"+ rs.getString("p.name") +"</td>\n" +
                "						<td>"+ rs.getInt("bd.quantity") +"</td>\n" +
                "						<td>"+ rs.getFloat("p.sale_price") +"</td>\n" +
                "						<td>"+ rs.getFloat("bd.amount") +"</td>\n" +
                
                "					</tr>\n");
            }
            
            fileWriter.println(
                "					<tr>\n" +
                "						<td>&nbsp;</td>\n" +
                "						<td>&nbsp;</td>\n" +
                "						<td>&nbsp;</td>\n" +
                "						<td class=\"bold\">TOTAL</td>\n" +
                "						<td class=\"bold\">"+ bill +"(Include 14.3% VAT)</td>\n" +
               
                "					</tr>\n" +
                "					<tr>\n" +
                "			<td colspan=\"20\">\n" +
                "			<p style=\"float:right;font-weight:bold;\">For Pawla Paint Store </p><br><br>\n" +
                "			<p><h4 style=\"float:left\">E. & O . E.</h4><h5 style=\"float:right;\">Signature</h5></p>\n" +
                "			</td>\n" +
                "					</tr>\n" +
                "				</tbody>\n" +
                "			</table>\n" +
                "		</div>\n" +
                "	</div>\n" +
                "   <div class=\"row\">\n" +
                "   	 <div>\n" +
                "   <img src=\"images/Dulux.jpg\" width=\"150\" height=\"150\">\n"+
                "   </img>\n" +
                "   <img src=\"images/Asian Paints logo 2012.png\" width=\"150\" height=\"150\">\n"+
                "   </img>\n" +
                "   <img src=\"images/drfixit.png\" width=\"150\" height=\"150\">\n"+
                "   </img>\n" +
                "   <img src=\"images/logo.png\" width=\"300\" height=\"150\">\n"+
                "   </img>\n" +
                "   <img src=\"images/masterbrush.jpg\" width=\"150\" height=\"150\">\n"+
                "   </img>\n" +
       
                        
//                "   	 <h3>Note: </h3>\n" +
//                "   	 <ul style=\"list-style:none;\">\n" +
//                "   	 	<li>1. ਵਿਕੇ ਹੋਏ ਮਾਲ ਦੀ ਵਾਪਸੀ 15 ਦਿਨ ਦੇ ਅੰਦਰ ਹੋਵੇਗੀ / बिके हुए माल की वापसी 15 दिन के अंदर होगी |</li>\n" +
//                "   	 	<li>2. ਡਾਈ ਦੁਆਰਾ ਤਿਆਰ ਕੀਤੇ ਕਲਰ ਦੀ ਗਾਰੰਟੀ ਨਹੀਂ ਹੋਵੇਗੀ / डाई से तयार किये गए कलर की गारंटी नही होगी |</li>\n" +
//                "   	 	<li>3. ਕਾਉੰਟਰ ਛੱਡਣ ਤੋਂ ਬਾਅਦ ਸਾਡੀ ਕੋਈ ਜਿੰਮੇਵਾਰੀ ਨਹੀਂ ਹੋਵੇਗੀ / कॉउंटर छोड़ने के बाद हमारी कोई जिमेवारी नही होगी |</li>\n" +
//                "   	 	<li>4. ਕਿਸੇ ਵੀ ਪੈਂਟ ਦੀ ਕੋਈ ਗਾਰੰਟੀ ਨਹੀਂ ਹੋਵੇਗੀ / किसी भी पेंट की कोई गारंटी नही होगी |</li>\n" +
//                "   	 	<li>5. ਸ਼ੋਰਾ ਸਲਾਭ ਤੇ ਕਿਸੇ ਬ ਪੈਂਟ ਦੀ ਕੋਈ ਗਾਰੰਟੀ ਨਹੀਂ ਹੈ / शोरा सलाभ पर किसी भी पेंट की कोई गारंटी नही है |</li>\n" +
//                "   	 	<li>6. ਕਿਸੇ ਵੀ ਕਲਰ ਨੂੰ ਤਿਆਰ ਕਰਨ ਦੇ ਕੋਈ ਪੈਸੇ ਨਹੀਂ ਲਾਵਾਂਗੇ / किसी भी कलर को तयार करने के कोई पैसे नही लिए जायेंगे |</li>\n" +
//                "   	 	<li>7. ਕਲਰ ਹਮੇਸ਼ਾ ਬੇਸ ਵਿਚ ਬਣਾ ਕੇ ਲਵੋ ਜੀ / कलर हमेशा बेस में बना के लो |</li>\n" +
//                "   	 </ul>\n" +
                "   	 </div>\n" +
                "   </div>\n" +
                "   <div class=\"row\">\n" +
                "   	 <div class=\"col-md-12 thumbnail\">\n" +
                "   	 <h3>Note: </h3>\n" +
                "   	 <ul style=\"list-style:none;\">\n" +
                "   	 	<li>1. ਵਿਕੇ ਹੋਏ ਮਾਲ ਦੀ ਵਾਪਸੀ 15 ਦਿਨ ਦੇ ਅੰਦਰ ਹੋਵੇਗੀ / बिके हुए माल की वापसी 15 दिन के अंदर होगी |</li>\n" +
                "   	 	<li>2. ਡਾਈ ਦੁਆਰਾ ਤਿਆਰ ਕੀਤੇ ਕਲਰ ਦੀ ਗਾਰੰਟੀ ਨਹੀਂ ਹੋਵੇਗੀ / डाई से तयार किये गए कलर की गारंटी नही होगी |</li>\n" +
                "   	 	<li>3. ਕਾਉੰਟਰ ਛੱਡਣ ਤੋਂ ਬਾਅਦ ਸਾਡੀ ਕੋਈ ਜਿੰਮੇਵਾਰੀ ਨਹੀਂ ਹੋਵੇਗੀ / कॉउंटर छोड़ने के बाद हमारी कोई जिमेवारी नही होगी |</li>\n" +
                "   	 	<li>4. ਕਿਸੇ ਵੀ ਪੈਂਟ ਦੀ ਕੋਈ ਗਾਰੰਟੀ ਨਹੀਂ ਹੋਵੇਗੀ / किसी भी पेंट की कोई गारंटी नही होगी |</li>\n" +
                "   	 	<li>5. ਸ਼ੋਰਾ ਸਲਾਭ ਤੇ ਕਿਸੇ ਬ ਪੈਂਟ ਦੀ ਕੋਈ ਗਾਰੰਟੀ ਨਹੀਂ ਹੈ / शोरा सलाभ पर किसी भी पेंट की कोई गारंटी नही है |</li>\n" +
                "   	 	<li>6. ਕਿਸੇ ਵੀ ਕਲਰ ਨੂੰ ਤਿਆਰ ਕਰਨ ਦੇ ਕੋਈ ਪੈਸੇ ਨਹੀਂ ਲਾਵਾਂਗੇ / किसी भी कलर को तयार करने के कोई पैसे नही लिए जायेंगे |</li>\n" +
                "   	 	<li>7. ਕਲਰ ਹਮੇਸ਼ਾ ਬੇਸ ਵਿਚ ਬਣਾ ਕੇ ਲਵੋ ਜੀ / कलर हमेशा बेस में बना के लो |</li>\n" +
                "   	 </ul>\n" +
                "   	 </div>\n" +
                "   </div>\n" +
                "</div>	\n" +
                "\n" +
                "</body>\n" +
                "</html>");
            fileWriter.close();
            JOptionPane.showMessageDialog(this, "PDF Generated Successfully");
          Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + file.getAbsolutePath());
          //    Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe " + file.getAbsolutePath());
          con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
//        try {
//
		
//
//  	  } catch (Exception ex) {
//		ex.printStackTrace();
//	  }

    
              
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

    private void btnrefreshnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshnameActionPerformed
       try {
           populateCustomerNameCombo();
       }
       catch(Exception e){}
    }//GEN-LAST:event_btnrefreshnameActionPerformed

    private void txtqty11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty11FocusLost
        getTextValues(comboproductname11, txtqty11, txtdiscount11, txtprice11, txttotal11, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty11FocusLost

    private void txtdiscount11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount11KeyReleased
      try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname11, txtqty11, txtdiscount11, txtprice11, txttotal11, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11;
         //           txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount11KeyReleased

    private void txtqty12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty12FocusLost
      getTextValues(comboproductname12, txtqty12, txtdiscount12, txtprice12, txttotal12, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12;
     //  txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty12FocusLost

    private void txtdiscount12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount12KeyReleased
      try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname12, txtqty12, txtdiscount12, txtprice12, txttotal12, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12;
       //             txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount12KeyReleased

    private void txtqty13FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty13FocusLost
       getTextValues(comboproductname13, txtqty13, txtdiscount13, txtprice13, txttotal13, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float t13 = Float.parseFloat(txttotal13.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13;
     //  txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty13FocusLost

    private void txtdiscount13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount13KeyReleased
     try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname13, txtqty13, txtdiscount13, txtprice13, txttotal13, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float t13 = Float.parseFloat(txttotal13.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13;
                 //   txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount13KeyReleased

    private void txtqty14FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty14FocusLost
       getTextValues(comboproductname14, txtqty14, txtdiscount14, txtprice14, txttotal14, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float t13 = Float.parseFloat(txttotal13.getText());
       float t14 = Float.parseFloat(txttotal14.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty14FocusLost

    private void txtdiscount14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount14KeyReleased
    try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname14, txtqty14, txtdiscount14, txtprice14, txttotal14, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float t13 = Float.parseFloat(txttotal13.getText());
                    float t14 = Float.parseFloat(txttotal14.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14;
                   // txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount14KeyReleased

    private void txtqty15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty15FocusLost
       getTextValues(comboproductname15, txtqty15, txtdiscount15, txtprice15, txttotal15, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float t13 = Float.parseFloat(txttotal13.getText());
       float t14 = Float.parseFloat(txttotal14.getText());
       float t15 = Float.parseFloat(txttotal15.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15;
       //txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty15FocusLost

    private void txtdiscount15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount15KeyReleased
    try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname15, txtqty15, txtdiscount15, txtprice15, txttotal15, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float t13 = Float.parseFloat(txttotal13.getText());
                    float t14 = Float.parseFloat(txttotal14.getText());
                    float t15 = Float.parseFloat(txttotal15.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15;
                   // txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount15KeyReleased

    private void txtqty16FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty16FocusLost
     getTextValues(comboproductname16, txtqty16, txtdiscount16, txtprice16, txttotal16, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float t13 = Float.parseFloat(txttotal13.getText());
       float t14 = Float.parseFloat(txttotal14.getText());
       float t15 = Float.parseFloat(txttotal15.getText());
       float t16 = Float.parseFloat(txttotal16.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16;
      // txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty16FocusLost

    private void txtdiscount16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount16KeyReleased
      try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname16, txtqty16, txtdiscount16, txtprice16, txttotal16, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float t13 = Float.parseFloat(txttotal13.getText());
                    float t14 = Float.parseFloat(txttotal14.getText());
                    float t15 = Float.parseFloat(txttotal15.getText());
                    float t16 = Float.parseFloat(txttotal16.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16;
                   // txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount16KeyReleased

    private void txtqty17FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty17FocusLost
    getTextValues(comboproductname17, txtqty17, txtdiscount17, txtprice17, txttotal17, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float t13 = Float.parseFloat(txttotal13.getText());
       float t14 = Float.parseFloat(txttotal14.getText());
       float t15 = Float.parseFloat(txttotal15.getText());
       float t16 = Float.parseFloat(txttotal16.getText());
       float t17 = Float.parseFloat(txttotal17.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16+t17;
      // txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty17FocusLost

    private void txtdiscount17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount17KeyReleased
      try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname17, txtqty17, txtdiscount17, txtprice17, txttotal17, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float t13 = Float.parseFloat(txttotal13.getText());
                    float t14 = Float.parseFloat(txttotal14.getText());
                    float t15 = Float.parseFloat(txttotal15.getText());
                    float t16 = Float.parseFloat(txttotal16.getText());
                    float t17 = Float.parseFloat(txttotal17.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16+t17;
                   // txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount17KeyReleased

    private void txtqty18FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty18FocusLost
    getTextValues(comboproductname18, txtqty18, txtdiscount18, txtprice18, txttotal18, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float t13 = Float.parseFloat(txttotal13.getText());
       float t14 = Float.parseFloat(txttotal14.getText());
       float t15 = Float.parseFloat(txttotal15.getText());
       float t16 = Float.parseFloat(txttotal16.getText());
       float t17 = Float.parseFloat(txttotal17.getText());
       float t18 = Float.parseFloat(txttotal18.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16+t17+t18;
     //  txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty18FocusLost

    private void txtdiscount18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount18KeyReleased
     try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname18, txtqty18, txtdiscount18, txtprice18, txttotal18, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float t13 = Float.parseFloat(txttotal13.getText());
                    float t14 = Float.parseFloat(txttotal14.getText());
                    float t15 = Float.parseFloat(txttotal15.getText());
                    float t16 = Float.parseFloat(txttotal16.getText());
                    float t17 = Float.parseFloat(txttotal17.getText());
                    float t18 = Float.parseFloat(txttotal18.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16+t17+t18;
                  //  txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount18KeyReleased

    private void txtqty18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqty18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqty18ActionPerformed

    private void txtqty19FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty19FocusLost
    getTextValues(comboproductname19, txtqty19, txtdiscount19, txtprice19, txttotal19, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float t13 = Float.parseFloat(txttotal13.getText());
       float t14 = Float.parseFloat(txttotal14.getText());
       float t15 = Float.parseFloat(txttotal15.getText());
       float t16 = Float.parseFloat(txttotal16.getText());
       float t17 = Float.parseFloat(txttotal17.getText());
       float t18 = Float.parseFloat(txttotal18.getText());
       float t19 = Float.parseFloat(txttotal19.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16+t17+t18+t19;
      // txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty19FocusLost

    private void txtqty19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqty19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqty19ActionPerformed

    private void txtdiscount19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount19KeyReleased
     try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname19, txtqty19, txtdiscount19, txtprice19, txttotal19, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float t13 = Float.parseFloat(txttotal13.getText());
                    float t14 = Float.parseFloat(txttotal14.getText());
                    float t15 = Float.parseFloat(txttotal15.getText());
                    float t16 = Float.parseFloat(txttotal16.getText());
                    float t17 = Float.parseFloat(txttotal17.getText());
                    float t18 = Float.parseFloat(txttotal18.getText());
                    float t19 = Float.parseFloat(txttotal19.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16+t17+t18+t19;
                  //  txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount19KeyReleased

    private void txtqty20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtqty20FocusLost
     getTextValues(comboproductname20, txtqty20, txtdiscount20, txtprice20, txttotal20, txttax, txtbill);
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
       float t11 = Float.parseFloat(txttotal11.getText());
       float t12 = Float.parseFloat(txttotal12.getText());
       float t13 = Float.parseFloat(txttotal13.getText());
       float t14 = Float.parseFloat(txttotal14.getText());
       float t15 = Float.parseFloat(txttotal15.getText());
       float t16 = Float.parseFloat(txttotal16.getText());
       float t17 = Float.parseFloat(txttotal17.getText());
       float t18 = Float.parseFloat(txttotal18.getText());
       float t19 = Float.parseFloat(txttotal19.getText());
       float t20 = Float.parseFloat(txttotal20.getText());
       float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16+t17+t18+t19+t20;
     //  txtgrandtotal.setText(String.valueOf(amt));
       float tax = (amt * 0.0f);
       txttax.setText(String.valueOf(tax));
       float bill = amt + tax;
        txtbill.setText(String.valueOf(bill));
    }//GEN-LAST:event_txtqty20FocusLost

    private void txtqty20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqty20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqty20ActionPerformed

    private void txtdiscount20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiscount20KeyReleased
    try {
            if (evt.getKeyCode() >= KeyEvent.VK_0 && evt.getKeyCode() <= KeyEvent.VK_9) {
                 getTextValues(comboproductname20, txtqty20, txtdiscount20, txtprice20, txttotal20, txttax, txtbill);
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
                    float t11 = Float.parseFloat(txttotal11.getText());
                    float t12 = Float.parseFloat(txttotal12.getText());
                    float t13 = Float.parseFloat(txttotal13.getText());
                    float t14 = Float.parseFloat(txttotal14.getText());
                    float t15 = Float.parseFloat(txttotal15.getText());
                    float t16 = Float.parseFloat(txttotal16.getText());
                    float t17 = Float.parseFloat(txttotal17.getText());
                    float t18 = Float.parseFloat(txttotal18.getText());
                    float t19 = Float.parseFloat(txttotal19.getText());
                    float t20 = Float.parseFloat(txttotal20.getText());
                    float amt=t1+t2+t3+t4+t5+t6+t7+t8+t9+t10+t11+t12+t13+t14+t15+t16+t17+t18+t19+t20;
                  //  txtgrandtotal.setText(String.valueOf(amt));
                    float tax = (amt * 0.0f);
                    txttax.setText(String.valueOf(tax));
                    float bill = amt + tax;
                    txtbill.setText(String.valueOf(bill));
                    //txtcredit.setText(String.valueOf(bill));
                
            }
        } catch (NumberFormatException | NullPointerException e) {}
    }//GEN-LAST:event_txtdiscount20KeyReleased

    private void comboproductname11ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname11ItemStateChanged
       getProductDetails(comboproductname11, txtqty11, txtprice11);
    }//GEN-LAST:event_comboproductname11ItemStateChanged

    private void comboproductname12ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname12ItemStateChanged
       getProductDetails(comboproductname12, txtqty12, txtprice12);
    }//GEN-LAST:event_comboproductname12ItemStateChanged

    private void comboproductname13ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname13ItemStateChanged
        getProductDetails(comboproductname13, txtqty13, txtprice13);
    }//GEN-LAST:event_comboproductname13ItemStateChanged

    private void comboproductname14ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname14ItemStateChanged
       getProductDetails(comboproductname14, txtqty14, txtprice14);
    }//GEN-LAST:event_comboproductname14ItemStateChanged

    private void comboproductname15ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname15ItemStateChanged
     getProductDetails(comboproductname15, txtqty15, txtprice15);
    }//GEN-LAST:event_comboproductname15ItemStateChanged

    private void comboproductname16ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname16ItemStateChanged
      getProductDetails(comboproductname16, txtqty16, txtprice16);
    }//GEN-LAST:event_comboproductname16ItemStateChanged

    private void comboproductname17ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname17ItemStateChanged
       getProductDetails(comboproductname17, txtqty17, txtprice17);
    }//GEN-LAST:event_comboproductname17ItemStateChanged

    private void comboproductname18ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname18ItemStateChanged
      getProductDetails(comboproductname18, txtqty18, txtprice18);
    }//GEN-LAST:event_comboproductname18ItemStateChanged

    private void comboproductname19ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname19ItemStateChanged
        getProductDetails(comboproductname19, txtqty19, txtprice19);
    }//GEN-LAST:event_comboproductname19ItemStateChanged

    private void comboproductname20ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboproductname20ItemStateChanged
        getProductDetails(comboproductname20, txtqty20, txtprice20);
    }//GEN-LAST:event_comboproductname20ItemStateChanged

    private void comboproductname6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboproductname6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboproductname6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btngeneratebill;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnrefreshname;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combocustomername;
    private javax.swing.JComboBox comboproductname1;
    private javax.swing.JComboBox comboproductname10;
    private javax.swing.JComboBox comboproductname11;
    private javax.swing.JComboBox comboproductname12;
    private javax.swing.JComboBox comboproductname13;
    private javax.swing.JComboBox comboproductname14;
    private javax.swing.JComboBox comboproductname15;
    private javax.swing.JComboBox comboproductname16;
    private javax.swing.JComboBox comboproductname17;
    private javax.swing.JComboBox comboproductname18;
    private javax.swing.JComboBox comboproductname19;
    private javax.swing.JComboBox comboproductname2;
    private javax.swing.JComboBox comboproductname20;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbltax;
    private javax.swing.JRadioButton radiocash;
    private javax.swing.JRadioButton radiocredit;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbill;
    private javax.swing.JTextField txtcredit;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtdiscount1;
    private javax.swing.JTextField txtdiscount10;
    private javax.swing.JTextField txtdiscount11;
    private javax.swing.JTextField txtdiscount12;
    private javax.swing.JTextField txtdiscount13;
    private javax.swing.JTextField txtdiscount14;
    private javax.swing.JTextField txtdiscount15;
    private javax.swing.JTextField txtdiscount16;
    private javax.swing.JTextField txtdiscount17;
    private javax.swing.JTextField txtdiscount18;
    private javax.swing.JTextField txtdiscount19;
    private javax.swing.JTextField txtdiscount2;
    private javax.swing.JTextField txtdiscount20;
    private javax.swing.JTextField txtdiscount3;
    private javax.swing.JTextField txtdiscount4;
    private javax.swing.JTextField txtdiscount5;
    private javax.swing.JTextField txtdiscount6;
    private javax.swing.JTextField txtdiscount7;
    private javax.swing.JTextField txtdiscount8;
    private javax.swing.JTextField txtdiscount9;
    private javax.swing.JTextField txtprice1;
    private javax.swing.JTextField txtprice10;
    private javax.swing.JTextField txtprice11;
    private javax.swing.JTextField txtprice12;
    private javax.swing.JTextField txtprice13;
    private javax.swing.JTextField txtprice14;
    private javax.swing.JTextField txtprice15;
    private javax.swing.JTextField txtprice16;
    private javax.swing.JTextField txtprice17;
    private javax.swing.JTextField txtprice18;
    private javax.swing.JTextField txtprice19;
    private javax.swing.JTextField txtprice2;
    private javax.swing.JTextField txtprice20;
    private javax.swing.JTextField txtprice3;
    private javax.swing.JTextField txtprice4;
    private javax.swing.JTextField txtprice5;
    private javax.swing.JTextField txtprice6;
    private javax.swing.JTextField txtprice7;
    private javax.swing.JTextField txtprice8;
    private javax.swing.JTextField txtprice9;
    private javax.swing.JTextField txtqty1;
    private javax.swing.JTextField txtqty10;
    private javax.swing.JTextField txtqty11;
    private javax.swing.JTextField txtqty12;
    private javax.swing.JTextField txtqty13;
    private javax.swing.JTextField txtqty14;
    private javax.swing.JTextField txtqty15;
    private javax.swing.JTextField txtqty16;
    private javax.swing.JTextField txtqty17;
    private javax.swing.JTextField txtqty18;
    private javax.swing.JTextField txtqty19;
    private javax.swing.JTextField txtqty2;
    private javax.swing.JTextField txtqty20;
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
    private javax.swing.JTextField txttotal11;
    private javax.swing.JTextField txttotal12;
    private javax.swing.JTextField txttotal13;
    private javax.swing.JTextField txttotal14;
    private javax.swing.JTextField txttotal15;
    private javax.swing.JTextField txttotal16;
    private javax.swing.JTextField txttotal17;
    private javax.swing.JTextField txttotal18;
    private javax.swing.JTextField txttotal19;
    private javax.swing.JTextField txttotal2;
    private javax.swing.JTextField txttotal20;
    private javax.swing.JTextField txttotal3;
    private javax.swing.JTextField txttotal4;
    private javax.swing.JTextField txttotal5;
    private javax.swing.JTextField txttotal6;
    private javax.swing.JTextField txttotal7;
    private javax.swing.JTextField txttotal8;
    private javax.swing.JTextField txttotal9;
    // End of variables declaration//GEN-END:variables
}
