/**
 * Class(es) in the controller package will accept the requests
 * This will contain the methods like GET, PUT, UPDATE, etc..., this will be exposed to the other app
 */

package com.revature.pms.controller;

import com.revature.pms.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//This is at the class level so if you want enter into this controller then you have to use localhost:8084/product
//Mapping at the class level
@RequestMapping("product")
public class ProductController {

    //Mapping for the method level
    @GetMapping("home") // in order to reach hear you must type localhost:8084/product/home in web browser
    public String home() {
        return "Welcome to Home Product App";
    }

    //Call the methods to fetch the product details of this product Id
    @GetMapping("/searchProductById/{pId}") //localhost:8084/product/searchProductById/1
    public Product getProduct(@PathVariable("pId") int productId) {
        System.out.println("Fetching details about product: " + productId);
        Product product = new Product(productId, "keyboard", 99, 100);
        return product;
    }

    @GetMapping("/searchProductByName/{pName}") //localhost:8084/product/searchProductByName/PS5
    public Product getProduct(@PathVariable("pName") String productName) {
        System.out.println("Fetching details about product: " + productName);
        Product product = new Product(20, productName, 99, 100);
        return product;
    }

    //localhost:8084/product/filterProductByPrice/100/and/500
    //Here is the result for product in the price range of 100 and 500
    @GetMapping("/filterProductByPrice/{lowerPrice}/and/{upperPrice}")
    public String filterProductByPrice(@PathVariable("lowerPrice")int lowerPrice,@PathVariable("upperPrice")int upperPrice){
        //call the methods to fetch product details of this productname
        return "Here is the result for product in the price range of "+lowerPrice+" and "+ upperPrice;
    }

    //localhost:8084/product/outOfStockProductDetails/350
    //Output: Order with qoh less than 50 should be reordered immediately
    //Output: Order with qoh less than 350 should be reordered immediately
    @GetMapping("/outOfStockProductDetails/{productStock}")
    public String outOfStockProductDetails(@PathVariable("productStock") int productStock) {
        return "Order with qoh less than " + productStock + " should be reordered immediately";
    }
}
