/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventoryproject;

/**
 *
 * @author HP
 */
public class BillClass {
    private String billid;
    private String username;
    private String customername;
    private String amount;
    private String status;
    private String pendingpayment;
    private String date;

    public BillClass() {
    }

    public BillClass(String billid, String username, String customername, String amount, String status, String pendingpayment, String date) {
        this.billid = billid;
        this.username = username;
        this.customername = customername;
        this.amount = amount;
        this.status = status;
        this.pendingpayment = pendingpayment;
        this.date = date;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPendingpayment() {
        return pendingpayment;
    }

    public void setPendingpayment(String pendingpayment) {
        this.pendingpayment = pendingpayment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    

    
    
    
}
