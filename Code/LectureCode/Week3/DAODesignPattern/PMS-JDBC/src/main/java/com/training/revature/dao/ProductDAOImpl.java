/**
 * This class takes all the methods from the interface(ProductDAO) and implements them
 */

package com.training.revature.dao;

import com.training.revature.model.Product;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{

    //1.Does product exist
    //The SELECT PreparedStatement to be executed on the database
    private static final String SELECT_PRODUCT_STATEMENT = "SELECT ? FROM product";

    //2.Add Product
    //The INSERT INTO PreparedStatement to be executed on the database
    private static final String INSERT_PRODUCT_STATEMENT = "INSERT INTO product VALUES(?,?,?,?)";

    //The UPDATE PreparedStatement to be executed on the database
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE product SET productId = ?, productName = ?, qoh = ?, price = ?";

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
