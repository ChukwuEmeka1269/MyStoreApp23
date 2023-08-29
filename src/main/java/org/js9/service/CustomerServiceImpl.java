package org.js9.service;

import org.js9.model.Customer;
import org.js9.model.Product;
import org.js9.model.Staff;

import java.util.Objects;

public class CustomerServiceImpl implements CustomerService {
    //Todo : This method has to be synchronized to prevent concurrency issues
    @Override
    public void buy(Customer customer, String productName, double quantity) {
        Product product = storeProducts.get(productName);
        if(product == null){
            System.out.println("Product not found!");
            return;
        }

        //Todo: Alternative to the above todo, we could put the below two lines in a synchronized block
        product.setQuantityToBuy(quantity);
        customer.getProductList().add(product);

    }
}
