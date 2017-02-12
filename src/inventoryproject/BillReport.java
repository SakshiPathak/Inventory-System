/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

import com.inventorysystem.helpers.DBConnection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import sun.swing.SwingUtilities2;

/**
 *
 * @author HP
 */
public class BillReport extends javax.swing.JInternalFrame {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    List<CustomerClass> billList;

    /**
     * Creates new form BillReport
     */
    public BillReport() {
        initComponents();
        billList = new ArrayList<>();
        
        populateBillDateCombo();
    }
    
    private void addEventToTable() {
        jTable1.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                int row = jTable1.getSelectedRow();
                //int col = 0;
                //String billid[] = new String[row];
                //String pending[] = new String[row];
                //for (int i = 0; i < row; i++) {
                String billid = jTable1.getValueAt(row,0).toString();
                 String pending = jTable1.getValueAt(row, 5).toString();
                
                //int billNo = Integer.parseInt((String)jTable1.getValueAt(e.getFirstRow(), 0));
                //jTable1.getValueAt(e.getFirstRow(), e.getColumn());
                //System.out.println(String.valueOf(jTable1.getValueAt(e.getFirstRow(), e.getColumn())));
                //System.out.println("e");
                try {
            con = DBConnection.getConnection();
//            String sql = "update bill set pending='" + pending[i] + "' where  id='"+ + "'";
             pst = con.prepareStatement("update bill set pending='" + pending + "' where  id='" + billid + "'");
             //pst.setInt(1, billNo);
            int k = pst.executeUpdate();
            if(k>0)
            JOptionPane.showMessageDialog(null, "updated");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
                //}
            }
        });
    }
    
         
    
    public ArrayList<BillClass> getBillList()
    {
        ArrayList<BillClass> billList=new ArrayList<BillClass>();
        
        try
        {
            String customername=txtcustomername.getText();
            //String selectedName = (String) combocustomername.getSelectedItem();
            //Class.forName("com.mysql.jdbc.Driver");
            con=DBConnection.getConnection();
            
             
            
            
            PreparedStatement pstmt = con.prepareStatement("select B.id, U.username, C.first_name, C.last_name, bill, status, pending, date from bill B, customer C, user U where B.customer_id=C.id and B.user_id=U.id AND C.first_name=?");
            pstmt.setString(1, customername);
            //pst.setInt(1, Integer.parseInt(billList.get(combocustomername.getSelectedIndex()-1).getId()));
            ResultSet rs = pstmt.executeQuery();
            
            //
            BillClass bill;
            while(rs.next())
            {
            bill=new BillClass(rs.getString("B.id"), rs.getString("U.username"),rs.getString("C.first_name") + " " + rs.getString("C.last_name"), rs.getString("bill"), rs.getString("status"), rs.getString("pending"), rs.getString("date"));
            billList.add(bill);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return billList;
    }
    
    public void showData()
    {
        ArrayList<BillClass> list= getBillList();
        DefaultTableModel model=getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getBillid();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getCustomername();
            row[3]=list.get(i).getAmount();
            row[4]=list.get(i).getStatus();
            row[5]=list.get(i).getPendingpayment();
            row[6]=list.get(i).getDate();
            
            model.addRow(row);
        }
        jTable1.setModel(model);
        addEventToTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combodate = new javax.swing.JComboBox();
        radiocash = new javax.swing.JRadioButton();
        radiocredit = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtcustomername = new javax.swing.JTextField();
        txtbillid = new javax.swing.JTextField();

        setClosable(true);
        setMaximizable(true);
        setTitle("Bill Report");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill ID", "User Name", "Customer Name", "Total Bill", "Status", "Pending Payment", "Date"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Search by Customer");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Search by Bill ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Search by Date");

        combodate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combodateItemStateChanged(evt);
            }
        });

        buttonGroup1.add(radiocash);
        radiocash.setSelected(true);
        radiocash.setText("Cash");
        radiocash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiocashActionPerformed(evt);
            }
        });

        buttonGroup1.add(radiocredit);
        radiocredit.setText("Credit");
        radiocredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiocreditActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Search by Pending Payment");

        txtcustomername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcustomernameActionPerformed(evt);
            }
        });

        txtbillid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbillidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcustomername, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(txtbillid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radiocash)
                        .addGap(18, 18, 18)
                        .addComponent(radiocredit))
                    .addComponent(combodate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radiocash)
                    .addComponent(radiocredit)
                    .addComponent(jLabel5)
                    .addComponent(txtcustomername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(combodate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtbillid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    int billid=0;
    public ArrayList<BillClass> getBillList1()
    {
        ArrayList<BillClass> billList=new ArrayList<BillClass>();
        
        try
        {
             billid = Integer.parseInt(txtbillid.getText());
            //Class.forName("com.mysql.jdbc.Driver");
            con=DBConnection.getConnection();
            
            PreparedStatement pstmt = con.prepareStatement("select B.id, U.username, C.first_name, C.last_name, bill, status, pending, date from bill B, customer C, user U where B.customer_id=C.id and B.user_id=U.id AND B.id=?");
            pstmt.setInt(1, billid);
            ResultSet rs = pstmt.executeQuery();
            
            //
            BillClass bill;
            while(rs.next())
            {
            bill=new BillClass(rs.getString("B.id"),rs.getString("U.username"), rs.getString("C.first_name") + " " + rs.getString("C.last_name"),  rs.getString("bill"), rs.getString("status"), rs.getString("pending"), rs.getString("date"));
            billList.add(bill);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return billList;
    }
    
    public void showData1()
    {
        ArrayList<BillClass> list= getBillList1();
        DefaultTableModel model=getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getBillid();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getCustomername();
            row[3]=list.get(i).getAmount();
            row[4]=list.get(i).getStatus();
            row[5]=list.get(i).getPendingpayment();
            row[6]=list.get(i).getDate();
            
            model.addRow(row);
        }
        jTable1.setModel(model);
        addEventToTable();
    }
    
    private void populateBillDateCombo() {
    try {
        con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("select date from bill");
        
        ResultSet rs = pstmt.executeQuery();
        combodate.addItem("");
        while (rs.next())
            combodate.addItem(rs.getString("date"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public ArrayList<BillClass> getBillList2()
    {
        ArrayList<BillClass> billList=new ArrayList<BillClass>();
        
        try
        {
            String selectedDate = (String) combodate.getSelectedItem();
            //Class.forName("com.mysql.jdbc.Driver");
            con=DBConnection.getConnection();
            
            PreparedStatement pstmt = con.prepareStatement("select B.id, U.username, C.first_name, C.last_name, bill, status, pending, date from bill B, customer C, user U where B.customer_id=C.id and B.user_id=U.id AND date=?");
            pstmt.setString(1, selectedDate);
            ResultSet rs = pstmt.executeQuery();
            
            //
            BillClass bill;
            while(rs.next())
            {
            bill=new BillClass(rs.getString("B.id"), rs.getString("U.username"), rs.getString("C.first_name") + " " + rs.getString("C.last_name"), rs.getString("bill"), rs.getString("status"), rs.getString("pending"), rs.getString("date"));
            billList.add(bill);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return billList;
    }

    private DefaultTableModel getModel() {
        
        return(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Bill ID", "User Name", "Customer Name", "Total Bill", "Status", "Pending Payment", "Date"
            }
        ));
        
    }
    
    public void showData2()
    {
        ArrayList<BillClass> list= getBillList2();
        DefaultTableModel model=getModel();
        Object[] row=new Object[7];
        
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getBillid();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getCustomername();
            row[3]=list.get(i).getAmount();
            row[4]=list.get(i).getStatus();
            row[5]=list.get(i).getPendingpayment();
            row[6]=list.get(i).getDate();
            
            model.addRow(row);
        }        
        
        jTable1.setModel(model);
        addEventToTable();
    }
    
    boolean isShown = false;
    
    private void combodateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combodateItemStateChanged
        if (!isShown)
            showData2();
        
        isShown = !isShown;
    }//GEN-LAST:event_combodateItemStateChanged
    
    public ArrayList<BillClass> getBillList3()
    {
        ArrayList<BillClass> billList=new ArrayList<BillClass>();
        
        try
        {
            boolean status=radiocash.isSelected();
            //Class.forName("com.mysql.jdbc.Driver");
            con=DBConnection.getConnection();
            
            PreparedStatement pstmt = con.prepareStatement("select B.id, U.username, C.first_name, C.last_name, bill, status, pending, date from bill B, customer C, user U where B.customer_id=C.id and B.user_id=U.id AND status=?");
            pstmt.setBoolean(1, status);
            ResultSet rs = pstmt.executeQuery();
            
            //
            BillClass bill;
            while(rs.next())
            {
            bill=new BillClass(rs.getString("B.id"), rs.getString("U.username"), rs.getString("C.first_name") + " " + rs.getString("C.last_name"), rs.getString("bill"), rs.getString("status"), rs.getString("pending"), rs.getString("date"));
            billList.add(bill);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return billList;
    }
    
    public void showData3()
    {
        ArrayList<BillClass> list= getBillList3();
        DefaultTableModel model=getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getBillid();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getCustomername();
            row[3]=list.get(i).getAmount();
            row[4]=list.get(i).getStatus();
            row[5]=list.get(i).getPendingpayment();
            row[6]=list.get(i).getDate();
            
            model.addRow(row);
        }
        jTable1.setModel(model);
        addEventToTable();
    }
   
    
    private void radiocashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiocashActionPerformed
      showData3();
    }//GEN-LAST:event_radiocashActionPerformed

    private void radiocreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiocreditActionPerformed
       showData3();
    }//GEN-LAST:event_radiocreditActionPerformed

    private void txtcustomernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcustomernameActionPerformed
       showData();
    }//GEN-LAST:event_txtcustomernameActionPerformed

    private void txtbillidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbillidActionPerformed
       showData1();
    }//GEN-LAST:event_txtbillidActionPerformed

    public ArrayList<BillClass> getBillList4()
    {
        ArrayList<BillClass> billList=new ArrayList<BillClass>();
        
        try
        {
            int row = jTable1.getSelectedRow();
           //int row = jTable1.getSelectedRow();
           int col = 5;
            //Class.forName("com.mysql.jdbc.Driver");
            con=DBConnection.getConnection();
            
             pst = con.prepareStatement("select B.id, U.username, C.first_name, C.last_name, bill, status, pending, date from bill B, customer C, user U where B.customer_id=C.id and B.user_id=U.id");
            //pst.setInt(1, row);
             rs = pst.executeQuery();
            
            //
            BillClass bill;
            while(rs.next())
            {
            bill=new BillClass(rs.getString("B.id"), rs.getString("U.username"), rs.getString("C.first_name") + " " + rs.getString("C.last_name"), rs.getString("bill"), rs.getString("status"), rs.getString("pending"), rs.getString("date"));
            billList.add(bill);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return billList;
    }
    
    public void showData4()
    {
        ArrayList<BillClass> list= getBillList3();
        DefaultTableModel model=getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getBillid();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getCustomername();
            row[3]=list.get(i).getAmount();
            row[4]=list.get(i).getStatus();
            row[5]=list.get(i).getPendingpayment();
            row[6]=list.get(i).getDate();
            
            model.addRow(row);
        }
        jTable1.setModel(model);
        addEventToTable();
    }
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            int row = jTable1.getSelectedRow();
            int col = 0;

            int billNo = Integer.parseInt((String) jTable1.getValueAt(row, col));
            //System.out.println(billNo);
            
            try {
                File file = new File(billNo + ".html");
                FileInputStream inputstream = new FileInputStream(file);
                inputstream.close();
            
          Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + file.getAbsolutePath());
           //Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe " + file.getAbsolutePath());
            //PrintWriter fileWriter = new PrintWriter(new FileOutputStream(file));
               //  Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + customerNo +".html");
            } catch (IOException ex) {
                Logger.getLogger(BillReport.class.getName()).log(Level.SEVERE, null, ex);
            } catch(Exception e) { }

//            try {
//                 Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe " + billNo +".html");
//            } 
////            catch (IOException ex) {
////                Logger.getLogger(BillReport.class.getName()).log(Level.SEVERE, null, ex);
////            } 
//            catch (Exception e) {}

    //        try
    //        {
    //         row=jTable1.rowAtPoint(evt.getPoint());
    //        col= 5;
    //JOptionPane.showMessageDialog(null, jTable1.getValueAt(row,col).toString());
    ////System.out.println(” Value in the cell clicked :”+ ” ” +table.getValueAt(row,col).toString());
    //        }catch(Exception e)
    //        {}
    //        try
    //        {
    //           row = jTable1.rowAtPoint(evt.getPoint());
    //           col = 5;
    //           con = DBConnection.getConnection();
    //           pst = con.prepareStatement("update bill set quantity=? where name=?");
    //        }catch(Exception e)
    //        {}
    //        showData4();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
//        System.out.println("working");
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            System.out.println("Working");
//            //---->int row = jTable1.getSelectedRow();
//            int count = jTable1.getRowCount();
//    int col = jTable1.getColumnCount();
//    String billid[] = new String[count];
////    String username[] = new String[count];
////    String customername[] = new String[count];
////    String totalbill[] = new String[count];
////    String status[] = new String[count];
//    String pending[] = new String[count];
////    String date[] = new String[count];
//
//    for (int i = 0; i < count; i++) {
//       billid[i] = jTable1.getValueAt(i,0).toString();
////        username[i] = jTable1.getValueAt(i,1).toString();
////        customername[i] = jTable1.getValueAt(i,2).toString();
////        totalbill[i] = jTable1.getValueAt(i,3).toString();
////        status[i] = jTable1.getValueAt(i,4).toString();
//        pending[i] = jTable1.getValueAt(i, 5).toString();
////        date[i] = jTable1.getValueAt(i,6).toString();
//
//        try {
//            con = DBConnection.getConnection();
////            String sql = "update bill set pending='" + pending[i] + "' where  id='"+ + "'";
//            pst = con.prepareStatement("update bill set pending='" + pending[i] + "' where  id='" + billid[i] + "'");
//            int k = pst.executeUpdate();
//            if(k>0)
//            JOptionPane.showMessageDialog(null, "updated");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }  
//
//    }
//        }
    }//GEN-LAST:event_jTable1KeyPressed
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combodate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radiocash;
    private javax.swing.JRadioButton radiocredit;
    private javax.swing.JTextField txtbillid;
    private javax.swing.JTextField txtcustomername;
    // End of variables declaration//GEN-END:variables
}
