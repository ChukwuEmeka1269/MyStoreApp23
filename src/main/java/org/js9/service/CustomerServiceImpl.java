package org.js9.service;

import org.js9.model.Customer;
import org.js9.model.Product;
import org.js9.model.Staff;
import org.js9.util.ProductUtil;

import java.util.Objects;

public class CustomerServiceImpl implements CustomerService {
    //Todo : This method has to be synchronized to prevent concurrency issues
    @Override
    public void buy(Customer customer, String productName, double quantity) {
        ProductUtil productUtil = new ProductUtil();
        Product product = productUtil.fetchProductByName(productName);
        if(product == null){
            product = new Product();
            product.setName(productName);
            product.setQuantityToBuy(quantity);
            customer.getProductList().add(product);
        }else{
            customer.getProductList().add(product);
        }

    }
}
