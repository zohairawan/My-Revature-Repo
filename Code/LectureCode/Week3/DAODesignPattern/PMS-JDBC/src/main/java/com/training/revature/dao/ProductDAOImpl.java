/**
 * This class takes all the methods from the interface(ProductDAO) and implements them
 */

package com.training.revature.dao;

import com.training.revature.model.Product;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{

    //1.Does product exist
    //The SELECT PreparedStatement to be executed on the database
    private static final String SELECT_PRODUCT = "SELECT productid FROM product WHERE productid = ?";

    //2.Add Product
    //The INSERT INTO PreparedStatement to be executed on the database
    private static final String INSERT_PRODUCT = "INSERT INTO product VALUES(?,?,?,?)";

    //3.Update Product
    //The UPDATE PreparedStatement to be executed on the database
    private static final String UPDATE_PRODUCT = "UPDATE product SET productname = ?, qoh = ?, price = ? WHERE productid = ?";

    //4.Delete Product
    //The DELETE PreparedStatement to be executed on the database
    private static final String DELETE_PRODUCT = "DELETE FROM product WHERE productid = ?";

    //5.Find Product by Id
    //The SELECT PreparedStatement to be executed on the database
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM product WHERE productid = ?";

    //6.Find product by Name
    //The SELECT PreparedStatement to be executed on the database
    private static final String GET_PRODUCT_BY_NAME = "SELECT * FROM product WHERE productname = ?";

    //7.Find all Products
    //The SELECT PreparedStatement to be executed on the database
    private static final String GET_ALL_PRODUCT = "SELECT * FROM product";

    //8.Update Stock
    //The UPDATE PreparedStatement to be executed on the database
    private static final String UPDATE_STOCK = "UPDATE product SET qoh = ? WHERE productid = ?";

    //9.Update Price
    //The UPDATE PreparedStatement to be executed on the database
    private static final String UPDATE_PRICE = "UPDATE product SET price = ? WHERE productid = ?";

    @Override
    public boolean isProductExist(int productId) {
        return false;
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }

    @Override
    public List<Product> getProduct(String productName) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public int updateStock(int productId, int addQoh) {
        return 0;
    }

    @Override
    public int updatePrice(int productId, int discountPercent) {
        return 0;
    }
}
