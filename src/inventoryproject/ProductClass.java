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
public class ProductClass {
    
    private String productname;
     private String units;
    private String quantity;
    private String costprice;
    private String saleprice;
    private String mrp;
    private String status;
    private String reorderlevel;
    private String categoryname;
    private String suppliername;

    public ProductClass() {
    }

    public ProductClass(String productname, String units, String quantity, String costprice, String saleprice, String mrp, String status, String reorderlevel, String categoryname, String suppliername) {
        this.productname = productname;
        this.units = units;
        this.quantity = quantity;
        this.costprice = costprice;
        this.saleprice = saleprice;
        this.mrp = mrp;
        this.status = status;
        this.reorderlevel = reorderlevel;
        this.categoryname = categoryname;
        this.suppliername = suppliername;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCostprice() {
        return costprice;
    }

    public void setCostprice(String costprice) {
        this.costprice = costprice;
    }

    public String getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(String saleprice) {
        this.saleprice = saleprice;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(String reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    
    
    
    
    
}
