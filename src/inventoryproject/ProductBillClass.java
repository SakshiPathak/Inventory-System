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
public class ProductBillClass {
    private String id;
    private String productname;
     private String units;
    private String quantity;
    private String costprice;
    private String saleprice;
    private String status;
    private String reorderlevel;
    private String categoryid;
    private String supplierid;

    public ProductBillClass() {
    }

    public ProductBillClass(String id, String productname, String units, String quantity, String costprice, String saleprice, String status, String reorderlevel, String categoryid, String supplierid) {
        this.id=id;
        this.productname = productname;
        this.units = units;
        this.quantity = quantity;
        this.costprice = costprice;
        this.saleprice = saleprice;
        this.status = status;
        this.reorderlevel = reorderlevel;
        this.categoryid = categoryid;
        this.supplierid = supplierid;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }
    
    
}
