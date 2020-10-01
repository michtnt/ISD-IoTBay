/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IoTBay.mvp.model;

import java.io.Serializable;

/**  
 *
 * @author rebeccagalletta
 */
public class Product implements Serializable{
    //the fields
    private int productid;
    private String productname;
    private String brand;
    private double price;
    private int stock;
    private String description;
    
    //initialise the variables
    public Product(int productid, String productname, String brand, double price, int stock, String description) {
        this.productid = productid;
        this.productname = productname;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }
    
    public Product(){}

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
