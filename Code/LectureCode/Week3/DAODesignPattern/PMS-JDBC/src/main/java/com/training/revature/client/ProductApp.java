package com.training.revature.client;

import com.training.revature.dao.ProductDAOImpl;
import com.training.revature.model.Product;

import java.util.Scanner;

public class ProductApp {

    public void startProductApp() {
        int choice = 0;
        Scanner keyboard = new Scanner(System.in);
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        boolean result = false;

        while (choice != 10) {
            System.out.println("M E N U");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Find Product by Id");
            System.out.println("4. Find product by Name");
            System.out.println("5. Find all Products");
            System.out.println("6. Update Stock");
            System.out.println("7. Update Price");
            System.out.println("8. Update Product");
            System.out.println("10. E X I T");

            System.out.print("Please enter your choice: ");
            choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Welcome to the 'Does product exist section");
                    System.out.print("Please enter the Product Id: ");
                    int productId = keyboard.nextInt();

                    if (productDAOImpl.isProductExist(productId)) {
                        System.out.println("This product already exists");
                    }
                    else {
                        System.out.print("Please enter the product name: ");
                        String productName = keyboard.next();
                        System.out.print("Please enter the product quantity on hand: ");
                        int qoh = keyboard.nextInt();
                        System.out.print("Please enter the product price: ");
                        System.out.print("Please enter the product price: ");
                        int price = keyboard.nextInt();
                        Product product = new Product(productId, productName, qoh, price);

                        result = productDAOImpl.addProduct(product);

                        if (result) {
                            System.out.println("Product saved successfully");
                        }
                        else {
                            System.out.println("Some error occurred when trying to save your product");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Welcome to the product delete section");
                    System.out.print("Please enter a Product Id: ");
                    productId = keyboard.nextInt();

                    if(!productDAOImpl.deleteProduct(productId)) {
                        System.out.println("This product does not exist, please enter a proper Product Id");
                    }
                    else {
                        result = productDAOImpl.deleteProduct(productId);
                        if(result) {
                            System.out.println("Product successfully deleted");
                        }
                        else {
                            System.out.println("Some problem occurred problem not deleted");
                        }
                    }
                    break;
            }
        }
    }
}
