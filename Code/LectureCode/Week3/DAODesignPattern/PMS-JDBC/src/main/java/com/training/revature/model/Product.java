/**
 * This class correlates to the public.product table in our postgres database
 * WE WILL HAVE TO CREATE A MODEL CLASS LIKE THIS IN OUR PROJECT
 */

package com.training.revature.model;

import java.io.Serializable;
import java.util.Objects;

//We implement Serializable because maybe we need to store something
//As best practice anywhere you need to save this it won't give you an error
public class Product implements Serializable {
    //These variables represent the columns in the product table
    private int productId;
    private String productName;
    private int qoh;
    private int price;

    //You need to have a default constructor, at least for the variables that represent the columns in the table
    public Product() {
    }

    //You need to have parameterized constructor, at least for the variables that represent the columns in the table
    public Product(int productId, String productName, int qoh, int price) {
        this.productId = productId;
        this.productName = productName;
        this.qoh = qoh;
        this.price = price;
    }

    //You need to have setters, at least for the variables that represent the columns in the table
    public void setProductId(int productId) {this.productId = productId;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setProductQoh(int qoh) {this.qoh = qoh;}
    public void setProductPrice(int price) {this.price = price;}

    //You need to have getters, at least for the variables that represent the columns in the table
    public int getProductId() {return productId;}
    public String getProductName() {return productName;}
    public int getQoh() {return qoh;}
    public int getPrice() {return price;}

    //equals() and hashCode() you need if you want to compare two products
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && qoh == product.qoh && price == product.price && Objects.equals(productName, product.productName);
    }

    //equals() and hashCode() you need if you want to compare two products
    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, qoh, price);
    }

    //You need toString() if you want to print the object out
    @Override
    public String toString() {
        return "\nProduct{" +
                "\nproductId=" + productId +
                "\nproductName='" + productName + '\'' +
                "\nqoh=" + qoh +
                "\nprice=" + price +
                "}\n";
    }
}
