/**
 * This class takes all the methods from the interface(ProductDAO) and implements them
 */

package com.training.revature.dao;

import com.training.revature.model.Product;
import com.training.revature.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    //These will be our PreparedStatements
    //1.Does product exist
    private static final String DOES_PRODUCT_EXIST = "SELECT productid FROM product WHERE productid = ?";
    //2.Add Product
    private static final String INSERT_PRODUCT = "INSERT INTO product VALUES(?,?,?,?)";
    //3.Update Product
    private static final String UPDATE_PRODUCT = "UPDATE product SET productname = ?, qoh = ?, price = ? WHERE productid = ?";
    //4.Delete Product
    private static final String DELETE_PRODUCT = "DELETE FROM product WHERE productid = ?";
    //5.Find Product by Id
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM product WHERE productid = ?";
    //6.Find product by Name
    private static final String GET_PRODUCT_BY_NAME = "SELECT * FROM product WHERE productname = ?";
    //7.Find all Products
    private static final String GET_ALL_PRODUCT = "SELECT * FROM product";
    //8.Update Stock
    private static final String UPDATE_STOCK = "UPDATE product SET qoh = qoh + ? WHERE productid = ?";
    //9.Update Price
    private static final String UPDATE_PRICE = "UPDATE product SET price = price - (price/100 * ?) WHERE productid = ?";

    //Create this object so we can use a PreparedStatement
    Connection connection = DBConnection.getConnection();

    @Override
    //1.Does product exist
    public boolean isProductExist(int productId) {
        //This object allows us to execute our query
        PreparedStatement pstmt;
        //Holds product if it exists
        ResultSet resultSet;
        try {
            //SELECT productid FROM product WHERE productid = ?
            pstmt = connection.prepareStatement(DOES_PRODUCT_EXIST);
            pstmt.setInt(1, productId);
            //Execute the PreparedStatement and storing the result
            resultSet = pstmt.executeQuery();
            //Checking to see if Product object exists
            if(resultSet.next()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //2.Add Product
    public boolean addProduct(Product product) {
        //This object allows us to execute our update
        PreparedStatement pstmt;
        int result = 0;
        try {
            //INSERT INTO product VALUES(?,?,?,?)
            pstmt = connection.prepareStatement(INSERT_PRODUCT);
            pstmt.setInt(1, product.getProductId());
            pstmt.setString(2, product.getProductName());
            pstmt.setInt(3, product.getQoh());
            pstmt.setInt(4, product.getPrice());
            //Execute the PreparedStatement and storing the result
            result = pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (result == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    //3.Update Product
    public boolean updateProduct(Product product) {
        //This object allows us to execute our update
        PreparedStatement pstmt;
        int result = 0;
        try {
            //UPDATE product SET productname = ?, qoh = ?, price = ? WHERE productid = ?
            pstmt = connection.prepareStatement(UPDATE_PRODUCT);
            pstmt.setInt(4, product.getProductId());
            pstmt.setString(1, product.getProductName());
            pstmt.setInt(2, product.getQoh());
            pstmt.setInt(3, product.getPrice());
            //Execute the PreparedStatement and storing the result
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(result == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    //4.Delete Product
    public boolean deleteProduct(int productId) {
        //This object allows us to execute our update
        PreparedStatement pstmt;
        int result = 0;
        try {
            //DELETE FROM product WHERE productid = ?
            pstmt = connection.prepareStatement(DELETE_PRODUCT);
            pstmt.setInt(1, productId);
            //Execute the PreparedStatement and storing the result
            result = pstmt.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (result == 0) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    //5.Find Product by Id
    public Product getProduct(int productId) {
        //This object allows us to execute our query
        PreparedStatement pstmt;
        ResultSet resultSet;
        Product product = new Product();
        try {
            //SELECT * FROM product WHERE productid = ?
            pstmt = connection.prepareStatement(GET_PRODUCT_BY_ID);
            pstmt.setInt(1, productId);
            //Execute the PreparedStatement and storing the result
            resultSet = pstmt.executeQuery();
            //Only one product will be retrieved so no need for loop
            resultSet.next();
            //Getting productid from database and setting in Product object
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setProductQoh(resultSet.getInt(3));
            product.setProductPrice(resultSet.getInt(4));
            return product;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //6.Find product by Name
    public List<Product> getProduct(String productName) {
        //SELECT * FROM product WHERE productname = ?
        //This object allows us to execute our query
        PreparedStatement pstmt;
        ResultSet resultSet;
        Product product = new Product();
        try {
            //SELECT * FROM product WHERE productid = ?
            pstmt = connection.prepareStatement(GET_PRODUCT_BY_NAME);
            pstmt.setString(1, productName);
            //Execute the PreparedStatement and storing the result
            resultSet = pstmt.executeQuery();
            //Only one product will be retrieved so no need for loop
            resultSet.next();
            //Getting productid from database and setting in Product object
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setProductQoh(resultSet.getInt(3));
            product.setProductPrice(resultSet.getInt(4));
            return product;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //7.Find all Products
    public List<Product> getProducts() {
        //SELECT * FROM product
        return null;
    }

    @Override
    //8.Update Stock
    public boolean updateStock(int productId, int addQoh) {
        //This object allows us to execute our update
        PreparedStatement pstmt;
        int result = 0;
        try {
            //UPDATE product SET qoh = qoh + ? WHERE productid = ?
            pstmt = connection.prepareStatement(UPDATE_STOCK);
            pstmt.setInt(1, addQoh);
            pstmt.setInt(2, productId);
            //Execute the PreparedStatement and storing the result
            result = pstmt.executeUpdate();
            if (result == 0) {
                return false;
            }
            else {
                return true;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    //9.Update Price
    public int updatePrice(int productId, int discountPercent) {
        //This object allows us to execute our
        //UPDATE product SET price = price - (price/100 * ?) WHERE productid = ?
        return 0;
    }
}
