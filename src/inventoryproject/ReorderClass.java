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
public class ReorderClass {
    private String productid;
    private String productname;
    private String categoryname;
    private String quantity;
    private String reorderlevel;

    public ReorderClass() {
    }

    public ReorderClass(String productid, String productname, String categoryname, String quantity, String reorderlevel) {
        this.productid = productid;
        this.productname = productname;
        this.categoryname = categoryname;
        this.quantity = quantity;
        this.reorderlevel = reorderlevel;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(String reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    
    
    
}
