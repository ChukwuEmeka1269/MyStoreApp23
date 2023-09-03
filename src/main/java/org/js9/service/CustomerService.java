package org.js9.service;


import org.js9.model.Customer;


public interface CustomerService  {
    void buy(Customer customer,String productName, double quantityToBuy);
}
