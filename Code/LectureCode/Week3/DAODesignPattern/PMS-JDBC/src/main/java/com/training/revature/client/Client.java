/**
 * Product CRUD App
 * M E N U
 * 1. Add Product
 * 2. Delete Product
 * 3. Find Product by Id
 * 4. Find product by Name
 * 5. Find all Products
 * 6. Update Stock
 * 7. Update Price
 * 8. Update Product
 * 9. E X I T
 *
 * Input values for initializing Product object will be taken from this class
 */

package com.training.revature.client;

public class Client {
    public static void main(String[] args) {
        ProductApp productApp = new ProductApp();
        productApp.startProductApp();
    }
}
