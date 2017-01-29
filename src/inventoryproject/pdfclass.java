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
public class pdfclass {
    private String billid;
    private String customername;
    private String date;
    private String productname;
    private String quantity;
    private String rate;
    private String amount;
    private String total;

    public pdfclass() {
    }

    public pdfclass(String billid, String customername, String date, String productname, String quantity, String rate, String amount, String total) {
        this.billid = billid;
        this.customername = customername;
        this.date = date;
        this.productname = productname;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
        this.total = total;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}
