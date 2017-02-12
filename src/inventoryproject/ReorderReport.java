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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ReorderReport extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReorderReport
     */
    public ReorderReport() {
        initComponents();
    }
    
    public ArrayList<ReorderClass> getReorderList()
    {
        ArrayList<ReorderClass> reorderList=new ArrayList<ReorderClass>();
        Connection con=null;
        ResultSet rs=null;
        PreparedStatement pst;
       
        try
        {
            //Class.forName("com.mysql.jdbc.Driver");
            con=DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement("select p.id, p.name, c.name, p.quantity, p.re_order_level from product p, category c where p.category_id=c.id AND quantity < re_order_level");

            rs = pstmt.executeQuery();
            
            //
            ReorderClass reorder;
            while(rs.next())
            {
            reorder=new ReorderClass(rs.getString("p.id"), rs.getString("p.name"), rs.getString("c.name"), rs.getString("p.quantity"), rs.getString("p.re_order_level"));
            reorderList.add(reorder);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return reorderList;
    }
    
    public void showData()
    {
        ArrayList<ReorderClass> list= getReorderList();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        Object[] row=new Object[5];
        for(int i=0;i<list.size();i++)
        {
            row[0]=list.get(i).getProductid();
            row[1]=list.get(i).getProductname();
            row[2]=list.get(i).getCategoryname();
            row[3]=list.get(i).getQuantity();
            row[4]=list.get(i).getReorderlevel();
            
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
        setTitle("Stock Reorder Report");
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
                "Product ID", "Product Name", "Category Name", "Quantity", "Reorder Level"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        showData();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
