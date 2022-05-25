/**
 * Class(es) in the controller package will accept the requests
 * This will contain the methods like GET, PUT, UPDATE, etc..., this will be exposed to the other app
 * Controller class is also responsible for creating an object and managing it
 */

package com.revature.pms.controller;

import com.revature.pms.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//This is at the class level so if you want enter into this controller then you have to use localhost:8084/product
//Mapping at the class level
@RequestMapping("product")
public class ProductController {

    @Autowired
    Product product;

    /**
     * @Autowired
     * AnotherProduct
     */

    //Mapping for the method level
    @GetMapping("/home") //localhost:8084/product/home
    public String home() {
        return "Welcome to Home Product App page";
    }

    @GetMapping() //localhost:8084/product
    public String getProducts() {
        return "Displaying all products";
    }

    //Call the methods to fetch the product details of this product Id
    @GetMapping("/searchProductById/{pId}") //localhost:8084/product/searchProductById/1
    public Product getProduct(@PathVariable("pId") int productId) {
        System.out.println("Fetching details about product: " + productId);
        Product product = new Product(productId, "keyboard", 99, 100);
        return product;
    }

    //Call the methods to fetch the product details of this product name
    @GetMapping("/searchProductByName/{pName}") //localhost:8084/product/searchProductByName/PS5
    public Product getProduct(@PathVariable("pName") String productName) {
        System.out.println("Fetching details about product: " + productName);
        Product product = new Product(20, productName, 99, 100);
        return product;
    }

    //Here is the result for product in the price range of 100 and 500
    @GetMapping("/filterProductByPrice/{lowerPrice}/and/{upperPrice}") //localhost:8084/product/filterProductByPrice/100/and/500
    public String filterProductByPrice(@PathVariable("lowerPrice")int lowerPrice,@PathVariable("upperPrice")int upperPrice){
        //call the methods to fetch product details of price range
        return "Here is the result for product in the price range of "+lowerPrice+" and "+ upperPrice;
    }

    //Output: Order with qoh less than 50 should be reordered immediately
    //Output: Order with qoh less than 350 should be reordered immediately
    @GetMapping("/outOfStockProductDetails/{productStock}") //localhost:8084/product/outOfStockProductDetails/350
    public String outOfStockProductDetails(@PathVariable("productStock") int productStock) {
        return "Order with qoh less than " + productStock + " should be reordered immediately";
    }

    //Deletes a single product based on productId
    @DeleteMapping("{pId}") //localhost:8084/product/123
    public String deleteProductById(@PathVariable("pId") int productId) {
        System.out.println("Deleted item number " + productId);
        return "Product " + productId + " successfully deleted";
    }

    //Save/Add a product
    //This method will save a product in DB
    @PostMapping() //localhost:8084/product
    public String saveProduct(@RequestBody Product product) {
        System.out.println("Saving details of " + product);
        return "Saved successfully";
    }

    //Update a product
    @PutMapping() //localhost:8084/product
    public String updateProduct(@RequestBody Product product) {
        System.out.println("Updating details of " + product);
        return "Product successfully updated";
    }
}
