package org.js9.service;


import org.js9.database.ProductDatabase;
import org.js9.model.Customer;
import org.js9.model.Product;
import org.js9.model.Staff;


public interface CustomerService extends ProductDatabase {
    void buy(Customer customer,String productName, double quantityToBuy);
}
