package com.revature.pms.controller;

import com.revature.pms.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @GetMapping("home") //localhost:8084/product/home
    public String home() {
        return "Welcome to Home Product App";
    }

    //Call the methods to fetch the product details of this product Id
    @GetMapping("{pId}") //localhost:8084/product/single
    public Product getSingleProduct(@PathVariable("pId") int productId) {
        System.out.println("Fetching details about product: " + productId);
        Product product = new Product(1, "keyboard", 99, 100);
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
