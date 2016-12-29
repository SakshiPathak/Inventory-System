/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ProductReport extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProductReport
     */
    public ProductReport() {
        initComponents();
    }
    
    public ArrayList<ProductClass> getProductList()
    {
        ArrayList<ProductClass> productList=new ArrayList<ProductClass>();
        Connection con=null;
        ResultSet rs=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","sakshi");
            Statement st=con.createStatement();
            rs=st.executeQuery("select Name,Units,Quantity,Cost_Price,Sale_Price,Status,Re_Order_Level from product where ID IN(select C.Name,S.Name from Product P,Category C,Supplier S where P.Category_ID=C.ID AND P.Supplier_ID=S.ID)");
            ProductClass product;
            while(rs.next())
            {
            product=new ProductClass(rs.getString("Name"), rs.getString("Units"), rs.getString("Quantity"), rs.getString("Cost_Price"), rs.getString("Sale_Price"), rs.getString("Status"), rs.getString("Re_Order_Level"), rs.getString("Name"), rs.getString("Name"));
            productList.add(product);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return productList;
    }
    
    public void showData()
    {
        ArrayList<ProductClass> list= getProductList();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row=new Object[9];
        for(int i=0;i<list.size();i++)
        {
            
            row[0]=list.get(i).getProductname();
            row[1]=list.get(i).getUnits();
            row[2]=list.get(i).getQuantity();
            row[3]=list.get(i).getCostprice();
            row[4]=list.get(i).getSaleprice();
            row[5]=list.get(i).getStatus();
            row[6]=list.get(i).getReorderlevel();
            row[7]=list.get(i).getCategoryname();
            row[8]=list.get(i).getSuppliername();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setTitle("Product Report");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Units", "Quantity", "Cost Price", "Sale Price", "Status", "Reorder Level", "Category Name", "Supplier Name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        showData();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}