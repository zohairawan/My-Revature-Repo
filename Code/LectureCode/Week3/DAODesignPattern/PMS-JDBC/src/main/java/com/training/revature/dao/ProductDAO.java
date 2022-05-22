/**
 * In this interface you should write all the functions you wish to be used in the other classes
 * Client --> DAO / DAO Impl --> DB
 * DAO is responsible for doing only the database access object
 */

package com.training.revature.dao;

import com.training.revature.model.Product;
import java.util.List;

public interface ProductDAO {
    //1.Does product exist
    public boolean isProductExist(int productId);

    //2.Add Product
    public boolean addProduct(Product product);

    //3.Update Product
    public boolean updateProduct(Product product);

    //4.Delete Product
    public boolean deleteProduct(int productId);

    //5.Find Product by Id
    public Product getProduct(int productId);

    //6.Find product by Name
    public List<Product> getProduct(String productName);

    //7.Find all Products
    public List<Product> getProducts();

    //8.Update Stock
    public int updateStock(int productId, int addQoh);

    //9. Discount Price
    public int updatePrice(int productId, int discountPercent);
}
